package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1463
public class baekjoon_2748 {
    static int N;
    static int count = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        arr[0] = 0;
        arr[1] = 1;

        int result = dp(N);
        System.out.println(result);
    }

    public static int dp(int n) {
        if(n == 0) return arr[0];
        if(n == 1) return arr[1];

        if(arr[n] == 0) {
            arr[n] = dp(n-1) + dp(n-2);
        }
        return arr[n];
    }
}
