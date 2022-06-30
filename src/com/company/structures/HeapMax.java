package com.company.structures;

import java.util.Arrays;
import java.util.Scanner;

public class HeapMax {
    private int[] values;
    private int size;

    public HeapMax(int[] values) {
        this.values = values;
        this.size = values.length;
        buildHeap();
    }

    public HeapMax(int size) {
        this.values = new int[size];
        this.size = size;
    }

    private void changeSize(int newSize) {
        if (newSize < size) {
            values = Arrays.copyOf(values, newSize);
            size = newSize;
        }
        if (newSize > size) {
            int[] newValues = new int[newSize];
            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
            size = newSize;
        }
    }

    public int[] getValues() {
        return values;
    }

    public int getSize() {
        return size;
    }

    public void siftDown(int i) {
        while (2 * i + 1 < size) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int j = left;
            if (right < size && values[right] > values[left]) {
                j = right;
            }
            if (values[i] >= values[j]) {
                break;
            }
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
            i = j;
        }
    }

    public void siftUp(int i) {
        while (values[i] > values[(i - 1) / 2]) {
            int temp = values[i];
            values[i] = values[(i - 1) / 2];
            values[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }
    }

    public void setElement(int i, int x) {
        if (x > values[i]) {
            values[i] = x;
            siftUp(i);
        }
        if (x < values[i]) {
            values[i] = x;
            siftDown(i);
        }
    }

    public int getElement(int i) {
        return values[i];
    }

    public int extractRoot() {
        int min = values[0];
        values[0] = values[size - 1];
        changeSize(size - 1);
        siftDown(0);
        return min;
    }

    public void addElement(int x) {
        changeSize(size + 1);
        values[size - 1] = x;
        siftUp(size - 1);
    }

    public void deleteElement(int i) {
        setElement(i, values[size - 1]);
        changeSize(size - 1);
    }

    public void buildHeap() {
        for (int i = size / 2; i >= 0; i--) {
            siftDown(i);
        }
    }

    public String toString() {
        return Arrays.toString(values);
    }

    // just for test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = scanner.nextInt();
        }

        HeapMax heap = new HeapMax(arr);
    }
}
