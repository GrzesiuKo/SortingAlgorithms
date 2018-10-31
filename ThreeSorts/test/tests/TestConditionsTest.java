package tests;

import threeSorts.QuickSort;
import threeSorts.InsertionSort;
import analysis.PesimisticGenerator;
import analysis.RandomGenerator;
import analysis.TestConditions;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestConditionsTest {

    TestConditions testConditions;

    @Before
    public void setUp() {
        testConditions = null;
    }

    @Test
    public void testConditionsConstructorIfInvalidArguments() {
        //When
        testConditions = new TestConditions(-10, 0, null, null);
        //Then
        assertEquals(100, testConditions.getMaxSize());
        assertEquals(1000, testConditions.getNumberOfTests());
        assertEquals(true, testConditions.getSortingAlgorithm() instanceof InsertionSort);
        assertEquals(true, testConditions.getDataGenerator() instanceof RandomGenerator);
    }

    @Test
    public void testConditionsConstructorIfValidArguments() {
        //Given
        int numberOfTests = 400;
        int maxSize = 200;
        PesimisticGenerator pesimisticGenerator = new PesimisticGenerator();
        QuickSort quickSort = new QuickSort();
        //When
        testConditions = new TestConditions(numberOfTests, maxSize, pesimisticGenerator, quickSort);
        //Then
        assertEquals(200, testConditions.getMaxSize());
        assertEquals(400, testConditions.getNumberOfTests());
        assertEquals(pesimisticGenerator, testConditions.getDataGenerator());
        assertEquals(quickSort, testConditions.getSortingAlgorithm());
    }
}
