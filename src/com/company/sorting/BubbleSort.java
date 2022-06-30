package com.company.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int arrSize = arr.length;
        for (int i = 0; i < arrSize; i++){
            for (int j = 0; j < arrSize - i - 1; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
