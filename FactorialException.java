package assign7Pt2;

class FactorialException  extends Exception{
	private int number;

    public FactorialException(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FactorialException: Invalid input for factorial calculation - " + number;
    }
}
