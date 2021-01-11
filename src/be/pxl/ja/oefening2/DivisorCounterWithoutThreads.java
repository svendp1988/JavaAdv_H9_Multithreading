package be.pxl.ja.oefening2;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class DivisorCounterWithoutThreads {
    private final List<Integer> maxFound;
    private final int min;
    private final int max;

    public DivisorCounterWithoutThreads(int min, int max) {
        this.min = min;
        this.max = max;
        this.maxFound = getHighestDivisorCount();
    }

    private List<Integer> getHighestDivisorCount() {
        int numberOfThreads = max % 10000 == 0 ? 0 : 1;
        numberOfThreads += max / 10000;
        for (int i = 0; i <= numberOfThreads; i++) {
            ThreadRunner threadRunner = new ThreadRunner(min, max);
            threadRunner.start();
        }
        return IntStream.rangeClosed(min, max)
                .boxed()
                .collect(toMap(Function.identity(), number -> {
                    int divisors = 0;
                    for (int j = number; j > 0; j--) {
                        if (number % j == 0) {
                            divisors++;
                        }
                    }
                    return divisors;
                }))
                .entrySet().stream()
                .collect(groupingBy(Map.Entry::getValue, TreeMap::new, toMap(Map.Entry::getKey, Map.Entry::getValue)))
                .lastEntry()
                .getValue().keySet().stream()
                .mapToInt(i -> i)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getMaxFound() {
        return maxFound;
    }

    public static void main(String[] args) {
//        DivisorCounter divisorCounter = new DivisorCounter(1, 10000);
//        long startTime = System.nanoTime();
//        List<Integer> maxFound = divisorCounter.getMaxFound();
//        long endTime = System.nanoTime();
//        long totalTime = endTime - startTime;
//        maxFound.forEach(System.out::println);
//        System.out.println("totalTime = " + totalTime + " nanoseconds");
        long startTime = System.nanoTime();
        DivisorCounterWithoutThreads divisorCounterWithoutThreads2 = new DivisorCounterWithoutThreads(1, 1000000);
        List<Integer> maxFound = divisorCounterWithoutThreads2.getMaxFound();
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Execution time: " + elapsedTime / 1000000000.0 + " seconds");
        maxFound.forEach(System.out::println);
    }

    private class ThreadRunner extends Thread {
        private DivisorCounterWithoutThreads divisorCounterWithoutThreads = new DivisorCounterWithoutThreads(min, max);

        @Override
        public void run() {
            super.run();
        }
    }
}
