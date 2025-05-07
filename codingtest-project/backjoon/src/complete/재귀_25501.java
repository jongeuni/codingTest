package complete;

import java.util.Scanner;

public class 재귀_25501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[t];
        for(int i = 0; i<t; i++) {
            arr[i] = sc.nextLine();
        }

        for(String s: arr) {
            palindrome(s, 0);
        }
    }

    public static void palindrome(String s, int index) {

        if(s.charAt(index) != s.charAt(s.length() - index -1)) {
            int count = index+1;
            System.out.println(0+" "+count);
            return;
        }

        if((s.length()/2) <= index) {
            int count = index+1;
            System.out.println(1+" "+count);
            return;
        }

        palindrome(s, index+1);
    }

}
