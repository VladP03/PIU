package PIUGame.States;

import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;

public class LoseState extends State {

    private final UIManager settingManager;

    public LoseState(RefLinks refLink) {

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(settingManager);


        settingManager.addObject(new UIImageButton((refLink.getGame().GetWidth() / 2) - 100, 160, 300, 90, Assets.new_game_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);

                // se reinitializeaza starea de playState
                refLink.getGame().setPlayState(new PlayState(refLink));
                State.setState(refLink.getGame().playState);
                refLink.getGame().getPlayState().updateObjectWithListener();

            }
        }));

        settingManager.addObject(new UIImageButton((refLink.getGame().GetWidth() / 2) - 100, 260, 300, 90, Assets.settings_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);

                State.setState(new PlayState(refLink));
                State.setState(new SettingState(refLink));
            }
        }));


        settingManager.addObject(new UIImageButton((refLink.getGame().GetWidth() / 2) - 100, 360, 300, 90, Assets.back_to_menu_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                State.setState(new PlayState(refLink));
                State.setState(new MenuState(refLink));
            }
        }));

    }


    @Override
    public void Update() {
        settingManager.Update();
    }


    // brief Deseneaza (randeaza) pe ecran setarile.
    // param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
    @Override
    public void Draw(Graphics g) {

        // add a background image
        g.drawImage(Assets.lose_background_image, 0, 0, refLink.getWidth(), refLink.getHeight(), null);

        // afiseaza un mesaj intr-un chenar
        Color rectangle_color = new Color(255, 255, 150, 50);
        g.setColor(rectangle_color);
        g.fillRoundRect(refLink.getGame().GetWidth() / 2 - 120, 20, 370, 75, 50, 50);

        Font font1 = new Font("arial", 1, 50);
        g.setFont(font1);
        g.setColor(Color.black);
        g.drawString("You lose !!!", refLink.getGame().GetWidth() / 2 - 100, 70);

        settingManager.Draw(g);
    }
}
