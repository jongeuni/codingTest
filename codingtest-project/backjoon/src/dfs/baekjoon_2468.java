package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_2468 {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < N; j++) {
                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        int maxSafeZone = 0;

        for (int rain = 0; rain <= maxHeight; rain++) {
            visited = new boolean[N][N];
            int safeCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > rain) {
                        dfs(i, j, rain);
                        safeCount++;
                    }
                }
            }

            maxSafeZone = Math.max(maxSafeZone, safeCount);
        }

        System.out.println(maxSafeZone);
        br.close();
    }

    private static void dfs(int y, int x, int rain) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if (!visited[ny][nx] && arr[ny][nx] > rain) {
                    dfs(ny, nx, rain);
                }
            }
        }
    }
}
