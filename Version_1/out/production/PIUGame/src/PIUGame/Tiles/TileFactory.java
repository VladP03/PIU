package PIUGame.Tiles;

import PIUGame.Tiles.Types.*;

/*! \class TileFactory
    \brief Implementarea sablonului de proiectare de tip Metoda Fabrica.
 */
public class TileFactory {

    /*! \fn public Tile makeTile(TileTypes tileType, int id)
        \brief Returneaza un obiect de tip dala cu id-ul corespunzator.
    */
    public Tile makeTile(TileTypes tileType, int id) {
        switch(tileType) {
            case GRASS: return new GrassTile(id);
            case MOUNTAIN: return new MountainTile(id);
            case SOIL: return new SoilTile(id);
            case SOLIDGRASS: return new SolidGrassTile(id);
            case TREE: return new TreeTile(id);
            case WALL: return new WallTile(id);
            case WALL2: return new WallTile2(id);
            case WATER: return new WaterTile(id);

            default: return null;
        }
    }
}
