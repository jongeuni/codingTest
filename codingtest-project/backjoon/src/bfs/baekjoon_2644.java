package bfs;

import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/2644
public class baekjoon_2644 {
    private static int N, K, S;
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        visited = new int[N + 1];
        int result = bfs(K, S);
        System.out.println(result);
    }

    static int bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1; // 시작점을 1로 초기화 (촌수 계산을 위해)

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == target) {
                return visited[current] - 1; // 실제 촌수는 -1 해줘야 함
            }

            for (int next : graph.get(current)) {
                if (visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    queue.add(next);
                }
            }
        }

        return -1; // 도달 불가한 경우
    }
}
