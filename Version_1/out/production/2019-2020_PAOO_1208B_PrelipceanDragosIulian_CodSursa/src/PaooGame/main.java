package PaooGame;

public class main {
    public static void main(String [] args){
        //Game paooGame = new Game("Please Run ->", 1400, 780);
        //paooGame.StartGame();


        createGame game1 = createGame.getInstance();
        game1.startGame();
        createGame.reset();

    }

}
