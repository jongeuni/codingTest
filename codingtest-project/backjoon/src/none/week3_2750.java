package none;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2750
// 재
public class week3_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = sort(arr, n, n);

        System.out.println(Arrays.toString(answer));
    }

    public static int[] sort(int[] arr, int i, int n) {
        if(i == 1) {
            return arr;
        }

        //
        if(arr[i] < arr[i+1]) {}


        return arr;
    }
}
