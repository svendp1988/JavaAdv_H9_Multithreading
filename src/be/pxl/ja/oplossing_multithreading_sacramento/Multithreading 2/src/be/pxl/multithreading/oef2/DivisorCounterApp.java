import java.util.ArrayList;
import java.util.List;

public class DivisorCounterApp {

	public static void main(String[] args) {

		// Single thread

		int rangeMax = 50000;
		System.out.println("Range [1-" + rangeMax + "]");

		DivisorCounter thread = new DivisorCounter(1, rangeMax);
		long before = System.currentTimeMillis();
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long after = System.currentTimeMillis();

		System.out.println("Getal: " + thread.getMaxNumber());
		System.out.println("Aantal delers: " + thread.getMaxDivisors());

		double seconds = (after - before) / 1000.0;
		System.out.printf("Single threaded berekening duurde %.3f seconden%n%n", seconds);


		System.out.println("---------------------------------------");

		// Multi-threaded
		long before2 = System.currentTimeMillis();

		int numThreads = 10;
		List<DivisorCounter> list = new ArrayList<>();
		for (int i = 0; i < numThreads; i++) {
			/* Opdeling kan veel efficiënter (# bewerkingen groeit exponentieel) */
			/* Nu: opdeling van de range in <numThreads> gelijke delen */
			DivisorCounter worker = new DivisorCounter(1 + (rangeMax / numThreads) * i, (rangeMax / numThreads) * (i + 1));
			worker.start();
			list.add(worker);
		}

		int maxNumber = -1;
		int maxDivisors = 0;

		for (DivisorCounter counter : list) {
			try {
				counter.join();

				if (counter.getMaxDivisors() > maxDivisors) {
					maxDivisors = counter.getMaxDivisors();
					maxNumber = counter.getMaxNumber();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long after2 = System.currentTimeMillis();

		System.out.println("Getal: " + maxNumber);
		System.out.println("Aantal delers: " + maxDivisors);

		double seconds2 = (after2 - before2) / 1000.0;
		System.out.printf("Multi-threaded berekening duurde %.3f seconden%n%n", seconds2);
	}

}
