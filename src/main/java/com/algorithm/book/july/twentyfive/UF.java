package com.algorithm.book.july.twentyfive;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
    private int[] id;
    private int count;

    public UF(int n) {
        count = n;
        id = new int[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        count--;
        int max = Math.max(p, q);
        int min = Math.min(p, q);
        id[p] = max;
        id[q] = max;
        if (max != min) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == min) {
                    id[i] = max;
                }
            }
        }
    }

    public static void main(String[] args) {
        int i = StdIn.readInt();
        UF uf = new UF(i);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p+" " + q);
        }
        StdOut.println(uf.count + "components");
    }
}
