package analysis;

public class OptimisticGenerator implements DataGenerator {

    @Override
    public double[] generate(int numberOfElements) {
        double[] data;

        if (numberOfElements <= 0) {
            return null;
        } else {
            data = new double[numberOfElements];
        }

        for (int i = 0; i < numberOfElements; i++) {
            data[i] = i;
        }
        return data;
    }
}
