### 이것이 자바다 181p 7번

주어진 배열의 항목에서 최대값을 구해보시오. (for문 사용.)

```java
package thisisjava_181p_7;

public class maxnum {
    public static void main(String[] args)
    {
        int max =0;
        int[] array = {1,5,3,8,2};
        for(int i=0; i<array.length; i++)
        {
            if(array[i]>=max)
            {
                max=array[i];
            }
        }
        System.out.println(max);
    }
}
```



### 이것이 자바다 181p 8번

주어진 배열의 전체 항목의 합과 평균값을 구해보시오. (중첩for문 사용.)

```java
public class arraySumAvg {
    public static void main(String[] args)
    {
        int[][] array = {{95,86},{83,92,96},{78,83,93,87,88}};
        int sum=0;
        double avg =0.0;
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[i].length; j++) {
                sum += array[i][j];
            }
        }
        avg=(double)sum/10;
        System.out.println("sum: "+sum);
        System.out.println("avg: "+avg);
    }
}

```



### 이것이 자바다 181p 9번

키보드로 학생 수와 학생들의 점수를 입력받아서 최고 점수 및 평균 점수를 구하는 프로그램을 작성하시오.

```java
package thisisjava_181p_9;
import java.util.Scanner;
public class sc_maxav {
    public static void main(String[] args)
    {
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        int[] scores=null;
        int studentnum=0;
        while (run)
        {
            System.out.println("------------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
            System.out.println("------------------------------------------------------");
            System.out.print(">선택: ");
            int selectnum = sc.nextInt();

            if(selectnum==1)
            {
                System.out.print(">학생수: ");
                studentnum=sc.nextInt();
                scores = new int[studentnum];
            }
            else if(selectnum==2)
            {
                for(int i=0; i<studentnum; i++)
                {
                    System.out.print("score["+i+"]>");
                    scores[i]=sc.nextInt();
                }
            }
            else if(selectnum==3)
            {
                for(int i=0; i<studentnum; i++)
                {
                    System.out.println("score["+i+"]>"+scores[i]);
                }
            }
            else if(selectnum==4)
            {
                int max=0,sum=0;
                double avg=0.0;
                for(int i=0; i<studentnum; i++)
                {
                    if(scores[i]>=max)
                    {
                        max=scores[i];
                    }
                    sum+=scores[i];
                }
                System.out.println("최고점수: "+max);
                avg=(double)sum/studentnum;
                System.out.println("평균점수: "+avg);
            }
            else if(selectnum==5)
            {
                System.out.println("시스템 종료");
                run=false;
            }
        }
    }
}
```