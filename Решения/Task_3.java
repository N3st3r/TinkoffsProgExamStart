package com.example;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Task_3 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(System.in));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int t = (int) in.nval;

        int[] row = new int[n];
        int[] col = new int[n];
        int diagonal = 0, antidiagonal = 0;

        for (int i = 1; i <= t; i++) {
            in.nextToken();
            int a = (int) in.nval - 1;
            int r = a / n, c = a % n;

            boolean win = false;
            if (++row[r] == n) win = true;
            if (++col[c] == n) win = true;
            if (r == c && ++diagonal == n) win = true;
            if (r + c == n - 1 && ++antidiagonal == n) win = true;

            if (win) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
