package PIUGame.Items;

import PIUGame.Graphics.Animation;
import PIUGame.Graphics.Assets;
import PIUGame.RefLinks;
import PIUGame.States.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;




public class Monster extends Character{

    //Animation
    private Animation animDown;     //mod_3
    private Animation animUp;     //mod_3
    private Animation animLeft;     //mod_3
    private Animation animRight;     //mod_3
    private Animation noAnim;     //mod_3

    private int nr_of_cycles = 0;       // nr of cycles to check if the player has blocked somewere
    private float previous_x = 0;       // previous position
    private float previous_y = 0;

    private float target_to_follow_x;
    private float target_to_follow_y;

    private int blocked = 0;

    private ItemDirection itemDirection = ItemDirection.NONE;
    private int distance_to_walk = 0;
    private int distance_contor = 0;

    //private float speed_moster = 2.0f;


    private BufferedImage image;    // < Referinta catre imaginea curenta a eroului.*/

        // brief Constructorul de initializare al clasei Hero.

        // param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        // param x Pozitia initiala pe axa X a eroului.
        // param y Pozitia initiala pe axa Y a eroului//
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
        noAnim = new Animation(0, Assets.monster_noAnimation);

        // Initial state
        previous_x = x;
        previous_y = y;
    }


    // constructor pentru caracterele ce se misca pe o traiectorie fixa
    public Monster(RefLinks refLink, float x, float y, ItemDirection itemDirection, int distance_to_walk)
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
        noAnim = new Animation(0, Assets.monster_noAnimation);

        // Initial state
        previous_x = x;
        previous_y = y;

        // seteaza atribute pentru traiectoria fixa
        this.itemDirection = itemDirection;
        this.distance_to_walk = distance_to_walk;
    }

        // brief Actualizeaza pozitia si imaginea eroului.

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

        //System.out.println("                                               new_m_x: " + x + " --- new_m_y: " + y +  "\n");




//        refLink.getGameCamera().centerOnEntity(this);       //mod_2
//
//        if(refLink.GetKeyManager().left == true)
//        {
//            image = Assets.heroLeft;
//        }
//        if(refLink.GetKeyManager().right == true) {
//            image = Assets.heroRight;
//        }



    }

        // brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.

    private void GetInput()
    {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        ///Verificare apasare tasta "sus"

//
//        System.out.println("m_x: " + x + " --- m_y: " + y +  "\n");
//
//        System.out.println("cycles: " + nr_of_cycles + "\n");
//
//        System.out.println("rezult_x: " + Math.abs(x - previous_x));
//        System.out.println("rezult_y: " + Math.abs(y - previous_y));
//
//        if(blocked == 0) {
//            // check if the player has blocked somewere and increment how many times
//            if (Math.abs(x - previous_x) == 0.0f && Math.abs(y - previous_y) < 0.7f) {
//                nr_of_cycles++;
//                System.out.println("aici");
//            } else {
//                nr_of_cycles = 0;
//            }
//        }
//        else{
//            if(blocked == 30){
//                blocked = 0;
//                //nr_of_cycles=0;
//            }
//        }
//
//        if(nr_of_cycles < 10){
//            target_to_follow_x = PlayState.GetHero().x;
//            target_to_follow_y = PlayState.GetHero().y;
//        }
//        else{
//            if(nr_of_cycles > 10){
//                blocked++;
//                target_to_follow_x = x + 100;
//                target_to_follow_y = y + 30;
//            }
//        }


        target_to_follow_x = PlayState.GetHero().x;
        target_to_follow_y = PlayState.GetHero().y;

        previous_x = x;
        previous_y = y;

        if(itemDirection == ItemDirection.NONE){
            //if(refLink.GetGame().playState.GetHero())
            if(x > target_to_follow_x){
                xMove = -speed;
            }
            else{
                if(x < target_to_follow_x - 3 ) {        // se face comparatia cu pozitia player-ului - 3 pixeli pentru a evita tranzitia deranjanta a imaginii de la stanga la dreapta
                    xMove = speed;
                }
            }
            if(y > target_to_follow_y){
                yMove = -speed;
            }
            if(y < target_to_follow_y){
                yMove = speed;
            }
        }
        else
        {
            switch(itemDirection){
                case DOWN:
                    if( distance_contor < distance_to_walk){
                        yMove = speed;
                        distance_contor++;
                    }
                    else{
                        itemDirection = ItemDirection.UP;
                        distance_contor = 0;
                    }
                    break;
                case UP:
                    if( distance_contor < distance_to_walk){
                        yMove = -speed;
                        distance_contor++;
                    }
                    else{
                        itemDirection = ItemDirection.DOWN;
                        distance_contor = 0;
                    }
                    break;
                case LEFT:
                    if( distance_contor < distance_to_walk){
                        xMove = -speed;
                        distance_contor++;
                    }
                    else{
                        itemDirection = ItemDirection.RIGHT;
                        distance_contor = 0;
                    }
                    break;
                case RIGHT:
                    if( distance_contor < distance_to_walk){
                        xMove = speed;
                        distance_contor++;
                    }
                    else{
                        itemDirection = ItemDirection.LEFT;
                        distance_contor = 0;
                    }
                    break;
                default:
                    break;
            }
        }







//        //if(refLink.GetGame().playState.GetHero())
//        if(x > PlayState.GetHero().x){
//            xMove = -speed;
//        }
//        else{
//            if(x < PlayState.GetHero().x - 3 ) {        // se face comparatia cu pozitia player-ului - 3 pixeli pentru a evita tranzitia deranjanta a imaginii de la stanga la dreapta
//                xMove = speed;
//            }
//        }
//        if(y > PlayState.GetHero().y){
//            yMove = -speed;
//        }
//        if(y < PlayState.GetHero().y){
//            yMove = speed;
//        }

        //System.out.println("                                   xM= "+ x + "    yM= " + y);

        //verifica daca a ajuns pe erou

    }

