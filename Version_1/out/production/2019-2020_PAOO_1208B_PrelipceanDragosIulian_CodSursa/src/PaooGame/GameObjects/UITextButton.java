package PaooGame.GameObjects;

import PaooGame.Input.ClickListener;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UITextButton extends UIObject{

    String buttonName;
    private ClickListener clicker;

    public UITextButton(float x, float y, int width, int height, String buttonName, ClickListener clicker){
        super(x, y, width, height);
        this.buttonName = buttonName;
        this.clicker = clicker;
    }


    @Override
    public void Update(){

    }

    @Override
    public void Draw(Graphics g){
        //g.drawRect((int)x, (int)y, width, height);
        if(hovering){
            g.drawString(buttonName, (int)x+5, (int)y+45);
        }else{
            g.drawString(buttonName, (int)x, (int)y+40);
            //g.drawImage(Assets.player_down[0], (int)x, (int)y, width, height, null);
        }

    }

    @Override
    public void onClick(){
        clicker.onClick();
    }

}
