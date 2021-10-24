package PaooGame.States;
import PaooGame.GameObjects.UIManager;
import PaooGame.GameObjects.UITextButton;
import PaooGame.Input.ClickListener;
import PaooGame.RefLinks;

import java.awt.*;

public class AboutState extends State{
    /*! \fn public AboutState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */

    private UIManager settingManager;


    public AboutState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(settingManager);


        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 200, 600, 200, 80, "Back to meniu", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new PlayState(refLink));
                State.SetState(new MenuState(refLink));
            }
        }));


    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniu about.
     */
    @Override
    public void Update()
    {


    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniu about.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        Font font1 = new Font("arial", 1, 50);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("About Game", refLink.GetGame().GetWidth() / 2 - 150, 70);


        font1 = new Font("arial", 1, 30);
        g.setFont(font1);
        g.drawString("Controls: W, A, S, D", refLink.GetGame().GetWidth() / 2 - 600, 130);
        g.drawString("P - Pause", refLink.GetGame().GetWidth() / 2 - 600, 180);
        g.drawString("You have to collect all the diamonds to move on to the next level.", refLink.GetGame().GetWidth() / 2 - 600, 250);
        g.drawString("Once you collect them you will have access to the next round.", refLink.GetGame().GetWidth() / 2 - 600, 300);
        g.drawString("Good Luck!", refLink.GetGame().GetWidth() / 2 - 600, 350);




        font1 = new Font("arial", 1, 50);
        g.setFont(font1);


        settingManager.Draw(g);
    }
}
