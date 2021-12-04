package PIUGame.Maps;

import PIUGame.RefLinks;
import PIUGame.Tiles.Tile;

import java.awt.*;

public class Map {

    protected RefLinks refLink;     // < O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
    private int width;              // < Latimea hartii in numar de dale.
    private int height;             // < Inaltimea hartii in numar de dale.
    private int [][] tiles;         // < Referinta catre o matrice cu codurile dalelor ce vor construi harta.
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

        // brief Functia de desenare a hartii.
        // param g Contextl grafi in care se realizeaza desenarea.
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

        // brief Intoarce o referinta catre dala aferenta codului din matrice de dale.
        // In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
        // intoarce o dala predefinita (ex. grassTile, mountainTile)
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.grassTile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.grassTile;
        }
        return t;
    }

        // brief Functie de incarcare a hartii jocului.
        // Aici se poate genera sau incarca din fisier harta. Momentan este incarcata static.
    private void LoadWorld(int map_level)
    {
        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
        ///Se stabileste latimea hartii in numar de dale.
        ///Se stabileste inaltimea hartii in numar de dale
        switch(map_level){
            case 1:
                width = 40;//30
                height = 20;//15
                break;
            case 2:
                width = 2*31;
                height = 2*39;
                break;
            default:
                width = 20;//30
                height = 20;//15
        }

        ///Se construieste matricea de coduri de dale
        tiles = new int[width][height];
        //Se incarca matricea cu coduri

        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                switch (map_level){
                    case 1:
//                        tiles[x][y] = MiddleEastMap(y, x);
                        tiles[x][y] = MapLevel_1.getPreciseTile(y, x);
                        break;
                    case 2:
                        tiles[x][y] = MapLevel_2.getPreciseTile(y, x);
                        break;
                    default:
                        System.out.println("Nivel harta inexistent! ");
                }

            }
        }
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

}
