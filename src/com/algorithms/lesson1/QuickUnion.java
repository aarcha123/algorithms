package com.algorithms.lesson1;

import java.util.Scanner;

//Lazy approach
public class QuickUnion {
	
	int[] id;
	
	public QuickUnion(int n){
		id = new int[n];
		for(int i=0;i<n;i++){
			id[i]=i;
		}
	}

    //worst case , as tree gets taller and becomes a skinny tree, it takes N array access to find the root O(n)
    private int root(int i){
       while(id[i]!=i){
           i=id[i];

       }
        return i;
    }

	public boolean connected(int p, int q){
        return root(p)==root(q);

    }
    //needs to change only one array element
    //worst case , as tree gets taller and becomes a skinny tree, it takes N array access to find the root which is O(n)

    public void union(int p, int q){

        id[root(p)]=root(q);

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
        QuickUnion quickUnion = new QuickUnion(n);
        boolean more = true;
        while (more) {
            System.out.println("Enter pair:");
            String pair = scanner.next();
            String[] nums = pair.split(",");
            int p = new Integer(nums[0]).intValue();
            int q = new Integer(nums[1]).intValue();
            if (quickUnion.connected(p, q)) {
                System.out.println("Connection exists");
            } else {
                quickUnion.union(p, q);
                System.out.println(p + " " + q + " connected");
            }
            quickUnion.printlist();
            System.out.println("more ?");
            more = scanner.next().equals("y");
        }
        quickUnion.printlist();
    }


	}


