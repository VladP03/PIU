package PaooGame;

public class createGame {

    private static createGame instance = null;
    private static Game game = null;

    private createGame(){
        System.out.println("Game is created.\n");
        game = new Game("Please Run ->", 1400, 780);
    }

    public static createGame getInstance(){
        if(instance == null){
            instance = new createGame();
        }
        return instance;
    }

    public static void reset(){
        instance = null;
    }

    public static void startGame(){
        game.StartGame();
    }

}
