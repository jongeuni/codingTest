package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_1012 {
    static int M, N;
    static int cabbageCount;
    static int[][] field;
    static boolean[][] visit;
    static int count;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스의 갯수

        for (int i = 0; i < tc; i++) {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 배추밭 가로 길이
            N = Integer.parseInt(st.nextToken()); // 배추밭 세로 길이
            field = new int[M][N];
            visit = new boolean[M][N];

            cabbageCount = Integer.parseInt(st.nextToken()); // 배추 갯수
            for (int j = 0; j < cabbageCount; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken()); // 배추 심어져있는 좌표 x
                int y = Integer.parseInt(st.nextToken()); // 배추 심어져있는 좌표 y
                field[x][y] = 1; // 배추 심어져있는 곳 표시
            }

            for (int x = 0; x < M; x++) { // 가로 길이만큼
                for (int y = 0; y < N; y++) { // 세로 길이 만큼
                    if (field[x][y] == 1 && !visit[x][y]) { // 양배추가 있고, 방문을 안한 곳이라면 dfs 함수
                        dfs(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    static void dfs(int x, int y) {
        visit[x][y] = true; // 방문 처리

        for (int i = 0; i < 4; i++) {
            // x, y 좌표 기준 4방면 탐방
            int cx = x + dx[i];
            int cy = y + dy[i];

            // 해당 좌표가 올바른 좌표인지 확인 (양배추 필드에 들어가는 좌표인지)
            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                // 해당 좌표에 방문한 적 있다면 dfs 함수 끝
                // 해당 좌표에 방문한 적 없고, 양배추가 있는 좌표라면 재귀 호출
                if (!visit[cx][cy] && field[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }

        }

    }
}
