package dfs;

import java.io.*;
import java.util.*;

public class baekjoon_2606 {

    static int count;
    static boolean[] visited;
    static List<Integer>[] computers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int connections = Integer.parseInt(br.readLine()); // 연결 수

        visited = new boolean[num + 1];
        computers = new ArrayList[num + 1];

        for (int i = 1; i <= num; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < connections; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a); // 양방향 연결
        }

        dfs(1); // 1번 컴퓨터에서 시작
        System.out.println(count - 1); // 1번 컴퓨터는 제외하고 출력

        br.close();
    }

    private static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        count++;

        for (int neighbor : computers[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
