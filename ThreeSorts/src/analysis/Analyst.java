package analysis;

import threeSorts.SortingAlgorithm;

public class Analyst {

    public long[] analyzeSort(TestConditions testConditions) {
        long[] results;

        results = measureAndSumSortingTimes(testConditions);
        divideResultsByNumberOfTests(testConditions.getNumberOfTests(), results);

        return results;
    }

    private long measureSortingTime(double[] vector, SortingAlgorithm sortingAlgorithm) {
        long start;
        long stop;

        start = System.nanoTime();
        sortingAlgorithm.sort(vector);
        stop = System.nanoTime();

        return stop - start;
    }

    private void divideResultsByNumberOfTests(int numberOfTests, long[] results) {
        for (int i = 0; i < results.length; i++) {
            results[i] = results[i] / numberOfTests;
        }
    }

    private long[] measureAndSumSortingTimes(TestConditions testConditions) {
        double[] currentTestedData;
        long operationTime;
        int maxSize, numberOfTests;
        SortingAlgorithm sortingAlgorithm;
        DataGenerator dataGenerator;
        long[] results;

        if (testConditions == null) {
            return null;
        } else {
            maxSize = testConditions.getMaxSize();
            numberOfTests = testConditions.getNumberOfTests();
            sortingAlgorithm = testConditions.getSortingAlgorithm();
            dataGenerator = testConditions.getDataGenerator();
            results = new long[maxSize + 1]; //We skip zero index and start from one while measuring
        }

        for (int test = 0; test < numberOfTests; test++) {
            for (int i = 1; i <= maxSize; i++) {
                currentTestedData = dataGenerator.generate(i);
                operationTime = measureSortingTime(currentTestedData, sortingAlgorithm);
                results[i] += operationTime;
            }
        }
        return results;
    }
}
