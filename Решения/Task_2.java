package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Task_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        TreeMap<String, Integer> cnt = new TreeMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            int c = cnt.merge(s, 1, Integer::sum);
            if (c > max) {
                max = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() == max) {
                sb.append(entry.getKey()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
