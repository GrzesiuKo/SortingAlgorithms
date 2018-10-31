package threeSorts;

import java.util.Stack;

public class QuickSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        double[] newVector;
        int size;

        if (unsortedVector == null) {
            return null;
        } else {
            size = unsortedVector.length;
            newVector = new double[size];
            System.arraycopy(unsortedVector, 0, newVector, 0, size);
        }

        quickSort(newVector, 0, size - 1);

        return newVector;
    }

    private void quickSort(double vector[], int startLeft, int endRight) {
        Stack<Integer> stack = new Stack<>();
        int pivotIndex;
        stack.push(startLeft);
        stack.push(endRight);

        while (!stack.isEmpty()) {

            endRight = stack.pop();
            startLeft = stack.pop();
            pivotIndex = divide(vector, startLeft, endRight);

            if (pivotIndex - 1 > startLeft) {
                stack.push(startLeft);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < endRight) {
                stack.push(pivotIndex + 1);
                stack.push(endRight);
            }
        }
    }

    public int divide(double[] vector, int start, int end) {
        int pivotIndex, currentElementIndex, insertIndex;
        double pivot;

        if (!areArgumentsValid(vector, start, end)) {
            return -1;
        } else {
            pivotIndex = end;
            pivot = vector[pivotIndex];
            currentElementIndex = start;
            insertIndex = start;
        }

        while (currentElementIndex < pivotIndex) {
            if (vector[currentElementIndex] < pivot) {
                swap(vector, currentElementIndex, insertIndex++);
            }
            currentElementIndex++;
        }

        swap(vector, insertIndex, pivotIndex);
        pivotIndex = insertIndex;

        return pivotIndex;
    }

    private boolean areArgumentsValid(double[] vector, int start, int end) {
        return vector != null && start < end && start < vector.length && end < vector.length;
    }

    private void swap(double[] vector, int left, int right) {
        double tmp = vector[left];
        vector[left] = vector[right];
        vector[right] = tmp;
    }
}
