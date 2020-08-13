package baekjoon_2675;
import java.util.Scanner;
public class string_iteration {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0; i<num; i++)
        {
            int repeat = sc.nextInt();
            String S = sc.next();
            for(int j=0; j<S.length(); j++)
            {
                for(int k=0; k<repeat; k++)
                {
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
