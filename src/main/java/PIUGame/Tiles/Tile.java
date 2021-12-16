package PIUGame.Tiles;

import PIUGame.RefLinks;
import PIUGame.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    private static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];       //  Vector de referinte de tipuri de dale.

    /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
    /// o singura data in memorie
    private static final TileFactory factory = new TileFactory();                               // Fabrica de dale

    public static Tile grassTile        = factory.makeTile(TileTypes.GRASS,0);              // Dala de tip iarba
    public static Tile solidGrassTile   = factory.makeTile(TileTypes.SOLIDGRASS,1);         // Dala de tip zid


    public static final int TILE_WIDTH  = 48;                       // Latimea unei dale.
    public static final int TILE_HEIGHT = 48;                       // Inaltimea unei dale.

    protected BufferedImage img;                                    // Imaginea aferenta tipului de dala.
    protected final int id;                                         // Id-ul unic aferent tipului de dala.
    String my_id;


    // param image Imaginea corespunzatoare dalei.
    // param id Id-ul dalei.
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;
        my_id = "" + idd;
        tiles[id] = this;
    }


    // brief Actualizeaza proprietatile dalei
    public void Update()
    {

    }


    // brief Deseneaza in fereastra dala.
    // param g Contextul grafic in care sa se realizeze desenarea
    // param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
    // param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
    public void Draw(Graphics g, int x, int y)
    {
        /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);


        // Utilizate pentru constructie hartii (pentru debug)
//        Font font1 = new Font("arial", 1, 20);
//        g.setFont(font1);
//        g.setColor(Color.white);
//        g.drawString(my_id, (int)x, (int)y);
//        g.drawRect((int)(x), (int)(y), 48, 48);

    }

    // Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
    public boolean IsSolid()
    {
        return false;
    }

    // Returneaza id-ul dalei.
    public int GetId()
    {
        return id;
    }
}
