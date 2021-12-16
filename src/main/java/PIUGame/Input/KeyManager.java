package PIUGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Thread.sleep;

public class KeyManager implements KeyListener {

    private final boolean[] keys;           //  Vector de flaguri pentru toate tastele. Tastele vor fi regasite dupa cod [0 - 255]
    public boolean up;                      // Flag pentru tasta "sus" apasata.
    public boolean down;                    // Flag pentru tasta "jos" apasata.
    public boolean left;                    // Flag pentru tasta "stanga" apasata.
    public boolean right;                   // Flag pentru tasta "dreapta" apasata.
    public boolean escape;
    public boolean space;
    public boolean pause;
    public boolean pause_value = false;     // Flag pentru tasta P pentru pauza.

    public KeyManager() {
        ///Constructie vector de flaguri aferente tastelor.
        keys = new boolean[256];
    }

    public void Update() throws InterruptedException {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];

        escape = keys[KeyEvent.VK_ESCAPE];
        space = keys[KeyEvent.VK_SPACE];

        pause = keys[KeyEvent.VK_P];
        if (pause) {
            sleep(100);         //tastele sunt citite la un interval de timp foarte mic astfel incat valoarea lui 'pause_value' oscileaza si nu se poate indeplinii functia specificata
            pause_value = !pause_value;
            sleep(100);         //tastele sunt citite la un interval de timp foarte mic astfel incat valoarea lui 'pause_value' oscileaza si nu se poate indeplinii functia specificata
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ///se retine in vectorul de flaguri ca o tasta a fost apasata.
        keys[e.getKeyCode()] = true;
    }

    /*
        Functie ce va fi apelata atunci cand un un eveniment de tasta eliberata este generat.
        \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        ///se retine in vectorul de flaguri ca o tasta a fost eliberata.
        keys[e.getKeyCode()] = false;
    }

    /*
        Functie ce va fi apelata atunci cand o tasta a fost apasata si eliberata.
        Momentan aceasta functie nu este utila in program.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
