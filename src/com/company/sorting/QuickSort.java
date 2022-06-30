package com.company.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    private static int partition(int[] arr, int leftEndIndex, int rightEndIndex) {
        int pivot = arr[rightEndIndex];
        int pointer = leftEndIndex;

        for (int i = leftEndIndex; i < rightEndIndex; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }
        }
        int temp = arr[rightEndIndex];
        arr[rightEndIndex] = arr[pointer];
        arr[pointer] = temp;
        return pointer;
    }

    private static void quickSort(int[] arr, int leftEndIndex, int rightEndIndex) {
        if (leftEndIndex < rightEndIndex) {
            int partitionIndex = partition(arr, leftEndIndex, rightEndIndex);
            quickSort(arr, leftEndIndex, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, rightEndIndex);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr, 0, arrSize - 1);
        System.out.println(Arrays.toString(arr));
    }
}
