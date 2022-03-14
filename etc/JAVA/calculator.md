# 계산기

```java
package _____;
class Calculator
{
    int left, right;

    public void setOprands(int left, int right)
    {
        this.left=left; //this.left는 calculator에서 작성한 int 변수 left를 의미함.
        this.right=right;
    }
    public void sum()
    {
        System.out.println("더하기: ");
        System.out.println(this.left+this.right);
    }
    public void sub()
    {
        System.out.println("빼기: ");
        System.out.println(this.left-this.right);
    }
    public void mul()
    {
        System.out.println("곱하기: ");
        System.out.println(this.left*this.right);
    }
    public void div()
    {
        System.out.println("나누기: ");
        System.out.println(this.left/this.right);
    }
    public void avg()
    {
        System.out.println("평균: ");
        System.out.println((this.left+this.right)/2);
    }
}

public class Calculation 
{
    public static void main(String[] args)
    {
        Calculator c1 = new Calculator(); //new라는 연산자를 이용해 클래스를 c1 객체에 담음.
        c1.setOprands(20,10);
        c1.sum();
        c1.sub();
        c1.mul();
        c1.div();
        c1.avg();

        Calculator c2 = new Calculator(); //c1과 c2는 객체, c1과 c2는 Calculator 클래스의 인스턴스.
        c2.setOprands(50,20);
        c2.sum();
        c2.sub();
        c2.mul();
        c2.div();
        c2.avg();
    }
}
```
