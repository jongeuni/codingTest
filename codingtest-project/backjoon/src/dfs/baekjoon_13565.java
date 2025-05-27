package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13565
public class baekjoon_13565 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }

        // 만약에 첫번째에 0이 없다면 fasle
        for (int i = 0; i < M; i++) {
            if(!visited[0][i] && (arr[0][i] == 0)) {
                dfs(0,i);
            }
        }

        System.out.println("NO");
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;

        if(i == N-1) {
            System.out.println("YES");
            System.exit(0);
        }

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(arr[nx][ny] == 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
