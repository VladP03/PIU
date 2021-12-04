package PIUGame.States;

import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.GameObjects.UITextButton;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;

public class FinishedGame extends State{

    private UIManager settingManager;

    public FinishedGame(RefLinks refLink){

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(settingManager);

        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 220, 300, 90, Assets.new_game_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);

                // se reinitializeaza starea de playState
                refLink.GetGame().setPlayState(new PlayState(refLink));
                State.SetState(refLink.GetGame().playState);
                refLink.GetGame().getPlayState().updateObjectWithListener();

            }
        }));


        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 320, 300, 90, Assets.back_to_menu_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new MenuState(refLink));
            }
        }));

    }
    @Override
    public void Update()
    {
        settingManager.Update();
    }


    // brief Deseneaza (randeaza) pe ecran setarile.
    // param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
    @Override
    public void Draw(Graphics g)
    {


        // add a background image
        g.drawImage(Assets.win_background_image, 0, 0, refLink.GetWidth(), refLink.GetHeight(), null);

        // afiseaza un mesaj intr-un chenar
        Color rectangle_color = new Color(20, 140, 120, 50);
        g.setColor(rectangle_color);
        g.fillRoundRect(refLink.GetGame().GetWidth() / 2 - 270, 20, 700, 75, 50, 50);


        Font font1 = new Font("arial", 1, 30);
        Color font_color = new Color(55, 80, 80, 250);
        g.setFont(font1);
        g.setColor(font_color);
        g.drawString("You win the game, Congratulation !!!", refLink.GetGame().GetWidth() / 2 - 250, 70);

        font1 = new Font("arial", 1, 50);
        g.setFont(font1);

        settingManager.Draw(g);
    }
}
