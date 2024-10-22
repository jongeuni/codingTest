package complete;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2445
public class star_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        self(n, 1);
    }

    public static void self(int n, int star) {
        if(n == star) {
            print(n, star);
            return;
        }
        print(n, star);
        self(n, star+1);
        print(n, star);
    }

    public static void print(int n, int star) {
        System.out.println("*".repeat(star) + " ".repeat(n*2-(2*star)) + "*".repeat(star));
    }


}


