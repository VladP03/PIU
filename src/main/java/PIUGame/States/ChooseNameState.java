package PIUGame.States;

import PIUGame.GameObjects.UIManager;
import PIUGame.RefLinks;
import PIUGame.States.AuxiliarStates.ChooseNameWindow;

import javax.swing.*;
import java.awt.*;

public class ChooseNameState extends State {

    private static ChooseNameWindow chooseNameWindow;
    private final UIManager chooseNameManager;
    private RefLinks refLink;
    private JFrame wndFrame;
    private Graphics g;


    public ChooseNameState(RefLinks refLink) {
        super(refLink);
        chooseNameManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(chooseNameManager);

        // se creeaza o noua fereastra in care se va introduce numele
        chooseNameWindow = new ChooseNameWindow(refLink);

    }

    @Override
    public void Update() {
        chooseNameManager.Update();
    }


    @Override
    public void Draw(Graphics g) {
        chooseNameManager.Draw(g);
    }
}
