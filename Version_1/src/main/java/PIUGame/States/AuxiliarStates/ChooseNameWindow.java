package PIUGame.States.AuxiliarStates;

import PIUGame.RefLinks;
import PIUGame.States.PlayState;
import PIUGame.States.State;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseNameWindow implements ActionListener {

    private final RefLinks refLink;
    private JTextField nameTextField;
    private JFrame newNameFrame;
    private JButton playButton;
    private Font playerNameFont;
    private Font playButtonFont;
    private Font labelNameFont;
    private JLabel nameLabel;

    @Getter
    private static String playerName;


    public ChooseNameWindow(RefLinks refLink) {

        this.refLink = refLink;

        //System.out.println("in create window constructor");

        initWindow();
    }

    public void initWindow() {

        // create a new window(frame)
        newNameFrame = new JFrame("nameFrame");
        newNameFrame.setSize(400, 300);
        newNameFrame.setResizable(false);
        newNameFrame.setLocationRelativeTo(null);
        newNameFrame.setLayout(null);
        newNameFrame.setVisible(true);

//        newNameFrame.setBackground(Color.blue);

        // definesc fontul textului afisat in textField
        playerNameFont = new Font("arial", 1, 20);
        playButtonFont = new Font("arial", 1, 15);
        labelNameFont = new Font("arial", 1, 25);


        // create a label message
        nameLabel = new JLabel("Player Name", JTextField.CENTER);
        nameLabel.setBounds(100, 20, 200, 30);
        nameLabel.setFont(labelNameFont);


        // create a textField in which you will specify the player name
        nameTextField = new JTextField("Player");
        nameTextField.setBounds(50, 80, 300, 40);
        nameTextField.setBackground(Color.red);
        nameTextField.setHorizontalAlignment(JTextField.CENTER);
        nameTextField.setFont(playerNameFont);


        // create the button which will start the game
        playButton = new JButton("Play");
        playButton.setBounds(125, 200, 150, 50);
        playButton.setFont(playButtonFont);
        playButton.addActionListener(this);


        // add the textField and the button to the window
        newNameFrame.add(nameLabel);
        newNameFrame.add(nameTextField);
        newNameFrame.add(playButton);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        playerName = nameTextField.getText();

        //System.out.println("name is: " + playerName);

        if (event.getSource() == playButton) {
            //System.out.println("Button pressed");
            newNameFrame.dispose();
            refLink.getGame().setPlayState(new PlayState(refLink));
            State.setState(refLink.getGame().playState);
            //State.SetState(new PlayState(refLink));
            refLink.getGame().getPlayState().updateObjectWithListener();

        }
    }
}
