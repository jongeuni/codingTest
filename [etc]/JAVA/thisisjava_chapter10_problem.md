### 이것이 자바다 449p 6번

**출력 결과는?**

```java
package thisisjava_449p_6;

public class TryCatchFinallyEx {
    public static void main(String[] args){
        String[] strArray={"10","2a"};
        int value =0;
        for(int i=0; i<=2; i++){
            try {
                value = Integer.parseInt(strArray[i]); 
                //문자열을 int형으로 변환
            } catch(ArrayIndexOutOfBoundsException e){
                System.out.println("인덱스를 초과했음");
            } catch(NumberFormatException e){
                System.out.println("숫자로 변환할 수 없음");
            } finally {
                System.out.println(value);
            }
        }
    }
```

i가 1이 되었을 땐 숫자로 변환할 수 없어서 NumberFormatException이 발생하고, i가 2가 되었을 땐 인덱스를 초과해서 ArrayIndexOutOfBoundsException이 발생한다. 값은 finally에 있음으로 저장된 10이 for문이 돌 때마다 계속 실행된다.



### 이것이 자바다 449p 7번

**존재하지 않는 ID를 입력했을 경우 NotExistIDException를 발생시키고, 잘못된 PW를 입력했을 경우 WrongPasswordException를 발생시키시오.**

#### LoginEx (main.java)

```java
package thisisjava_449p_7;

public class LoginEx {
    public static void main(String[] args){
        try{
            login("white","12345");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        try{
            login("blue","54321");
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void login(String id, String pw) throws NotExistIDException, WrongPasswordException{
        if(!id.equals("blue")){
            throw new NotExistIDException("아이디가 존재하지 않습니다.");
        }
        if(!pw.equals("12345")){
            throw new WrongPasswordException("패스워드가 틀립니다.");
        }
    }
}
```

#### NotExistIDException

```java
package thisisjava_449p_7;

public class NotExistIDException extends Exception {
    public NotExistIDException() {}
    public NotExistIDException(String message) {
        super(message);
    }
}
```

#### WrongPasswordException

```java
package thisisjava_449p_7;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {}
    public WrongPasswordException(String message) {
        super(message);
    }
}
```