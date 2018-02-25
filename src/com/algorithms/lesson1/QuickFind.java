package com.algorithms.lesson1;

import java.util.Scanner;

//Union-Find , Quick find implementation - greedy/eager way
// Union operation is an equivalence relation

public class QuickFind {

    int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }

    }

    //This is constant time - quick find
    public boolean connected(int p, int q) {

        return id[p] == id[q];
    }

    /**
     * too many elements to change
     * each union operation takes O(n)
     * for n unions it is O(n*n)=O(n^2)
     */
    public void union(int p, int q) {
        int pid = id[p];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = id[q];
            }

        }
        id[p] = id[q];

    }

    public void printlist() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + ",");
        }

    }

    public static void main(String[] args) {
        System.out.println("Enter no of objects");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        QuickFind quickFind = new QuickFind(n);
        boolean more = true;
        while (more) {
            System.out.println("Enter pair:");
            String pair = scanner.next();
            String[] nums = pair.split(",");
            int p = new Integer(nums[0]).intValue();
            int q = new Integer(nums[1]).intValue();
            if (quickFind.connected(p, q)) {
                System.out.println("Connection exists");
            } else {
                quickFind.union(p, q);
                System.out.println(p + " " + q + " connected");
            }
            quickFind.printlist();
            System.out.println("more ?");
            more = scanner.next().equals("y");
        }
        quickFind.printlist();
    }

}

