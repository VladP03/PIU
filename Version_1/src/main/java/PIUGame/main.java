package PIUGame;

public class main {
    public static void main(String [] args){
        createGame game1 = createGame.getInstance();
        game1.startGame();
        createGame.reset();
    }
}
