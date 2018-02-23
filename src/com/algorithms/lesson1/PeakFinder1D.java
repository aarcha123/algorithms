package com.algorithms.lesson1;

public class PeakFinder1D {
	/**
	 * a[i] is a peak if and only if a[i]>=a[i-1] and a[i]>=a[i+1]
	 * @param args
	 */
	public static void main(String[] args){
		int[] numbers={1,3,4,3,5,1,3};
		int peak=findAPeak(numbers,0,numbers.length-1);
		System.out.println(" peak = "+peak);
	}
	
	public static int findAPeak(int[] array,int start , int end){
		int peak=0;
		if(start!=end){
		int middle= (end-start+1) /2;
		if (array[middle]<array[middle-1]){
			
			return findAPeak(array,start,middle-1);
			
		}else if(array[middle]<array[middle+1]){
			return findAPeak(array,middle+1,end);
			
		}else{
			peak= array[middle];
		}
		}else{
			peak=array[start];
		}
		
		return peak;
	}

}
