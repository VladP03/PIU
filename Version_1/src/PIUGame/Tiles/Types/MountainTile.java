package PIUGame.Tiles.Types;

import PIUGame.Graphics.Assets;
import PIUGame.Tiles.Tile;

public class MountainTile extends Tile {
    // param id Id-ul dalei util in desenarea hartii.
    public MountainTile(int id) {
        super(Assets.mountain, id);
    }

    // brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
    @Override
    public boolean IsSolid() {
        return true;
    }
}
