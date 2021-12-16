package PIUGame.States;

import PIUGame.Database.Table.Record;
import PIUGame.Database.Table.RecordDAO;
import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;
import PIUGame.States.AuxiliarStates.ChooseNameWindow;

import java.awt.*;

public class FinishedGame extends State {

    private final UIManager settingManager;

    public FinishedGame(RefLinks refLink) {

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(settingManager);

        // buton care creaza din nou starea de playState
        settingManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 220, 300, 90, Assets.new_game_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);

                // se reinitializeaza starea de playState
                refLink.getGame().setPlayState(new PlayState(refLink));
                State.setState(refLink.getGame().playState);
                refLink.getGame().getPlayState().updateObjectWithListener();

            }
        }));

        // buton care ne intoarce la meniul principal
        settingManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 320, 300, 90, Assets.back_to_menu_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                State.setState(new MenuState(refLink));
            }
        }));

        String gameDuration = PlayState.getMinutes() + ":" + PlayState.getSeconds();
        RecordDAO recordDAO = new RecordDAO();
        Record record = Record.builder()
                .name(ChooseNameWindow.getPlayerName())
                .time(gameDuration)
                .levelDifficulty(PlayState.levelDifficulty)
                .build();

        recordDAO.saveRecord(record);
    }

    @Override
    public void Update() {
        settingManager.Update();
    }

    // brief Deseneaza (randeaza) pe ecran setarile.
    // param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
    @Override
    public void Draw(Graphics g) {

        // add a background image
        g.drawImage(Assets.win_background_image, 0, 0, refLink.getWidth(), refLink.getHeight(), null);

        // afiseaza un mesaj intr-un chenar
        Color rectangle_color = new Color(20, 140, 120, 50);
        g.setColor(rectangle_color);
        g.fillRoundRect(30, 20, 1350, 75, 50, 50);


        Font font1 = new Font("arial", 1, 30);
        Color font_color = new Color(55, 80, 80, 250);
        g.setFont(font1);
        g.setColor(font_color);
        g.drawString(String.format("%s, You win the game, Congratulations !!!", ChooseNameWindow.getPlayerName()), refLink.getGame().getWidth() / 2 - 250, 70);

        font1 = new Font("arial", 1, 50);
        g.setFont(font1);

        settingManager.Draw(g);
    }
}
