package analysis;

public class PesimisticGenerator implements DataGenerator {

    @Override
    public double[] generate(int numberOfElements) {
        double[] data;
        double value;

        if (numberOfElements <= 0) {
            return null;
        } else {
            data = new double[numberOfElements];
            value = (double) numberOfElements;
        }

        for (int i = 0; i < numberOfElements; i++) {
            data[i] = --value;
        }
        return data;
    }
}
