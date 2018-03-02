package com.algorithms.lesson1;

import java.util.Arrays;
import java.util.List;

public class WeightedQuickUnion {

    int[] id;
    int[] size;
    int connectedComponents;


    public WeightedQuickUnion(int n) {
        id = new int[n];
        size = new int[n];
        connectedComponents=n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    //takes time proportional to the depth of node i (log N)
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;

    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);

    }

    public void union(int p, int q) {
        int rootp = root(p);
        int rootq = root(q);
        if (size[p] < size[q]) {
            id[rootp] = rootq;
            size[q] += size[p];
        } else {
            id[rootq] = rootp;
            size[p] += size[q];
        }
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
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
        List<String> pairs = Arrays.asList("4,3", "3,8", "6,5", "9,4", "2,1", "8,9", "5,0", "7,2", "6,1");
        for (String item : pairs) {
            String[] nums = item.split(",");
            int p = new Integer(nums[0]).intValue();
            int q = new Integer(nums[1]).intValue();
            if (weightedQuickUnion.connected(p, q)) {
                System.out.println(p + " " + q + " Connection exists");
            } else {
                weightedQuickUnion.union(p, q);
                System.out.println(p + " " + q + " connected");
            }
            weightedQuickUnion.printlist();
            System.out.println("All nodes connected="+weightedQuickUnion.allConnected());


        }


    }
    //output: 6,2,6,4,6,6,,6,2,4,4

}
