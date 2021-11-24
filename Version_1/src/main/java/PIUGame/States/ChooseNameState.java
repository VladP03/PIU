package PIUGame.States;

import PIUGame.GameObjects.UIManager;
import PIUGame.RefLinks;
import PIUGame.States.AuxiliarStates.ChooseNameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ChooseNameState extends State {

    private UIManager chooseNameManager;

    private RefLinks refLink;
    private JFrame wndFrame;
    private Graphics g;

    private static ChooseNameWindow chooseNameWindow;


    public ChooseNameState(RefLinks refLink){
        super(refLink);
        chooseNameManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(chooseNameManager);


        System.out.println("before create window");

        // se creeaza o noua fereastra in care se va introduce numele
        chooseNameWindow = new ChooseNameWindow(refLink);

        //wndFrame = refLink.GetGame().getWnd().GetWndFrame();




    }

    @Override
    public void Update(){
        chooseNameManager.Update();
    }


    @Override
    public void Draw(Graphics g){
        chooseNameManager.Draw(g);
    }


}
