package threeSorts;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        int size;
        int unsortedPointer;

        if (unsortedVector == null) {
            return null;
        } else {
            size = unsortedVector.length;
            unsortedPointer = 0;
        }

        while (unsortedPointer < size) {
            insort(unsortedVector, unsortedPointer);
            unsortedPointer++;
        }
        return unsortedVector;
    }

    private void insort(double[] vector, int unsortedIndex) {
        int sortedIndex;
        double unsortedValue;
        double sortedValue;

        if (!areArgumentsValid(vector, unsortedIndex)) {
            return;
        } else {
            sortedIndex = unsortedIndex - 1;
            unsortedValue = vector[unsortedIndex];
        }

        while (sortedIndex >= 0) {
            sortedValue = vector[sortedIndex];

            if (unsortedValue < sortedValue) {
                moveRight(vector, sortedIndex);
            } else {
                vector[sortedIndex + 1] = unsortedValue;
                return;
            }
            if (sortedIndex - 1 < 0) {
                vector[sortedIndex] = unsortedValue;
            }
            sortedIndex--;
        }
    }

    private void moveRight(double[] vector, int elementIndex) {
        int size = vector.length;
        int newIndex = elementIndex + 1;

        if (newIndex < size) {
            vector[newIndex] = vector[elementIndex];
        }
    }

    private boolean areArgumentsValid(double[] vector, int unsortedIndex) {
        return vector != null && unsortedIndex > 0 && unsortedIndex < vector.length;
    }
}
