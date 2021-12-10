package PIUGame.GameObjects;

import PIUGame.Input.ClickListener;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

    private final BufferedImage images;
    private final ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage images, ClickListener clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void Draw(Graphics g) {
        if (hovering) {
            g.drawImage(images, (int) x + 5, (int) y + 5, width, height, null);
        } else {
            g.drawImage(images, (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}
