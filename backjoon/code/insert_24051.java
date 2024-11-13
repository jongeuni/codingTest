package sort;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/24052
public class insert_24051 {
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
        int th = 0;
        int[] answer = new int[arr.length];
        for (int i = 1; i < arr.length; i++) { // 2
            int temp = arr[i];
            int j = i-1;

            while(j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
                th++;
                if(th == k) {
                    answer = arr.clone();
                }
            }

            if(arr[j+1] != temp) {
                arr[j+1] = temp;
                th++;
            }
        }

        if(th < k) {
            System.out.println("-1");
        } else {
            for (int j : answer) {
                System.out.print(j + " ");
            }
        }
    }
}
