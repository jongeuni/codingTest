package none;

import java.util.*;

public class week2_10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> q = new ArrayDeque<>();

        String[] commands = new String[n];
        sc.nextLine();
        for (int j = 0; j < n; j++) {
            commands[j] = sc.nextLine();
        }

        for (int i = 0; i < n; i++) {

            String command = commands[i];

            switch (command) {
                case "pop": {
                    if(q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(q.poll());
                    break;
                }
                case "size": {
                    System.out.println(q.size());
                    break;
                }
                case "empty": {
                    if(q.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }
                case "front": {
                    if(q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(q.peekFirst());
                    break;
                }
                case "back": {
                    if(q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(q.peekLast());
                    break;
                }
                default:
                    q.add(Integer.valueOf(command.substring(5)));
            }
        }
    }



}
