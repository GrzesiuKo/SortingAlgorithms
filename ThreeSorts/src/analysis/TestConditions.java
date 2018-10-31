package analysis;

import threeSorts.InsertionSort;
import threeSorts.SortingAlgorithm;

public class TestConditions {

    private final int numberOfTests;
    private final int maxSize;
    private final DataGenerator dataGenerator;
    private final SortingAlgorithm sortingAlgorithm;

    public TestConditions(int numberOfTests, int maxSize, DataGenerator dataGenerator, SortingAlgorithm sortingAlgorithm) {
        this.numberOfTests = numberOfTests > 0 ? numberOfTests : 1000;
        this.maxSize = maxSize > 0 ? maxSize : 100;
        this.dataGenerator = dataGenerator != null ? dataGenerator : new RandomGenerator();
        this.sortingAlgorithm = sortingAlgorithm != null ? sortingAlgorithm : new InsertionSort();
    }

    public int getNumberOfTests() {
        return numberOfTests;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public DataGenerator getDataGenerator() {
        return dataGenerator;
    }

    public SortingAlgorithm getSortingAlgorithm() {
        return sortingAlgorithm;
    }
}
