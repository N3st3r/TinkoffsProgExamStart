package com.example;

import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = arr[i] + arr[j];
                boolean ok = true;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j && arr[k] != target) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}