package threeSorts;

public class MergeSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        int begin, mid, end, size;
        double[] newVector;

        if (unsortedVector == null) {
            return null;
        } else {
            size = unsortedVector.length;
            newVector = new double[size];
            System.arraycopy(unsortedVector, 0, newVector, 0, size);
        }

        for (int interval = 1; interval < size; interval *= 2) {
            for (begin = 0; begin < size; begin = end + 1) {
                mid = begin + interval < size ? begin + interval : size - 1;
                end = mid + interval - 1 < size ? mid + interval - 1 : size - 1;
                newVector = merge(newVector, begin, mid, end);
            }
        }
        return newVector;
    }

    public double[] merge(double[] vector, int startLeft, int mid, int endRight) {
        int leftIterator, rightIterator, resultIterator, size;
        double[] newVector;

        if (!areGivenArgumentsValid(vector, startLeft, mid, endRight)) {
            return null;
        } else {
            size = vector.length;
            newVector = new double[size];
        }

        leftIterator = startLeft;
        rightIterator = mid;
        resultIterator = startLeft;

        while (leftIterator < mid && rightIterator <= endRight) {
            if (vector[leftIterator] <= vector[rightIterator]) {
                newVector[resultIterator++] = vector[leftIterator++];
            } else if (vector[leftIterator] > vector[rightIterator]) {
                newVector[resultIterator++] = vector[rightIterator++];
            }
        }

        while (leftIterator < mid) {
            newVector[resultIterator++] = vector[leftIterator++];
        }

        while (rightIterator < size) {
            newVector[resultIterator++] = vector[rightIterator++];
        }

        // Copy the beginning of the old vector to the new one since it was sorted before
        if (startLeft > 0) {
            System.arraycopy(vector, 0, newVector, 0, startLeft);
        }

        return newVector;
    }

    private boolean areGivenArgumentsValid(double[] vector, int startLeft, int mid, int endRight) {
        int size;

        if (vector == null) {
            return false;
        } else {
            size = vector.length;
        }

        if (startLeft >= size || endRight >= size || startLeft > endRight) {
            return false;
        }

        if (startLeft > mid || mid > endRight) {
            return false;
        }

        return true;
    }
}
