package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Stone extends Item{

    public BufferedImage stone_image;

    public boolean stone_collected = false;

    public boolean visited = false;

    public Stone(RefLinks refLink, int x, int y){
        super(refLink, x, y, 50, 50);

        stone_image = Assets.stone_image;
    }

    @Override
    public void Update(){

        if(!stone_collected){
            stoneCollected();
        }
        //System.out.println(stone_collected);
    }

    @Override
    public void Draw(Graphics g){
        if(!stone_collected) {
            //g.drawImage(stone_image, (int)x, (int)y, 50, 50, null);
            g.drawImage(stone_image, (int)(x - refLink.getGameCamera().getxOffset()), (int)(y - refLink.getGameCamera().getyOffset()), width, height, null);
            System.out.println("            exista");
        }else{
            System.out.println("nu mai e");
        }
    }

    public boolean stoneCollected(){
        if(x >= PlayState.GetHero().x && x <= (PlayState.GetHero().x +PlayState.GetHero().width) && y >= PlayState.GetHero().y && y <= (PlayState.GetHero().y +PlayState.GetHero().height)){
            //System.out.println("                                                                    false");
            //System.out.println("x= " + PlayState.GetHero().x + "     y= " + PlayState.GetHero().y + "      xS= "+ x + "    yS= " + y);
            stone_collected = true;

            return true;
        }
        else{
            //System.out.println("                                                                    false");
            //System.out.println("x= " + PlayState.GetHero().x + "     y= " + PlayState.GetHero().y + "      xS= "+ x + "    yS= " + y);
            //System.out.println("                                                                    true");
            //stone_collected = true;
            return false;
        }
    }

    public boolean getStoneStatus(){
        return stone_collected;
    }

    public void resetStoneStatus(){
        stone_collected = false;
        visited = false;
    }



}