//    private boolean isCollidingBound(){
//        if(x > PlayState.GetHero().x && x < (PlayState.GetHero().x +PlayState.GetHero().width) && y > PlayState.GetHero().y && y < (PlayState.GetHero().y +PlayState.GetHero().height))
//    }

    public boolean hasKilledPlayer(){
        //if(PlayState.GetHero().normalBounds.contains(x, y)){
        if(collisionWithPlayer()){
            //System.out.println("                                                                    false");
            //System.out.println("x= " + PlayState.GetHero().x + "     y= " + PlayState.GetHero().y + "      xM= "+ x + "    yM= " + y);
            return true;
        }
        else{
            //System.out.println("                                                                    true");
            return false;
        }
    }

    public boolean collisionWithPlayer() {
//        float temp_x = PlayState.GetHero().x  + PlayState.GetHero().bounds.x + PlayState.GetHero().bounds.width;
//        float temp_m_x = x + bounds.x + bounds.width;
//        System.out.println("temp_x: " + temp_x + "\n");
//        System.out.println("temp_m_x: " + temp_m_x + "\n");
//        System.out.println("sx = " + x + "  bounds_x: " + bounds.x + " --- p_x: " + PlayState.GetHero().x + " p_bounds_x: " + PlayState.GetHero().bounds.width + "\n");
//        System.out.println("sy = " + y + "  bounds_y: " + bounds.y + " --- p_y: " + PlayState.GetHero().y + " p_bounds_y: " + PlayState.GetHero().bounds.height + "\n");
        if ((x + bounds.x + bounds.width) >= (PlayState.GetHero().x + PlayState.GetHero().bounds.x) &&
                (x + bounds.x) <= (PlayState.GetHero().x + PlayState.GetHero().bounds.x + PlayState.GetHero().bounds.width) &&
                (y + bounds.y) <= (PlayState.GetHero().y + PlayState.GetHero().bounds.y + PlayState.GetHero().bounds.height) &&
                (y + bounds.y + bounds.height) >= (PlayState.GetHero().y + PlayState.GetHero().bounds.y))
//        if(x + width >= PlayState.GetHero().x  &&
//                x <= PlayState.GetHero().x + PlayState.GetHero().width &&
//                y <= PlayState.GetHero().y + PlayState.GetHero().height &&
//                y + height >= PlayState.GetHero().y)
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
//        g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getxOffset()), (int)(y + bounds.y - refLink.getGameCamera().getyOffset()), bounds.width, bounds.height);


//        g.fillRect((int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height);

        g.drawImage(getCurrentAnimationFrame(), (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height, null);
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


    public ItemDirection getItemDirection() {
        return itemDirection;
    }

    public void setItemDirection(ItemDirection itemDirection) {
        this.itemDirection = itemDirection;
    }

    public int getDistance_to_walk() {
        return distance_to_walk;
    }

    public void setDistance_to_walk(int distance_to_walk) {
        this.distance_to_walk = distance_to_walk;
    }
}
