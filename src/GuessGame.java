import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;

public class GuessGame extends Game {
    private int hiddenNumber;
    private Scanner input;
    private int lower, upper;
    public GuessGame() {
        isRunning = true;
        hiddenNumber = newHiddenNumber(0, 1);
        input = new Scanner(System.in);
    }

    private int newHiddenNumber(int lower, int upper) {
        Random rand = new Random();
        return rand.nextInt(upper + lower + 1) - lower;
    }

    @Override
    public void run() {
        start();
        if (isRunning) {
            menu();
        }
    }

    private void start() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("You're game will begin in a moment...");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("There was an error. Please run again.");
            e.printStackTrace();
        }
    }

    protected void menu() {
        getBoundsFromUser();
    }

    private void getBoundsFromUser() {
        System.out.print("Please enter the lower bound of the range you would like to guess from: ");
        try {
            lower = input.nextInt();
        } catch (Exception e) {
            System.out.println("You did not enter valid input. Please run the program again.");
            System.exit(1);
        }
        System.out.print("Please enter the upper bound of the range you would like to guess from: ");
        try {
            upper = input.nextInt();
        } catch (Exception e) {
            System.out.println("You did not enter valid input. Please run the program again.");
            System.exit(1);
        }
    }

    @Override
    void quit() {
        isRunning  = false;
    }
}
