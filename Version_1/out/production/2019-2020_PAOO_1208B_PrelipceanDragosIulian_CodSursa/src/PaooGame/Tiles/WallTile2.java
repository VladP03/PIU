package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class WallTile2 extends Tile{
    public WallTile2(int id){
        super(Assets.wall_image, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
