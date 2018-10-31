package tests;

import analysis.RandomGenerator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomGeneratorTest {

    RandomGenerator randomGenerator;

    @Before
    public void setUp() {
        randomGenerator = new RandomGenerator();
    }

    @Test
    public void testGenerateIfPositiveArgument() {
        //Given
        double[] actual;
        boolean isNull;
        boolean areValuesOnlyZeros;
        //When
        actual = randomGenerator.generate(6);
        isNull = checkIfNull(actual);
        areValuesOnlyZeros = checkIfValuesAreOnlyZeros(actual);
        //Then
        assertEquals(isNull, false);
        assertEquals(actual.length, 6);
        assertEquals(false, areValuesOnlyZeros);
    }

    @Test
    public void testGenerateIfNegativeArgument() {
        //Given
        double[] actual;
        double[] expected = null;
        //When
        actual = randomGenerator.generate(-1);
        //Then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testGenerateIfArgumentIsZero() {
        //Given
        double[] actual;
        double[] expected = null;
        //When
        actual = randomGenerator.generate(0);
        //Then
        assertArrayEquals(expected, actual, 0);
    }

    private boolean checkIfNull(double[] vector) {
        return vector == null;
    }

    private boolean checkIfValuesAreOnlyZeros(double[] vector) {
        int size = vector.length;
        int zeroCount = 0;

        for (int i = 0; i < size; i++) {
            if (vector[i] == 0) {
                zeroCount++;
            }
        }
        return zeroCount == size;
    }
}
