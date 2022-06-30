package com.company.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    private static void mergeSort(int[] arr, int leftEndIndex, int rightEndIndex, int[] buffer) {
        if (leftEndIndex < rightEndIndex) {
            int partitionIndex = (leftEndIndex + rightEndIndex) / 2;
            mergeSort(arr, leftEndIndex, partitionIndex, buffer);
            mergeSort(arr, partitionIndex + 1, rightEndIndex, buffer);

            int bufferCounter = leftEndIndex;
            for (int firstPartCounter = leftEndIndex, secondPartCounter = partitionIndex + 1;
                 firstPartCounter <= partitionIndex || secondPartCounter <= rightEndIndex; ) {
                if (secondPartCounter > rightEndIndex || (firstPartCounter <= partitionIndex && arr[firstPartCounter] < arr[secondPartCounter])) {
                    buffer[bufferCounter] = arr[firstPartCounter];
                    firstPartCounter++;
                } else {
                    buffer[bufferCounter] = arr[secondPartCounter];
                    secondPartCounter++;
                }
                bufferCounter++;
            }
            System.arraycopy(buffer, leftEndIndex, arr, leftEndIndex, rightEndIndex - leftEndIndex + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] buffer = new int[arrSize];
        mergeSort(arr, 0, arrSize - 1, buffer);
        System.out.println(Arrays.toString(arr));
    }
}
