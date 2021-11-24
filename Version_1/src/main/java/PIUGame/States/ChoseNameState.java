package PIUGame.States;

import PIUGame.GameObjects.UIManager;
import PIUGame.RefLinks;

import javax.swing.*;
import java.awt.*;

public class ChoseNameState extends State {

    private UIManager choseNameManager;

    private RefLinks refLinks;
    private JFrame wndFrame;
    private Graphics g;
    private JTextField nameTextField;

    private JFrame newNameFrame;

    public ChoseNameState(RefLinks refLinks){
        super(refLinks);
        choseNameManager = new UIManager(refLinks);
        refLink.GetMouseManager().setUIManager(choseNameManager);


        wndFrame = refLinks.GetGame().getWnd().GetWndFrame();


        newNameFrame = new JFrame("nameFrame");
        //wndFrame.setSize(300, 400);


        nameTextField = new JTextField();
        nameTextField.setBounds(20, 30, 50, 30);
        nameTextField.setBackground(Color.white);
        //wndFrame.add(nameTextField);

        //wndFrame.add(newNameFrame);

        newNameFrame.add(nameTextField);


        newNameFrame.pack();

        newNameFrame.setVisible(true);

        //newNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //State.SetState(refLink.GetGame().playState);

        //g = refLinks.GetGame().getGraphics();
        //nameTextField.paint(g);

    }

    @Override
    public void Update(){
        choseNameManager.Update();
    }


    @Override
    public void Draw(Graphics g){
        choseNameManager.Draw(g);
    }


}
