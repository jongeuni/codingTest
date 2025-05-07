package sort;

import java.util.Arrays;
import java.util.Scanner;


public class merge_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(arr);
    }

    // 최솟값 선택
    public static void sort(int[] arr) {

        for (int j = 0; j < arr.length; j++) {
            int targetIndex = j;
            for(int i = j; i < arr.length; i++) {

                if(arr[targetIndex] > arr[i]) {
                    targetIndex = arr[i];
                }
            }

            int temp = arr[j];
            arr[j] = arr[targetIndex];
            arr[targetIndex] = temp;
        }
       System.out.println(Arrays.toString(arr));
    }
}
