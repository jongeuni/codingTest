package complete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class week1_4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        List<Integer> nums = new ArrayList<>();

        while(flag) {
            int num = sc.nextInt();
            if(num == 0) {
                flag = false;
                continue;
            }

            nums.add(num);
        }

        nums.forEach(num -> {
            int finish = num * 2;
            System.out.println(decimalCountSelf(num, finish));
        });
    }

    // 재귀로 풀어보기
    public static int decimalCountSelf(int num, int finish) {
        return decimalCount(num + 1, finish, 2);
    }

    public static int decimalCount(int i, int finish, int j) {
        if(i> finish) {
            return 0;
        }

        if(j == Math.floor(Math.sqrt(i))+1) {
            return 1+decimalCount(i+1, finish, 2);
        }

        if(i%j == 0) {
            return decimalCount(i+1, finish, 2);
        }

        return decimalCount(i, finish, j+1);
    }

    // n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재
    public static int decimalCount(int num, int finish) {
        int decimalCount = 0;

        for(int i = num + 1; i<=finish; i++) {
            // /2로 하면 2일때 for문이 안돈다 루트로 하면 중복된 값이 있어서 틀릴 확률이 높다.
            for(int j = 2; j<=Math.floor(Math.sqrt(i))+1; j++) {
                if(j == Math.floor(Math.sqrt(i)) + 1) {
                    decimalCount++;
                }
                if(i % j == 0) {
                    break;
                }

            }
        }
        return decimalCount;
    }
}
