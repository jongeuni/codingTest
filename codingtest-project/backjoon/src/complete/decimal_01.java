package complete;

import java.util.*;

public class decimal_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startNum = sc.nextInt();
        int finishNum = sc.nextInt();

        for(int i = startNum; i<=finishNum; i++) {
            decimal(i);
        }
    }

    public static void decimal(int targetNum) {
        if (targetNum == 1){
            return;
        }

        if (targetNum == 0 || targetNum == 2 ){
            System.out.println(targetNum);
            return;
        }
        for(int i = 2; i <= (targetNum/2)+1; i++) {
            if(targetNum%i == 0) {
                return;
            }
        }
        System.out.println(targetNum);
    }
}