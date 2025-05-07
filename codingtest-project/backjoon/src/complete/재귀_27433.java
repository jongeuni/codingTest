package complete;

import java.util.Scanner;

public class 재귀_27433 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f_27433(n));
    }

    // factorial int로 쓰면 값이 넘는다.
    public static Long f_27433(int n) {

        if(n<=1) {
            return 1L;
        }

        return n * f_27433(n-1);
    }

}
