package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13565
public class baekjoon_10026 {
    static int N;
    static String[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());

        arr = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = st.nextToken().split("");
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        // 색약의 경우 G를 R로 바꿔줌
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Objects.equals(arr[i][j], "G")) {
                    arr[i][j] = "R";
                }
            }
        }

        int colorManCount = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    colorManCount++;
                }
            }
        }

        System.out.println(count + " " + colorManCount);
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;

        String now = arr[i][j];

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(Objects.equals(arr[nx][ny], now) && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
