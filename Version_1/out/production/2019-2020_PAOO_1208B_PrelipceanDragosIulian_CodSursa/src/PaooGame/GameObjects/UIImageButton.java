package PaooGame.GameObjects;
import PaooGame.Graphics.Assets;
import PaooGame.Input.ClickListener;

import java.awt.*;
import java.awt.image.BufferedImage;


public class UIImageButton extends UIObject{

    private BufferedImage images;
    private ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage images, ClickListener clicker){
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }


    @Override
    public void Update(){

    }

    @Override
    public void Draw(Graphics g){

        if(hovering){
            g.drawImage(images, (int)x+5, (int)y+5, width, height, null);
        }else{
            g.drawImage(images, (int)x, (int)y, width, height, null);
            //g.drawImage(Assets.player_down[0], (int)x, (int)y, width, height, null);
        }

    }

    @Override
    public void onClick(){
        clicker.onClick();
    }


}
