import java.util.Scanner;
import java.security.SecureRandom;

/*
 * Create a method called "quiz" that contains the program logic
 * Create a method called "askQuestion" that prints the problem to the screen
 * Create a method called "readResponse" that reads the answer from the student
 * Create a method called "isAsnwerCorrect" that checks to see if the student's answer matches the correct answer to the problem
 * Create a method called "displayCorrectResponse" that prints out the response when a student enters a correct answer
 * Create a method called "displayInorrectResponse" that prints out the response when a student enters an incorrect answer
 * Create a main method that runs your program by calling the "quiz" method
 */

public class CAI1 {
	
	static SecureRandom  randomNumbers = new SecureRandom();
	private static int digit1 = randomNumbers.nextInt(10);
	private static int digit2 = randomNumbers.nextInt(10);
	private static int response;
	
	
	private static void isAnswerCorrect() {
		if(response == (digit1 * digit2)) {
			displayCorrectResponse();
		}else {
			displayIncorrectResponse();
		}
	}
	
	
	
	
	private static void displayCorrectResponse() {
		System.out.println("Very Good!");
	}
	private static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
	
	
	private static void quiz(){
	
		askQuestion();
		readResponse();
		while(true) {
			if(response != (digit1 * digit2)) {
				displayIncorrectResponse();
				askQuestion();
				readResponse();
				continue;
			}
			else if(response == (digit1 * digit2)) {
				isAnswerCorrect();
				break;
			}

		}
		
		
	}
	
	public static void askQuestion() {
		System.out.printf("How much is %d times %d?%n", digit1, digit2);
	}
	



	public static void main(String[] args) {
		quiz();
	
	}
	
	private static void readResponse() {
		Scanner input = new Scanner(System.in);
		response = input.nextInt();
		//System.out.println(response);
	}
	

}
