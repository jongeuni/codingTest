package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2178
// https://helll-o.tistory.com/32
public class baekjoon_2178 {
    private static int N, M;
    private static int[][] arr;
    private static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 노드의 갯수
        M = Integer.parseInt(st.nextToken()); // 노드의 갯수

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    // 맨 끝(N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수
    static void bfs(int x, int y){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x,y));
        visited[x][y]=true;

        while(!que.isEmpty()){
            Point p = que.poll();
            for(int i =0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if (!visited[nx][ny] && arr[nx][ny]>0) {
                        que.add(new Point(nx, ny));
                        visited[nx][ny] = true; // visited으로 인해 늦게 도착한 값은 저장 안됨
                        arr[nx][ny] = arr[p.x][p.y] + 1; // 경로에 여태 길이 저장
                    }
                }
            }
        }
    }

}
