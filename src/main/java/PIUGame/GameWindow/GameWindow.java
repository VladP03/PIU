package PIUGame.GameWindow;

import PIUGame.Graphics.Assets;
import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class GameWindow {

    private final String wndTitle;          // < titlul ferestrei
    private final int wndWidth;             // < latimea ferestrei in pixeli
    private final int wndHeight;            // < inaltimea ferestrei in pixeli
    private JFrame wndFrame;                // < fereastra principala a jocului
    private Canvas canvas;                  // < "panza/tablou" in care se poate desena

    public GameWindow(String title, int width, int height) {
        wndTitle = title;
        wndWidth = width;
        wndHeight = height;
        wndFrame = null;         // < Fereastra nu este construita.
    }

    public void BuildGameWindow() {
        /// Daca fereastra a mai fost construita intr-un apel anterior
        /// se renunta la apel
        if (wndFrame != null) {
            return;
        }

        /// Aloca memorie pentru obiectul de tip fereastra si seteaza denumirea
        /// ce apare in bara de titlu
        wndFrame = new JFrame(wndTitle);

        /// Seteaza dimensiunile ferestrei in pixeli
        wndFrame.setSize(wndWidth, wndHeight);

        /// Operatia de inchidere (fereastra sa poata fi inchisa atunci cand
        /// este apasat butonul x din dreapta sus al ferestrei). Totodata acest
        /// lucru garanteaza ca nu doar fereastra va fi inchisa ci intregul
        /// program
        wndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /// Avand in vedere ca dimensiunea ferestrei poate fi modificata
        /// si corespunzator continutul actualizat (aici ma refer la dalele
        /// randate) va recomand sa constrangeti deocamdata jucatorul
        /// sa se joace in fereastra stabilitata de voi. Puteti reveni asupra
        /// urmatorului apel ulterior.
        wndFrame.setResizable(false);

        /// Recomand ca fereastra sa apara in centrul ecranului. Pentru orice
        /// alte pozitie se va apela "wndFrame.setLocation(x, y)" etc.
        wndFrame.setLocationRelativeTo(null);

        /// Implicit o fereastra cand este creata nu este vizibila motiv pentru
        /// care trebuie setata aceasta proprietate
        wndFrame.setVisible(true);
        wndFrame.setBackground(Color.WHITE);

        /// Creaza obiectul de tip canvas (panza) pe care se poate desena.
        canvas = new Canvas();

        /// In aceeasi maniera trebuie setate proprietatile pentru acest obiect
        /// canvas (panza): dimensiuni preferabile, minime, maxime etc.
        /// Urmotorul apel de functie seteaza dimensiunea "preferata"/implicita
        /// a obiectului de tip canvas.
        /// Functia primeste ca parametru un obiect de tip Dimension care incapsuleaza
        /// doua proprietati: latime si inaltime. Cum acest obiect nu exista
        /// a fost creat unul si dat ca parametru.
        canvas.setPreferredSize(new Dimension(wndWidth, wndHeight));

        /// Avand in vedere ca elementele unei ferestre pot fi scalate atunci cand
        /// fereastra este redimensionata
        canvas.setMaximumSize(new Dimension(wndWidth, wndHeight));
        canvas.setMinimumSize(new Dimension(wndWidth, wndHeight));
        canvas.setFocusable(false);

        /// Avand in vedere ca obiectul de tip canvas, proaspat creat, nu este automat
        /// adaugat in fereastra trebuie apelata metoda add a obiectul wndFrame

        canvas.setBackground(Color.WHITE);
        wndFrame.add(canvas);
        /// Urmatorul apel de functie are ca scop eventuala redimensionare a ferestrei
        /// ca tot ce contine sa poate fi afisat complet
        wndFrame.pack();
    }
}
