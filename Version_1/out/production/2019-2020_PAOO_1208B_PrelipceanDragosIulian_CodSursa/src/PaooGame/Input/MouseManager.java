package PaooGame.Input;

import PaooGame.GameObjects.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager extends MouseAdapter {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;


    public MouseManager(){

    }

    public void setUIManager(UIManager uiManager){
        this.uiManager = uiManager;
    }


    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("clicked");
    }

    @Override
    public void mousePressed(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1){
            leftPressed = true;
        }else if(e.getButton() == MouseEvent.BUTTON3){
            rightPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){
        if(e.getButton() == MouseEvent.BUTTON1){
            leftPressed = true;
        }else if(e.getButton() == MouseEvent.BUTTON3){
            rightPressed = true;
        }
        if(uiManager != null){
            uiManager.onMouseReleased(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        if(uiManager != null) {
            uiManager.onMouseMove(e);
        }
        //System.out.println(mouseX);
    }

    public boolean isLeftPressed(){
        return leftPressed;
    }

    public boolean isRightPressed(){
        return rightPressed;
    }

    public int getMouseX(){
        return mouseX;
    }
    public int getMouseY(){
        return mouseY;
    }



}
