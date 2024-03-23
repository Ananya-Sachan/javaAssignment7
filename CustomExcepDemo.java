package assign7Pt3;
import java.util.Scanner;
public class CustomExcepDemo {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter a string (Type 'India' to proceed):");
	        String userInput = scanner.nextLine();

	        try {
	            checkInput(userInput);
	            System.out.println("User input matches 'India'. Proceeding with the program.");
	        } catch (NoMatchException e) {
	            System.out.println(e);
	        }
	    }

	    // Method to check input and throw custom exception
	    private static void checkInput(String input) throws NoMatchException {
	        if (!input.equals("India")) {
	            throw new NoMatchException(input, Thread.currentThread().getStackTrace()[2].getLineNumber());
	        }
	    }

}
