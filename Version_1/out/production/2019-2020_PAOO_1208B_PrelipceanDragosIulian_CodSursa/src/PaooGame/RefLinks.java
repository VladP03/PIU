package PaooGame;

import PaooGame.GameCamera.GameCamera;
import PaooGame.Input.MouseManager;
import PaooGame.Maps.Map;

import PaooGame.Input.KeyManager;

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

    /*! \fn public int GetHeight()
        \brief Returneaza inaltimea ferestrei jocului.
     */
    public int GetHeight()
    {
        return game.GetHeight();
    }

    /*! \fn public Game GetGame()
        \brief Intoarce referinta catre obiectul Game.
     */
    public Game GetGame()
    {
        return game;
    }

    /*! \fn public void SetGame(Game game)
        \brief Seteaza referinta catre un obiect Game.

        \param game Referinta obiectului Game.
     */
    public void SetGame(Game game)
    {
        this.game = game;
    }

    /*! \fn public Map GetMap()
        \brief Intoarce referinta catre harta curenta.
     */
    public Map GetMap()
    {
        return map;
    }

    /*! \fn public void SetMap(Map map)
        \brief Seteaza referinta catre harta curenta.

        \param map Referinta catre harta curenta.
     */
    public void SetMap(Map map)
    {
        this.map = map;
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }       //mod_2


}
