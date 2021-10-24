package PIUGame.Tiles;

import PIUGame.Graphics.Assets;


public class MountainTile extends Tile {

       // param id Id-ul dalei util in desenarea hartii.
    public MountainTile(int id)
    {
        // Apel al constructorului clasei de baza
        super(Assets.mountain, id);
    }

        // brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
