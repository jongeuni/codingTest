package complete;

import java.util.Scanner;
import java.util.Stack;

public class week2_10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        String[] commands = new String[n];
        sc.nextLine();
        for (int j = 0; j < n; j++) {
            commands[j] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {

            String command = commands[i];

            switch (command) {
                case "pop": {
                    if(stack.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.pop());
                    break;
                }
                case "size": {
                    System.out.println(stack.size());
                    break;
                }
                case "empty": {
                    if(stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }
                case "top": {
                    if(stack.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(stack.peek());
                    break;
                }
                default:
                    stack.push(Integer.valueOf(command.substring(5)));
            }
        }
    }



}
