package complete;

import java.util.Scanner;

// https://www.acmicpc.net/problem/10990
public class star_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n==1) {
            System.out.println("*");
            return;
        }

        for(int i=1; i<n; i++) {
            if(i == 1) {
                System.out.println(" ".repeat(n-i) + "*");
            } else {
                System.out.println(" ".repeat(n-i) + "*" +" ".repeat(2*i-3) +"*"); // 2×N-1 개
            }
        }

        System.out.print("*"+" ".repeat(n*2-3)+"*");
    }
}
