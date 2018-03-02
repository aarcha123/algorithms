package com.algorithms.lesson1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Lazy approach
public class QuickUnion {

    int[] id;
    int connectedComponents;


    public QuickUnion(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        connectedComponents=n;

    }

    //worst case , as tree gets taller and becomes a skinny tree, it takes N array access to find the root O(n)
    private int root(int i) {
        while (id[i] != i) {
            i = id[i];

        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);

    }
    //needs to change only one array element
    //worst case , as tree gets taller and becomes a skinny tree, it takes N array access to find the root which is O(n)

    public void union(int p, int q) {

        id[root(p)] = root(q);
        connectedComponents--;


    }

    public void printlist() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + ",");
        }
        System.out.println("\nconnected components="+connectedComponents);

    }
    public boolean allConnected(){
        return connectedComponents==1;
    }

    public static void main(String[] args) {

        QuickUnion quickUnion = new QuickUnion(10);
        List<String> pairs = Arrays.asList("4,3", "3,8", "6,5", "9,4", "2,1", "8,9", "5,0", "7,2", "6,1","7,3");

        for (String item : pairs) {

            System.out.println("Enter pair:");
            String[] nums = item.split(",");
            int p = new Integer(nums[0]).intValue();
            int q = new Integer(nums[1]).intValue();
            if (quickUnion.connected(p, q)) {
                System.out.println(p + " " + q + " Connection exists");
            } else {
                quickUnion.union(p, q);
                System.out.println(p + " " + q + " connected");
            }
            quickUnion.printlist();
        }
        quickUnion.printlist();
        System.out.println("All nodes connected="+quickUnion.allConnected());

    }

//output:1,8,1,8,3,0,5,1,8,8
}


