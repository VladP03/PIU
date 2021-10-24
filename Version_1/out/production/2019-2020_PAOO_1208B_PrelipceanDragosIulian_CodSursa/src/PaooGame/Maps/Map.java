package PaooGame.Maps;

import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Map {

    protected RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    private int [][] tiles;     /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private int map_level;

    public Map(RefLinks refLink, int map_level)
    {
        /// Retine referinta "shortcut".
        this.refLink = refLink;
        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld(map_level);
    }

    public  void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextl grafi in care se realizeaza desenarea.
     */
    public void Draw(Graphics g)
    {
        int xStart =(int) Math.max(0, refLink.GetGame().getGameCamera().getxOffset() / Tile.TILE_WIDTH );
        int xEnd = (int) Math.min(width, (refLink.GetGame().getGameCamera().getxOffset() + refLink.GetGame().GetWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, refLink.GetGame().getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
        int yEnd = (int) Math.min(height, (refLink.GetGame().getGameCamera().getyOffset() + refLink.GetGame().GetHeight()) / Tile.TILE_HEIGHT + 1);;

        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        //for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        for(int y = yStart; y < yEnd; y++)
        {
            //for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            for(int x = xStart; x < xEnd; x++)
            {
                GetTile(x, y).Draw(g, (int)(x * Tile.TILE_HEIGHT - refLink.getGameCamera().getxOffset()), (int)(y * Tile.TILE_WIDTH - refLink.getGameCamera().getyOffset()));
            }
        }
    }

    /*! \fn public Tile GetTile(int x, int y)
        \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

        In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        intoarce o dala predefinita (ex. grassTile, mountainTile)
     */
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.mountainTile;
        }
        return t;
    }

    /*! \fn private void LoadWorld()
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
     */
    private void LoadWorld(int map_level)
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.
        width = 40;//30
        ///Se stabileste inaltimea hartii in numar de dale
        height = 20;//15
        ///Se construieste matricea de coduri de dale
        tiles = new int[width][height];
        //Se incarca matricea cu coduri

        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                switch (map_level){
                    case 1:
                        tiles[x][y] = MiddleEastMap(y, x);
                        break;
                    case 2:
                        tiles[x][y] = Level_2(y, x);
                        break;
                    default:
                        System.out.println("Nivel harta inexistent! ");
                }

            }
        }
    }

    /*! \fn private int MiddleEastMap(int x ,int y)
        \brief O harta incarcata static.

        \param x linia pe care se afla codul dalei de interes.
        \param y coloana pe care se afla codul dalei de interes.
     */
    private int MiddleEastMap(int x ,int y)
    {
        ///Definire statica a matricei de coduri de dale.
        final int map[][] = {
                {6, 3, 3, 3, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6,    6, 6, 6, 6, 6, 5, 5, 5, 5, 5, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1},
                {6, 6, 6, 6, 3, 3, 6, 6, 6, 3, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6,    6, 6, 3, 3, 3, 0, 0, 0, 0, 0, 5, 5, 5, 3, 1, 1, 1, 1, 1, 1},
                {3, 6, 6, 6, 6, 6, 6, 3, 0, 3, 3, 3, 0, 0, 3, 3, 3, 3, 3, 6,    6, 6, 3, 3, 6, 3, 0, 0, 0, 0, 5, 5, 3, 3, 1, 1, 1, 1, 1, 1},
                {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3,    0, 3, 3, 3, 3, 3, 4, 0, 0, 0, 5, 0, 3, 3, 5, 5, 4, 4, 4, 1},
                {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2,    3, 0, 3, 0, 3, 3, 4, 0, 0, 0, 5, 0, 5, 5, 5, 5, 4, 4, 4, 1},
                {3, 3, 0, 0, 3, 0, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 3, 3,    3, 0, 0, 0, 3, 4, 4, 0, 0, 5, 5, 5, 5, 5, 5, 5, 4, 5, 5, 1},
                {3, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4, 4, 4, 4, 5, 1},
                {5, 0, 3, 0, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 1, 1, 0, 0, 5, 5, 5, 5, 5, 5, 4, 4, 4, 5, 1},
                {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5, 5, 5,    0, 0, 5, 5, 0, 3, 1, 0, 0, 0, 5, 3, 3, 5, 5, 4, 4, 4, 5, 1},
                {5, 0, 5, 5, 5, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0,    0, 0, 0, 5, 0, 3, 0, 0, 0, 0, 5, 3, 3, 3, 5, 5, 4, 4, 5, 1},
                {5, 0, 0, 3, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3,    2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 5, 5, 4, 5, 5, 5},
                {5, 0, 0, 0, 3, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 2,    2, 3, 0, 5, 3, 0, 0, 0, 5, 5, 5, 5, 4, 4, 4, 4, 4, 5, 5, 5},
                {5, 0, 3, 3, 3, 3, 2, 2, 3, 0, 0, 0, 0, 0, 0, 0, 5, 3, 0, 3,    2, 2, 0, 5, 0, 0, 0, 0, 3, 3, 5, 4, 4, 5, 4, 5, 5, 5, 5, 5},
                {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 5, 0, 0, 2,    2, 2, 0, 5, 3, 0, 0, 3, 2, 2, 5, 4, 4, 5, 4, 5, 5, 5, 5, 5},

                {5, 0, 0, 0, 0, 3, 3, 0, 3, 3, 3, 3, 3, 3, 0, 0, 5, 5, 0, 2,    5, 5, 0, 5, 5, 0, 0, 3, 2, 2, 5, 4, 4, 4, 4, 4, 4, 5, 5, 5},
                {5, 0, 0, 0, 1, 3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 3, 3, 2, 2, 5, 4, 5, 5, 5, 4, 5, 5, 5, 5},
                {5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,    0, 0, 0, 0, 0, 0, 0, 3, 2, 2, 5, 5, 5, 5, 5, 4, 5, 5, 5, 5},
                {5, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0,    0, 0, 0, 3, 3, 0, 0, 0, 3, 3, 5, 5, 4, 4, 4, 4, 5, 4, 4, 6},
                {5, 0, 5, 5, 5, 0, 0, 2, 2, 3, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0,    0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 4, 4, 4, 5, 5, 4, 4, 4, 4, 6},
                {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 3, 3, 3, 3,    3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}};
        return map[x][y];
    }

    private int Level_2(int x ,int y)
    {
        ///Definire statica a matricei de coduri de dale.
        final int map[][] = {
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 3, 6, 6, 6, 6, 3, 6, 6, 6, 6, 6,    6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 1, 1, 1, 1, 1, 1, 1},
                {7, 4, 3, 4, 3, 3, 7, 7, 4, 3, 3, 3, 3, 3, 3, 3, 6, 6, 6, 6,    6, 6, 3, 3, 3, 4, 4, 4, 4, 4, 7, 7, 7, 3, 1, 1, 1, 1, 1, 1},
                {3, 3, 3, 4, 3, 4, 7, 3, 4, 3, 3, 3, 4, 4, 3, 3, 3, 3, 3, 6,    4, 4, 4, 4, 4, 3, 4, 4, 4, 4, 7, 7, 3, 3, 1, 1, 1, 1, 1, 1},
                {3, 4, 4, 4, 4, 4, 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3,    4, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 3, 3, 7, 7, 4, 4, 4, 1},
                {3, 4, 4, 4, 4, 4, 7, 7, 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 2,    4, 4, 3, 4, 3, 3, 4, 4, 4, 4, 7, 4, 7, 7, 7, 7, 4, 4, 4, 1},
                {3, 3, 4, 4, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3,    4, 4, 4, 4, 3, 4, 4, 4, 4, 7, 7, 4, 7, 7, 7, 7, 4, 7, 7, 1},
                {3, 4, 4, 4, 3, 3, 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,    4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 4, 4, 4, 4, 4, 4, 4, 7, 1},
                {7, 4, 4, 4, 7, 7, 7, 7, 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,    4, 4, 4, 4, 4, 1, 1, 4, 4, 7, 7, 7, 7, 7, 7, 4, 4, 4, 7, 1},
                {7, 4, 4, 4, 7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,    4, 4, 7, 7, 4, 3, 1, 4, 4, 4, 7, 3, 3, 7, 7, 4, 4, 4, 7, 1},
                {7, 4, 7, 7, 7, 4, 4, 3, 3, 4, 7, 4, 4, 4, 4, 4, 4, 4, 4, 4,    4, 4, 4, 7, 4, 3, 4, 4, 4, 4, 7, 3, 3, 3, 7, 7, 4, 4, 7, 1},
                {7, 4, 4, 4, 4, 3, 3, 3, 4, 4, 7, 4, 4, 4, 4, 4, 4, 4, 4, 3,    4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 7, 7, 4, 7, 7, 7},
                {7, 7, 7, 4, 3, 3, 2, 3, 4, 4, 7, 4, 4, 4, 4, 4, 4, 4, 4, 2,    2, 4, 4, 7, 3, 4, 4, 4, 7, 7, 7, 7, 4, 4, 4, 4, 4, 7, 7, 7},
                {7, 4, 4, 4, 3, 3, 2, 2, 3, 4, 7, 4, 4, 4, 4, 4, 4, 3, 4, 3,    2, 4, 4, 7, 4, 4, 4, 4, 3, 3, 7, 4, 4, 7, 7, 7, 7, 7, 7, 7},
                {3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 3, 3, 3, 4, 4, 4, 4, 4, 2,    2, 2, 2, 7, 3, 4, 4, 3, 2, 2, 7, 4, 4, 7, 7, 7, 7, 7, 7, 7},

                {3, 4, 4, 4, 4, 3, 3, 4, 4, 4, 7, 3, 3, 3, 4, 4, 7, 7, 7, 2,    2, 7, 7, 7, 7, 4, 4, 3, 2, 2, 7, 4, 4, 4, 4, 4, 4, 7, 7, 7},
                {3, 4, 4, 4, 1, 3, 4, 4, 4, 4, 7, 7, 4, 4, 4, 4, 4, 4, 4, 4,    4, 4, 4, 4, 4, 4, 3, 3, 2, 2, 7, 4, 7, 7, 7, 4, 7, 7, 7, 7},
                {3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,    4, 4, 4, 4, 4, 4, 4, 3, 2, 2, 7, 7, 7, 7, 7, 4, 7, 7, 7, 7},
                {7, 4, 4, 4, 4, 4, 4, 2, 3, 4, 4, 4, 4, 4, 3, 4, 4, 4, 4, 4,    4, 4, 4, 3, 3, 4, 4, 4, 3, 3, 7, 7, 4, 4, 4, 4, 7, 4, 4, 6},
                {7, 4, 7, 7, 7, 4, 4, 2, 2, 3, 4, 4, 4, 4, 3, 3, 4, 4, 4, 4,    4, 4, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 7, 7, 4, 4, 4, 4, 6},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3,    3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}};
        return map[x][y];
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

}
