package PaooGame.Items;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Monster extends Character{

    //Animation
    private Animation animDown;     //mod_3
    private Animation animUp;     //mod_3
    private Animation animLeft;     //mod_3
    private Animation animRight;     //mod_3
    private Animation noAnim;     //mod_3

    //private float speed_moster = 2.0f;


    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Monster(RefLinks refLink, float x, float y)
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
        animDown = new Animation(100, Assets.monster_down);      //mod_3
        animUp = new Animation(100, Assets.monster_up);      //mod_3
        animLeft = new Animation(100, Assets.monster_left);      //mod_3
        animRight = new Animation(100, Assets.monster_right);      //mod_3
        noAnim = new Animation(0, Assets.monster_noAnim);
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


        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
        ///Actualizeaza imaginea

        //refLink.getGameCamera().centerOnEntity(this);       //mod_2

//        if(refLink.GetKeyManager().left == true)
//        {
//            image = Assets.heroLeft;
//        }
//        if(refLink.GetKeyManager().right == true) {
//            image = Assets.heroRight;
//        }



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

        //if(refLink.GetGame().playState.GetHero())
        if(x > PlayState.GetHero().x){
            xMove = -speed;
        }
        if(x < PlayState.GetHero().x){
            xMove = speed;
        }
        if(y > PlayState.GetHero().y){
            yMove = -speed;
        }
        if(y < PlayState.GetHero().y){
            yMove = speed;
        }

        //System.out.println("                                   xM= "+ x + "    yM= " + y);

        //verifica daca a ajuns pe erou

    }

//    private boolean isCollidingBound(){
//        if(x > PlayState.GetHero().x && x < (PlayState.GetHero().x +PlayState.GetHero().width) && y > PlayState.GetHero().y && y < (PlayState.GetHero().y +PlayState.GetHero().height))
//    }

    public boolean hasKilledPlayer(){
        //if(PlayState.GetHero().normalBounds.contains(x, y)){
        if(x >= PlayState.GetHero().x && x <= (PlayState.GetHero().x +PlayState.GetHero().width) && y >= PlayState.GetHero().y && y <= (PlayState.GetHero().y +PlayState.GetHero().height)){
            //System.out.println("                                                                    false");
            //System.out.println("x= " + PlayState.GetHero().x + "     y= " + PlayState.GetHero().y + "      xM= "+ x + "    yM= " + y);
            return true;
        }
        else{
            //System.out.println("                                                                    true");
            return false;
        }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(), (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height, null);

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

}
