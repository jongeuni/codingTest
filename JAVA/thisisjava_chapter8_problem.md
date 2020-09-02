### 이것이 자바다 356p 3번

**main() 메소드에서 printSound()를 호출할 때 Cat과 Dog 객체를 주고 실행하면 각각 "야옹"과 "멍멍"이 출력되도록 Cat과 Dog 클래스를 작성하시오.**

#### Soundable (interface)

```java
package thisisjava_386p_3;

public interface Soundable {
    String sound();
}
```

#### SoundbleEx (main.java)

```java
package thisisjava_386p_3;

public class SoundbleEx {
    private static void printSound(Soundable soundable){
        System.out.println(soundable.sound());
    }

    public static void main(String[] args){
        Cat cat = new Cat();
        printSound(cat);
        printSound(new Dog());
    }
}
```

#### Cat (class)

```java
package thisisjava_386p_3;

public class Cat implements Soundable{
    @Override
    public String sound(){
        String sound ="야옹";
        return sound;
    }
}
```

#### Dog (class)

```java
package thisisjava_386p_3;

public class Dog implements Soundable{
    @Override
    public String sound(){
        String sound ="멍멍";
        return sound;
    }
}
```



### 이것이 자바다 357p 4번

**실행 결과를 보고 DataAccObj 인터페이스와 OracleDao, MySqlDao 구현 클래스를 각각 작성하시오.**

#### DataAccObj (interface)

```java
package thisisjava_387p_4;

public interface DataAccObj {
    void select();
    void insert();
    void update();
    void delete();
}
```

#### DaoEx (main.java)

```java
package thisisjava_387p_4;

public class DaoEx {
    public static void dbWork(DataAccObj dao){
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }
    public static void main(String[] args){
        dbWork(new OracleDao());
        dbWork(new MySqlDao());
    }
}
```

#### OracleDao (class)

```java
package thisisjava_387p_4;

public class OracleDao implements DataAccObj{
    public void select(){
        System.out.println("Oracle DB에서 검색");
    }
    public void insert(){
        System.out.println("Oracle DB에 삽입");
    }
    public void update(){
        System.out.println("Oracle DB를 수정");
    }
    public void delete(){
        System.out.println("Oracle DB에서 삭제");
    }
}

```

#### MySqlDao (class)

```java
package thisisjava_387p_4;

public class MySqlDao implements DataAccObj{
    public void select(){
        System.out.println("MySql DB에서 검색");
    }
    public void insert(){
        System.out.println("MySql DB에 삽입");
    }
    public void update(){
        System.out.println("MySql DB를 수정");
    }
    public void delete(){
        System.out.println("MySql DB에서 삭제");
    }
}
```



### 이것이 자바다 357p 5번

**main() 메소드에서 Action의 익명 구현 객체를 만들어 다음과 같은 실행 결과가 나오도록 코드를 작성하시오.**

#### Action (interface)

```java
package thisisjava_387p_5;

public interface Action {
    void work();
}
```

#### main.java

```java
package thisisjava_387p_5;

public class Anonymous_Object_Pr {
    public static void main(String[] args){
        Action action = new Action() {
            public void work() {
                System.out.println("복사를 합니다.");
            }
        };
        action.work();
    }
}
```