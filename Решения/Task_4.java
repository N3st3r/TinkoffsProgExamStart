package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        StringBuilder sb = new StringBuilder();
        int low = 1, high = n;
        while (low <= high) {
            long r = high - low;
            if (r > 0 && k >= r) {
                sb.append(high--).append(' ');
                k -= r;
            } else {
                int x = (int) (low + k);
                sb.append(x).append(' ');
                for (int v = low; v <= high; v++) {
                    if (v != x) sb.append(v).append(' ');
                }
                break;
            }
        }
        System.out.println(sb.toString().trim());
    }
}
