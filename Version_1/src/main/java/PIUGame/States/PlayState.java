package PIUGame.States;
import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.GameObjects.UITextButton;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.Maps.Map;
import PIUGame.Maps.MapElements;
import PIUGame.RefLinks;
import PIUGame.Items.*;
import PIUGame.States.PlayStateUpdates.ReinitializeObjects;

import java.util.List;
import java.awt.*;
import java.util.ArrayList;

public class PlayState extends State{


    private UIManager resumeManager;
    private RefLinks refLink;

    private static Hero hero;   // < Referinta catre obiectul animat erou (controlat de utilizator).
    private Map map;        // < Referinta catre harta curenta.

    private int index_level = 1;
    public static List<Monster> monster;
    public static Stone[] stone;
    public static MapElements map_elements;
    public static String difficulty_level = "Easy";
    public static ReinitializeObjects reinitializeObjects;
    public List<Sord> sords = new ArrayList<Sord>();
    public List<Explosion> explosions = new ArrayList<Explosion>();

    public static int minutes = 0;
    public static int seconds = 0;
    public static int timer_count = 0;



    //monster.SetSpeed(32.3);


        // brief Constructorul de initializare al clasei
        // param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program
    public PlayState(RefLinks refLink)
    {
        ///Apel al constructorului clasei de baza
        super(refLink);
        this.refLink = refLink;

        // se actualizeaza obiectele cand starea de playState este resetata deoarece se pierde focusul(este esentiala la trecerea dintr-o stare in alta: de ex, din starea meniu in playState)
        updateObjectWithListener();

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


    // se actualizeaza obiectele cand starea de playState este resetata deoarece se pierde focusul
    public void updateObjectWithListener(){
        // Seteaza un buton de resume
        resumeManager = new UIManager(refLink);
        refLink.GetMouseManager().setUIManager(resumeManager);

        resumeManager.addObject(new UIImageButton( 1100, 28, 130, 44, Assets.menu_button_image, new ClickListener() {
        //resumeManager.addObject(new UIImageButton((int)(refLink.GetGame().GetWidth() / 2) - 100, 140, 200, 80, Assets.buttonStart_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.GetMouseManager().setUIManager(null);
                State.SetState(new ResumeState(refLink));
                //State.SetState(new ChooseNameState(refLink));
            }
        }));
    }


    @Override
    public void Update()
    {
        if(!refLink.GetKeyManager().pause_value) {      //jocul este pornit
            map.Update();
            hero.Update();

            if(!sords.isEmpty()){
                for(int i=0; i<sords.size(); i++){
                    sords.get(i).Update();
                    if(sords.isEmpty()){
                        break;
                    }
                    //System.out.println("update_sord");
                }
            }

            if(!explosions.isEmpty()){
                for(Explosion e: explosions){
                    e.Update();
                    if(explosions.isEmpty()){
                        break;
                    }
                    //System.out.println("update_sord");
                }
            }

            for(Stone s: stone) {
                s.Update();
            }

            if(!monster.isEmpty()) {
                for (Monster t : monster) {
                    //t.Update();
                }
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

            if(timer_count <= 60){
                timer_count++;
            }
            else{
                timer_count = 0;
                if(seconds == 59){
                    minutes++;
                    seconds = 0;
                }else{
                    seconds++;
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

        //resumeManager.Update();
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

            if(!sords.isEmpty()){
                for(Sord s: sords){
                    s.Draw(g);
                }
            }


            if(!explosions.isEmpty()){
                for(Explosion e: explosions){
                    e.Draw(g);
                    if(!explosions.isEmpty()){
                        break;
                    }
                }
            }

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

            Font font_pause = new Font("arial", 1, 50);
            g.setFont(font_pause);
            g.setColor(Color.WHITE);
            g.drawString("PAUSE", (int)refLink.GetWidth()/2 - 50, (int)refLink.GetHeight()/2 - 50);
        }

        // afiseaza timpul
        g.setColor(Color.GRAY);
        g.fillRoundRect(1230, 30, 110, 40, 20, 20);

        Font font_timer = new Font("arial", 1, 25);
        g.setFont(font_timer);
        g.setColor(Color.WHITE);
        g.drawString(""+ minutes + " : " + seconds, 1250, 60);


        // deseneaza butonul de resume
        resumeManager.Draw(g);


    }

    public static List<Monster> GetMonster(){
        return monster;
    }

    public static void setMonster(List<Monster> monster) {
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

    public List<Sord> getSords() {
        return sords;
    }

    public void setSords(List<Sord> sords) {
        this.sords = sords;
    }

    public List<Explosion> getExplosions() {
        return explosions;
    }

    public void setExplosions(List<Explosion> explosions) {
        this.explosions = explosions;
    }
}
