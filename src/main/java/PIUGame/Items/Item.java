package PIUGame.Items;

import PIUGame.RefLinks;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public abstract class Item {
    ///asa cum s-a mai precizat, coordonatele x si y sunt de tip float pentru a se elimina erorile de rotunjire
    ///ce pot sa apara in urma calculelor, urmand a se converti la intreg doar in momentul desenarii.
    protected float x;                  // Pozitia pe axa X a "tablei" de joc a imaginii entitatii
    protected float y;                  // Pozitia pe axa Y a "tablei" de joc a imaginii entitatii
    protected int width;                // Latimea imaginii entitatii
    protected int height;               // Inaltimea imaginii entitatii
    protected Rectangle bounds;         // Dreptunghiul curent de coliziune
    protected Rectangle normalBounds;   // Dreptunghiul de coliziune aferent starii obisnuite(spatiul ocupat de entitate in mod normal), poate fi mai mic sau mai mare decat dimensiunea imaginii sale.
    protected Rectangle attackBounds;   // Dreptunghiul de coliziune aferent starii de atac
    protected RefLinks refLink;         // O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program

    protected float initialX;
    protected float initialY;


    // brief Constructor de initializare al clasei
    // param  reflink Referinte "shortcut" catre alte referinte
    // param  x   Pozitia pe axa X a "tablei" de joc a imaginii entitatii.
    // param  y   Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.
    // param  width   Latimea imaginii entitatii.
    // param  height  Inaltimea imaginii entitatii.
    public Item(RefLinks refLink, float x, float y, int width, int height) {
        this.x = x;                 // Retine coordonata pe axa X.
        this.y = y;                 // Retine coordonata pe axa X.
        this.width = width;         // Retine latimea imaginii.
        this.height = height;       // Retine inaltimea imaginii.
        this.refLink = refLink;     // Retine the "shortcut".

        this.initialX = x;
        this.initialY = y;

        ///Creaza dreptunghi de coliziune pentru modul normal, aici a fost stabilit la dimensiunea imaginii dar poate fi orice alta dimensiune
        normalBounds = new Rectangle(0, 0, width, height);

        ///Creaza dreptunghi de coliziune pentru modul de atack, aici a fost stabilit la dimensiunea imaginii dar poate fi orice alta dimensiune
        attackBounds = new Rectangle(0, 0, width, height);

        ///Dreptunghiul de coliziune implicit este setat ca fiind cel normal
        bounds = normalBounds;
    }

    public void resetPosition() {
        this.x = initialX;
        this.y = initialY;
    }

    ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();

    ///Metoda abstracta destinata desenarii starii curente
    public abstract void Draw(Graphics g);
}
