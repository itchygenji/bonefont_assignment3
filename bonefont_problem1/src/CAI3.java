import java.util.Scanner;
import java.security.SecureRandom;




/*The program shall generate random numbers with a SecureRandom object
 * The program shall ask the student to solve 10 different multiplication problems
 * Multiplication problems shall contain two numbers sampled from a uniform random distribution in the range of 0 to 9 (inclusive)
 * The program shall display a random positive message if the student provides a correct response
 * The program shall display a random negative message if the student provides an incorrect response
 * The program shall display the student's score after the student has attempted to solve 10 problems
 * The student's score shall be the percentage of problems correctly solved
 * The program shall display the message "Please ask your teacher for extra help." if the student's score is less than 75%
 * The program shall display the message "Congratulations, you are ready to go to the next level!" if the student's score is greater than or equal to 75%
 * The program shall ask the student if they want to solve a new problem set after the score message has been displayed
 * The program shall restart when the student agrees to solve a new problem set
 * The program shall terminate when the student declines to solve another problem set
 * Create a method called "quiz" that contains the program logic
 * Create a function called "askQuestion" that prints the problem to the screen
 * Create a function called "readResponse" that reads the answer from the student
 * Create a function called "isAsnwerCorrect" that checks to see if the student's answer matches the correct answer to the problem
 * Create a function called "displayCorrectResponse" that prints out the response when a student enters a correct answer
 * Create a function called "displayInorrectResponse" that prints out the response when a student enters an incorrect answer
 * Create a function called "displayCompletionMessage" that prints out the studen't score and appropriate score response
 * Create a main method that runs your program by calling the "quiz" method*/



public class CAI3 {
	
	static SecureRandom  randomNumbers = new SecureRandom();
	private static int digit1 = randomNumbers.nextInt(10);
	private static int digit2 = randomNumbers.nextInt(10);
	private static int switchChoice = 1 + randomNumbers.nextInt(4);
	private static int response, correctAnswers, finalGradeResponse;
	private static String response2;
	static boolean problemSetRepeat;
	
	
	private static void isAnswerCorrect() {
		if(response == (digit1 * digit2)) {
			++correctAnswers;
			displayCorrectResponse();
		}else {
			displayIncorrectResponse();
		}
	}
	
	private static void displayCorrectResponse() {
		switch(switchChoice) {
		case 1:
			System.out.println("Very Good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
			break;
		}
	}
	private static void displayIncorrectResponse() {
		switch(switchChoice) {
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more");
			break;
		case 3:
			System.out.println("Don't give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	
	private static void quiz(){
		
		do {
			for(int i = 0; i < 10; i++) {
				digit1 = randomNumbers.nextInt(10);
				digit2 = randomNumbers.nextInt(10);
				askQuestion();
				readResponse();
				while(true) {
					switchChoice = 1 + randomNumbers.nextInt(4);
					
					if(response != (digit1 * digit2)) {
						
						isAnswerCorrect();
						System.out.println();
						
						break;
					}
					else if(response == (digit1 * digit2)) {
						isAnswerCorrect();
						System.out.println();
						break;
					}

				}
			}
			
			displayCompletionMessage();
			System.out.printf("\n\nIf you would you like to try another problem set; please type yes, otherwise type anything to quit?\n");
			Scanner input = new Scanner(System.in);
			response2 = input.nextLine();
			
			if(response2.equalsIgnoreCase("yes")) {
				correctAnswers = 0;
				quiz();
			}else {
				problemSetRepeat = false;
				
				System.out.println("You have finished!");
			}
		
			}
		while(problemSetRepeat == true);
		
		
		
	}
	
	public static void askQuestion() {
		
			System.out.printf("How much is %d times %d?%n", digit1, digit2);
			
	}
	
	private static void readResponse() {
		Scanner input = new Scanner(System.in);
		response = input.nextInt();
		//System.out.println(response);
	}
	
	private static void displayCompletionMessage() {
		finalGradeResponse = (correctAnswers * 100) / 10;
		
		
		if(finalGradeResponse >= 75) {
			System.out.printf("Congratulations, you are ready to go to the next level!\nYour score is %d%%", finalGradeResponse);
		}else {
			System.out.printf("Please ask your teacher for extra help.\nYour score is %d%%", finalGradeResponse);
		}
		
	}
	

	public static void main(String[] args) {
		
		quiz();
		
		


	}

}
