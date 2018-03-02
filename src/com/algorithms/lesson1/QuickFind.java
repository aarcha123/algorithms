package com.algorithms.lesson1;

import java.util.Arrays;
import java.util.List;

//Union-Find , Quick find implementation - greedy/eager way
// Union operation is an equivalence relation

public class QuickFind {

    int[] id;
    int connectedComponents;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        connectedComponents=n;

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

        QuickFind quickFind = new QuickFind(10);
        List<String> pairs = Arrays.asList("4,3", "3,8", "6,5", "9,4", "2,1", "8,9", "5,0", "7,2", "6,1");
        for (String item : pairs) {

            String[] nums = item.split(",");
            int p = new Integer(nums[0]).intValue();
            int q = new Integer(nums[1]).intValue();
            if (quickFind.connected(p, q)) {
                System.out.println(p + " " + q + " Connection exists");
            } else {
                quickFind.union(p, q);
                System.out.println(p + " " + q + " connected");
            }
            quickFind.printlist();

        }
        quickFind.printlist();
        System.out.println("All nodes connected="+quickFind.allConnected());
    }
//output: 1,1,1,8,8,1,1,1,8,8
}

