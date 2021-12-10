package PIUGame;

import PIUGame.GameCamera.GameCamera;
import PIUGame.Input.KeyManager;
import PIUGame.Input.MouseManager;
import PIUGame.Maps.Map;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class RefLinks {
    private Game game;
    private Map map;

    public RefLinks(Game game) {
        this.game = game;
    }

    public KeyManager getKeyManager() {
        return game.GetKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.GetMouseManager();
    }
    /*! \fn public int GetWidth()
        \brief Returneaza latimea ferestrei jocului.
     */

    public Graphics getGraphics() {
        return game.getGraphics();
    }

    public void setGraphics(Graphics g) {
        setGraphics(g);
    }

    // Returneaza latimea ferestrei jocului.
    public int getWidth() {
        return game.GetWidth();
    }

    // Returneaza inaltimea ferestrei jocului.
    public int getHeight() {
        return game.GetHeight();
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }
}
