package PIUGame.States;

import PIUGame.Database.Table.Record;
import PIUGame.Database.Table.RecordDAO;
import PIUGame.GameObjects.UIManager;
import PIUGame.GameObjects.UITextButton;
import PIUGame.Input.ClickListener;
import PIUGame.RefLinks;
import PIUGame.States.Difficulty.Difficulty;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ScoreState extends State {

    private final UIManager settingManager;
    private final ArrayList<Record> recordList;

    public ScoreState(RefLinks refLink) {

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(settingManager);

        RecordDAO recordDAO = new RecordDAO();
        recordList = recordDAO.getRecords();
        sort();

        settingManager.addObject(new UITextButton((refLink.GetGame().GetWidth() / 2) - 100, 560, 200, 80, "<- Back to meniu", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new MenuState(refLink));
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
        Font fontTitle = new Font("arial", 1, 50);
        g.setFont(fontTitle);
        g.setColor(Color.white);
        g.drawString("Best Score", refLink.GetGame().GetWidth() / 2 - 100, 70);

        Font fontTable = new Font("arial", 1, 30);
        g.setFont(fontTable);
        g.setColor(Color.white);

        g.drawString("Difficulty", refLink.GetGame().GetWidth() / 2 - 600, 130);
        g.drawString("Name", refLink.GetGame().GetWidth() / 2 - 400, 130);
        g.drawString("Time", refLink.GetGame().GetWidth() / 2, 130);

        Font fontRow = new Font("arial", 1, 30);
        g.setFont(fontRow);
        g.setColor(Color.white);


        int i = 40;
        int k = 0;
        for (Record rec : recordList) {
            if (k<=9) {
                g.drawString(String.valueOf(rec.getDifficulty()), refLink.GetGame().GetWidth() / 2 - 600, 130 + i);
                g.drawString(String.valueOf(rec.getName()), refLink.GetGame().GetWidth() / 2 - 400, 130 + i);
                g.drawString(rec.getTime().toString(), refLink.GetGame().GetWidth() / 2, 130 + i);
                i += 40;
                k++;
            } else {
                break;
            }
        }

        settingManager.Draw(g);
    }

    private void sort() {
        recordList.sort(new Comparator<Record>() {
            @Override
            public int compare(Record first, Record second) {
                if (first.getDifficulty().compareTo(second.getDifficulty()) == 0) {
                    return first.getTime().compareTo(second.getTime());
                } else if (first.getDifficulty().compareTo(second.getDifficulty()) > 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
    }
}
