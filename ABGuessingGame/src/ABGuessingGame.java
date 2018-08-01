//John Chung King Sow
//The task is to write an A/B guessing game which makes use of a hashtable to keep track of various
//last four guess combinations and associates those with a count of the next guess that followed. 
//The key is a four character 

import java.util.HashMap;
import java.util.Scanner; 


public class ABGuessingGame {

	private HashMap<String, AB>sequences; 

	public static void play(){

		Scanner input = new Scanner (System.in); 

		ABGuessingGame guesser = new ABGuessingGame(); 

		//the game variables 

		String guesses = "";  

		char letterGuess = ' ';

		int correctGuess = 0; //To store the count of correct guesses 

		int incorrectGuess = 0; //To store the count of incorrect guesses 

		while(true) {

			System.out.println("Please select between A or B:");
			input.nextLine();

			letterGuess = guesser.getGuess(guesses); //Computer's turn to guess

			if (letterGuess != 'A' && letterGuess !='B'){
				throw new IllegalStateException();
			}

			//We need to get the user's response to the computer's guess 
			
			String userResponse = ""; 

			while (userResponse.toUpperCase().charAt(0) != 'N' &&
					userResponse.toUpperCase().charAt(0)!='Y' && 
					userResponse.toUpperCase().charAt(0)!='Q'){
				System.out.println("Your Guess is: " + letterGuess);
				System.out.println("Is my guess correct or not?");
				userResponse = input.next();
			}

			switch (userResponse.toUpperCase().charAt(0)) {

			case 'Q': System.exit(0); //Exit the game 
			case 'Y': correctGuess++; //We increment correctGuesses if y is pressed to determine that the guess is correct 
			break;
			case 'N': 

				letterGuess = letterGuess =='A'? 'B': 'A'; 
				incorrectGuess++; 
			}

			if(guesses.length() > 3){
				guesser.addSequence(guesses, letterGuess);

				// We add current guess/actual response to guesses

				guesses = guesses.substring(1, guesses.length()) 

						+ Character.toString(letterGuess);

			}

			else { // sequence hasn't reached length 4 yet

				guesses += Character.toString(letterGuess);

			}


          //To display the score of the correct guesses and incorrect guesses 
			System.out.println("Score: " + correctGuess + " correct guesses and " 

			+ incorrectGuess + " incorrect guesses");

		}
	}


	private ABGuessingGame() {

		sequences = new HashMap<>();

	}



	// returns most common choice if parameter in memory or a random choice

	private char getGuess(String guesses) {

		char guess = getMostCommonChoice(guesses);

		return guess == ' ' ? randAB() : guess;

	}



	// writes a sequence/choice pair to memory

	private void addSequence(String sequence, char choice) {

		if (sequences.get(sequence) == null) {

			sequences.put(sequence, new AB());

		}



		AB temp = new AB();

		if (choice == 'A') {   // We increment A

			temp.a = ++sequences.get(sequence).a;

			temp.b = sequences.get(sequence).b;

		}

		else if (choice == 'B') {   //We increment B

			temp.a = sequences.get(sequence).a;

			temp.b = ++sequences.get(sequence).b;

		}

		else {

			throw new IllegalStateException();

		}

		sequences.put(sequence, temp);

	}



	// returns the most common choice if sequence has been seen, or a blank char if unseen 

		
	private char getMostCommonChoice(String sequence) {

		if (sequences.containsKey(sequence)) {

			return sequences.get(sequence).a > 

			sequences.get(sequence).b ? 'A' : 'B';

		}

		return ' ';

	}



	// returns a random choice

	private char randAB() {

		return Math.random() >= .5 ? 'A' : 'B';

	}



	// represents a count of A and B choices

	private class AB {

		private int a;

		private int b;



		private AB() {

			a = 0;

			b = 0;

		}

	}
}


