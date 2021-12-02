package PIUGame.Items;

import PIUGame.Graphics.Animation;
import PIUGame.Graphics.Assets;
import PIUGame.RefLinks;
import PIUGame.States.PlayState;

import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Sord extends Character{

    //Animation
    private BufferedImage animDown;     //mod_3
    private BufferedImage animUp;     //mod_3
    private BufferedImage animLeft;     //mod_3
    private BufferedImage animRight;     //mod_3
    private BufferedImage noAnim;     //mod_3
    private int DEFAULT_WIDTH = 30;

    private float sord_speed = 3.5f;    // viteza de deplasare a sabiei

    private float previous_x = 0;       // previous position
    private float previous_y = 0;


    private ItemDirection sordDirection = ItemDirection.NONE;


    //private float speed_moster = 2.0f;


    private BufferedImage image;    // < Referinta catre imaginea curenta a eroului.*/


    // brief Constructorul de initializare al clasei Hero.
    // param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
    // param x Pozitia initiala pe axa X a eroului.
    // param y Pozitia initiala pe axa Y a eroului//
    public Sord(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x,y, 20, 20);

        ///Seteaza imaginea de start a eroului
        //image = Assets.heroLeft;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 20;
        normalBounds.y = 20;
        normalBounds.width = 26;
        normalBounds.height = 36;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 38;
        attackBounds.height = 38;


        //Animation
        animDown = Assets.sord_down_image;
        animUp = Assets.sord_up_image;
        animLeft = Assets.sord_left_image;
        animRight = Assets.sord_right_image;
        noAnim = Assets.sord_right_image;

    }


    // constructor pentru caracterele ce se misca pe o traiectorie fixa
    public Sord(RefLinks refLink, float x, float y, ItemDirection sordDirection)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x,y, 30, 30);

        ///Seteaza imaginea de start a eroului
        //image = Assets.heroLeft;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 20;
        normalBounds.y = 20;
        normalBounds.width = 20;
        normalBounds.height = 20;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 20;
        attackBounds.height = 20;


        //Animation
        animDown = Assets.sord_down_image;
        animUp = Assets.sord_up_image;
        animLeft = Assets.sord_left_image;
        animRight = Assets.sord_right_image;
        noAnim = Assets.sord_right_image;


        // seteaza atribute pentru traiectoria fixa
        this.sordDirection = sordDirection;
    }

    // brief Actualizeaza pozitia si imaginea eroului.

    @Override
    public void Update()
    {
        ///Verifica daca a fost apasata o tasta
        GetInput();

        ///Actualizeaza pozitia
        Move();
    }


    // brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;


        if(sordDirection == ItemDirection.NONE){        // player-ul sta pe loc si trage, am decis ca sageata sa se duca la dreapta
           xMove = sord_speed;
        }
        else
        {
            switch(sordDirection){
                case DOWN:
                    yMove = sord_speed;
                    break;
                case UP:
                    yMove = -sord_speed;
                    break;
                case LEFT:
                    xMove = -sord_speed;
                    break;
                case RIGHT:
                    xMove = sord_speed;
                    break;
                default:
                    break;
            }
        }

        // daca sabia a ajuns intr-un obiect prin care nu poate trece pozitia va ramane aceeasi, iar acest lucru inseamna ca trebuie stearsa
        if(x == previous_x && y == previous_y){
            distroySord();
        }

        previous_x = x;
        previous_y = y;
    }

    public void distroySord(){
        List<Sord> sords = refLink.GetGame().getPlayState().getSords();
        for(int i=0; i<sords.size(); i++)
        {
            if(sords.get(i) == this){
                sords.remove(this);
            }
        }
        refLink.GetGame().getPlayState().setSords(sords);
    }

    public boolean hasKilledMonster(){
        //if(PlayState.GetHero().normalBounds.contains(x, y)){
        if(collisionWithMonster()){
            //System.out.println("                                                                    false");
            //System.out.println("x= " + PlayState.GetHero().x + "     y= " + PlayState.GetHero().y + "      xM= "+ x + "    yM= " + y);
            return true;
        }
        else{
            //System.out.println("                                                                    true");
            return false;
        }
    }

    public boolean collisionWithMonster() {

        List<Monster> monsters = refLink.GetGame().getPlayState().GetMonster();


        if ((x + bounds.x + bounds.width) >= (PlayState.GetHero().x + PlayState.GetHero().bounds.x) &&
                (x + bounds.x) <= (PlayState.GetHero().x + PlayState.GetHero().bounds.x + PlayState.GetHero().bounds.width) &&
                (y + bounds.y) <= (PlayState.GetHero().y + PlayState.GetHero().bounds.y + PlayState.GetHero().bounds.height) &&
                (y + bounds.y + bounds.height) >= (PlayState.GetHero().y + PlayState.GetHero().bounds.y))
        {
            return true;
        } else {
            return false;
        }
    }

    // brief Randeaza/deseneaza eroul in noua pozitie.
    // brief g Contextul grafi in care trebuie efectuata desenarea eroului.
    @Override
    public void Draw(Graphics g)
    {
        //g.drawImage(getCurrentAnimationFrame(), (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height, null);


        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        g.setColor(Color.red);
//        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getxOffset()), (int)(y + bounds.y - refLink.getGameCamera().getyOffset()), bounds.width, bounds.height);


//        g.fillRect((int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height);


        // se decide directia in care se va deplasa sageata in functie de directia de mers a jucatorului
        switch(sordDirection){
            case DOWN:
                g.drawImage(animDown, (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), 15, 40, null);
                break;
            case UP:
                g.drawImage(animUp, (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), 15, 40, null);
                break;
            case LEFT:
                g.drawImage(animLeft, (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), 40, 15, null);
                break;
            case RIGHT:
                g.drawImage(animRight, (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), 40, 15, null);
                break;
            default:
                break;
        }

    }

    public ItemDirection getSordDirection() {
        return sordDirection;
    }

    public void setSordDirection(ItemDirection sordDirection) {
        this.sordDirection = sordDirection;
    }

}
