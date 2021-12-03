package PIUGame.States;
import PIUGame.GameObjects.UIManager;
import PIUGame.GameObjects.UITextButton;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;

public class AboutState extends State{

    private UIManager aboutManager;

        // brief Constructorul de initializare al clasei.
        // param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program
    public AboutState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        aboutManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(aboutManager);


        aboutManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 200, 600, 200, 80, "Back to meniu", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(new PlayState(refLink));
                State.SetState(new MenuState(refLink));
            }
        }));


    }


    // brief Actualizeaza starea curenta a meniu about.
    @Override
    public void Update()
    {

    }


    // brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.
    // param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    @Override
    public void Draw(Graphics g)
    {

        // seteaza imagine de fundal
        g.drawImage(Assets.setting_background_image, 0, 0, refLink.GetWidth(), refLink.GetHeight(), null);

        Font font1 = new Font("arial", 1, 50);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("About Game", refLink.GetGame().GetWidth() / 2 - 150, 70);



        font1 = new Font("arial", 1, 30);
        g.setFont(font1);
        g.drawString("Controls: W, A, S, D", refLink.GetGame().GetWidth() / 2 - 600, 130);
        g.drawString("P - Pause", refLink.GetGame().GetWidth() / 2 - 600, 180);
        g.drawString("SPACE - Fire a sord which will kill the monster.", refLink.GetGame().GetWidth() / 2 - 600, 230);
        g.drawString("You have to collect all the diamonds to move on to the next level.", refLink.GetGame().GetWidth() / 2 - 600, 300);
        g.drawString("Once you collect them you will have access to the next round.", refLink.GetGame().GetWidth() / 2 - 600, 350);
        g.drawString("Good Luck!", refLink.GetGame().GetWidth() / 2 - 600, 400);




        font1 = new Font("arial", 1, 50);
        g.setFont(font1);

        aboutManager.Draw(g);
    }
}
