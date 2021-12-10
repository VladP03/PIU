package PIUGame;

import PIUGame.Database.HibernateUtil;

public class Main {
    public static void main(String [] args){
        // start session to DB
        HibernateUtil.startSession();

        // start the game
        StartGame.startGame();
    }
}
