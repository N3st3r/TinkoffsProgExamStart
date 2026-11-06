package com.example;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Task_5 {
    static long[] a;
    static int n;

    static int upper(int from, long v) {
        int low = from, high = n;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (a[mid] <= v) low = mid + 1; else high = mid;
        }
        return low;
    }

    static int lower(int from, long v) {
        int low = from, high = n;
        while (low < high) {
            int m = (low + high) >>> 1;
            if (a[m] < v) low = m + 1; else high = m;
        }
        return low;
    }

    static long count(long x) {
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            long ai = a[i];
            if (ai > 0) {
                count += upper(i + 1, Math.floorDiv(x, ai)) - (i + 1);
            } else if (ai < 0) {
                long bound = -Math.floorDiv(x, -ai);
                count += n - lower(i + 1, bound);
            } else {
                if (x >= 0) count += n - i - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        n = (int) readLong(in);
        long k = readLong(in);
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = readLong(in);
        }
        Arrays.sort(a);

        long low = -1000000000000000000L, high = 1000000000000000000L;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (mid < low) mid = low;
            if (count(mid) >= k) high = mid; else low = mid + 1;
        }
        System.out.println(low);
    }

    static long readLong(DataInputStream in) throws IOException {
        int b = in.read();
        while (b != '-' && (b < '0' || b > '9')) {
            b = in.read();
        }
        boolean neg = false;
        if (b == '-') {
            neg = true;
            b = in.read();
        }

        long r = 0;
        while (b >= '0' && b <= '9') {
            r = r * 10 + (b - '0');
            b = in.read();
        }

        return neg ? -r : r;
    }
}
