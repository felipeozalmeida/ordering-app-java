package utils;

import java.util.Date;
import java.util.Random;

public class Utils {
    private static int[] generateArray(int length) {
        int[] array = new int[length];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(length);
        }

        return array;
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int lowestNumberIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[lowestNumberIndex]) lowestNumberIndex = j;
            }

            int value = array[lowestNumberIndex];
            array[lowestNumberIndex] = array[i];
            array[i] = value;
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;

            while (j > 0 && array[j - 1] > array[j]) {
                int value = array[j];
                array[j] = array[j - 1];
                array[j - 1] = value;
                j--;
            }
        }
    }

    private static int partition(int[] v, int p, int r) {
        int i = p - 1;

        for (int j = p; j < r; j++) {
            if (v[j] <= v[r]) {
                i++;
                int value = v[j];
                v[j] = v[i];
                v[i] = value;
            }
        }

        i++;
        int value = v[r];
        v[r] = v[i];
        v[i] = value;

        return i;
    }

    private static void quickSort(int[] v, int p, int r) {
        if (p < r) {
            int q = partition(v, p, r);
            quickSort(v, p, q - 1);
            quickSort(v, q + 1, r);
        }
    }

    public static void testSorting(int length, String algorithm) {
        int[] numbers = generateArray(length);

        long startTime = new Date().getTime();

        if (algorithm == "selection") selectionSort(numbers);
        if (algorithm == "insertion") insertionSort(numbers);
        if (algorithm == "quick") quickSort(numbers, 0, numbers.length - 1);

        long endTime = new Date().getTime();

        for (int i: numbers) System.out.println(i);
        System.out.printf("Time spent: %d\n", endTime - startTime);
    }
}
