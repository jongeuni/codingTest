package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// https://www.acmicpc.net/problem/14716
public class baekjoon_14716 {
    public static int N, M;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] dx = {0, 1, 0, -1, 1, -1, -1, 1};
    public static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }

            }
        }


        System.out.println(count);
    }
    public static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 8; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(!visited[nx][ny] && arr[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }
}
