package PaooGame.States;
import PaooGame.GameObjects.UIImageButton;
import PaooGame.GameObjects.UIManager;
import PaooGame.GameObjects.UITextButton;
import PaooGame.Graphics.Assets;
import PaooGame.Input.ClickListener;
import PaooGame.Items.Monster;
import PaooGame.RefLinks;

import java.awt.*;

public class SettingState extends State{

    private UIManager settingManager;
    public Monster []settingMonster;

    private static String difficultyLevel = "Easy";

    public Monster oneMonster;

    public SettingState(RefLinks refLink){

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(settingManager);



        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 160, 200, 80, "Easy", new ClickListener() {
            @Override
            public void onClick() {
                difficultyLevel = "Easy";
                refLink.GetGame().getPlayState().setDifficulty_level(difficultyLevel);

                refLink.GetMouseManager().setUIManager(null);

                settingMonster = PlayState.GetMonster();
                for(Monster m: settingMonster){
                    m.SetSpeed(0.6f);
                }


                //oneMonster = refLink.GetGame().playState.GetMonster();
                //settingMonster = new Monster(refLink, 50, 50);
                //settingMonster.SetSpeed(10.0f);
                //State.SetState(new PlayState(refLink));
                State.SetState(new MenuState(refLink));
            }
        }));

        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 260, 200, 80, "Medium", new ClickListener() {
            @Override
            public void onClick() {
                difficultyLevel = "Medium";
                refLink.GetGame().getPlayState().setDifficulty_level(difficultyLevel);
                refLink.GetMouseManager().setUIManager(null);

                settingMonster = PlayState.GetMonster();
                for(Monster m: settingMonster){
                    m.SetSpeed(1.0f);
                }
                State.SetState(new MenuState(refLink));

                //refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().playState);
            }
        }));

        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 360, 200, 80, "Hard", new ClickListener() {
            @Override
            public void onClick() {
                difficultyLevel = "Hard";
                refLink.GetGame().getPlayState().setDifficulty_level(difficultyLevel);
                refLink.GetMouseManager().setUIManager(null);

                settingMonster = PlayState.GetMonster();
                for(Monster m: settingMonster){
                    m.SetSpeed(2.0f);
                }
                State.SetState(new MenuState(refLink));
                //refLink.GetMouseManager().setUIManager(null);
                //State.SetState(refLink.GetGame().playState);
            }
        }));



        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 460, 200, 80, "<- Back to meniu", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new MenuState(refLink));
                //System.exit(1);
                //refLink.GetGame().StopGame();
            }
        }));

    }
    @Override
    public void Update()
    {
        //settingManager.Update();
        settingManager.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran setarile.

        \param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        Font font1 = new Font("arial", 1, 50);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("Settings", refLink.GetGame().GetWidth() / 2 - 100, 70);

        settingManager.Draw(g);
    }

    public static String getDifficultyLevel(){
        return difficultyLevel;
    }
}
