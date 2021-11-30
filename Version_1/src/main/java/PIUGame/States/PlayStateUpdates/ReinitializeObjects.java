package PIUGame.States.PlayStateUpdates;

import PIUGame.Items.Monster;
import PIUGame.Items.MonsterDirection;
import PIUGame.Items.Stone;
import PIUGame.RefLinks;

public class ReinitializeObjects {

    private RefLinks refLink;

    public ReinitializeObjects(RefLinks refLink){
        this.refLink = refLink;
    }

    public void reorganizeObject(Integer level){
        switch(level){
            case 1:
                createObjectLevel_1();
                break;
            case 2:
                createObjectLevel_2();
                break;
            default:
                break;
        }
    }

    public void createObjectLevel_1(){

        // restabilesc pozitia player-ului (chiar daca a fost setata)
        refLink.GetGame().getPlayState().GetHero().SetX(150);
        refLink.GetGame().getPlayState().GetHero().SetY(200);

//        refLink.GetGame().getPlayState().GetHero().SetX(1700);
//        refLink.GetGame().getPlayState().GetHero().SetY(800);

        refLink.GetGame().getPlayState().GetHero().setInitialX(150);
        refLink.GetGame().getPlayState().GetHero().setInitialY(200);


        // stabilesc zona in care player-ul va trece la nivelul urmator
        refLink.GetGame().getPlayState().GetHero().setFinish_zone_x(1750);
        refLink.GetGame().getPlayState().GetHero().setFinish_zone_y(770);

        refLink.GetGame().getPlayState().GetHero().setTarget_to_follow_x(1825);
        refLink.GetGame().getPlayState().GetHero().setTarget_to_follow_y(770);



        //stabilesc pozitiile pietrelor
        Stone[] stone = new Stone[5];
        stone[0] = new Stone(refLink, 620, 144);
        stone[1] = new Stone(refLink, 1340, 96);
        stone[2] = new Stone(refLink, 576, 864);
        stone[3] = new Stone(refLink, 1050, 576);
        stone[4] = new Stone(refLink, 1728, 336);


        // stabilesc pozitiile inamicilor
        Monster[] monster = new Monster[5];
        monster[0] = new Monster(refLink,760, 430);
        monster[1] = new Monster(refLink,1300, 380);
        monster[2] = new Monster(refLink,700, 700);
        monster[3] = new Monster(refLink,150, 300, MonsterDirection.DOWN, 400);
        monster[4] = new Monster(refLink,1100, 800, MonsterDirection.RIGHT, 500);

        // seteaza viteza monstrului
        for(Monster m: monster){
            m.SetSpeed(0.6f);
        }


        // reinitializez obiectele din PlayState
        refLink.GetGame().getPlayState().setStone(stone);
        refLink.GetGame().getPlayState().setMonster(monster);
    }

    public void createObjectLevel_2(){

        // restabilesc pozitia player-ului (chiar daca a fost setata)
        refLink.GetGame().getPlayState().GetHero().SetX(140);
        refLink.GetGame().getPlayState().GetHero().SetY(180);

        refLink.GetGame().getPlayState().GetHero().setInitialX(140);
        refLink.GetGame().getPlayState().GetHero().setInitialY(180);


        //stabilesc pozitiile pietrelor
        Stone[] stone = new Stone[5];
        stone[0] = new Stone(refLink, 620, 144);
        stone[1] = new Stone(refLink, 1340, 96);
        stone[2] = new Stone(refLink, 576, 864);
        stone[3] = new Stone(refLink, 1050, 576);
        stone[4] = new Stone(refLink, 1728, 336);


        // stabilesc pozitiile inamicilor
        Monster[] monster = new Monster[4];
        monster[0] = new Monster(refLink,680, 367, MonsterDirection.RIGHT, 500);
        monster[1] = new Monster(refLink,1820, 560, MonsterDirection.RIGHT, 400);
        monster[2] = new Monster(refLink,2193, 980, MonsterDirection.DOWN, 300);
        monster[3] = new Monster(refLink,80, 300, MonsterDirection.DOWN, 400);


        // seteaza viteza monstrului
        for(Monster m: monster){
            m.SetSpeed(0.6f);
        }


        // reinitializez obiectele din PlayState
        refLink.GetGame().getPlayState().setStone(stone);
        refLink.GetGame().getPlayState().setMonster(monster);
    }


}
