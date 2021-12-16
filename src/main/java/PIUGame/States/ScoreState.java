package PIUGame.States;

import PIUGame.Database.Table.Record;
import PIUGame.Database.Table.RecordDAO;
import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.GameObjects.UITextButton;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;

public class ScoreState extends State {

    private final UIManager settingManager;
    private final ArrayList<Record> recordList;

    public ScoreState(RefLinks refLink) {

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(settingManager);

        RecordDAO recordDAO = new RecordDAO();
        recordList = recordDAO.getRecords();
        sort();

        settingManager.addObject(new UIImageButton((refLink.getGame().getWidth() / 2) - 100, 560, 300, 90, Assets.back_to_menu_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                State.setState(new MenuState(refLink));
            }
        }));
    }

    @Override
    public void Update() {
        //System.out.println("leaderBoard");
        settingManager.Update();
    }


    @Override
    public void Draw(Graphics g) {
        // seteaza imagine de fundal
        g.drawImage(Assets.setting_background_image, 0, 0, refLink.getWidth(), refLink.getHeight(), null);


        // afiseaza un mesaj intr-un chenar pentru titlu
        Color rectangle_color = new Color(255, 255, 150, 50);
        g.setColor(rectangle_color);
        g.fillRoundRect(refLink.getGame().getWidth() / 2 - 180, 20, 400, 70, 50, 50);

        Font fontTitle = new Font("arial", 1, 50);
        g.setFont(fontTitle);
        g.setColor(Color.white);
        g.drawString("Best Score", refLink.getGame().getWidth() / 2 - 120, 70);


        // seteaza un chenar de fundal pentru informatiile afisate din baza de date
        rectangle_color = new Color(255, 255, 150, 50);
        g.setColor(rectangle_color);
        g.fillRoundRect(refLink.getGame().getWidth() / 2 - 650, 95, 1300, 470, 50, 50);

        Font fontTable = new Font("arial", 1, 30);
        g.setFont(fontTable);
        g.setColor(Color.white);

        g.drawString("Difficulty", refLink.getGame().getWidth() / 2 - 600, 130);
        g.drawString("Name", refLink.getGame().getWidth() / 2 - 400, 130);
        g.drawString("Time", refLink.getGame().getWidth() / 2, 130);

        Font fontRow = new Font("arial", 1, 30);
        g.setFont(fontRow);
        g.setColor(Color.white);



        int i = 40;
        int k = 0;
        for (Record rec : recordList) {
            if (k <= 9) {
                g.drawString(String.valueOf(rec.getLevelDifficulty()), refLink.getGame().getWidth() / 2 - 600, 130 + i);
                g.drawString(String.valueOf(rec.getName()), refLink.getGame().getWidth() / 2 - 400, 130 + i);
                g.drawString(rec.getTime().toString(), refLink.getGame().getWidth() / 2, 130 + i);
                i += 40;
                k++;
            } else {
                break;
            }
        }

        settingManager.Draw(g);
    }

    private void sort() {
        recordList.sort((first, second) -> {
            if (first.getLevelDifficulty().compareTo(second.getLevelDifficulty()) == 0) {
                return first.getTime().compareTo(second.getTime());
            } else if (first.getLevelDifficulty().compareTo(second.getLevelDifficulty()) > 0) {
                return -1;
            } else {
                return 1;
            }
        });
    }
}
