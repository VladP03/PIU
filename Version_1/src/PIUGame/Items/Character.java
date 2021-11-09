package PIUGame.Items;

import PIUGame.RefLinks;
import PIUGame.Tiles.Tile;

/*
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.
    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item
{
    public static final int DEFAULT_LIFE            = 3;   /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED         = 5.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH  = 64;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 64;   /*!< Inaltimea implicita a imaginii caracterului.*/

    protected int life;     /*!< Retine viata caracterului.*/
    protected float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;  /*!< Retine numarul de pixeli cu care trebuie sa se podifice pozitia caracterului pe axa X.*/
    protected float yMove;  /*!< Retine numarul de pixeli cu care trebuie sa se podifice pozitia caracterului pe axa Y.*/

    /*
        \brief Constructor de initializare al clasei Character
        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */
    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
        ///Apel constructor la clasei de baza
        super(refLink, x,y, width, height);
        //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        life    = DEFAULT_LIFE;
        this.speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;
    }

        // brief Modifica pozitia caracterului
    public void Move()
    {
        ///Modifica pozitia caracterului pe axa X.
        ///Modifica pozitia caracterului pe axa Y.
        MoveX();
        MoveY();
    }


        // brief Modifica pozitia caracterului pe axa X.
    public void MoveX()
    {
        ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa X.

        if(xMove > 0){  //moving right
            int tx = (int)(x+ xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                x += xMove;
            }
        }else if(xMove<0){//moving left
            int tx = (int)(x+ xMove + bounds.x) / Tile.TILE_WIDTH;
            if(!collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILE_HEIGHT) && !collisionWithTile(tx, (int)(y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            }
        }
    }

        // brief Modifica pozitia caracterului pe axa Y.
    public void MoveY()
    {
        ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa Y.

        if(yMove < 0){      //up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                y += yMove;
            }
        }else if(yMove > 0){        //down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x + bounds.x) / Tile.TILE_WIDTH, ty) && !collisionWithTile((int)(x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                y += yMove;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y){
        return refLink.GetMap().GetTile(x, y).IsSolid();
    }




        // brief Returneaza viata caracterului.
    public int GetLife()
    {
        return life;
    }


        // brief Returneaza viteza caracterului.
    public float GetSpeed()
    {
        return speed;
    }


        // brief Seteaza viata caracterului.
    public void SetLife(int life)
    {
        this.life = life;
    }


    public void SetSpeed(float speed) {
        this.speed = speed;
    }


        // brief Returneaza distanta in pixeli pe axa X cu care este actualizata pozitia caracterului.
    public float GetXMove()
    {
        return xMove;
    }


        // brief Returneaza distanta in pixeli pe axa Y cu care este actualizata pozitia caracterului.
    public float GetYMove()
    {
        return yMove;
    }


        // brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia caracterului.
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }


        // brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia caracterului.
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }
}

