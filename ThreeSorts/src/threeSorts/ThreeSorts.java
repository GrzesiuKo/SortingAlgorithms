package threeSorts;

import analysis.*;

public class ThreeSorts {

    private static final int CONSTANT_NUMBER_OF_TESTS = 1000;
    private static final int CONSTANT_MAX_SIZE = 100;

    public static void main(String[] args) {
        Analyst analyst = new Analyst();
        //Results
        long[] randomResults;
        long[] optimisticResults;
        long[] pesimisticResults;
        //Sorting Algorithms
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();
        QuickSort quickSort = new QuickSort();

        SortingAlgorithm currentAlgorithm = quickSort;
        //Data Generators
        RandomGenerator randomGenerator = new RandomGenerator();
        OptimisticGenerator optimisticGenerator = new OptimisticGenerator();
        PesimisticGenerator pesimisticGenerator = new PesimisticGenerator();
        //Test Conditions
        TestConditions random = new TestConditions(CONSTANT_NUMBER_OF_TESTS, CONSTANT_MAX_SIZE, randomGenerator, currentAlgorithm);
        TestConditions optimistic = new TestConditions(CONSTANT_NUMBER_OF_TESTS, CONSTANT_MAX_SIZE, optimisticGenerator, currentAlgorithm);
        TestConditions pesimistic = new TestConditions(CONSTANT_NUMBER_OF_TESTS, CONSTANT_MAX_SIZE, pesimisticGenerator, currentAlgorithm);
        //Analysis
        randomResults = analyst.analyzeSort(random);
        optimisticResults = analyst.analyzeSort(optimistic);
        pesimisticResults = analyst.analyzeSort(pesimistic);

        System.out.println(currentAlgorithm.toString());
        System.out.println("Random Case: " + java.util.Arrays.toString(randomResults) + "\n");
        System.out.println("Optimistic Case: " + java.util.Arrays.toString(optimisticResults) + "\n");
        System.out.println("Pesimistic Case: " + java.util.Arrays.toString(pesimisticResults) + "\n");
    }
}
