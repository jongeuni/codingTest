package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class week2_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> arr = new ArrayList<>();

        for(int i =0; i<n; i++) {
            arr.add(br.readLine());

        }

        for (String s : arr) {
            check(s);
        }

    }

    //(()()())
    public static void check(String a) {

        Stack<String> sk = new Stack<>();
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '(') {
                sk.push(String.valueOf(a.charAt(i)));
            } else {
                try {
                    sk.pop();
                } catch (Exception e) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if(sk.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
