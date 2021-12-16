package PIUGame.States;

import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;

public class ResumeState extends State {

    private final UIManager resumeManager;

    // Constructorul de initializare al clasei.
    public ResumeState(RefLinks refLink) {
        super(refLink);
        resumeManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(resumeManager);


        resumeManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 140, 300, 90, Assets.continue_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                State.setState(State.getPreviousState());

                refLink.getGame().getPlayState().updateObjectWithListener();
            }
        }));


        resumeManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 240, 300, 90, Assets.main_menu_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                State.setState(new MenuState(refLink));
            }
        }));


        resumeManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 440, 300, 90, Assets.exit_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                System.exit(1);
            }
        }));


    }

    //  Deseneaza (randeaza) pe ecran starea curenta a meniu about.
    @Override
    public void Draw(Graphics g) {

        // add a background image
        g.drawImage(Assets.resume_background_image, 0, 0, refLink.getWidth(), refLink.getHeight(), null);

        Font font2 = new Font("arial", 1, 40);
        g.setFont(font2);

        resumeManager.Draw(g);
    }
}
