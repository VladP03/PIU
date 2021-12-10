package PIUGame.States;

import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;

public class AboutState extends State {

    private final UIManager aboutManager;

    // brief Constructorul de initializare al clasei.
    // param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program
    public AboutState(RefLinks refLink) {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        aboutManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(aboutManager);


        aboutManager.addObject(new UIImageButton((refLink.getGame().GetWidth() / 2) - 100, 600, 300, 90, Assets.back_to_menu_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                //State.SetState(new PlayState(refLink));
                State.setState(new MenuState(refLink));
            }
        }));
    }

    // brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.
    // param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    @Override
    public void Draw(Graphics g) {

        // seteaza imagine de fundal
        g.drawImage(Assets.setting_background_image, 0, 0, refLink.getWidth(), refLink.getHeight(), null);

        // afiseaza un mesaj intr-un chenar pentru titlu
        Color rectangle_color = new Color(255, 255, 150, 50);
        g.setColor(rectangle_color);
        g.fillRoundRect(refLink.getGame().GetWidth() / 2 - 180, 20, 400, 70, 50, 50);

        Font font1 = new Font("arial", 1, 50);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("About Game", refLink.getGame().GetWidth() / 2 - 150, 70);


        // afiseaza un mesaj intr-un chenar pentru descriere
        rectangle_color = new Color(255, 255, 150, 50);
        g.setColor(rectangle_color);
        g.fillRoundRect(refLink.getGame().GetWidth() / 2 - 650, 95, 1300, 400, 50, 50);

        font1 = new Font("arial", 1, 30);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("Controls: W, A, S, D", refLink.getGame().GetWidth() / 2 - 600, 130);
        g.drawString("P - Pause", refLink.getGame().GetWidth() / 2 - 600, 180);
        g.drawString("SPACE - Fire a sord which will kill the monster.", refLink.getGame().GetWidth() / 2 - 600, 230);
        g.drawString("You have to collect all the diamonds to move on to the next level.", refLink.getGame().GetWidth() / 2 - 600, 300);
        g.drawString("Once you collect them you will have access to the next round.", refLink.getGame().GetWidth() / 2 - 600, 350);
        g.drawString("Good Luck!", refLink.getGame().GetWidth() / 2 - 600, 400);


        font1 = new Font("arial", 1, 50);
        g.setFont(font1);

        aboutManager.Draw(g);
    }
}
