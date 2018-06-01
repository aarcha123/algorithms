package com.algorithms.search;

import java.util.Scanner;

/**
 * Binary search using array - non recursive
 */
public class BinarySearch {
    private static Scanner scanner = new Scanner(System.in);
    private int[] numarray;
    private int n;

    BinarySearch(int n) {
        this.n = n;
        numarray = new int[n];
    }

    void init() {
        System.out.println("Enter number data set:");
        for (int i = 0; i < n; i++) {
            numarray[i] = scanner.nextInt();
        }
    }

    boolean search(int key) {
        boolean found = false;
        int begin = 0, end = n;
        int mid = (begin + end) / 2;
        while (mid >= 0) {
            if (key < numarray[mid])
                end = mid - 1;
            else if (key > numarray[mid])
                begin = mid + 1;
            else
                return found = true;
            mid = (begin + end) / 2;
        }
        return found;
    }

    public static void main(String[] args) {

        System.out.println("No of item:");
        BinarySearch binarySearch = new BinarySearch(scanner.nextInt());
        binarySearch.init();
        System.out.println("item to search:");
        System.out.println("found =" + binarySearch.search(scanner.nextInt()));
    }
}