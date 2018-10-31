package cw3;

import threeSorts.QuickSort;
import threeSorts.MergeSort;
import threeSorts.SortingAlgorithm;
import threeSorts.InsertionSort;
import analysis.Analyst;
import analysis.DataGenerator;
import analysis.OptimisticGenerator;
import analysis.PesimisticGenerator;
import analysis.RandomGenerator;
import analysis.TestConditions;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnalystTest {

    Analyst analyst;
    TestConditions testConditions;
    SortingAlgorithm sortingAlgorithm;
    DataGenerator dataGenerator;

    @Before
    public void setUp() {
        analyst = new Analyst();
        testConditions = null;
        sortingAlgorithm = null;
        dataGenerator = null;
    }

    @Test
    public void testAnalyzeSortTestCheckIfInitializedCorrectly() {
        //Given
        long[] results;
        sortingAlgorithm = new QuickSort();
        dataGenerator = new PesimisticGenerator();
        testConditions = new TestConditions(100, 100, dataGenerator, sortingAlgorithm);
        //When
        results = analyst.analyzeSort(testConditions);
        //Then
        assertEquals(true, results != null);
        assertEquals(101, results.length);//101 because we want the last index to be 100
    }

    @Test
    public void testAnalyzeSortTestCheckIfValuesAreNonNegative() {
        //Given
        long[] results;
        boolean areValuesNonNegative;
        sortingAlgorithm = new MergeSort();
        dataGenerator = new OptimisticGenerator();
        testConditions = new TestConditions(100, 100, dataGenerator, sortingAlgorithm);
        //When
        results = analyst.analyzeSort(testConditions);
        areValuesNonNegative = checkIfValuesAreNonNegative(results);
        //Then
        assertEquals(true, areValuesNonNegative);
    }

    @Test
    public void testAnalyzeSortTestCheckIfValuesNotOnlyZeros() {
        //Given
        long[] results;
        boolean areValuesOnlyZeros;
        sortingAlgorithm = new InsertionSort();
        dataGenerator = new PesimisticGenerator();
        testConditions = new TestConditions(100, 100, dataGenerator, sortingAlgorithm);
        //When
        results = analyst.analyzeSort(testConditions);
        areValuesOnlyZeros = checkIfValuesAreOnlyZeros(results);
        //Then
        assertEquals(false, areValuesOnlyZeros);
    }

    @Test
    public void testAnalyzeSortTestCheckIfOmitedZeroIndex() {
        //Given
        long[] results;
        sortingAlgorithm = new QuickSort();
        dataGenerator = new RandomGenerator();
        testConditions = new TestConditions(100, 100, dataGenerator, sortingAlgorithm);
        //When
        results = analyst.analyzeSort(testConditions);
        //Then
        assertEquals(0, results[0]);
    }

    private boolean checkIfValuesAreNonNegative(long[] results) {
        int size = results.length;
        for (int i = 0; i < size; i++) {
            if (results[i] < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIfValuesAreOnlyZeros(long[] results) {
        int size = results.length;
        int zeroCounter = 0;
        for (int i = 0; i < size; i++) {
            if (results[i] == 0) {
                zeroCounter++;
            }
        }
        return zeroCounter == size;
    }
}
