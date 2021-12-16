package PIUGame.States;

import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;

public class MenuState extends State {

    private final UIManager menuManager;


    public MenuState(RefLinks refLink) {
        super(refLink);
        menuManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(menuManager);


        menuManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 140, 300, 90, Assets.start_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                State.setState(new ChooseNameState(refLink));
            }
        }));


        menuManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 240, 300, 90, Assets.settings_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);
                State.setState(new SettingState(refLink));
            }
        }));

        menuManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 340, 300, 90, Assets.score_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);

                State.setState(new ScoreState(refLink));
                //State.SetState(new MenuState(refLink));
            }
        }));

        menuManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 440, 300, 90, Assets.about_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);
                State.setState(new AboutState(refLink));
            }
        }));

        menuManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 540, 300, 90, Assets.exit_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().settingState);
                System.exit(1);
                //refLink.GetGame().StopGame();
            }
        }));
    }


    //  Actualizeaza starea curenta a meniului.
    @Override
    public void Update() {
        menuManager.Update();
    }

    // Deseneaza (randeaza) pe ecran starea curenta a meniului.
    @Override
    public void Draw(Graphics g) {
        // add a background image
        g.drawImage(Assets.menu_background_image, 0, 0, refLink.getWidth(), refLink.getHeight(), null);

        // seteaza fontul si culoarea acestuia
        Font font1 = new Font("arial", 1, 50);
        g.setFont(font1);
        g.setColor(Color.white);
        menuManager.Draw(g);
    }
}
