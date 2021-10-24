package PaooGame.GameCamera;

import PaooGame.Game;
import PaooGame.Items.Item;
import PaooGame.RefLinks;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Tiles.Tile;

public class GameCamera {           //mod_2

    private RefLinks refLink;
    private Game game;
    private float xOffset, yOffset;

    //public GameCamera(RefLinks refLink, float xOffset, float yOffset){
    public GameCamera(RefLinks refLink, float xOffset, float yOffset){
        this.refLink = refLink;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void checkBlanckSpace(){
        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > refLink.GetMap().getWidth() * Tile.TILE_WIDTH - refLink.GetWidth()){
            xOffset = refLink.GetMap().getWidth() * Tile.TILE_WIDTH - refLink.GetWidth();
        }


        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > refLink.GetMap().getHeight() * Tile.TILE_HEIGHT - refLink.GetHeight()){
            yOffset = refLink.GetMap().getHeight() * Tile.TILE_HEIGHT - refLink.GetHeight();
        }
    }

    public void centerOnEntity(Item e){
        xOffset = e.GetX() - (float)(refLink.GetWidth() / 2.) + (float)(e.GetWidth() / 2.);
        yOffset = e.GetY() - (float)(refLink.GetHeight() / 2.) + (float)(e.GetHeight() / 2.);
        checkBlanckSpace();
    }

    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlanckSpace();
    }

    public float getxOffset(){
        return xOffset;
    }
    public float getyOffset(){
        return yOffset;
    }
    public void setxOffset(float xOffset){
        this.xOffset = xOffset;
    }
    public void setyOffset(float yOffset){
        this.yOffset = yOffset;
    }
}
