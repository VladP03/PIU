package PIUGame.Tiles.Types;

import PIUGame.Graphics.Assets;
import PIUGame.Tiles.Tile;

public class SolidGrassTile extends Tile {
    // param id Id-ul dalei util in desenarea hartii.
    public SolidGrassTile(int id) {
        super(Assets.grass_image, id);
    }

    // brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
    @Override
    public boolean IsSolid() {
        return true;
    }
}
