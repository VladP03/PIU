package PIUGame.Tiles;

import PIUGame.Graphics.Assets;

public class GrassTile extends Tile
{

        // param id Id-ul dalei util in desenarea hartii.
    public GrassTile(int id)
    {
        // Apel al constructorului clasei de baza
        super(Assets.grass, id);
    }
    @Override
    public boolean IsSolid()
    {
        return false;
    }
}
