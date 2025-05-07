package none;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/4779
public class 재귀_4779 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = new ArrayList<>();

        while(sc.hasNextInt()) {
            arr.add(sc.nextInt());
        }

        for(int n: arr) {
            String s = "-".repeat((int) Math.pow(3, n));
            char[] chars = s.toCharArray();
            self(first(chars));
        }
    }

    public static char[] first(char[] chars) {
        // chars length가 1이면 출력
        if(chars.length == 1) {
            System.out.println(Arrays.toString(chars));
        }

        // 아니면 3등분해서 리턴.

        int count = chars.length;
        int t = count/3;
        for(int i = t+1; i <= t+t; i++) {
            chars[i] = ' ';
        }

        return chars;
    }

    // 다음 공백까지의 갯수를 세고,
    public static void self(char[] chars) {

        // 공백이 없다면 공백 처리.


        for(int i=0;i<chars.length;i++) {
            if(chars[i]==' ') {
                if(chars[i-1] == ' ') {
                    continue;
                }
                int t = i/3;
                for(int j = t+1; j <= t+t; j++) {
                    chars[j] = ' ';
                }
                // 공백 이전을 3등분으로 나누고 공백 처리
            }
        }

        // 만약 chars[0]이 -이고 그 다음이 ' '라면 출력
        if(chars[1] == ' ') {
            System.out.println(Arrays.toString(chars));
        } else {
            self(chars);
        }
    }
}
