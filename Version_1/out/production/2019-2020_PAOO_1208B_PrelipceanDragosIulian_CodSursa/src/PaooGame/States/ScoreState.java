package PaooGame.States;

import PaooGame.GameObjects.UIManager;
import PaooGame.GameObjects.UITextButton;
import PaooGame.Input.ClickListener;
import PaooGame.RefLinks;
import PaooGame.DatabaseConnection.Record;

import java.awt.*;
import java.util.LinkedList;

public class ScoreState extends State{

    private UIManager settingManager;
    private LinkedList<Record> records;


    public ScoreState(RefLinks refLink){

        super(refLink);
        settingManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(settingManager);


        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 460, 200, 80, "Reset record", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                refLink.GetGame().getDatabaseConnection().deleteRecords();
                //sterge inregistrarile sau o parte din ele


                State.SetState(new ScoreState(refLink));
                //System.exit(1);
                //refLink.GetGame().StopGame();
            }
        }));

        settingManager.addObject(new UITextButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 560, 200, 80, "<- Back to meniu", new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new MenuState(refLink));
                //System.exit(1);
                //refLink.GetGame().StopGame();
            }
        }));

        //records = null;
        records = refLink.GetGame().getDatabaseConnection().getRecords();

    }
    @Override
    public void Update()
    {
        //System.out.println("leaderBoard");
        settingManager.Update();

    }


    @Override
    public void Draw(Graphics g)
    {
        Font fontTitle = new Font("arial", 1, 50);
        g.setFont(fontTitle);
        g.setColor(Color.white);
        g.drawString("Best Score", refLink.GetGame().GetWidth() / 2 - 100, 70);

        Font fontTable = new Font("arial", 1, 30);
        g.setFont(fontTable);
        g.setColor(Color.white);

        g.drawString("Level", refLink.GetGame().GetWidth() / 2 -600, 130);
        g.drawString("Diamond Collected", refLink.GetGame().GetWidth() / 2 -400, 130);
        g.drawString("Difficulty Level", refLink.GetGame().GetWidth() / 2 , 130);

        Font fontRow = new Font("arial", 1, 30);
        g.setFont(fontRow);
        g.setColor(Color.white);


        int i=40;

        for(Record rec: records){
        //for(int j=0; j< records.size(); j++){

            g.drawString(String.valueOf(rec.getLevel()), refLink.GetGame().GetWidth() / 2 -600, 130 + i);
            g.drawString(String.valueOf(rec.getDiamondCollected()), refLink.GetGame().GetWidth() / 2 -400, 130 + i);
            g.drawString(rec.getDifficultyLevel(), refLink.GetGame().GetWidth() / 2 , 130 + i);
            i += 40;
        }




        settingManager.Draw(g);
    }
}
