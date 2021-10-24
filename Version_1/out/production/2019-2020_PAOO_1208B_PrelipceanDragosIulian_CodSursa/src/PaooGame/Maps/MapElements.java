package PaooGame.Maps;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;

public class MapElements {

    private int index_level;
    private RefLinks refLink;

    public MapElements(RefLinks refLink,  int index_level){
        this.refLink = refLink;
        this.index_level = index_level;
    }

    public void Draw(Graphics g, int index_level){
        switch(index_level){
            case 1:
                g.drawImage(Assets.tree_image, (int)(10 - refLink.getGameCamera().getxOffset()),(int)(10 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(50 - refLink.getGameCamera().getxOffset()),(int)(20 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(100 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(150 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(200 - refLink.getGameCamera().getxOffset()),(int)(100 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(250 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(300 - refLink.getGameCamera().getxOffset()),(int)(80 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(350 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(450 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(500 - refLink.getGameCamera().getxOffset()),(int)(100 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.tree_image, (int)(550 - refLink.getGameCamera().getxOffset()),(int)(90 - refLink.getGameCamera().getyOffset()),50,70, null);
                g.drawImage(Assets.arrow_image, (int)(1790 - refLink.getGameCamera().getxOffset()),(int)(850 - refLink.getGameCamera().getyOffset()),60,50, null);
                break;
            case 2:
                g.drawImage(Assets.arrow_image, (int)(1790 - refLink.getGameCamera().getxOffset()),(int)(850 - refLink.getGameCamera().getyOffset()),60,50, null);
                break;
            case 3:
                break;
            default:
                System.out.println("level not found");
        }

    }

}
