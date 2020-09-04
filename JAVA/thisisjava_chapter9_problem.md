### 이것이 자바다 417p 4번

**ClassEx에서 멤버 클래스의 객체를 생성하는 코드를 작성하시오.**

#### ClassEx (main.java)

```java
package thisisjava_417p_4;

public class ClassEx {
    public static void main(String[] args){
        Car myCar = new Car();
        Car.Tire tire = myCar.new Tire();
        Car.Engine engine = new Car.Engine();
    }
}
```

인스턴트 클래스 객체 생성과, 정적 클래스 객체 생성 방법은 다르다.

#### ClassEx

```java
package thisisjava_417p_4;

public class Car {
    class Tire{}
    static class Engine{}
}
```



### 이것이 자바다 418p 5번

#### Vehicle (interface)

```java
package thisisjava_418p_5;

public interface Vehicle {
    public void run();
}
```

#### AnonymousEx (main.java)

```java
package thisisjava_418p_5;

public class AnonymousEx {
    public static void main(String[] args){
        Anonymous anony = new Anonymous();
        anony.field.run();
        anony.method1();
        anony.method2(new Vehicle() {
            @Override
            public void run() {
                System.out.println("트럭이 달립니다.");
            }
        });
    }
}
```

#### Anonymous

```java
package thisisjava_418p_5;

public class Anonymous {
    Vehicle field = new Vehicle() {
        @Override
        public void run() {
            System.out.println("자전거가 달립니다.");
        }
    };
    void method1(){
        Vehicle localVar = new Vehicle() {
            @Override
            public void run() {
                System.out.println("승용차가 달립니다.");
            }
        };
        localVar.run();
    }
    void method2(Vehicle v){
        v.run();
    }
}
```