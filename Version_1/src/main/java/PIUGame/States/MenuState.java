package PIUGame.States;
import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.GameObjects.UITextButton;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;

public class MenuState extends State{

    private UIManager menuManager;


    public MenuState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza.
        super(refLink);
        menuManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(menuManager);
        //refLink.GetMouseManager().setUIManager(null);
        //refLink.GetMouseManager().setUIManager(menuManager);

        menuManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 140, 200, 80, Assets.buttonStart_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().playState);
                State.SetState(new ChooseNameState(refLink));
            }
        }));


//        menuManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 140, 200, 80, "Start", new ClickListener() {
//            @Override
//            public void onClick() {
//                refLink.GetMouseManager().setUIManager(null);
//                State.SetState(refLink.GetGame().playState);
//            }
//        }));
        menuManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 240, 200, 80, "Settings", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);
                State.SetState(new SettingState(refLink));
            }
        }));

        menuManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 340, 200, 80, "Score", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);
                State.SetState(new ScoreState(refLink));
            }
        }));

        menuManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 440, 200, 80, "About", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);
                State.SetState(new AboutState(refLink));
            }
        }));

        menuManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 540, 200, 80, "Exit", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);
                System.exit(1);
                //refLink.GetGame().StopGame();
            }
        }));
        //refLink.GetMouseManager().setUIManager(null);
    }

        // brief Actualizeaza starea curenta a meniului.
    @Override
    public void Update()
    {
//        if(refLink.GetMouseManager().isLeftPressed()){
//            State.SetState(refLink.GetGame().playState);
//        }
        menuManager.Update();
        //System.out.println("mouse");
    }

        // brief Deseneaza (randeaza) pe ecran starea curenta a meniului.
        // param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    @Override
    public void Draw(Graphics g)
    {
        //g.setColor(Color.white);
        //g.drawString("Menu", 100, 100);

        Font font1 = new Font("arial", 1, 50);
        Font font2 = new Font("arial", 1, 30);

        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("Menu", refLink.GetGame().GetWidth() / 2 - 70, 70);

        // add a background image
        g.drawImage(Assets.background_image, 0, 0, 1350, 780, null);


//        g.setFont(font2);
//        g.drawRect(410, 150, 200, 64);
//        g.drawString("Play", 470, 190);
//
//        g.drawRect(410, 250, 200, 64);
//        g.drawString("Setting", 470, 290);
//
//        g.drawRect(410, 350, 200, 64);
//        g.drawString("Quit", 470, 390);


        menuManager.Draw(g);

    }
}
