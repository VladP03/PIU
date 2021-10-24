package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.Graphics.Animation;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.PlayState;
import PaooGame.States.State;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    //Animation
    private Animation animDown;     //mod_3
    private Animation animUp;     //mod_3
    private Animation animLeft;     //mod_3
    private Animation animRight;     //mod_3
    private Animation noAnim;     //mod_3

    private BufferedImage lifeImage;
    private BufferedImage stoneImage;


    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/

    public int nr_stone = 0;

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
        ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

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
        animDown = new Animation(100, Assets.player_down);      //mod_3
        animUp = new Animation(100, Assets.player_up);      //mod_3
        animLeft = new Animation(100, Assets.player_left);      //mod_3
        animRight = new Animation(100, Assets.player_right);      //mod_3
        noAnim = new Animation(0, Assets.player_noAnim);

        lifeImage = Assets.lifeImage;
        stoneImage = Assets.stone_image;
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
        //Animation
        animDown.Update();
        animUp.Update();
        animLeft.Update();
        animRight.Update();
        noAnim.Update();

        System.out.println(nr_stone);



        for(Stone s: PlayState.stone){
           if(s.stone_collected && !s.visited){
               nr_stone++;
               s.visited = true;
               //s.stone_collected = true;
               //System.out.println(s.stone_collected);
               break;

           }
        }

        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
        ///Actualizeaza imaginea

        refLink.getGameCamera().centerOnEntity(this);       //mod_2

    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        ///Verificare apasare tasta "sus"

        if(refLink.GetKeyManager().up)
        {
            yMove = -speed;
        }
        ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
        }
        ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
        }
        ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
        }
        //System.out.println("x= "+ x + "    y= " + y);
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height, null);

        //g.fillRect(20, 20, 200, 60);
        //g.fillRect();
        //g.setColor(Color.black);

        for(int i=0; i < life; i++){
            g.drawImage(lifeImage, 30 + i * 50, 30, 40, 40, null);
        }
        //g.setColor(Color.black);
        //g.fillRect((int)(refLink.GetWidth())-200,(int)(refLink.GetHeight())-200, 200, 200);

        g.drawImage(stoneImage, 200, 30, 40, 40, null);
        Font font1 = new Font("arial", 1, 40);
        g.setFont(font1);
        g.setColor(Color.white);

        String nr = Integer.toString(nr_stone);
        g.drawString(nr, 240, 50);

 

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        //g.setColor(Color.blue);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        //g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getxOffset()), (int)(y + bounds.y - refLink.getGameCamera().getyOffset()), bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){      //moving to the left
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){        //moving to the right
            return animRight.getCurrentFrame();
        }else if(yMove < 0){        //moving up
            return animUp.getCurrentFrame();
        }else if(yMove > 0){        //moving down
            return animDown.getCurrentFrame();
        }
        return noAnim.getCurrentFrame();
    }

    public boolean levelFinished(){
        if(playerInFinishZone() && stonesAreCollected()){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean playerInFinishZone(){
        if(x > refLink.GetWidth() + refLink.getGameCamera().getxOffset()-200 && y > refLink.GetHeight() +refLink.getGameCamera().getyOffset() -200){
            //System.out.println(refLink.GetWidth() + refLink.getGameCamera().getxOffset());
            //System.out.println(refLink.GetHeight() +refLink.getGameCamera().getyOffset());
            System.out.println("in zone");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean stonesAreCollected(){

        if(nr_stone == 5){
            System.out.println("collested-->>>");
            return true;
        }
        else{
            System.out.println("NOTT   collested");
            return false;
        }
    }

    public void resetStone(){
        for(Stone s: PlayState.stone){
            s.resetStoneStatus();
        }
        nr_stone =0;
    }

    public int getNr_stone(){
        return nr_stone;
    }



}


