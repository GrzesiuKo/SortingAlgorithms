package tests;

import analysis.PesimisticGenerator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PesimisticGeneratorTest {

    PesimisticGenerator pesimisticGenerator;

    @Before
    public void setUp() {
        pesimisticGenerator = new PesimisticGenerator();
    }

    @Test
    public void testGenerateIfPositiveArgument() {
        //Given
        double[] actual;
        double[] expected = {5, 4, 3, 2, 1, 0};
        //When
        actual = pesimisticGenerator.generate(6);
        //Then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testGenerateIfNegativeArgument() {
        //Given
        double[] actual;
        double[] expected = null;
        //When
        actual = pesimisticGenerator.generate(-1);
        //Then
        assertArrayEquals(expected, actual, 0);
    }

    @Test
    public void testGenerateIfArgumentIsZero() {
        //Given
        double[] actual;
        double[] expected = null;
        //When
        actual = pesimisticGenerator.generate(0);
        //Then
        assertArrayEquals(expected, actual, 0);
    }
}
