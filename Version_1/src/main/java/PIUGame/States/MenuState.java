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

        menuManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 140, 200, 80, Assets.start_button_image, new ClickListener() {
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
        // add a background image
        g.drawImage(Assets.menu_background_image, 0, 0, refLink.GetWidth(), refLink.GetHeight(), null);

        // afiseaza un mesaj intr-un chenar
//        g.setColor(Color.GRAY);
//        g.fillRoundRect(refLink.GetGame().GetWidth() / 2 - 100, 20, 220, 60, 30, 30);

        Font font1 = new Font("arial", 1, 50);
        g.setFont(font1);
        g.setColor(Color.white);
//        g.drawString("Menu", refLink.GetGame().GetWidth() / 2 - 70, 70);


        g.setFont(font1);
        g.setColor(Color.white);
        menuManager.Draw(g);

    }
}
