package com.algorithms.arrays;

import java.util.Scanner;

/**
 * Faster version of finding prime numbers in a given set of n numbers
 * using Sieve of Eratosthenes O(n log log n)
 *
 * modern: Sieve of Atkin(2003)
 */
public class PrimeFast {

    static void findPrimes(int n){
        boolean[] prime = new boolean[n+1];
        for(int i=2;i<=n;i++){
            prime[i]=true;
        }

        for(int divisor=2;divisor*divisor<=n;divisor++){
            for(int i=2*divisor;i<=n;i=i+divisor){
                prime[i]=false;
            }
        }
        for(int i=2;i<=n;i++){
            if(prime[i]){
                System.out.print(" "+i);
            }
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the limit to find prime");
        int n=scanner.nextInt();
        findPrimes(n);
    }

}
