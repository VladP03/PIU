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
            case SOLIDGRASS: return new SolidGrassTile(id);

            default: return null;
        }
    }
}
