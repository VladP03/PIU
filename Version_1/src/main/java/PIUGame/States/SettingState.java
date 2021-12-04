package PIUGame.States;
import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.GameObjects.UITextButton;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.Items.Monster;
import PIUGame.RefLinks;
import PIUGame.States.Difficulty.LevelDifficulty;

import java.util.List;
import java.awt.*;

public class SettingState extends State{

    private UIManager settingManager;
    public List<Monster> settingMonster;

    public static LevelDifficulty levelDifficulty = LevelDifficulty.EASY;   // Nivelul de dificultate al jocului

    public SettingState(RefLinks refLink){

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(settingManager);

        // set difficulty to EASY
        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 160, 300, 90, Assets.easy_button_image, new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.EASY;
                refLink.GetGame().getPlayState().setLevelDifficulty(levelDifficulty);

                refLink.GetMouseManager().setUIManager(null);

//                settingMonster = PlayState.GetMonster();
//                for(Monster m: settingMonster){
//                    m.SetSpeed(0.4f);
//                }

                State.SetState(new MenuState(refLink));
            }
        }));


        // set difficulty to MEDIUM
        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 260, 300, 90, Assets.medium_button_image, new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.MEDIUM;
                refLink.GetGame().getPlayState().setLevelDifficulty(levelDifficulty);
                refLink.GetMouseManager().setUIManager(null);

                State.SetState(new MenuState(refLink));
            }
        }));


        // set difficulty to HARD
        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 360, 300, 90, Assets.hard_button_image, new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.HARD;
                refLink.GetGame().getPlayState().setLevelDifficulty(levelDifficulty);
                refLink.GetMouseManager().setUIManager(null);

                State.SetState(new MenuState(refLink));
            }
        }));


        // BUTTON for going back to main menu
        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 560, 300, 90, Assets.back_to_menu_button_image, new ClickListener() {
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


    // Deseneaza (randeaza) pe ecran setarile
    // param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
    @Override
    public void Draw(Graphics g)
    {
        // seteaza imagine de fundal
        g.drawImage(Assets.setting_background_image, 0, 0, refLink.GetWidth(), refLink.GetHeight(), null);


        // afiseaza un mesaj intr-un chenar
        Color rectangle_color = new Color(255, 255, 100, 40);
        g.setColor(rectangle_color);
        g.fillRoundRect(refLink.GetGame().GetWidth() / 2 - 70, 20, 220, 75, 50, 50);

        Font font1 = new Font("arial", 1, 40);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("Settings", refLink.GetGame().GetWidth() / 2 - 50, 70);

        settingManager.Draw(g);
    }


    public static LevelDifficulty getLevelDifficulty() {
        return levelDifficulty;
    }

    public static void setLevelDifficulty(LevelDifficulty levelDifficulty) {
        SettingState.levelDifficulty = levelDifficulty;
    }

}
