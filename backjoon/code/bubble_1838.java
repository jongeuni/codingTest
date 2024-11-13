package sort;

import java.util.Arrays;
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
        int roop = arr.length -1;
        int th = 0;
        int[] answer = new int[2];
        while(roop > 0) {
            for(int i = 0; i < roop; i++) {
                if(arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    th++;
                }
                if(th == k) {
                    answer[0] = arr[i];
                    answer[1] = arr[i+1];
                    th++;
                }
            }
            roop -=1;
        }
        if(th < k) {
            System.out.println("-1");
        } else {
            System.out.print(answer[0] + " " + answer[1]);
        }
    }
}
