package complete;

import java.util.Scanner;

public class bronze_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
            count(arr[i]);
        }
    }

    public static void count(String s) {
        char[] c = s.toCharArray();

        int n = 1; // 누적 값
        int total = 0;
        for (char value : c) {
            if (value == 'O') {
                total = total+n;
                n++;
            } else {
                n = 1;
            }
        }

        System.out.println(total);
    }
}
