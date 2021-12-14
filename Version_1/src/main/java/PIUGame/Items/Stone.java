package PIUGame.Items;

import PIUGame.Graphics.Assets;
import PIUGame.RefLinks;
import PIUGame.States.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Stone extends Item {

    public BufferedImage stone_image;
    public boolean stone_collected = false;         // retine daca o piatra a fost colectata
    public boolean visited = false;                 // chiar daca piatra a fost colectata, ea nu trebuie adaugata la numarul total, daca se mai trece prin acea zona


    public Stone(RefLinks refLink, int x, int y) {
        super(refLink, x, y, 50, 50);

        stone_image = Assets.stone_image;
    }

    @Override
    public void Update() {

        if (!stone_collected) {
            stoneCollected();
        }
    }

    @Override
    public void Draw(Graphics g) {
        // piatra se deseneaza atat timp cat inca nu a fost colectata
        if (!stone_collected) {

//            g.setColor(Color.green);
//            g.fillRect((int)(x + bounds.x - refLink.getGameCamera().getXOffset()), (int)(y + bounds.y - refLink.getGameCamera().getYOffset()), bounds.width, bounds.height);
            g.drawImage(stone_image, (int) (x - refLink.getGameCamera().getXOffset()), (int) (y - refLink.getGameCamera().getYOffset()), width, height, null);
        } else {
        }
    }

    // verifica daca o piatra a fost colectata(adica daca a intrat in coliziune cu player-ul)
    public boolean stoneCollected() {
        if (collisionWithPlayer()) {
            stone_collected = true;
            return true;
        } else {
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
