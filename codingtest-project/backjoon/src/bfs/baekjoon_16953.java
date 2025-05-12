package bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16953
// https://helll-o.tistory.com/34
public class baekjoon_16953 {
    private static long A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken()); // 기본 값
        B = Integer.parseInt(st.nextToken()); // 변경할 값

        bfs();
    }

    // 맨 끝(N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수
    static void bfs(){
        Queue<CustomPoint> que = new LinkedList<>();
        que.add(new CustomPoint(A, 1));

        while(!que.isEmpty()){
            CustomPoint p = que.poll();
            for(int i =0; i<2; i++){
                long next = p.x;
                if(i==0) {
                    next = next * 2;
                } else {
//                    next = Integer.parseInt(next + "1");
                    next = next * 10 + 1;
                }

                if(next == B) {
                    System.out.println(p.y + 1);
                    return;
                }

                if(next < B){
                    que.add(new CustomPoint(next, p.y+1));
                } else if (que.isEmpty()) {
                    System.out.println(-1);
                    return;
                }

            }
        }
    }

    public static class CustomPoint {
        long x;
        long y;
        public CustomPoint(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }


}
