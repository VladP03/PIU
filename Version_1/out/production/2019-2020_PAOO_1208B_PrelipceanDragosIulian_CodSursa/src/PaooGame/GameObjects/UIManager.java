package PaooGame.GameObjects;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class UIManager {

    private RefLinks refLink;
    private ArrayList<UIObject> objects;

    public UIManager(RefLinks refLink){
        this.refLink = refLink;
        objects = new ArrayList<UIObject>();
    }

    public void Update(){
        for(UIObject o : objects){
            o.Update();
        }
    }

    public void Draw(Graphics g){
        for(UIObject o : objects){
            o.Draw(g);
        }
    }

    public void onMouseMove(MouseEvent e){
        for(UIObject o : objects){
            o.onMouseMove(e);
        }
    }

    public void onMouseReleased(MouseEvent e){
        for(UIObject o : objects){
            o.onMouseRelease(e);
        }
    }

    public void addObject(UIObject o){
        objects.add(o);
    }

    public void removeObject(UIObject o){
        objects.remove(o);
    }

    public RefLinks getRefLink() {
        return refLink;
    }

    public void setRefLink(RefLinks refLink) {
        this.refLink = refLink;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }
}
