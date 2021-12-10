package PIUGame.States;

import PIUGame.GameObjects.UIImageButton;
import PIUGame.GameObjects.UIManager;
import PIUGame.Graphics.Assets;
import PIUGame.Input.ClickListener;
import PIUGame.Items.*;
import PIUGame.Maps.Map;
import PIUGame.Maps.MapElements;
import PIUGame.RefLinks;
import PIUGame.States.Difficulty.LevelDifficulty;
import PIUGame.States.PlayStateUpdates.ReinitializeObjects;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PlayState extends State {

    public static List<Monster> monster;                                        // Lista monstrilor
    public static Stone[] stone;                                                // Lista pietrelor pe care trebuie sa le colecteze eroul
    public static MapElements map_elements;                                     // Elementele de pe harta care sunt desenate peste tiles pe baza coordonatelor date
    public static LevelDifficulty levelDifficulty = LevelDifficulty.EASY;       // Nivelul de dificultate al jocului
    public static ReinitializeObjects reinitializeObjects;                      // La fiecare nivel o serie de obiecte trebuie reinitializate
    // Retine timpul de cand s-a inceput jocul
    public static int minutes = 0;
    public static int seconds = 0;
    public static int timer_count = 0;                                          // Tine evidenta update-urilor pentru a numara o secunda(Update-urile se realizeza de 60/s)
    private static Hero hero;                                                   // < Referinta catre obiectul animat erou (controlat de utilizator).
    private final RefLinks refLink;                                             // Referinta catre clasa ce are acces la celelalte obiecte
    public List<Sword> swords = new ArrayList<Sword>();                             // Lista sabiilor pe care eroul le creeaza cand ataca, apasand tasta space
    public List<Explosion> explosions = new ArrayList<Explosion>();                     // Lista animatiilor de explozii cand sabia intalneste un obstacol
    private UIManager resumeManager;                                            // Referinta catre obiectul care gestioneaza meniul de Resume(cand se apasa pe butonul MENU)
    private Map map;                                                            // < Referinta catre harta curenta.
    private int index_level = 1;                                                // Indexul nivelului


    // brief Constructorul de initializare al clasei
    // param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program
    public PlayState(RefLinks refLink) {
        ///Apel al constructorului clasei de baza
        super(refLink);
        this.refLink = refLink;

        // se actualizeaza obiectele cand starea de playState este resetata deoarece se pierde focusul(este esentiala la trecerea dintr-o stare in alta: de ex, din starea meniu in playState)
        updateObjectWithListener();

        ///Construieste harta jocului
        map = new Map(refLink, index_level);

        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.setMap(map);

        ///Construieste eroul
        hero = new Hero(refLink, 150, 200);


        // creez obiect care imi va gestiona obiectele in diferite niveluri
        reinitializeObjects = new ReinitializeObjects(refLink);
        reinitializeObjects.reorganizeObject(index_level);

        map_elements = new MapElements(refLink, index_level);
    }

    public static void setLevelDifficulty(LevelDifficulty levelDifficulty) {
        PlayState.levelDifficulty = levelDifficulty;
    }

    public static void setStone(Stone[] stone) {
        PlayState.stone = stone;
    }

    public static void setMonster(List<Monster> monster) {
        PlayState.monster = monster;
    }

    public static Hero getHero() {
        return hero;
    }

    public static void setMinutes(int minutes) {
        PlayState.minutes = minutes;
    }

    public static int getSeconds() {
        return seconds;
    }

    public static void setSeconds(int seconds) {
        PlayState.seconds = seconds;
    }

    public static LevelDifficulty getLevelDifficulty() {
        return levelDifficulty;
    }

    public static List<Monster> getMonster(){
        return monster;
    }

    // se actualizeaza obiectele cand starea de playState este resetata deoarece se pierde focusul
    public void updateObjectWithListener() {
        // Seteaza un buton de resume
        resumeManager = new UIManager(refLink);
        refLink.getMouseManager().setUIManager(resumeManager);

        resumeManager.addObject(new UIImageButton(1100, 28, 130, 44, Assets.menu_button_image, new ClickListener() {
            @Override
            public void onClick() {
                refLink.getMouseManager().setUIManager(null);
                State.setState(new ResumeState(refLink));
            }
        }));
    }

    @Override
    public void Update() {
        if (!refLink.getKeyManager().pause_value) {      //jocul este pornit
            hero.Update();

            if (!swords.isEmpty()) {
                for (int i = 0; i < swords.size(); i++) {
                    swords.get(i).Update();
                    if (swords.isEmpty()) {
                        break;
                    }
                }
            }

            if (!explosions.isEmpty()) {
                for (int j = 0; j < explosions.size(); j++) {
                    explosions.get(j).Update();
                }
            }

            for (Stone s : stone) {
                s.Update();
            }

            if (!monster.isEmpty()) {
                for (Monster t : monster) {
                    t.Update();
                    if (monster.isEmpty()) {
                        break;
                    }
                }
            }

            for (Monster m : monster) {
                if (m.hasKilledPlayer()) {
                    System.out.println("mort");

                    hero.createExplosionEffect();

                    hero.resetPosition();
                    hero.setLife(hero.getLife() - 1);
                    for (Monster t : monster) {
                        t.resetPosition();
                    }
                    if (hero.getLife() == 0) {
                        //hero.setIsAlive(false);

                        //waitForExplosionEffect();
//                        if(explosion_effect_finished == true){
//                            State.SetState(new LoseState(refLink));
//                        }
                        State.setState(new LoseState(refLink));
//                        refLink.GetGame().getDatabaseConnection().update();
                    }
                }
            }

            if (timer_count <= 60) {
                timer_count++;
            } else {
                timer_count = 0;
                if (seconds == 59) {
                    minutes++;
                    seconds = 0;
                } else {
                    seconds++;
                }
            }
        }

        if (hero.levelFinished()) {
            if (index_level == 2) {
                //System.out.println("done");
//                refLink.GetGame().getDatabaseConnection().update();
                State.setState(new FinishedGame(refLink));
            } else {
                //System.out.println("not yet");
                index_level++;

                // se reinitializeaza obiectele din joc la trecerea catre un nivel nou
                reinitializeObjects.reorganizeObject(index_level);

                map = new Map(refLink, index_level);
                refLink.setMap(map);

            }
        }
        //resumeManager.Update();
    }

    // brief Deseneaza (randeaza) pe ecran starea curenta a jocului.
    // param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    @Override
    public void Draw(Graphics g) {


        if (!refLink.getKeyManager().pause_value) {      // jocul este pornit

            //map_elements.Draw(g, index_level);

            map.Draw(g);
            map_elements.Draw(g, index_level);
            hero.Draw(g);

            if (!swords.isEmpty()) {
                for (Sword s : swords) {
                    s.Draw(g);
                }
            }


            if (!explosions.isEmpty()) {
                for (Explosion e : explosions) {
                    e.Draw(g);
                    if (!explosions.isEmpty()) {
                        break;
                    }
                }
            }

            for (Stone s : stone) {
                s.Draw(g);
            }

            for (Monster t : monster) {
                t.Draw(g);
            }


        } else {
            map.Draw(g);
            map_elements.Draw(g, index_level);
            hero.Draw(g);

            for (Stone s : stone) {
                s.Draw(g);
            }

            for (Monster t : monster) {
                t.Draw(g);
            }

            // afiseaza pe centru mesajul "PAUSE" cand jocul este pus pe pauza(a fost apasata tasta "P")
            Font font_pause = new Font("arial", 1, 50);
            g.setFont(font_pause);
            g.setColor(Color.WHITE);
            g.drawString("PAUSE", refLink.getWidth() / 2 - 50, refLink.getHeight() / 2 - 50);
        }

        // afiseaza timpul
        g.setColor(Color.GRAY);
        g.fillRoundRect(1230, 30, 110, 40, 20, 20);

        Font font_timer = new Font("arial", 1, 25);
        g.setFont(font_timer);
        g.setColor(Color.WHITE);
        g.drawString("" + minutes + " : " + seconds, 1250, 60);


        // deseneaza butonul de resume
        resumeManager.Draw(g);
    }
}
