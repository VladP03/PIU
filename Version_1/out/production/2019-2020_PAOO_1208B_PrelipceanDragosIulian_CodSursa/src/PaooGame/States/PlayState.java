package PaooGame.States;
import PaooGame.DatabaseConnection.DatabaseConnection;
import PaooGame.GameCamera.GameCamera;
import PaooGame.GameObjects.UIImageButton;
import PaooGame.GameObjects.UIManager;
import PaooGame.Graphics.Assets;
import PaooGame.Input.ClickListener;
import PaooGame.Maps.Map;
import PaooGame.Maps.MapElements;
import PaooGame.RefLinks;
import PaooGame.Items.*;

import java.awt.*;
import PaooGame.Items.Character;

public class PlayState extends State{


    //private UIManager uiManager;

    private static Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/

    private int index_level=1;

    public static Monster[] monster = new Monster[4];

    public static Stone[] stone = new Stone[5];

    public static MapElements map_elements;

    public static String difficulty_level = "Easy";

    //monster.SetSpeed(32.3);

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);
        ///Construieste harta jocului
        map = new Map(refLink, 1);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
        ///Construieste eroul
        hero = new Hero(refLink,50, 200);
        monster[0] = new Monster(refLink,844, 310);
        monster[1] = new Monster(refLink,720, 770);
        monster[2] = new Monster(refLink,1190, 528);
        monster[3] = new Monster(refLink,440, 810);

        //aseaza pietrele
        stone[0] = new Stone(refLink, 620, 144);
        stone[1] = new Stone(refLink, 1340, 96);
        stone[2] = new Stone(refLink, 576, 864);
        stone[3] = new Stone(refLink, 1050, 576);
        stone[4] = new Stone(refLink, 1728, 336);
        //monster[0].SetSpeed(1.0f);

        for(Monster m: monster){
            m.SetSpeed(0.6f);
        }

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
            //stone.stoneCollected();

            for (Monster t : monster) {
                t.Update();
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
                        refLink.GetGame().getDatabaseConnection().update();
                        State.SetState(new LoseState(refLink));
                    }
                }
            }
        }

        if(hero.levelFinished()){
            if(index_level == 2){
                refLink.GetGame().getDatabaseConnection().update();
                State.SetState(new FinishedGame(refLink));
            }else {
                hero.resetPosition();
                hero.resetStone();
                for (Monster t : monster) {
                    t.resetPosition();
                }
                index_level++;
                map = new Map(refLink, index_level);
                refLink.SetMap(map);

            }
        }

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        if(!refLink.GetKeyManager().pause_value) {
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

}
