// NUMBER GUESSING GAME

import java.util.Random;
import javax.swing.JOptionPane;

public class GuessTheNumberGame
{

    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Number Guessing Game!");

        // Set the range for the random number
        int min = 1;
        int max = 100;

        // Set the number of rounds
        int rounds = 3;

        // Variable to keep track of the user's total score
        int totalScore = 0;

        int avg=0;

        // Game loop for multiple rounds
        for (int round = 1; round <= rounds; round++) 
        {
            System.out.println("\n**** Welcome to Round " + round + " of " + rounds + " ****");

            // Generate a random number between minRange and maxRange (inclusive)
            int randNumber = getRandomNumber(min, max);

            System.out.println("Guess the number between " + min + " and " + max + ".");

            // Game loop for attempts
            int attempts = 0;
            while (true) 
            {
                // Show the input dialog for user guess
                String userInput = JOptionPane.showInputDialog(null, "Attempt " + (attempts + 1) + ": Enter your guess:");
                int userGuess = Integer.parseInt(userInput);
                attempts++;

                // Check if the guess matches the random number
                if (userGuess == randNumber) 
                {
                    System.out.println("\nYEAH!...Congratulations! You guessed the correct number! The number is "+userGuess);
                    int points = 100 - (attempts + 1)*5;
                    totalScore += points;
                    avg=totalScore/3;
                    System.out.println("You earned " + points + " points in this round.");
                    break; // Break out of the attempts loop since the number is guessed correctly
                } 
                else if (userGuess < randNumber) 
                {
                    System.out.println("OOPS! The number " +userGuess+ " is Smaller than the number generated randomly. Please TRY YOUR LUCK AGAIN");
                } 
                else 
                {
                    System.out.println("OOPS! The number "+userGuess+ " is Greater than the number generated randomly. Please TRY YOUR LUCK AGAIN");
                }
            }
        }

        // Display the final score after all rounds are finished
        System.out.println("\nGame Over! Your average score for 3 rounds is: " + avg);
        System.out.println();
    }

    // Function to generate a random number between min and max (inclusive)
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
