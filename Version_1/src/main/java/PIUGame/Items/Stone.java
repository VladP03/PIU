package PIUGame.Items;

import PIUGame.Graphics.Assets;
import PIUGame.RefLinks;
import PIUGame.States.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Stone extends Item {

    public BufferedImage stone_image;

    public boolean stone_collected = false;

    public boolean visited = false;

    public Stone(RefLinks refLink, int x, int y) {
        super(refLink, x, y, 50, 50);

//        normalBounds.x = 0;
//        normalBounds.y = 0;
//        normalBounds.width = 50;
//        normalBounds.height = 50;

        stone_image = Assets.stone_image;
    }

    @Override
    public void Update() {

        if (!stone_collected) {
            stoneCollected();
        }
        //System.out.println(stone_collected);
    }

    @Override
    public void Draw(Graphics g) {
        if (!stone_collected) {
            //g.drawImage(stone_image, (int)x, (int)y, 50, 50, null);
            //g.drawImage(stone_image, (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height, null);

            g.setColor(Color.red);
            //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);

            //g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getxOffset()), (int)(y + bounds.y - refLink.getGameCamera().getyOffset()), bounds.width, bounds.height);

            //g.fillRect((int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height);

            // draw the actual image
            g.drawImage(stone_image, (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), width, height, null);

            //System.out.println("            exista");
        } else {
            //System.out.println("nu mai e");
        }
    }

    public boolean stoneCollected() {
        if (collisionWithPlayer()) {
            //System.out.println("                                                                    false");
            //System.out.println("x= " + PlayState.GetHero().x + "     y= " + PlayState.GetHero().y + "      xS= "+ x + "    yS= " + y);
            stone_collected = true;

            return true;
        } else {
            //System.out.println("                                                                    false");
            //System.out.println("x= " + PlayState.GetHero().x + "     y= " + PlayState.GetHero().y + "      xS= "+ x + "    yS= " + y);
            //System.out.println("                                                                    true");
            //stone_collected = true;
            return false;
        }
    }

    public boolean collisionWithPlayer() {
        return (x + bounds.x + bounds.width) >= (PlayState.getHero().x + PlayState.getHero().bounds.x) &&
                (x + bounds.x) <= (PlayState.getHero().x + PlayState.getHero().bounds.x + PlayState.getHero().bounds.width) &&
                (y + bounds.y) <= (PlayState.getHero().y + PlayState.getHero().bounds.y + PlayState.getHero().bounds.height) &&
                (y + bounds.y + bounds.height) >= (PlayState.getHero().y + PlayState.getHero().bounds.y);
    }


    public boolean getStoneStatus() {
        return stone_collected;
    }

    public void resetStoneStatus() {
        stone_collected = false;
        visited = false;
    }
}
