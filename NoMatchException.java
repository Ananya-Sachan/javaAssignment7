package assign7Pt3;
import java.util.Scanner;
class NoMatchException extends Exception {
	private String inputString;
    private int lineNumber;
    
    public NoMatchException(String inputString, int lineNumber) {
        this.inputString = inputString;
        this.lineNumber = lineNumber;
    }
    @Override
    public String toString() {
        return "NOMATCHEXCP: Input mismatch at line " + lineNumber + ". Expected 'India' but found '" + inputString + "'.";
    }


}
