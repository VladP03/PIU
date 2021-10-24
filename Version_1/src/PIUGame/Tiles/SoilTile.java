package PIUGame.Tiles;

import PIUGame.Graphics.Assets;

public class SoilTile extends Tile
{

        // param id Id-ul dalei util in desenarea hartii.
    public SoilTile(int id)
    {
        super(Assets.soil, id);
    }

    @Override
    public boolean IsSolid()
    {
        return false;
    }
}
