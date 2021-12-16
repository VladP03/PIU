package PIUGame.Input;

import PIUGame.GameObjects.UIManager;
import lombok.NoArgsConstructor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@NoArgsConstructor
public class MouseManager extends MouseAdapter {

    private boolean leftPressed, rightPressed;
    private UIManager uiManager;

    public void setUIManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = true;
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            rightPressed = true;
        }
        if (uiManager != null) {
            uiManager.onMouseReleased(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        //System.out.println("mouse_x: " + mouseX + " ---  mouse_y: " + mouseY);
        if (uiManager != null) {
            uiManager.onMouseMove(e);
        }
    }
}
