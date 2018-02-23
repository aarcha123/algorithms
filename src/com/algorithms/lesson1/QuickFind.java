package com.algorithms.lesson1;

import java.util.Scanner;

//Union-Find , Quick find implementation

public class QuickFind {

    int n; // total no of items
    int[] id = new int[]{};

    public QuickFind(int n){
        for(int i=0;i<n;i++){
            id[i]=i;
        }
    }

    public boolean connected(int p, int q){
        

    }
}









































	
	/*int n;
	int[] array;
	
	QuickFind(int n){
		this.n=n;
	}
	
	void initialize(int n){
		array = new int[n];
		for(int i=0;i<n;i++){
			array[i]=i;
		}
	}
	
	public int[] getArray(){
		return array;
	}
	
	public int find(int p){
		
		return 0;
		
	}
	
	public void union(int p, int q){
		
		int pid=array[p];
		int qid=array[q];
		for(int i=0;i<array.length;i++){
			if(array[i]==pid){
				array[i]=qid;
			}
		}
				
	}
	
	public boolean connected(int p, int q){
		
		return array[p]==array[q];

	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line=scanner.nextLine();
		int n =	Integer.parseInt(line);
		QuickFind qf = new QuickFind(n);
		qf.initialize(n);
		while(scanner.hasNext()){
		
		int p =	Integer.parseInt(scanner.nextLine());
		int q =	Integer.parseInt(scanner.nextLine());
		if(!qf.connected(p,q)){
			qf.union(p,q);
			System.out.println(p+" connected to "+q);
		}
		
		}
	}*/

