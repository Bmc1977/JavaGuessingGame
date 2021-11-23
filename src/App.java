public class App {
    public static void main(String[] args) {
        GuessGame myGame = new GuessGame();
        do {
            myGame.run();
            if (!myGame.playAgain()) {
                myGame.quit();
            }
            myGame.reset();
        } while (myGame.isRunning());
    }
}
