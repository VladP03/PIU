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
        return game.getKeyManager();
    }

    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    public Graphics getGraphics() {
        return game.getGraphics();
    }

    public void setGraphics(Graphics g) {
        setGraphics(g);
    }

    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }
}
