package PIUGame.Graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage       spriteSheet;            // Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.
    private static final int    tileWidth   = 48;       // Latimea unei dale din sprite sheet.
    private static final int    tileHeight  = 48;       // Inaltime unei dale din sprite sheet.

    private static final int    playerWidth = 63;       // latimea playerului
    private static final int    playerHeight = 63;      // inaltimea playerului

    private static final int    monsterWidth = 41;      // latimea playerului
    private static final int    monsterHeight = 52;     // inaltimea playerului



    public SpriteSheet(BufferedImage buffImg)
    {
        /// Retine referinta catre BufferedImage object.
        spriteSheet = buffImg;
    }


    //  preiau subimagini pe baza coordonatelor sub forma de pixeli
    public BufferedImage crop_player(int x, int y){
        return spriteSheet.getSubimage(x * playerWidth, y * playerHeight, playerWidth, playerHeight);
    }

    public BufferedImage crop_precise(int x, int y, int width, int height){
        return spriteSheet.getSubimage(x, y, width, height);
    }

    public BufferedImage crop_monster(int x, int y){
        return spriteSheet.getSubimage(x * monsterWidth, y * monsterHeight, monsterWidth, monsterHeight);
    }

    public BufferedImage crop_explosion(int x, int y){
        return spriteSheet.getSubimage(x * 400, y * 300, 400, 300);
    }

}
