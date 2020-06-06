package utils;

import java.util.Date;
import java.util.Random;

public class Utils {
    public static int[] generateArray(int length) {
        int[] array = new int[length];

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000000);
        }

        return array;
    }

    public static void selectionSort(int[] array) {
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

    public static void insertionSort(int[] array) {
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

    public static void testSorting(int length, String algorithm) {
        int[] numbers = generateArray(length);

        long startTime = new Date().getTime();

        if (algorithm == "selection") selectionSort(numbers);
        if (algorithm == "insertion") insertionSort(numbers);

        long endTime = new Date().getTime();

        for (int i: numbers) System.out.println(i);
        System.out.printf("Time spent: %d", endTime - startTime);
    }
}
