package PIUGame.Items;

import PIUGame.Graphics.Assets;
import PIUGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Sword extends Character {

    //Animation
    private final BufferedImage animDown;     //mod_3
    private final BufferedImage animUp;     //mod_3
    private final BufferedImage animLeft;     //mod_3
    private final BufferedImage animRight;     //mod_3
    private final BufferedImage noAnim;     //mod_3
    private final int DEFAULT_WIDTH = 30;

    private final float sord_speed = 3.5f;    // viteza de deplasare a sabiei

    private float previous_x = 0;       // previous position
    private float previous_y = 0;

    private ItemDirection swordDirection = ItemDirection.NONE;

    private BufferedImage image;    // < Referinta catre imaginea curenta a eroului.*/

    // brief Constructorul de initializare al clasei Hero.
    // param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
    // param x Pozitia initiala pe axa X a eroului.
    // param y Pozitia initiala pe axa Y a eroului//

    // constructor pentru caracterele ce se misca pe o traiectorie fixa
    public Sword(RefLinks refLink, float x, float y, ItemDirection sordDirection) {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, 30, 30);

        ///Seteaza imaginea de start a eroului
        //image = Assets.heroLeft;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 0;
        normalBounds.y = 0;
        normalBounds.width = 20;
        normalBounds.height = 20;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 10;
        attackBounds.y = 10;
        attackBounds.width = 20;
        attackBounds.height = 20;


        //Animation
        animDown = Assets.sword_down_image;
        animUp = Assets.sword_up_image;
        animLeft = Assets.sword_left_image;
        animRight = Assets.sword_right_image;
        noAnim = Assets.sword_right_image;


        // seteaza atribute pentru traiectoria fixa
        this.swordDirection = sordDirection;
    }

    // brief Actualizeaza pozitia si imaginea eroului.

    @Override
    public void Update() {
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


        if (swordDirection == ItemDirection.NONE) {        // player-ul sta pe loc si trage, am decis ca sageata sa se duca la dreapta
            xMove = sord_speed;
        } else {
            switch (swordDirection) {
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
        if (x == previous_x && y == previous_y) {
            distroySord();
        }

        // seteaza coordonatele pentru a le verifica la urmatorul update
        previous_x = x;
        previous_y = y;

        // verifica daca sageata a intalnit vreun monstru in cale
        collisionWithAllMonsters();

    }


    public void distroySord() {
        List<Sword> swords = refLink.getGame().getPlayState().getSwords();
        for (int i = 0; i < swords.size(); i++) {
            if (swords.get(i) == this) {
                swords.remove(this);
                createExplosionEffect();
            }
        }
        refLink.getGame().getPlayState().setSwords(swords);
    }


    public void collisionWithAllMonsters() {
        List<Monster> monsters = refLink.getGame().getPlayState().getMonsterList();

        for (int i = 0; i < monsters.size(); i++) {
            if (collisionWithOneMonster(monsters.get(i))) {
                monsters.remove(monsters.get(i));
                distroySord();
            }
        }
        refLink.getGame().getPlayState().setMonsterList(monsters);
    }


    public boolean collisionWithOneMonster(Monster monster) {
        return (x + bounds.x + bounds.width) >= (monster.x + monster.bounds.x) &&
                (x + bounds.x) <= (monster.x + monster.bounds.x + monster.bounds.width) &&
                (y + bounds.y) <= (monster.y + monster.bounds.y + monster.bounds.height) &&
                (y + bounds.y + bounds.height) >= (monster.y + monster.bounds.y);
    }


    public void createExplosionEffect() {
        List<Explosion> explosions = refLink.getGame().getPlayState().getExplosions();
        Explosion explosion = new Explosion(refLink, x, y);
        explosions.add(explosion);
        refLink.getGame().getPlayState().setExplosions(explosions);
    }


    // Randeaza/deseneaza eroul in noua pozitie.
    // g Contextul grafic in care trebuie efectuata desenarea eroului.
    @Override
    public void Draw(Graphics g) {
        //g.drawImage(getCurrentAnimationFrame(), (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height, null);


        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        g.setColor(Color.red);
//        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
//        g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getxOffset()), (int)(y + bounds.y - refLink.getGameCamera().getyOffset()), bounds.width, bounds.height);
//        g.fillRect((int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height);


        // se decide directia in care se va deplasa sageata in functie de directia de mers a jucatorului
        switch (swordDirection) {
            case DOWN:
                g.drawImage(animDown, (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), 15, 40, null);
                break;
            case UP:
                g.drawImage(animUp, (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), 15, 40, null);
                break;
            case LEFT:
                g.drawImage(animLeft, (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), 40, 15, null);
                break;
            case RIGHT:
                g.drawImage(animRight, (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), 40, 15, null);
                break;
            default:
                break;
        }
    }

    public ItemDirection getSwordDirection() {
        return swordDirection;
    }

    public void setSwordDirection(ItemDirection sordDirection) {
        this.swordDirection = sordDirection;
    }

}
