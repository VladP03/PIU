package PIUGame;

import PIUGame.GameCamera.GameCamera;
import PIUGame.Input.MouseManager;
import PIUGame.Maps.Map;

import PIUGame.Input.KeyManager;

import java.awt.*;

public class RefLinks {

    private Game game;
    private Map map;

    public RefLinks(Game game){
        this.game = game;
    }
    public KeyManager GetKeyManager()
    {
        return game.GetKeyManager();
    }

    public MouseManager GetMouseManager()
    {
        return game.GetMouseManager();
    }
    /*! \fn public int GetWidth()
        \brief Returneaza latimea ferestrei jocului.
     */

    public Graphics getGraphics(){
        return game.getGraphics();
    }

    public void setGraphics(Graphics g){
        setGraphics(g);
    }



    public int GetWidth()
    {
        return game.GetWidth();
    }

    // Returneaza inaltimea ferestrei jocului.
    public int GetHeight()
    {
        return game.GetHeight();
    }


    // Intoarce referinta catre obiectul Game.

    public Game GetGame()
    {
        return game;
    }


    // Seteaza referinta catre un obiect Game.
    // game Referinta obiectului Game.

    public void SetGame(Game game)
    {
        this.game = game;
    }


    // Intoarce referinta catre harta curenta.

    public Map GetMap()
    {
        return map;
    }


    // Seteaza referinta catre harta curenta.
    // map Referinta catre harta curenta.

    public void SetMap(Map map)
    {
        this.map = map;
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }       //mod_2


}
