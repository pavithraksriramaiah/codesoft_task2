import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int maxRange = 100;
        int maxAttempts = 10;
        int totalRounds = 0;
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange) + 1;
            int attemptsLeft = maxAttempts;
            boolean hasGuessedCorrectly = false;

            System.out.println("A number between 1 and " + maxRange + " has been generated. Try to guess it!");

            while (attemptsLeft > 0 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attemptsLeft--;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    hasGuessedCorrectly = true;
                    totalScore += attemptsLeft + 1;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low. Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("Your guess is too high. Attempts left: " + attemptsLeft);
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + numberToGuess);
            }

            totalRounds++;
            System.out.println("Total Score: " + totalScore);
            System.out.println("Total Rounds Played: " + totalRounds);

            System.out.print("Do you want to play again? (yes/no): ");
            String userResponse = sc.next();

            playAgain = userResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is " + totalScore + " after " + totalRounds + " rounds.");
        sc.close();
    }
}