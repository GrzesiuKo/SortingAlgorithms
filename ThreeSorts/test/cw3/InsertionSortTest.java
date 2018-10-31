package cw3;

import threeSorts.InsertionSort;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class InsertionSortTest {

    InsertionSort insertionSort;

    @Before
    public void setUp() {
        insertionSort = new InsertionSort();
    }

    @Test
    public void testSortIFNull() {
        //Given
        double[] given = null;
        double[] result = null;
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(result, given, 0);
    }

    @Test(timeout = 100)
    public void testSortIfOnlyEqualNumbers() {
        //Given
        double[] given = {16, 16, 16, 16, 16, 16};
        double[] result = {16, 16, 16, 16, 16, 16};
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(result, given, 0);
    }

    @Test
    public void testSortIfOnlyNegativeNumbers() {
        //Given
        double[] given = {-10, -50, -100, -40, -20, -90, -60, -70, -30, -80};
        double[] result = {-100, -90, -80, -70, -60, -50, -40, -30, -20, -10};
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(result, given, 0);
    }

    @Test
    public void testSortIfNegativeAndPositiveNumbers() {
        //Given
        double[] given = {18, -50, -100, -40, 17, -90, -60, -70, 15, -80};
        double[] result = {-100, -90, -80, -70, -60, -50, -40, 15, 17, 18};
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(result, given, 0);
    }

    @Test
    public void testSortIfTwoEqualAmongDifferent() {
        //Given
        double[] given = {18, -100, -40, -60, -70, 15, 18, -80, 50, 60};
        double[] result = {-100, -80, -70, -60, -40, 15, 18, 18, 50, 60};
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(result, given, 0);
    }

    @Test
    public void testSortIfOnlyPositiveNumbers() {
        //Given
        double[] given = {8, 3, 6, 4, 2, 1, 5, 6, 7, 9, 0};
        double[] result = {0, 1, 2, 3, 4, 5, 6, 6, 7, 8, 9};
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(result, given, 0);
    }

    @Test
    public void testSortIfEvenNumberOfElements() {
        //Given
        double[] given = {7, 8, 4, 6};
        double[] expected = {4, 6, 7, 8};
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(expected, given, 0);
    }

    @Test
    public void testSortIfOddNumberOfElements() {
        //Given
        double[] given = {7, 8, 9, 10, 3, 4, 6, 8, 9};
        double[] expected = {3, 4, 6, 7, 8, 8, 9, 9, 10};
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(expected, given, 0);
    }

    @Test
    public void testSortIfElementsSortedInDescendingOrder() {
        //Given
        double[] given = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        double[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //When
        given = insertionSort.sort(given);
        //Then
        assertArrayEquals(expected, given, 0);
    }
}
