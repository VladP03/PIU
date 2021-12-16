package PIUGame;

final class StartGame {
    private static Game game = null;

    private StartGame() {
    }

    public static void startGame() {
        if (game == null) {
            System.out.println("Game created.\n");
            game = new Game("Vanatoarea de diamante", 1400, 780);
        }

        game.StartGame();
    }
}
