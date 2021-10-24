package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class WallTile extends Tile{

    public WallTile(int id){
        super(Assets.tile_1, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
