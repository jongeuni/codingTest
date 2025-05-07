package complete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class week2_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n!=0) {
                stack.push(n);
            } else {
                stack.pop();
            }
        }

        System.out.println(stack.stream().mapToInt(i -> i).sum());
    }
}
