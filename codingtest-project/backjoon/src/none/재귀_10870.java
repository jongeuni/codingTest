package none;

import java.util.Scanner;

public class 재귀_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(self(n));
    }

    public static int self(int n) {

        if(n<=1) {
            return 1;
        }

        return self(n-1) + self(n-2);
    }
}
