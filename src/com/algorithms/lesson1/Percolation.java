package com.algorithms.lesson1;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private boolean[][] grid;
    private WeightedQuickUnionUF weightedQuickUnion;
    private int top = 0;
    private int bottom;
    private int opened = 0;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {

        if (n <= 0)
            throw new IllegalArgumentException("n should be greater than 0");
        grid = new boolean[n][n];
        weightedQuickUnion = new WeightedQuickUnionUF((n * n) + 2);
        bottom = (n * n) + 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }

    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!isOpen(row, col)) {
            row = row - 1;
            col = col - 1;
            grid[row][col] = true;
            opened++;
            //connect with neighbours
            boolean left = false, right = false, up = false, down = false;

            left = validNeighbour(row, col - 1);
            right = validNeighbour(row, col + 1);
            up = validNeighbour(row - 1, col);
            down = validNeighbour(row + 1, col);


            int p = (row * grid.length) + col + 1;
            int q;

            if (left && grid[row][col - 1]) {

                q = (row * grid.length) + col;
                weightedQuickUnion.union(p, q);
            }
            if (right && grid[row][col + 1]) {
                q = (row * grid.length) + col + 2;
                weightedQuickUnion.union(p, q);
            }
            if (up && grid[row - 1][col]) {
                q = ((row - 1) * grid.length) + col + 1;
                weightedQuickUnion.union(p, q);
            }
            if (down && grid[row + 1][col]) {
                q = ((row + 1) * grid.length) + col + 1;
                weightedQuickUnion.union(p, q);
            }
            if (row == 0) {
                weightedQuickUnion.union(p, top);
            }
            if (row == grid.length - 1) {
                weightedQuickUnion.union(p, bottom);
            }
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        row = row - 1;
        col = col - 1;
        return grid[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        //TODO: validate
        validate(row,col);
        int p = ((row - 1) * grid.length) + col;
        return weightedQuickUnion.connected(p, top);

    }

    // number of open sites
    public int numberOfOpenSites() {
        return opened;
    }

    // does the system percolate?
    public boolean percolates() {
        //if any bottom site is connected to top site then percolates
        return weightedQuickUnion.connected(top, bottom);
    }

    private boolean validate(int row, int col) {
        //if (!(row >= 0 && row < grid.length && col >= 0 && col < grid.length)) {
        if (row <= 0 || row > grid.length || col <= 0 || col > grid.length) {
            throw new IllegalArgumentException("row= " + row + " col= " + col + " index not in range 1 and " + grid.length);
        }
        return true;
    }

    private boolean validNeighbour(int row, int col) {
        // if (!(row >= 0 && row < grid.length && col >= 0 && col < grid.length)) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid.length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        Percolation percolation = new Percolation(n);
        while (!percolation.percolates()) {
            int row = StdRandom.uniform(1, 4);
            int col = StdRandom.uniform(1, 4);
            System.out.println("trying to open (" + row + "," + col + ")");
            percolation.open(row, col);
            System.out.println("opened");

            System.out.println("opened sites=" + percolation.numberOfOpenSites());
        }
        System.out.println("opened sites=" + percolation.numberOfOpenSites());


    }

    /*      List<String> pairs = Arrays.asList("1,3", "2,3", "3,3","3,1","2,1","1,1");
        System.out.println("BEFORE opening");
        System.out.println("percolates=" + percolation.percolates());

        percolation.printarray();
        for (String item : pairs) {
            String[] nums = item.split(",");
            int p = new Integer(nums[0]).intValue();
            int q = new Integer(nums[1]).intValue();
            percolation.open(p, q);
            System.out.println("after opening");
            percolation.printarray();
            System.out.println(percolation.isFull(p, q));
            System.out.println("open sites=" + percolation.numberOfOpenSites());
            System.out.println("percolates=" + percolation.percolates());
            percolation.printarray();


        }*/
}
