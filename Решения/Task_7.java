package com.example;

import java.io.*;

public class Task_7 {
    static int[][] p = new int[10][];
    static int[] comp = new int[10];

    static int find(int[] par, int x) {
        while (par[x] != x) {
            par[x] = par[par[x]];
            x = par[x];
        }
        return x;
    }

    static void addEdge(int u, int v, int w) {
        for (int k = w; k <= 9; k++) {
            int a = find(p[k], u), b = find(p[k], v);
            if (a != b) {
                p[k][a] = b;
                comp[k]--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int n = readInt(in), q = readInt(in);
        for (int k = 1; k <= 9; k++) {
            p[k] = new int[n + 1];
            for (int i = 0; i <= n; i++) p[k][i] = i;
            comp[k] = n;
        }
        for (int i = 0; i < n - 1; i++) {
            int a = readInt(in), b = readInt(in), c = readInt(in);
            addEdge(a, b, c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int u = readInt(in), v = readInt(in), w = readInt(in);
            addEdge(u, v, w);
            long ans = n - 1; // k = 0: n компонент
            for (int k = 1; k <= 9; k++) ans += comp[k] - 1;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    static int readInt(DataInputStream in) throws IOException {
        int b = in.read();
        while (b != -1 && (b < '0' || b > '9')) b = in.read();
        int r = 0;
        while (b >= '0' && b <= '9') {
            r = r * 10 + (b - '0');
            b = in.read();
        }
        return r;
    }
}