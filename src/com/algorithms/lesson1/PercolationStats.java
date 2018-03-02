package com.algorithms.lesson1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    // perform trials independent experiments on an n-by-n grid
    private int n;
    private int trials;
    private double threshold[];
    private final double hiloConstant=1.96;
    public PercolationStats(int n, int trials){
        if(n<=0 || trials<=0){
            throw new IllegalArgumentException("n and trials should be > 0");
        }
        this.n=n;
        this.trials=trials;
        threshold= new double[trials];

    }
    // sample mean of percolation threshold
    public double mean()  {
        return StdStats.mean(threshold);
    }
    // sample standard deviation of percolation threshold
    public double stddev() {

       return StdStats.stddev(threshold);
    }
    // low  endpoint of 95% confidence interval
    public double confidenceLo()  {

        return (mean()-((hiloConstant*stddev())/Math.sqrt((double)trials)));
    }
    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean()+((hiloConstant*stddev())/Math.sqrt((double)trials)));

    }
    private double threshold(int opened){
        double totalsites=n*n;
        return (opened/totalsites);
    }


    private void conductExperiment(){
        Percolation percolation ;

        for(int i=0;i<trials;i++) {
            System.out.println("experiment :"+ (i+1));
            percolation = new Percolation(n);
            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n+1);
                int col = StdRandom.uniform(1, n+1);
                percolation.open(row, col);
                System.out.println("opened sites=" + percolation.numberOfOpenSites());

            }
            threshold[i] = threshold(percolation.numberOfOpenSites());
        }

    }

    public static void main(String[] args){
        if(args.length!=2){
            throw new IllegalArgumentException("Insufficent argument : usage PercolationStats [gridsize] [trials]");
        }
        int n=Integer.parseInt(args[0]);
        int trials=Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(n,trials);
        stats.conductExperiment();
        System.out.println("mean="+stats.mean());
        System.out.println("stddev="+stats.stddev());
        System.out.println("95% confidence interval=[ "+stats.confidenceLo()+","+stats.confidenceHi()+" ]");

    }
}
