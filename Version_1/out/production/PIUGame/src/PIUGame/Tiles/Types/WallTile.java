package PIUGame.Tiles.Types;

import PIUGame.Graphics.Assets;
import PIUGame.Tiles.Tile;

public class WallTile extends Tile {
    // param id Id-ul dalei util in desenarea hartii.
    public WallTile(int id) {
        super(Assets.tile_1, id);
    }

    // brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
    @Override
    public boolean IsSolid() {
        return true;
    }
}
