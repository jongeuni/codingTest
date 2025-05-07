package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_4963 {

    static boolean[][] visited;
    static int[] dx = { 0, -1, 0, 1, -1, -1, 1, 1 }; // 8방향
    static int[] dy = { 1, 0, -1, 0, -1, 1, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 지도의 너비
            int h = Integer.parseInt(st.nextToken()); // 지도의 높이

            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int y = 0; y < h; y++) { // 세로 길이만큼
                for (int x = 0; x < w; x++) { // 가로 길이만큼
                    if (map[y][x] == 1 && !visited[y][x]) { // 방문 안 한 섬이라면
                        dfs(x, y, map);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

        br.close();
    }

    public static void dfs(int x, int y, int[][] map) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && ny < map.length && nx < map[0].length) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(nx, ny, map);
                }
            }
        }
    }
}
