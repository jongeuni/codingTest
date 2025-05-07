package complete;// https://www.acmicpc.net/problem/1935

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class week2_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String expression = br.readLine();

        int[] arr = new int[n];

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch == '+'){
                double f = stack.pop();
                double s = stack.pop();
                stack.push(s+f);

            } else if(ch == '-'){
                double f = stack.pop();
                double s = stack.pop();
                stack.push(s-f);

            } else if(ch == '*'){
                double f = stack.pop();
                double s = stack.pop();
                stack.push(s*f);

            } else if(ch == '/'){
                double f = stack.pop();
                double s = stack.pop();
                stack.push(s/f);
            } else {
                stack.push((double) arr[ch - 'A']);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
