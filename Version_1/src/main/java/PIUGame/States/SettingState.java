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
        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 160, 200, 80, Assets.start_button_image, new ClickListener() {
        //settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 160, 200, 80, "Easy", new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.EASY;
                refLink.GetGame().getPlayState().setLevelDifficulty(levelDifficulty);

                refLink.GetMouseManager().setUIManager(null);

                settingMonster = PlayState.GetMonster();
                for(Monster m: settingMonster){
                    m.SetSpeed(0.4f);
                }

                State.SetState(new MenuState(refLink));
            }
        }));


        // set difficulty to MEDIUM
        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 260, 200, 80, Assets.start_button_image, new ClickListener() {
//        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 260, 200, 80, "Medium", new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.MEDIUM;
                refLink.GetGame().getPlayState().setLevelDifficulty(levelDifficulty);
                refLink.GetMouseManager().setUIManager(null);

                settingMonster = PlayState.GetMonster();
                for(Monster m: settingMonster){
                    m.SetSpeed(0.6f);
                }
                State.SetState(new MenuState(refLink));
            }
        }));


        // set difficulty to HARD
        settingManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 360, 200, 80, Assets.start_button_image, new ClickListener() {
//        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 360, 200, 80, "Hard", new ClickListener() {
            @Override
            public void onClick() {
                levelDifficulty = LevelDifficulty.HARD;
                refLink.GetGame().getPlayState().setLevelDifficulty(levelDifficulty);
                refLink.GetMouseManager().setUIManager(null);

                settingMonster = PlayState.GetMonster();
                for(Monster m: settingMonster){
                    m.SetSpeed(1.0f);
                }
                State.SetState(new MenuState(refLink));
            }
        }));


        // BUTTON for going back to main menu
        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 460, 200, 80, "<- Back to meniu", new ClickListener() {
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
        g.setColor(Color.GRAY);
        g.fillRoundRect(refLink.GetGame().GetWidth() / 2 - 120, 20, 220, 75, 50, 50);

        Font font1 = new Font("arial", 1, 40);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("Settings", refLink.GetGame().GetWidth() / 2 - 100, 70);

        settingManager.Draw(g);
    }


    public static LevelDifficulty getLevelDifficulty() {
        return levelDifficulty;
    }

    public static void setLevelDifficulty(LevelDifficulty levelDifficulty) {
        SettingState.levelDifficulty = levelDifficulty;
    }

}
