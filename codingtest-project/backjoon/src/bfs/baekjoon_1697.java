package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1697
// https://helll-o.tistory.com/33
public class baekjoon_1697 {
    private static int N, K;
    private static final int MAX = 100001;
    private static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        K = Integer.parseInt(st.nextToken()); // 동생의 위치

        // 탐색이 더 커져야할 가능성이 있음
        // check = K >= N? new int[K + 1] : new int[N + 1];
        check = new int[MAX];

        if (N == K) {
            System.out.println(0);
        } else {
            bfs();
        }
    }

    static void bfs(){
        Queue<Integer> que = new LinkedList<>();

        que.add(N);
        check[N] = 0;

        while(!que.isEmpty()){
            Integer currentSpot = que.poll();

            for(int i =0; i<3; i++){
                int nextSpot = currentSpot;
                if(i==0) {
                    nextSpot = nextSpot + 1;
                } else if (i==1) {
                    nextSpot = nextSpot - 1;
                } else {
                    nextSpot = nextSpot * 2;
                }

                if(nextSpot >= 0 && nextSpot < MAX && check[nextSpot] == 0) {
                    check[nextSpot] = check[currentSpot] + 1;

                    if(nextSpot == K) {
                        System.out.println(check[nextSpot]);
                        return;
                    }

                    que.add(nextSpot);
                }
            }
        }
    }

}
