package none;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class week2_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();

        String[] commands = new String[n];
        for (int j = 0; j < n; j++) {
            commands[j] = br.readLine();
        }

        for (int i = 0; i < n; i++) {

            String command = commands[i];

            switch (command) {
                case "pop_front": {
                    if(q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(q.pollFirst());
                    break;
                }
                case "pop_back": {
                    if(q.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(q.pollLast());
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
                default: {
                    if (command.contains("front")) {
                        q.addFirst(cutNum(command, 11));
                        break;
                    }
                    if (command.contains("back")) {
                        q.addLast(cutNum(command, 10));
                        break;
                    }
                }
            }
        }
    }

    public static int cutNum(String s, int sub) {
        return Integer.parseInt(s.substring(sub));
    }
}
