package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/5597
public class baekjoon_5597 {
    private static int N = 30;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }

        for(int i = 0; i< 28; i++) {
            int idx = Integer.parseInt(br.readLine());
            list.remove(idx);
        }

        list.forEach(System.out::println);
    }

}
