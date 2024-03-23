package assign7Pt2;

public class ExceptionDemo {
	 public static void main(String[] args) {
	        for (String arg : args) {
	            try {
	                int num = Integer.parseInt(arg);
	                factorial(num);
	            } catch (NumberFormatException e) {
	                System.out.println("NumberFormatException: Invalid number format - " + arg);
	            } catch (FactorialException e) {
	                System.out.println(e.toString());
	            }
	        }
	    }

	    // Method to calculate factorial
	    private static void factorial(int n) throws FactorialException {
	        if (n < 0 || n > 15) {
	            throw new FactorialException(n);
	        }

	        int result = 1;
	        for (int i = 1; i <= n; i++) {
	            result *= i;
	        }
	        System.out.println("Factorial of " + n + " is: " + result);
	    }
}
