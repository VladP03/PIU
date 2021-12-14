package PIUGame;

import PIUGame.GameCamera.GameCamera;
import PIUGame.GameWindow.GameWindow;
import PIUGame.Graphics.Assets;
import PIUGame.Input.KeyManager;
import PIUGame.Input.MouseManager;
import PIUGame.States.MenuState;
import PIUGame.States.PlayState;
import PIUGame.States.State;
import lombok.Getter;

import java.awt.*;
import java.awt.image.BufferStrategy;

@Getter
public class Game implements Runnable {
    private final GameWindow wnd;
    private GameCamera gameCamera;
    public KeyManager keyManager;
    public MouseManager mouseManager;

    private RefLinks refLink;

    public State playState;
    public State menuState;

    private Thread gameThread;

    private BufferStrategy bs;
    private Graphics graphics;

    private boolean runState;


    public Game(String title, int width, int height) {
        wnd = new GameWindow(title, width, height);
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

        runState = false;
    }

    public void run() {
        InitGame();

        long oldTime = System.nanoTime();
        long curentTime;

        final int framesPerSecond = 60;                             // Constanta intreaga initializata cu numarul de frame-uri pe secunda.
        final double timeFrame = 1000000000 / framesPerSecond;      // Durata unui frame in nanosecunde.  = 16.666.666ns =~ 16.6ms =~0.016s

        /// Atat timp timp cat threadul este pornit Update() & Draw()
        while (runState == true) {
            /// Se obtine timpul curent
            curentTime = System.nanoTime();
            /// Daca diferenta de timp dintre curentTime si oldTime mai mare decat 16.6 ms
            if ((curentTime - oldTime) > timeFrame) {
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

    public synchronized void StartGame() {
        if (runState == false) {
            /// Se actualizeaza flagul de stare a threadului
            runState = true;
            /// Se construieste threadul avand ca parametru obiectul Game. De retinut faptul ca Game class
            /// implementeaza interfata Runnable. Threadul creat va executa functia run() suprascrisa in clasa Game.
            gameThread = new Thread(this);
            /// Threadul creat este lansat in executie (va executa metoda run())
            gameThread.start();
        } else {
            /// Thread-ul este creat si pornit deja
            return;
        }
    }

    public synchronized void StopGame() {
        if (runState == true) {
            /// Actualizare stare thread
            runState = false;
            /// Metoda join() arunca exceptii motiv pentru care trebuie incadrata intr-un block try - catch.
            try {
                /// Metoda join() pune un thread in asteptare panca cand un altul isi termina executie.
                /// Totusi, in situatia de fata efectul apelului este de oprire a threadului.
                gameThread.join();
                //System.out.println("oprit_1");
            } catch (InterruptedException ex) {
                /// In situatia in care apare o exceptie pe ecran vor fi afisate informatii utile pentru depanare.
                ex.printStackTrace();
            }
        } else {
            /// Thread-ul este oprit deja.
            return;
        }
    }

    private void InitGame() {
        wnd.BuildGameWindow();


        wnd.getWndFrame().addKeyListener(keyManager);
        wnd.getWndFrame().addMouseListener(mouseManager);
        wnd.getWndFrame().addMouseMotionListener(mouseManager);
        wnd.getCanvas().addMouseListener(mouseManager);
        wnd.getCanvas().addMouseMotionListener(mouseManager);

        Assets.Init();          // initializam toate elementele de pe harta(tiles, player_frames, diferite obiecte)

        refLink = new RefLinks(this);
        gameCamera = new GameCamera(refLink, 0, 0);

        menuState = new MenuState(refLink);
        State.setState(menuState);
    }

    private void Update() throws InterruptedException {
        ///Determina starea tastelor
        keyManager.Update();
        //mouseManager.Update();
        ///Trebuie obtinuta starea curenta pentru care urmeaza a se actualiza starea, atentie trebuie sa fie diferita de null.
        if (State.getCurrentState() != null) {
            ///Actualizez starea curenta a jocului daca exista.
            State.getCurrentState().Update();
        }
    }

    private void Draw() {
        /// Returnez bufferStrategy pentru canvasul existent
        bs = wnd.getCanvas().getBufferStrategy();
        /// Verific daca buffer strategy a fost construit sau nu
        if (bs == null) {
            /// Se executa doar la primul apel al metodei Draw()
            try {
                /// Se construieste tripul buffer
                wnd.getCanvas().createBufferStrategy(3);
                return;
            } catch (Exception e) {
                /// Afisez informatii despre problema aparuta pentru depanare.
                e.printStackTrace();
            }
        }

        /// Se obtine contextul grafic curent in care se poate desena.
        graphics = bs.getDrawGraphics();

        /// Se sterge ce era
        graphics.clearRect(0, 0, wnd.getWndWidth(), wnd.getWndHeight());

        /// operatie de desenare
        ///Trebuie obtinuta starea curenta pentru care urmeaza a se actualiza starea, atentie trebuie sa fie diferita de null.
        if (State.getCurrentState() != null) {
            ///Actualizez starea curenta a jocului daca exista.
            State.getCurrentState().Draw(graphics);
        }
        /// end operatie de desenare

        /// Se afiseaza pe ecran
        bs.show();

        /// Elibereaza resursele de memorie aferente contextului grafic curent (zonele de memorie ocupate de
        /// elementele grafice ce au fost desenate pe canvas).
        graphics.dispose();
    }

    public int getWidth() {
        return wnd.getWndWidth();
    }

    public int getHeight() {
        return wnd.getWndHeight();
    }

    public PlayState getPlayState() {
        return (PlayState) playState;
    }

    public Game setPlayState(State playState) {
        this.playState = playState;
        return this;
    }
}
