package PIUGame.GameObjects;

import PIUGame.RefLinks;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

@Getter
@Setter
public class UIManager {

    private RefLinks refLink;
    private ArrayList<UIObject> objects;

    public UIManager(RefLinks refLink) {
        this.refLink = refLink;
        objects = new ArrayList<UIObject>();
    }

    public void Update() {
        for (UIObject o : objects) {
            o.Update();
        }
    }

    public void Draw(Graphics g) {
        for (UIObject o : objects) {
            o.Draw(g);
        }
    }

    public void onMouseMove(MouseEvent e) {
        for (UIObject o : objects) {
            o.onMouseMove(e);
        }
    }

    public void onMouseReleased(MouseEvent e) {
        for (UIObject o : objects) {
            o.onMouseRelease(e);
        }
    }

    public void addObject(UIObject o) {
        objects.add(o);
    }
}
