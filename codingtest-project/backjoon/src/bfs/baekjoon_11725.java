package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://helll-o.tistory.com/31
public class baekjoon_11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 노드의 갯수

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        // 갯수만큼 초기화
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 각각 연결해줌
            // ex arr[1] {2} arr[2] {1}
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1]; // 0인덱스 사용 x
        int[] parent = new int[n + 1];

        q.add(1); // 첫번째 노드 추가
        visit[1] = true;

        while (!q.isEmpty()) { // q가 비어있지 않을 때까지
            int v = q.poll();
            for (int next : arr.get(v)) { // arr에서 연결되어있는 node 찾기
                if (!visit[next]) {
                    visit[next] = true;
                    parent[next] = v;
                    q.add(next);
                }
            }
        }


        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

}
