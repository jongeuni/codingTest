package none;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10994
public class silver_10994 {
    public static  void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        self(n, 1);
    }

    public static void self(int n, int star) {
        if(n==star) {
            System.out.println("* ".repeat(n*2-1));
            return;
        }
        print(n, star);

        self(n, star+1);

        printAfter(n, star);
    }

    public static void print(int n, int star) {
        String s = createCornerStar(star);
        int repeatCount = centerRepeat(n, s);

        System.out.println(s + "*".repeat(repeatCount) + s);
        System.out.println(s + " ".repeat(repeatCount) + s);
    }

    public static void printAfter(int n, int star) {
        String s = createCornerStar(star);
        int repeatCount = centerRepeat(n, s);

        System.out.println(s + " ".repeat(repeatCount) + s);
        System.out.println(s + "*".repeat(repeatCount) + s);
    }

    public static String createCornerStar(int star) {
        String s = "";
        for(int i = 1; i<=star; i++) {
            s = s.concat("*");
            if(i!=star) {
                s = s.concat(" ");
            }
        }
        return s;
    }

    public static int centerRepeat(int n, String s) {
        return 4*(n-1)+1-(s.length()*2);
    }

}
