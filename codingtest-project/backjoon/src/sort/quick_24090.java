package sort;

import java.util.Scanner;

public class quick_24090 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);
    }

    public static void sort(int[] arr) {
        int pivot = arr[arr.length/2];

        int start = 0;
        int end = arr.length-1;

        while(arr[start] < pivot) {
            start ++;
        }

        while(arr[end] > pivot) {
            end --;
        }



    }

    public static void quickSort(int[] arr, int start, int end) {
        if(start>=end) {
            return;
        }

        int pivot = start;
        int s = start + 1;
        int e = end;

        while(s <= e) {
            while(s <= e || arr[pivot] > arr[s]) {
                s++;
            }
            while(s <= e || arr[pivot] > arr[s]) {
                e--;
            }
            if (s > e)
                swap(arr, e, pivot);
            else
                swap(arr, s, e);
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
