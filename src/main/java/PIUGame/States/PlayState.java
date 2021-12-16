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
    @Getter @Setter
    public static LevelDifficulty levelDifficulty = LevelDifficulty.EASY;       // Nivelul de dificultate al jocului

    public List<Sword> swords = new ArrayList<Sword>();                             // Lista sabiilor pe care eroul le creeaza cand ataca, apasand tasta space
    public List<Explosion> explosions = new ArrayList<Explosion>();                     // Lista animatiilor de explozii cand sabia intalneste un obstacol

    @Getter @Setter
    private static Hero hero;                                                   // Referinta catre obiectul animat erou (controlat de utilizator).
    @Getter @Setter
    public static List<Monster> monsterList;                                    // Lista monstrilor
    @Getter @Setter
    public static List<Stone> stoneList;                                        // Lista pietrelor pe care trebuie sa le colecteze eroul

    public static MapElements map_elements;                                     // Elementele de pe harta care sunt desenate peste tiles pe baza coordonatelor date

    public static ReinitializeObjects reinitializeObjects;                      // La fiecare nivel o serie de obiecte trebuie reinitializate

    // Retine timpul de cand s-a inceput jocul
    @Getter @Setter
    private static int minutes = 0;
    @Getter @Setter
    private static int seconds = 0;
    private static int timer_count = 0;                                          // Tine evidenta update-urilor pentru a numara o secunda(Update-urile se realizeza de 60/s)

    private final RefLinks refLink;                                             // Referinta catre clasa ce are acces la celelalte obiecte

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

    // Actualizeaza starea jocului(variabilele)
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

            if(!stoneList.isEmpty()){
                for(Stone s: stoneList)
                {
                    s.Update();
                    if(stoneList.isEmpty()){
                        break;
                    }
                }
            }

            if (!monsterList.isEmpty()) {
                for (Monster t : monsterList) {
                    t.Update();
                    if (monsterList.isEmpty()) {
                        break;
                    }
                }
            }

            for (Monster m : monsterList) {
                if (m.hasKilledPlayer()) {
                    hero.createExplosionEffect();
                    hero.resetPosition();
                    hero.setLife(hero.getLife() - 1);
                    for (Monster t : monsterList) {
                        t.resetPosition();
                    }
                    if (hero.getLife() == 0) {
                        State.setState(new LoseState(refLink));
                    }
                }
            }

            // determina intervalul de timp care s-a scurs de la inceputul jocului
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

        // verifica daca nivelul s-a terminat
        if (hero.levelFinished()) {
            if (index_level == 2) {
                State.setState(new FinishedGame(refLink));
            } else {
                index_level++;

                // se reinitializeaza obiectele din joc la trecerea catre un nivel nou
                reinitializeObjects.reorganizeObject(index_level);

                map = new Map(refLink, index_level);
                refLink.setMap(map);

            }
        }
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

            for (Stone s : stoneList) {
                s.Draw(g);
            }

            for (Monster t : monsterList) {
                t.Draw(g);
            }


        } else {
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

            for (Stone s : stoneList) {
                s.Draw(g);
            }

            for (Monster t : monsterList) {
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


        // afiseaza numarul de vieti ale player-ului
        Color lifeBoxColor = new Color(130, 229, 231, 200);
        g.setColor(lifeBoxColor);
        g.fillRoundRect(20, 20, 170, 60, 20, 20);
        for (int i = 0; i < hero.getLife(); i++) {
            g.drawImage(Assets.heart_life_image, 25 + i * 50, 30, 60, 40, null);
        }


        // afiseaza numarul de pietre colectate de player
        Color stoneBoxColor = new Color(4, 105, 106, 200);
        g.setColor(stoneBoxColor);
        g.fillRoundRect(200, 20, 100, 60, 20, 20);

        g.drawImage(Assets.stone_image, 210, 30, 40, 40, null);
        Font font1 = new Font("arial", 1, 40);
        g.setFont(font1);
        g.setColor(Color.white);

        String nrOfStone = Integer.toString(hero.nr_stone_collected);
        g.drawString(nrOfStone, 250, 55);


        // afiseaza nivelul la care este player-ul
        Color levelBoxColor = new Color(5, 166, 167, 200);
        g.setColor(levelBoxColor);
        g.fillRoundRect(320, 20, 110, 60, 20, 20);

        Font fontLevel = new Font("arial", 1, 30);
        g.setFont(fontLevel);
        g.setColor(Color.white);

        String currentLevel = "Lvl: ";
        currentLevel += Integer.toString(index_level);
        g.drawString(currentLevel, 330, 60);


        // deseneaza butonul de resume
        resumeManager.Draw(g);
    }
}
