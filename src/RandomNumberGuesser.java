import java.util.Scanner;

/**
 * This is the RandomNumberGuesser class that allows a user to guess numbers between 1 and 100
 * and depending on whether the guess is too high or too low to some random number
 * will be asked for a new guess in a smaller range of numbers
 * @author shyazanar
 *
 */
public class RandomNumberGuesser {
	/**
	 * The main method that starts a game and when finished will
	 * prompt user whether they want to continue or not
	 * @param args
	 */
	public static void main(String[] args) {
		//create a Scanner object to read from the keyboard
		Scanner keyboard = new Scanner (System.in);
		// create variables to hold the
		int randNum;	// random number generated
		int nextGuess;	// users next guess
		int highGuess;	// the high value of range of guesses to try
		int lowGuess;	// the low value of range of guesses to try
		String userResponse;	// user response to whether to play again
		
		do {
			// initialize the game with the high value, low value, random number and guess count
			highGuess = 100;
			lowGuess = 1;
			randNum = RNG.rand();
			RNG.resetCount();
			// prompt user to enter their first guess
			System.out.println("Enter your first guess");
			// repeat reading response from keyboard until a valid guess is received
			do {
				nextGuess = keyboard.nextInt();
			} while (!RNG.inputValidation(nextGuess, lowGuess, highGuess));
			// print number of  guesses made so far
			System.out.println("Number of guesses is " + RNG.getCount());
			// repeat this block until a correct guess is made
			while (nextGuess != randNum) {
				if (nextGuess > randNum) {
					// print this message when the guess is too high
					System.out.println("Your guess is too high");
					// set the high value of the range of guesses to new guess
					highGuess = nextGuess;
					// prompt user to enter their next guess between new range of guesses
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					// repeat reading response from keyboard until a valid guess is received
					do {
						nextGuess = keyboard.nextInt();
					} while (!RNG.inputValidation(nextGuess, lowGuess, highGuess));
					// print number of  guesses made so far
					System.out.println("Number of guesses is " + RNG.getCount());
				} else {
					// print this message when the guess is too low
					System.out.println("Your guess is too low");
					// set the low value of the range of guesses to new guess
					lowGuess = nextGuess;
					// prompt user to enter their next guess between new range of guesses
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
					// repeat reading response from keyboard until a valid guess is received
					do {
						nextGuess = keyboard.nextInt();
					} while (!RNG.inputValidation(nextGuess, lowGuess, highGuess));
					// print number of  guesses made so far
					System.out.println("Number of guesses is " + RNG.getCount());
				}
			};
			// print this message when a correct guess is made
			System.out.println("Congratulations, you guessed correctly");
			
			// prompt user whether to try again
			System.out.println("Try again (yes or no)");
			// clear the new line char from keyboard
			keyboard.nextLine();
			// and read the user response
			userResponse = keyboard.nextLine();
			
		} while(userResponse.equalsIgnoreCase("yes"));
		// print final message
		System.out.println("Thanks for playing...");	
		// close the keyboard scanner object
		keyboard.close();
	}

}
