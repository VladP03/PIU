package PIUGame.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    /*
        Incarca o imagine intr-un obiect BufferedImage si returneaza o referinta catre acesta.
        path -  Calea relativa pentru localizarea fisierul imagine.
     */
    public static BufferedImage LoadImage(String path) {
        /// Avand in vedere exista situatii in care fisierul sursa sa nu poate fi accesat
        /// metoda read() arunca o excpetie ce trebuie tratata
        try {
            /// Clasa ImageIO contine o serie de metode statice pentru file IO.
            /// Metoda read() are ca argument un InputStream construit avand ca referinta
            /// directorul res, director declarat ca director de resurse in care se gasesc resursele
            /// proiectului sub forma de fisiere sursa.
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            /// Afiseaza informatiile necesare depanarii.
            e.printStackTrace();
        }
        return null;
    }
}
