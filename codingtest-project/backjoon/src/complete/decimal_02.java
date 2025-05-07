package complete;

import java.util.*;

public class decimal_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int[] nums = new int[count];

        for(int i = 0; i<count; i++) {
            nums[i] = sc.nextInt();
        }

        int sum = 0;

        for(int num: nums) {
            sum += decimal(num);
        }

        System.out.println(sum);
    }

    public static int decimal(int targetNum) {
        if(targetNum == 1) {
            return 0;
        }
        if(targetNum == 0 || targetNum == 2) {
            return 1;
        }

        for(int i=2; i<=(targetNum/2)+1; i++) {
            if(targetNum%i==0) {
                return 0;
            }
        }
        return 1;
    }
}