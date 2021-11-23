import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;

public class GuessGame extends Game {
    private int hiddenNumber;
    private Scanner input;
    private int lower, upper, guess, numberGuesses;
    public GuessGame() {
        isRunning = true;
        hiddenNumber = newHiddenNumber(0, 1);
        input = new Scanner(System.in);
        guess = -1;
        numberGuesses = 0;
    }

    private int newHiddenNumber(int lower, int upper) {
        Random rand = new Random();
        return rand.nextInt(lower, upper + 1);
    }

    @Override
    public void run() {
        start();
        menu();
        while (guess != hiddenNumber) {
            getGuess();
            if (guess > hiddenNumber) {
                System.out.println("Too high!");
            } else if (guess < hiddenNumber) {
                System.out.println("Too low!");
            }
            numberGuesses++;
        }
        System.out.println("Congrats that was the hidden number!");
        System.out.println("It took you " + numberGuesses + " guesses! Good job!");
    }

    public void reset() {
        hiddenNumber = newHiddenNumber(lower, upper);
        guess = -1;
        numberGuesses = 0;
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

    protected void getGuess() {
        guess = 0;
        System.out.print("Please enter your guess: ");
        try {
            guess = input.nextInt();
        } catch (Exception e) {
            System.out.println("You did not enter valid input. Please run the program again.");
            System.exit(1);
        }
    }

    protected void menu() {
        getBoundsFromUser();
    }

    @Override
    boolean isRunning() {
        return isRunning;
    }

    public boolean playAgain() {
        System.out.print("Would you like to play again? (y/n) ");
        String userInput = input.next();
        return userInput.charAt(0) == 'y';
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
        hiddenNumber = newHiddenNumber(lower, upper);
    }

    @Override
    void quit() {
        isRunning  = false;
        System.out.println("Thank you for playing!");
    }
}
