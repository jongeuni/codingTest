package complete;

import java.util.Scanner;

public class week1_11653 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int value = num;
        boolean flag = true;
        int i = 2;

        while(flag) {
            if (value%i == 0) {
                value = value/i;
                System.out.println(i);
            } else if (i >= value) {
                flag = false;
            } else {
                i += 1;
            }
        }
    }
}
