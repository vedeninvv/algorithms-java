package com.company.sorting;

import com.company.structures.HeapMax;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    public static int[] heapSort(int[] arr) {
        HeapMax heap = new HeapMax(arr);
        int[] sortedArr = new int[arr.length];
        int i = arr.length - 1;
        while (heap.getSize() > 0) {
            sortedArr[i] = heap.extractRoot();
            i--;
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }

        arr = heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
