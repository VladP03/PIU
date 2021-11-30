package PIUGame.States;

import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.GameObjects.UITextButton;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;

public class ResumeState extends State{

    private UIManager resumeManager;

    // brief Constructorul de initializare al clasei.
    // param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program
    public ResumeState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        resumeManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(resumeManager);


        resumeManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 140, 200, 80, Assets.buttonStart_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(refLink.GetGame().playState);
                refLink.GetGame().getPlayState().updateObjectWithListener();
            }
        }));


//        menuManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 140, 200, 80, "Start", new ClickListener() {
//            @Override
//            public void onClick() {
//                refLink.GetMouseManager().setUIManager(null);
//                State.SetState(refLink.GetGame().playState);
//            }
//        }));

        resumeManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 240, 200, 80, "Main Menu", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new PlayState(refLink));     // se creaza din nou starea de play, altfel vor ramane salvate datele existente
                State.SetState(new MenuState(refLink));
            }
        }));


        resumeManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 340, 200, 80, "Exit Game", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);
                System.exit(1);
                //refLink.GetGame().StopGame();
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
        Font font1 = new Font("arial", 1, 50);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("Resume Game", refLink.GetGame().GetWidth() / 2 - 150, 70);

        font1 = new Font("arial", 1, 50);
        g.setFont(font1);

        resumeManager.Draw(g);
    }
}
