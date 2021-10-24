package PaooGame;

import PaooGame.DatabaseConnection.DatabaseConnection;
import PaooGame.GameCamera.GameCamera;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.Input.KeyManager;
import PaooGame.Input.MouseManager;
import PaooGame.States.*;
import PaooGame.Tiles.Tile;


import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    private GameWindow wnd;
    private boolean runState;
    private Thread gameThread;
    private BufferStrategy bs;

    private Graphics g;

    private GameCamera gameCamera;      //mod_2

    public State playState;
    public State menuState;
    public State finishedGame;
    public State settingState;
    public State aboutState;
    public KeyManager keyManager;
    public MouseManager mouseManager;      //mod_1
    private RefLinks refLink;

    private DatabaseConnection databaseConnection;


    private Tile tile;

    public Game(String title, int width, int height){
        wnd = new GameWindow(title, width, height);
        runState = false;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();      //mod_1

    }

    private void InitGame(){
        wnd.BuildGameWindow();

        wnd.GetWndFrame().addKeyListener(keyManager);
        wnd.GetWndFrame().addMouseListener(mouseManager);       //mod_1
        wnd.GetWndFrame().addMouseMotionListener(mouseManager);       //mod_1
        wnd.GetCanvas().addMouseListener(mouseManager);         //mod_1
        wnd.GetCanvas().addMouseMotionListener(mouseManager);     //mod_1



        Assets.Init();



        refLink = new RefLinks(this);
        gameCamera = new GameCamera(refLink, 0,0);         //mod_2

        playState = new PlayState(refLink);
        databaseConnection = new DatabaseConnection(refLink);


        //settingState = new SettingState(refLink);
        menuState = new MenuState(refLink);
        //finishedGame = new FinishedGame(refLink);
        //finishedGame = new AboutState(refLink);
        //aboutState = new AboutState(refLink);

        //State.SetState(playState);
        State.SetState(menuState);
        //State.SetState(finishedGame);
        //State.SetState(settingState);

    }



    public void run(){
        InitGame();

        long oldTime = System.nanoTime();
        long curentTime;

        final int framesPerSecond   = 60; /*!< Constanta intreaga initializata cu numarul de frame-uri pe secunda.*/
        final double timeFrame      = 1000000000 / framesPerSecond; /*!< Durata unui frame in nanosecunde.*/

        /// Atat timp timp cat threadul este pornit Update() & Draw()
        while (runState == true)
        {
            /// Se obtine timpul curent
            curentTime = System.nanoTime();
            /// Daca diferenta de timp dintre curentTime si oldTime mai mare decat 16.6 ms
            if((curentTime - oldTime) > timeFrame)
            {
                /// Actualizeaza pozitiile elementelor
                try {
                    Update();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /// Deseneaza elementele grafica in fereastra.
                Draw();
                oldTime = curentTime;
                //System.out.println("frame: " + (curentTime - oldTime)*600000000);
            }
        }

    }

    public synchronized void StartGame()
    {
        if(runState == false)
        {
            /// Se actualizeaza flagul de stare a threadului
            runState = true;
            /// Se construieste threadul avand ca parametru obiectul Game. De retinut faptul ca Game class
            /// implementeaza interfata Runnable. Threadul creat va executa functia run() suprascrisa in clasa Game.
            gameThread = new Thread(this);
            /// Threadul creat este lansat in executie (va executa metoda run())
            gameThread.start();
        }
        else
        {
            /// Thread-ul este creat si pornit deja
            return;
        }
    }

    public synchronized void StopGame()
    {
        if(runState == true)
        {
            /// Actualizare stare thread
            runState = false;
            /// Metoda join() arunca exceptii motiv pentru care trebuie incadrata intr-un block try - catch.
            try
            {
                /// Metoda join() pune un thread in asteptare panca cand un altul isi termina executie.
                /// Totusi, in situatia de fata efectul apelului este de oprire a threadului.
                gameThread.join();
                //System.out.println("oprit_1");
            }
            catch(InterruptedException ex)
            {
                /// In situatia in care apare o exceptie pe ecran vor fi afisate informatii utile pentru depanare.
                ex.printStackTrace();
            }
        }
        else
        {
            /// Thread-ul este oprit deja.
            return;
        }
    }


    private void Update() throws InterruptedException {
        ///Determina starea tastelor
        keyManager.Update();
        //mouseManager.Update();      //mod_1
        ///Trebuie obtinuta starea curenta pentru care urmeaza a se actualiza starea, atentie trebuie sa fie diferita de null.
        if(State.GetState() != null)
        {
            ///Actualizez starea curenta a jocului daca exista.
            State.GetState().Update();
        }
    }

    private void Draw()
    {
        /// Returnez bufferStrategy pentru canvasul existent
        bs = wnd.GetCanvas().getBufferStrategy();
        /// Verific daca buffer strategy a fost construit sau nu
        if(bs == null)
        {
            /// Se executa doar la primul apel al metodei Draw()
            try
            {
                /// Se construieste tripul buffer
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                /// Afisez informatii despre problema aparuta pentru depanare.
                e.printStackTrace();
            }
        }
        /// Se obtine contextul grafic curent in care se poate desena.
        g = bs.getDrawGraphics();
        /// Se sterge ce era
        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());

        /// operatie de desenare
        ///Trebuie obtinuta starea curenta pentru care urmeaza a se actualiza starea, atentie trebuie sa fie diferita de null.
        if(State.GetState() != null)
        {
            ///Actualizez starea curenta a jocului daca exista.
            State.GetState().Draw(g);
        }
        /// end operatie de desenare

        /// Se afiseaza pe ecran
        bs.show();

        /// Elibereaza resursele de memorie aferente contextului grafic curent (zonele de memorie ocupate de
        /// elementele grafice ce au fost desenate pe canvas).
        g.dispose();
    }
    public int GetWidth()
    {
        return wnd.GetWndWidth();
    }

    /*! \fn public int GetHeight()
        \brief Returneaza inaltimea ferestrei
     */
    public int GetHeight()
    {
        return wnd.GetWndHeight();
    }

    /*! \fn public KeyManager GetKeyManager()
        \brief Returneaza obiectul care gestioneaza tastatura.
     */
    public KeyManager GetKeyManager()
    {
        return keyManager;
    }
    public MouseManager GetMouseManager()
    {
        return mouseManager;
    }

    public GameCamera getGameCamera(){
        return gameCamera;
    }

    public Graphics getGraphics(){
        return g;
    }

    public void setGraphics(Graphics g){
        this.g = g;
    }

    public DatabaseConnection getDatabaseConnection(){
        return databaseConnection;
    }
    public PlayState getPlayState(){
        return (PlayState) playState;
    }

}
