package PIUGame.GameObjects;

import PIUGame.Input.ClickListener;

import java.awt.*;

public class UITextButton extends UIObject {

    private final ClickListener clicker;
    private String buttonName;

    public UITextButton(float x, float y, int width, int height, String buttonName, ClickListener clicker) {
        super(x, y, width, height);
        this.buttonName = buttonName;
        this.clicker = clicker;
    }

    @Override
    public void Draw(Graphics g) {
        if (hovering) {
            g.drawString(buttonName, (int) x + 5, (int) y + 45);
        } else {
            g.drawString(buttonName, (int) x, (int) y + 40);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}
