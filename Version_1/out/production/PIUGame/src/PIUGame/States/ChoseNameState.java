package PIUGame.States;

import PIUGame.GameObjects.UIManager;
import PIUGame.RefLinks;

import java.awt.*;

public class ChoseNameState extends State {

    private UIManager choseNameManager;

    public ChoseNameState(RefLinks refLinks){
        super(refLinks);
        choseNameManager = new UIManager(refLinks);
        refLink.GetMouseManager().setUIManager(choseNameManager);


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
