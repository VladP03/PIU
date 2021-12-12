package PIUGame.Items;

import PIUGame.Graphics.Animation;
import PIUGame.Graphics.Assets;
import PIUGame.RefLinks;
import PIUGame.States.PlayState;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/*
    brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).
    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
@Getter
@Setter
public class Hero extends Character {

    //Animation
    private final Animation animDown;
    private final Animation animUp;
    private final Animation animLeft;
    private final Animation animRight;
    private final Animation noAnim;
    private final BufferedImage lifeImage;
    private final BufferedImage stoneImage;
    private int finish_zone_x = 0;
    private int finish_zone_y = 0;
    private float target_to_follow_x;
    private float target_to_follow_y;
    private boolean is_arrive_at_gate = false;
    private boolean in_finish_zone = false;
    private ItemDirection heroDirection = ItemDirection.NONE;

    /* deoarece update-urile la taste sunt foarte rapide, o singura apasare va fi considerata ca mai multe apasari;
     se folosesc pentru tasta space, pentru a nu lansa mai multe sulite la o singura apasare */
    private boolean key_already_pressed = false;
    private int number_key_pressed = 0;
    private BufferedImage image;    /* Referinta catre imaginea curenta a eroului. */

    public int nr_stone_collected = 0;
    public int min_nr_stone = 6;


    /*
        \brief Constructorul de initializare al clasei Hero.
        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y) {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

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
        animDown = new Animation(100, Assets.hero_down);
        animUp = new Animation(100, Assets.hero_up);
        animLeft = new Animation(100, Assets.hero_left);
        animRight = new Animation(100, Assets.hero_right);
        noAnim = new Animation(0, Assets.hero_noAnimation);

        lifeImage = Assets.heart_life_image;
        stoneImage = Assets.stone_image;
    }

    // brief Actualizeaza pozitia si imaginea eroului.
    @Override
    public void Update() {
        //Animation
        animDown.Update();
        animUp.Update();
        animLeft.Update();
        animRight.Update();
        noAnim.Update();


        for (Stone s : PlayState.stoneList) {
            if (s.stone_collected && !s.visited) {
                nr_stone_collected++;
                s.visited = true;
                break;

            }
        }

        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
        ///Actualizeaza imaginea

        refLink.getGameCamera().centerOnEntity(this);

    }

    // Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
    private void GetInput() {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;

        if (key_already_pressed == true && number_key_pressed < 100) {
            number_key_pressed++;
        } else {
            number_key_pressed = 0;
            key_already_pressed = false;
        }

        if (in_finish_zone == true && stonesAreCollected()) {             // player-ul se afla in zona de trecere catre urmatorul nivel
            // se verifica daca player-ul a ajuns in zona de trecere catre urmatorul nivel si astfel tranzitia este terminata (se considera o eroare de +-10 pixeli)
            if (x > target_to_follow_x - 10 && y < target_to_follow_y + 10) {
                is_arrive_at_gate = true;
            } else {
                // daca player-ul este in apropierea zonei de final se realizeaza o tranzitie care duce caracterul catre portal
                if (x < target_to_follow_x) {
                    xMove = speed / 8;
                } else {
                    xMove = -speed / 8;
                }
                if (y > target_to_follow_y) {
                    yMove = -speed / 8;
                } else {
                    yMove = speed / 8;
                }
            }
        } else {                               // player-ul se deplaseaza normal
            ///Verificare apasare tasta "sus"
            if (refLink.getKeyManager().up) {
                yMove = -speed;
                heroDirection = ItemDirection.UP;
            }
            ///Verificare apasare tasta "jos"
            if (refLink.getKeyManager().down) {
                yMove = speed;
                heroDirection = ItemDirection.DOWN;
            }
            ///Verificare apasare tasta "left"
            if (refLink.getKeyManager().left) {
                xMove = -speed;
                heroDirection = ItemDirection.LEFT;
            }
            ///Verificare apasare tasta "dreapta"
            if (refLink.getKeyManager().right) {
                xMove = speed;
                heroDirection = ItemDirection.RIGHT;
            }
            ///Verificare apasare tasta "space" pentru tragere
            if (refLink.getKeyManager().space && key_already_pressed == false) {
                key_already_pressed = true;
                createSword(heroDirection);
            }

        }
    }



    //  Randeaza/deseneaza eroul in noua pozitie.
    @Override
    public void Draw(Graphics g) {

        // afiseaza player-ul
        g.drawImage(getCurrentAnimationFrame(), (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
/*        g.setColor(Color.blue);
        //g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getxOffset()), (int)(y + bounds.y - refLink.getGameCamera().getyOffset()), bounds.width, bounds.height);
        //g.fillRect((int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height);
        System.out.println("player_x: " + x + " ---  player_y: " + y);
*/
    }


    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {      //moving to the left
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {        //moving to the right
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {        //moving up
            return animUp.getCurrentFrame();
        } else if (yMove > 0) {        //moving down
            return animDown.getCurrentFrame();
        }
        return noAnim.getCurrentFrame();
    }

    public boolean levelFinished() {
        return playerInFinishZone() && stonesAreCollected() && is_arrive_at_gate;
    }

    public boolean playerInFinishZone() {
        if (x > finish_zone_x && y > finish_zone_y) {
            in_finish_zone = true;
            return true;
        } else {
            // pentru a nu se activa, in mod eronat, tranzitia care duce player-ul catre poarta cand pietrele au fost colectate, se foloseste o variabila de verificare in plus (in_finish_zone)
            if (x < finish_zone_x - 80 && y < finish_zone_y - 80) {
                in_finish_zone = false;
            }
            return false;
        }
    }



    // verfica daca numarul minim de pietre a fost colectat pentru a putea trece la urmatorul nivel
    public boolean stonesAreCollected() {
        return nr_stone_collected >= min_nr_stone;
    }


    public void createSword(ItemDirection heroDirection) {
        // creez un obiect de tip sabie
        Sword sword = new Sword(refLink, x + 20, y + 20, heroDirection);

        // adaug obiectul in lista de sabii pentru a putea fi actualizat atat timp cat exista
        List<Sword> swords = refLink.getGame().getPlayState().getSwords();
        swords.add(sword);
        refLink.getGame().getPlayState().setSwords(swords);
    }


    // preia lista de explozii existente, creeza si adauga noua explozie, apoi rezurneza lista
    public void createExplosionEffect() {
        List<Explosion> explosions = refLink.getGame().getPlayState().getExplosions();
        Explosion explosion = new Explosion(refLink, x, y);
        explosions.add(explosion);
        refLink.getGame().getPlayState().setExplosions(explosions);
    }
}


