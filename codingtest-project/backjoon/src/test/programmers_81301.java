package test;

import java.util.Arrays;
import java.util.Scanner;

public class programmers_81301 {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {

        String[] english = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < english.length; i++) {
            if(s.contains(english[i])) {
                s =s.replaceAll(english[i], String.valueOf(a.getNum(english[i])));
            }
        }

        return Integer.parseInt(s);
    }

    public enum a{
        zero(0),
        one(1),
        two(2),
        three(3),
        four(4),
        five(5),
        six(6),
        seven(7),
        eight(8),
        nine(9);
        final int num;

        a(int a) {
            this.num = a;
        }

        static public int getNum(String s) {
            return a.valueOf(s).num;
        }
    }

}
