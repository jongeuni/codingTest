package complete;

import java.io.IOException;
import java.util.*;

// https://www.acmicpc.net/problem/11866
public class week2_11866 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++) {
            q.add(i);
        }
        List<Integer> res = new ArrayList<>();

        int count = 1;
        while(!q.isEmpty()) {
            int a = q.poll();
            if(count != k) {
                q.add(a);
                count ++;
            } else {
                res.add(a);
                count = 1;
            }
        }

        System.out.print("<");
        String answer = Arrays.toString(res.toArray());
        System.out.print(answer.substring(1, answer.length() - 1));
        System.out.print(">");
    }
}
