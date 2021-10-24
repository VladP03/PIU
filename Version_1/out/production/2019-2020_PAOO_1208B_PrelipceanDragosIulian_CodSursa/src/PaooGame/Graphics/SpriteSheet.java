package PaooGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage       spriteSheet;        /*!< Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.*/
    private static final int    tileWidth   = 48;   /*!< Latimea unei dale din sprite sheet.*/
    private static final int    tileHeight  = 48;   /*!< Inaltime unei dale din sprite sheet.*/

    private static final int    playerWidth = 63;   // latimea playerului
    private static final int    playerHeight = 63;   // inaltimea playerului

    private static final int    monsterWidth = 41;   // latimea playerului
    private static final int    monsterHeight = 54;   // inaltimea playerului

    /*! \fn public SpriteSheet(BufferedImage sheet)
        \brief Constructor, initializeaza spriteSheet.

        \param buffImg Un obiect BufferedImage valid.
     */
    public SpriteSheet(BufferedImage buffImg)
    {
        /// Retine referinta catre BufferedImage object.
        spriteSheet = buffImg;
    }

    /*! \fn public BufferedImage crop(int x, int y)
        \brief Returneaza un obiect BufferedImage ce contine o subimage (dala).

        Subimaginea este localizata avand ca referinta punctul din stanga sus.

        \param x numarul dalei din sprite sheet pe axa x.
        \param y numarul dalei din sprite sheet pe axa y.
     */
    public BufferedImage crop(int x, int y)
    {
        /// Subimaginea (dala) este regasita in sprite sheet specificad coltul stanga sus
        /// al imaginii si apoi latimea si inaltimea (totul in pixeli). Coltul din stanga sus al imaginii
        /// se obtine inmultind numarul de ordine al dalei cu dimensiunea in pixeli a unei dale.
        return spriteSheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }

    public BufferedImage crop_player(int x, int y){
        return spriteSheet.getSubimage(x * playerWidth, y * playerHeight, playerWidth, playerHeight);
    }

    public BufferedImage crop_precise(int x, int y, int width, int height){
        return spriteSheet.getSubimage(x, y, width, height);
    }

    public BufferedImage crop_monster(int x, int y){
        return spriteSheet.getSubimage(x * monsterWidth, y * monsterHeight, monsterWidth, monsterHeight);
    }
}
