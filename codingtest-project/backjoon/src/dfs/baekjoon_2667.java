package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://helll-o.tistory.com/30
public class baekjoon_2667 {
    static int N;

    static int[][] map;
    static boolean[][] visit;
    static Map<Integer, Integer> houseCount = new HashMap<>();
    static int count = 0; // 단지 수
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 지도의 크기
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            map[i] = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int houseNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && map[i][j] == 1) {
                    count++;
                    dfs(i, j, houseNum++);
                }
            }
        }

        System.out.println(count);

        List<Integer> keySet = new ArrayList<>(houseCount.keySet());
        keySet.sort(Comparator.comparing(o -> houseCount.get(o)));

        for(int key: keySet) {
            System.out.println(houseCount.get(key));
        }

    }

    public static void dfs(int i, int j, int houseNum) {
        visit[i][j] = true;
        houseCount.put(houseNum, houseCount.getOrDefault(houseNum, 0) + 1);

        if(!visit[i][j] || map[i][j] == 0) {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int ny = i + dy[k];
            int nx = j + dx[k];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(!visit[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx, houseNum);
                }
            }
        }
    }





}
