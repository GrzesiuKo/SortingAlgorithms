package cw3;

import analysis.OptimisticGenerator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OptimisticGeneratorTest {

    OptimisticGenerator optimisticGenerator;

    public OptimisticGeneratorTest() {
    }

    @Before
    public void setUp() {
        optimisticGenerator = new OptimisticGenerator();
    }

    @Test
    public void testGenerateIfPositiveArgument() {
        //Given
        double[] actual;
        double[] expected = {0, 1, 2, 3, 4, 5};
        //When
        actual = optimisticGenerator.generate(6);
        //Then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testGenerateIfNegativeArgument() {
        //Given
        double[] actual;
        double[] expected = null;
        //When
        actual = optimisticGenerator.generate(-1);
        //Then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testGenerateIfArgumentIsZero() {
        //Given
        double[] actual;
        double[] expected = null;
        //When
        actual = optimisticGenerator.generate(0);
        //Then
        assertArrayEquals(expected, actual, 0);
    }
}
