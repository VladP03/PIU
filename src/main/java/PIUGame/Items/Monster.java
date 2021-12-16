package PIUGame.Items;

import PIUGame.Graphics.Animation;
import PIUGame.Graphics.Assets;
import PIUGame.RefLinks;
import PIUGame.States.PlayState;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.image.BufferedImage;

@Getter
@Setter
public class Monster extends Character {
    //Animation
    private final Animation animDown;
    private final Animation animUp;
    private final Animation animLeft;
    private final Animation animRight;
    private final Animation noAnim;

    private final int nr_of_cycles = 0;         // numar de cicli pentru a verifica daca player-ul s-a blocat undeva
    private float previous_x = 0;               // pozitia anterioasa
    private float previous_y = 0;

    private float target_to_follow_x;
    private float target_to_follow_y;

    private final int blocked = 0;

    private ItemDirection monsterDirection = ItemDirection.NONE;
    private int distance_to_walk = 0;                               // pentru monstrii care se deplaseaza pe o singura directie
    private int distance_contor = 0;                                // salveaza cat a parcurs monstrul pana la "distance_to_walk"

    //private float speed_moster = 2.0f;

    private BufferedImage image;            //  Referinta catre imaginea curenta a eroului.


    // brief Constructorul de initializare al clasei Hero.
    // param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
    // param x Pozitia initiala pe axa X a eroului.
    // param y Pozitia initiala pe axa Y a eroului//
    public Monster(RefLinks refLink, float x, float y) {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

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
        animDown = new Animation(100, Assets.monster_down);
        animUp = new Animation(100, Assets.monster_up);
        animLeft = new Animation(100, Assets.monster_left);
        animRight = new Animation(100, Assets.monster_right);
        noAnim = new Animation(0, Assets.monster_noAnimation);

        // Initial state
        previous_x = x;
        previous_y = y;

        // seteaza viteza monstrilor in functie de nivelul de dificultate
        setMonsterSpeed();

    }


    // constructor pentru caracterele ce se misca pe o traiectorie fixa
    public Monster(RefLinks refLink, float x, float y, ItemDirection itemDirection, int distance_to_walk) {
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

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
        animDown = new Animation(100, Assets.monster_down);
        animUp = new Animation(100, Assets.monster_up);
        animLeft = new Animation(100, Assets.monster_left);
        animRight = new Animation(100, Assets.monster_right);
        noAnim = new Animation(0, Assets.monster_noAnimation);

        // Initial state
        previous_x = x;
        previous_y = y;

        // seteaza atribute pentru traiectoria fixa ( acei monstrii care se misca pe o linie)
        this.monsterDirection = itemDirection;
        this.distance_to_walk = distance_to_walk;

        // seteaza viteza monstrilor in functie de nivelul de dificultate
        setMonsterSpeed();
    }


    //  Actualizeaza pozitia si imaginea eroului.
    @Override
    public void Update() {
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


    }

    // brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
    private void GetInput() {
        ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;

        target_to_follow_x = PlayState.getHero().x;
        target_to_follow_y = PlayState.getHero().y;

        previous_x = x;
        previous_y = y;

        if (monsterDirection == ItemDirection.NONE) {
            if (x > target_to_follow_x) {
                xMove = -speed;
            } else {
                if (x < target_to_follow_x - 3) {        // se face comparatia cu pozitia player-ului - 3 pixeli pentru a evita tranzitia deranjanta a imaginii de la stanga la dreapta
                    xMove = speed;
                }
            }
            if (y > target_to_follow_y) {
                yMove = -speed;
            }
            if (y < target_to_follow_y) {
                yMove = speed;
            }
        } else {
            switch (monsterDirection) {
                case DOWN:
                    if (distance_contor < distance_to_walk) {
                        yMove = speed;
                        distance_contor++;
                    } else {
                        monsterDirection = ItemDirection.UP;
                        distance_contor = 0;
                    }
                    break;
                case UP:
                    if (distance_contor < distance_to_walk) {
                        yMove = -speed;
                        distance_contor++;
                    } else {
                        monsterDirection = ItemDirection.DOWN;
                        distance_contor = 0;
                    }
                    break;
                case LEFT:
                    if (distance_contor < distance_to_walk) {
                        xMove = -speed;
                        distance_contor++;
                    } else {
                        monsterDirection = ItemDirection.RIGHT;
                        distance_contor = 0;
                    }
                    break;
                case RIGHT:
                    if (distance_contor < distance_to_walk) {
                        xMove = speed;
                        distance_contor++;
                    } else {
                        monsterDirection = ItemDirection.LEFT;
                        distance_contor = 0;
                    }
                    break;
                default:
                    break;
            }
        }
    }


    public boolean hasKilledPlayer() {
        return collisionWithPlayer();
    }

    // verifica coliziunea cu player-ul
    public boolean collisionWithPlayer() {
        return (x + bounds.x + bounds.width) >= (PlayState.getHero().x + PlayState.getHero().bounds.x) &&
                (x + bounds.x) <= (PlayState.getHero().x + PlayState.getHero().bounds.x + PlayState.getHero().bounds.width) &&
                (y + bounds.y) <= (PlayState.getHero().y + PlayState.getHero().bounds.y + PlayState.getHero().bounds.height) &&
                (y + bounds.y + bounds.height) >= (PlayState.getHero().y + PlayState.getHero().bounds.y);
    }

    // Randeaza/deseneaza eroul in noua pozitie.
    @Override
    public void Draw(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), width, height, null);

//        g.setColor(Color.GREEN);
//        g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getXOffset()), (int)(y + bounds.y - refLink.getGameCamera().getYOffset()), bounds.width, bounds.height);
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


    // seteaza viteza monstrului in functie de nivelul de dificultate
    public void setMonsterSpeed() {
        switch (refLink.getGame().getPlayState().getLevelDifficulty()) {
            case EASY:
                speed = 0.4f;
                break;
            case MEDIUM:
                speed = 0.6f;
                break;
            case HARD:
                speed = 1.0f;
                break;
            default:
                speed = 0.4f;
                break;
        }
    }
}
