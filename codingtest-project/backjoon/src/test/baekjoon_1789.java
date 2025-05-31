package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1789
public class baekjoon_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;

        long i;
        for(i = 1; i<S; i++) {
            sum += i;

            if(sum + (i+1) > S) {
                break;
            }
        }

        System.out.println(i);
    }

}
