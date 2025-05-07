package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_3187 {

    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = { 0, 0, -1, 1};

    static int inWolf = 0;
    static int inSheep = 0;
    // 빈 공간 = .
    // 울타리 = #
    // 늑대 = v 양 = k
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 세로 길이
        int C = Integer.parseInt(st.nextToken()); // 가로 길이


        String[][] space = new String[R][C];
        visited = new boolean[R][C];

        int wolfCount = 0;
        int sheepCount = 0;

        for (int i = 0; i < R; i++) space[i] = br.readLine().split(""); // 마당의 각 행을 입력받아 저장

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {

                if(!visited[i][j] && !space[i][j].equals("#")) {
                    dfs(j, i, space);

                    if(inSheep>inWolf) {
                        sheepCount += inSheep;
                    } else {
                        wolfCount += inWolf;
                    }

                    inWolf = 0;
                    inSheep = 0;
                }

            }

        }


        System.out.print(sheepCount + " " + wolfCount);

        br.close();
    }

    public static void dfs(int x, int y, String[][] space) {
        visited[y][x] = true;

        if(space[y][x].equals("v")) {
            inWolf++;
        } else if (space[y][x].equals("k")) {
            inSheep++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && ny < space.length && nx < space[y].length) {
                if (!visited[ny][nx] && !space[ny][nx].equals("#")) {
                    dfs(nx, ny, space);
                }
            }
        }
    }
}
