package PaooGame.States;

import PaooGame.GameObjects.UIManager;
import PaooGame.GameObjects.UITextButton;
import PaooGame.Input.ClickListener;
import PaooGame.RefLinks;

import java.awt.*;

public class FinishedGame extends State{

    private UIManager settingManager;

    public FinishedGame(RefLinks refLink){

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(settingManager);


        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 200, 220, 200, 80, "Start a new game", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);

                State.SetState(new PlayState(refLink));

            }
        }));


        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 200, 360, 200, 80, "Back to meniu", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new PlayState(refLink));
                State.SetState(new MenuState(refLink));
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


        Font font1 = new Font("arial", 1, 30);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString("You finished the game, Congratulation !!!", refLink.GetGame().GetWidth() / 2 - 300, 70);

        font1 = new Font("arial", 1, 50);
        g.setFont(font1);


        settingManager.Draw(g);
    }
}
