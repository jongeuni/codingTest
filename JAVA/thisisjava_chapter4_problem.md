### 이것이 자바다 134p 4번

**while문과 Math.random() 메소드를 이용해서 두 개의 주사위를 던졌을 때 나오는 눈을 (눈1,눈2) 형태로 출력하고, 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추는 코드를 작성하시오.**

```java
package thisisjava_dice;

public class dice {
    public static void main(String[] argc) {
        while (true) {
            int dice1 = (int) (Math.random() * 6);
            int dice2 = (int) (Math.random() * 6);
            System.out.println("("+dice1 +","+ dice2 +")");
            if (dice1 + dice2 == 5)
            {
                break;
            }
        }
    }
}
```



### 이것이 자바다 135p 5번

**중첩 for문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력하시오. 단, x와 y는 10 이하의 자연수.**

```java
package thisisjava_134p_5;

public class equation {
    public static void main(String[] argc)
    {
        for(int x=0; x<=10; x++)
        {
            for(int y=0; y<=10; y++)
            {
                if(4*x+5*y==60)
                {
                    System.out.println("("+x+","+ y+")");
                }
            }
        }
    }
}
```



### 이것이 자바다 135p 7번

**while문과 Scanner를 이용해서 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성하시오.**

```java
package thisisjava_134p_7;
import java.util.Scanner;
public class pr_scanner {
    public static void main(String[] argc)
    {
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        int sum=0,money;
        while(run)
        {
            System.out.println("----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 |4. 종료");
            System.out.println("----------------------------------");
            System.out.print("선택>");
            int num = sc.nextInt();
            switch(num)
            {
                case 1:
                    System.out.print("예금액>");
                    money = sc.nextInt();
                    sum+=money;
                    break;
                case 2:
                    System.out.print("출금액>");
                    money = sc.nextInt();
                    sum-=money;
                    break;
                case 3:
                    System.out.println("잔고>");
                    System.out.print(sum);
                    break;
                default:
                    run=false;
                    break;
            }
        }
        System.out.print("프로그램 종료");
    }
}
```