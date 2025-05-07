package test;

import java.util.Scanner;

// https://www.acmicpc.net/problem/23968
public class bubble_1838 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr, k);
    }

    public static void sort(int[] arr, int k) {

    }
}
