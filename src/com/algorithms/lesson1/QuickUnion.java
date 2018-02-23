package com.algorithms.lesson1;

import java.util.Scanner;

public class QuickUnion {
	
	int n;
	int[] array;
	
	void initialize(int n){
		array = new int[n];
		for(int i=0;i<n;i++){
			array[i]=i;
		}
	}
	
	public int root(int i){
		
		while(i!=array[i]){
			i=array[i];
		}
		
		return i;
	}
	
	public void union(int p, int q){
		
		int rootp=root(p);
		int rootq=root(q);
		array[rootq]=rootp;
		
	}
	
	public boolean connected(int p, int q){
	 return root(p)==root(q);

	}

	public static void main(String[] args) {
		
		QuickUnion qu = new QuickUnion();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter array size: ");
		int n = Integer.parseInt(scanner.nextLine());
		qu.initialize(n);
		
		while(true)	{	
		System.out.println("Enter node: ");
		int p = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter node: ");
		int q = Integer.parseInt(scanner.nextLine());
		if(!(qu.connected(p, q))){
			qu.union(p, q);
			System.out.println(p+" is connected to "+q);
		}else{
			System.out.println(p+" is already connected to "+q);

		}
		
		}
			

	}

}
