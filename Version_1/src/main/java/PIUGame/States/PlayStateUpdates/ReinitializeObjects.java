package PIUGame.States.PlayStateUpdates;

import PIUGame.Items.ItemDirection;
import PIUGame.Items.Monster;
import PIUGame.Items.Stone;
import PIUGame.RefLinks;

import java.util.ArrayList;
import java.util.List;

public class ReinitializeObjects {

    private final RefLinks refLink;

    public ReinitializeObjects(RefLinks refLink) {
        this.refLink = refLink;
    }

    public void reorganizeObject(Integer level) {
        switch (level) {
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

    public void createObjectLevel_1() {

        // restabilesc pozitia player-ului (chiar daca a fost setata)
        refLink.getGame().getPlayState().getHero().setX(150);
        refLink.getGame().getPlayState().getHero().setY(200);

//        refLink.GetGame().getPlayState().GetHero().SetX(1700);
//        refLink.GetGame().getPlayState().GetHero().SetY(800);

        refLink.getGame().getPlayState().getHero().setInitialX(150);
        refLink.getGame().getPlayState().getHero().setInitialY(200);


        // stabilesc zona in care player-ul va trece la nivelul urmator
        refLink.getGame().getPlayState().getHero().setFinish_zone_x(1750);
        refLink.getGame().getPlayState().getHero().setFinish_zone_y(770);

        // zona in care se trece efectic la nivelul urmator
        refLink.getGame().getPlayState().getHero().setTarget_to_follow_x(1825);
        refLink.getGame().getPlayState().getHero().setTarget_to_follow_y(770);


        // se reseteaza variabila care ne spune ca suntem in zona de final (ultima verificare ce ne permite trece la nivelul urmator)
        refLink.getGame().getPlayState().getHero().set_arrive_at_gate(false);

        // resetez timpul
        refLink.getGame().getPlayState().setMinutes(0);
        refLink.getGame().getPlayState().setSeconds(0);

        //stabilesc pozitiile pietrelor
        List<Stone> stoneList = new ArrayList<>();
        stoneList.add(new Stone(refLink, 620, 144));
        stoneList.add(new Stone(refLink, 1340, 96));
        stoneList.add(new Stone(refLink, 576, 864));
        stoneList.add(new Stone(refLink, 1050, 576));
        stoneList.add(new Stone(refLink, 1728, 336));


        // stabilesc pozitiile inamicilor
        List<Monster> monster = new ArrayList<Monster>();
        monster.add(new Monster(refLink, 760, 430));
        monster.add(new Monster(refLink, 1300, 380));
        monster.add(new Monster(refLink, 700, 700));
        monster.add(new Monster(refLink, 150, 300, ItemDirection.DOWN, 400));
        monster.add(new Monster(refLink, 1100, 800, ItemDirection.RIGHT, 500));


        // reinitializez obiectele din PlayState
        refLink.getGame().getPlayState().setStoneList(stoneList);
        refLink.getGame().getPlayState().setMonsterList(monster);
    }

    public void createObjectLevel_2() {
        // restabilesc pozitia player-ului (chiar daca a fost setata)
        refLink.getGame().getPlayState().getHero().setX(140);
        refLink.getGame().getPlayState().getHero().setY(180);

        refLink.getGame().getPlayState().getHero().setInitialX(140);
        refLink.getGame().getPlayState().getHero().setInitialY(180);

        // stabilesc zona in care player-ul va trece la nivelul urmator
        refLink.getGame().getPlayState().getHero().setFinish_zone_x(2680);
        refLink.getGame().getPlayState().getHero().setFinish_zone_y(3500);

        // zona in care se trece efectic la nivelul urmator
        refLink.getGame().getPlayState().getHero().setTarget_to_follow_x(2793);
        refLink.getGame().getPlayState().getHero().setTarget_to_follow_y(3500);


        // se reseteaza variabila care ne spune ca suntem in zona de final (ultima verificare ce ne permite trece la nivelul urmator)
        refLink.getGame().getPlayState().getHero().set_arrive_at_gate(false);

        //stabilesc pozitiile pietrelor
        List<Stone> stoneList = new ArrayList<>();
         stoneList.add(new Stone(refLink, 2*314, 2*703));
        stoneList.add(new Stone(refLink, 2*71, 2*839));
        stoneList.add(new Stone(refLink, 2*118, 2*1660));
        stoneList.add(new Stone(refLink, 2*1417, 2*1557));
        stoneList.add(new Stone(refLink, 2*786, 2*71));
        stoneList.add(new Stone(refLink, 2*1407, 2*557));


        // stabilesc pozitiile inamicilor
        List<Monster> monster = new ArrayList<Monster>();
        monster.add(new Monster(refLink, 2*342, 2*65, ItemDirection.RIGHT, 2*1286 - 2*342));
        monster.add(new Monster(refLink, 2*1286, 2*65, ItemDirection.LEFT, 2*1286 - 2*342));
        monster.add(new Monster(refLink, 2*64, 2*445, ItemDirection.RIGHT, 2*450 - 2*64));
        monster.add(new Monster(refLink, 2*70, 2*354, ItemDirection.DOWN, 2*1250 - 2*354));
        monster.add(new Monster(refLink, 64, 445));
        monster.add(new Monster(refLink, 1913, 639));
        monster.add(new Monster(refLink, 1328, 711));
        monster.add(new Monster(refLink, 2804, 1665));
        monster.add(new Monster(refLink, 1148, 1125));
        monster.add(new Monster(refLink, 1679, 1332));
        monster.add(new Monster(refLink, 2300, 1755));
        monster.add(new Monster(refLink, 2813, 2934));
        monster.add(new Monster(refLink, 1958, 2394));
        monster.add(new Monster(refLink, 2183, 3087));
        monster.add(new Monster(refLink, 1499, 3555));
        monster.add(new Monster(refLink, 1166, 3096));
        monster.add(new Monster(refLink, 383, 3285));
        monster.add(new Monster(refLink, 833, 1755));
        monster.add(new Monster(refLink, 122, 2511));
        monster.add(new Monster(refLink, 572, 2799));
        monster.add(new Monster(refLink, 743, 2430));
        // reinitializez obiectele din PlayState
        refLink.getGame().getPlayState().setStoneList(stoneList);
        refLink.getGame().getPlayState().setMonsterList(monster);
    }
}
