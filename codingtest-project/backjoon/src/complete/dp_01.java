package complete;

import java.util.Scanner;
import java.io.IOException;

public class dp_01 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[] dp = new int[num+1];

        dp[0] = 0;
        dp[1] = 0;

        // 모든 경우의 수를 다 한다음 가장 작은걸
        // 메모이제이션


        for(int i = 2; i <= num; i++) {
            if(i==2 || i==3) {
                dp[i] = 1;
                continue;
            }
            if(i%3==0) {
                dp[i] = 1+dp[i/3];
                continue;
            }
            if(i%2==0) {
                if((i-1)%3==0) {
                    dp[i] = 1+dp[i-1];
                } else {
                    dp[i] = 1+dp[i/2];
                }
                continue;
            }
            dp[i] = 1+dp[i-1];
        }

        System.out.println(dp[num]);

    }
}