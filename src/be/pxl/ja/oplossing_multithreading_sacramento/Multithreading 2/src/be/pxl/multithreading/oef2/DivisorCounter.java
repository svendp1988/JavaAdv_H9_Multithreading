public class DivisorCounter extends Thread {

	private int rangeMin;
	private int rangeMax;

	private int maxDivisors;
	private int maxNumber;

	public DivisorCounter(int rangeMin, int rangeMax) {
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
	}

	@Override
	public void run() {

		findHighestNumber();
	}

	private void findHighestNumber() {
		for (int i = rangeMin; i <= rangeMax; i++) {
			int numberOfDivisors = getNumberOfDivisors(i);
			if (numberOfDivisors >= maxDivisors) {
				maxDivisors = numberOfDivisors;
				maxNumber = i;
			}
		}
	}

	private int getNumberOfDivisors(int i) {
		int numberOfDivisors = 0;
		for (int divisor = 1; divisor <= i; divisor++) {
			if (i % divisor == 0) {
				numberOfDivisors++;
			}
		}
		return numberOfDivisors;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public int getMaxDivisors() {
		return maxDivisors;
	}

}
