package PIUGame.States;
import PIUGame.Maps.Map;
import PIUGame.Maps.MapElements;
import PIUGame.RefLinks;
import PIUGame.Items.*;
import PIUGame.States.PlayStateUpdates.ReinitializeObjects;

import java.awt.*;

public class PlayState extends State{


    //private UIManager uiManager;

    private static Hero hero;   // < Referinta catre obiectul animat erou (controlat de utilizator).
    private Map map;        // < Referinta catre harta curenta.

    private int index_level = 1;

    public static Monster[] monster;

    public static Stone[] stone;

    public static MapElements map_elements;

    public static String difficulty_level = "Easy";

    public static ReinitializeObjects reinitializeObjects;

    //monster.SetSpeed(32.3);


        // brief Constructorul de initializare al clasei
        // param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program   // `
    public PlayState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);

        ///Construieste harta jocului
        map = new Map(refLink, index_level);

        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);

        ///Construieste eroul
        hero = new Hero(refLink,150, 200);


        // creez obiect care imi va gestiona obiectele in diferite niveluri
        reinitializeObjects = new ReinitializeObjects(refLink);
        reinitializeObjects.reorganizeObject(index_level);

        map_elements = new MapElements(refLink, index_level);
    }

    @Override
    public void Update()
    {
        if(!refLink.GetKeyManager().pause_value) {      //joc pus pe pauza
            map.Update();
            hero.Update();
            for(Stone s: stone) {
                s.Update();
            }

            for (Monster t : monster) {
                //t.Update();
            }

            for (Monster m : monster) {
                if (m.hasKilledPlayer()) {
                    System.out.println("mort");
                    hero.resetPosition();
                    hero.SetLife(hero.GetLife() - 1);
                    for (Monster t : monster) {
                        t.resetPosition();
                    }
                    if (hero.GetLife() == 0) {
//                        refLink.GetGame().getDatabaseConnection().update();
                        State.SetState(new LoseState(refLink));
                    }
                }
            }
        }

        if(hero.levelFinished()){
            if(index_level == 2){
//                refLink.GetGame().getDatabaseConnection().update();
                State.SetState(new FinishedGame(refLink));
            }else {
                index_level++;
                hero.resetPosition();
                //hero.resetStone();

                reinitializeObjects.reorganizeObject(index_level);

                for (Monster t : monster) {
                    t.resetPosition();
                }

                map = new Map(refLink, index_level);
                refLink.SetMap(map);

            }
        }

    }

        // brief Deseneaza (randeaza) pe ecran starea curenta a jocului.
        // param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    @Override
    public void Draw(Graphics g)
    {
        if(!refLink.GetKeyManager().pause_value) {      // jocul este pornit

            //map_elements.Draw(g, index_level);

            map.Draw(g);
            map_elements.Draw(g, index_level);
            hero.Draw(g);


            for(Stone s: stone) {
                s.Draw(g);
            }

            for (Monster t : monster) {
                t.Draw(g);
            }
        }else{
            map.Draw(g);
            map_elements.Draw(g, index_level);
            hero.Draw(g);

            for(Stone s: stone) {
                s.Draw(g);
            }

            for (Monster t : monster) {
                t.Draw(g);
            }


            Font font1 = new Font("arial", 1, 50);
            g.setFont(font1);
            g.setColor(Color.WHITE);
            g.drawString("PAUSE", (int)refLink.GetWidth()/2 - 50, (int)refLink.GetHeight()/2 - 50);
        }

    }

    public static Monster[] GetMonster(){
        return monster;
    }

    public static void setMonster(Monster[] monster) {
        PlayState.monster = monster;
    }

    public static Hero GetHero(){
        return hero;
    }

    public int getIndex_level(){
        return index_level;
    }

    public void setDifficulty_level(String difficulty_level){
        this.difficulty_level = difficulty_level;
    }

    public String getDifficulty_level(){
        return difficulty_level;
    }

    public static Stone[] getStone() {
        return stone;
    }

    public static void setStone(Stone[] stone) {
        PlayState.stone = stone;
    }
}
