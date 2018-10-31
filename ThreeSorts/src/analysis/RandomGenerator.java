package analysis;

import java.util.Random;

public class RandomGenerator implements DataGenerator {

    private final Random random;

    public RandomGenerator() {
        random = new Random();
    }

    @Override
    public double[] generate(int numberOfElements) {
        double[] data;

        if (numberOfElements <= 0) {
            return null;
        } else {
            data = new double[numberOfElements];
        }

        for (int i = 0; i < numberOfElements; i++) {
            data[i] = random.nextDouble();
        }
        return data;
    }
}
