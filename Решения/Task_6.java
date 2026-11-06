package com.example;

import java.io.*;

public class Task_6 {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int n = readInt(in);
        int m = 1 << n;

        int[][] c = new int[m][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 1; j <= n; j++)
                c[i][j] = readInt(in);

        long[] f = new long[m];

        for (int d = 0; d < n; d++) {
            int size = 1 << d;
            for (int start = 0; start < m; start += 2 * size) {
                int mid = start + size;
                long bestLeft = Long.MIN_VALUE, bestRight = Long.MIN_VALUE;
                for (int u = start; u < mid; u++)
                    bestLeft = Math.max(bestLeft, f[u] + (d == 0 ? 0 : c[u][d]));
                for (int u = mid; u < mid + size; u++)
                    bestRight = Math.max(bestRight, f[u] + (d == 0 ? 0 : c[u][d]));
                for (int w = start; w < mid; w++) f[w] += bestRight;
                for (int w = mid; w < mid + size; w++) f[w] += bestLeft;
            }
        }

        long ans = Long.MIN_VALUE;
        for (int w = 0; w < m; w++) ans = Math.max(ans, f[w] + c[w][n]);
        System.out.println(ans);
    }

    static int readInt(DataInputStream in) throws IOException {
        int b = in.read();
        while (b != -1 && b != '-' && (b < '0' || b > '9')) b = in.read();
        boolean neg = false;
        if (b == '-') { neg = true; b = in.read(); }
        int r = 0;
        while (b >= '0' && b <= '9') {
            r = r * 10 + (b - '0');
            b = in.read();
        }
        return neg ? -r : r;
    }
}
