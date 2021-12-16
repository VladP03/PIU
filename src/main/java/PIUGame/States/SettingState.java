package PIUGame.States;

import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.Items.Monster;
import PIUGame.RefLinks;
import PIUGame.States.Difficulty.LevelDifficulty;

import java.awt.*;
import java.util.List;

public class SettingState extends State {

    public static LevelDifficulty levelDifficulty = LevelDifficulty.EASY;   // Nivelul de dificultate al jocului
    public List<Monster> settingMonster;
    private final UIManager settingManager;

    public SettingState(RefLinks refLink) {

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(settingManager);

        // set difficulty to EASY
        settingManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 160, 300, 90, Assets.easy_button_image, new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.EASY;
                refLink.getGame().getPlayState().setLevelDifficulty(levelDifficulty);
                refLink.getMouseManager().setUIManager(null);
                State.setState(new MenuState(refLink));
            }
        }));


        // set difficulty to MEDIUM
        settingManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 260, 300, 90, Assets.medium_button_image, new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.MEDIUM;
                refLink.getGame().getPlayState().setLevelDifficulty(levelDifficulty);
                refLink.getMouseManager().setUIManager(null);

                State.setState(new MenuState(refLink));
            }
        }));


        // set difficulty to HARD
        settingManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 360, 300, 90, Assets.hard_button_image, new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.HARD;
                refLink.getGame().getPlayState().setLevelDifficulty(levelDifficulty);
                refLink.getMouseManager().setUIManager(null);

                State.setState(new MenuState(refLink));
            }
        }));


        // BUTTON for going back to main menu
        settingManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 560, 300, 90, Assets.back_to_menu_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                State.setState(new MenuState(refLink));
            }
        }));

    }

    public static LevelDifficulty getLevelDifficulty() {
        return levelDifficulty;
    }

    public static void setLevelDifficulty(LevelDifficulty levelDifficulty) {
        SettingState.levelDifficulty = levelDifficulty;
    }

    @Override
    public void Update() {
        settingManager.Update();
    }

    // Deseneaza (randeaza) pe ecran setarile
    @Override
    public void Draw(Graphics g) {
        // seteaza imagine de fundal
        g.drawImage(Assets.setting_background_image, 0, 0, refLink.getWidth(), refLink.getHeight(), null);


        // afiseaza un mesaj intr-un chenar
        Color rectangle_color = new Color(255, 255, 100, 40);
        g.setColor(rectangle_color);
        g.fillRoundRect(refLink.getGame().getWidth() / 2 - 70, 20, 220, 75, 50, 50);

        Font font1 = new Font("arial", 1, 40);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("Settings", refLink.getGame().getWidth() / 2 - 50, 70);

        settingManager.Draw(g);
    }
}
