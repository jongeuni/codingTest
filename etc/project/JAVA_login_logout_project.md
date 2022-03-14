## 기능

1. 회원가입
2. 로그인과 로그아웃
3. 계정 탈퇴, 정보 변경
4. 전체 계정 정보 (관리자의 경우)



## 조건

1. 아이디와 비밀번호는 중복될 수 없다.
2. 계정 정보를 변경 시 현재 자신의 아이디, 비밀번호와 같을 수 있다.
3. 관리자만 전체 계정 정보를 볼 수 있다.



## 소스코드

### Member

```java
package login_logout;

public class Member {
    private String name; //이름
    int age; // 나이
    private String id; //아이디
    private String password; //비밀번호

    public Member(String name, int age, String id, String password)
    {
        this.name=name;
        this.age=age;
        this.id=id;
        this.password=password;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public String getId()
    {
        return id;
    }
    public void setId(String id)
    {
        this.id=id;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
}
```





### MemberServiceEx

```java
package login_logout;
import java.util.Scanner;

public class MemberServiceEx {
    private static Member[] members = new Member[100];
    static Scanner sc = new Scanner(System.in);
    //1 (main)
    //2 (newId)
    //3 (login)
    //4 (management)
    //5 (allId)
}
```

#### main

```java
public static void main(String[] args) {
    boolean run = true;
    while (run) {
        System.out.println("아이디 생성은 1, 로그인은 2, 아이디 전체 보기는 3, 종료는 4");
        int input = sc.nextInt();
        if (input == 1) {
            newId();
        } else if (input == 2) {
            login();
        } else if (input == 3) {
            allId();
        } else if (input == 4) {
            run = false;
        }
    }
}
```

#### newId() (아이디 생성)

```java
public static void newId() //아이디 생성
{
    System.out.println("아이디 생성");
    System.out.print("이름: ");
    String name = sc.next();
    System.out.print("나이: ");
    int age = sc.nextInt();
    System.out.print("아이디: ");
    String id = sc.next();
    for(int i=0; i<members.length; i++){
        if (members[i] != null) {
            if(id.equals(members[i].getId())) //아이디 중복될 시 불가
            {
                System.out.println("아이디가 중복됩니다.");
                return;
            }
        }
    }
    System.out.print("비밀번호: ");
    String pw = sc.next();
    for(int i=0; i<members.length; i++){
        if(members[i]!=null){
            if(pw.equals(members[i].getPassword())) //비밀번호 중복될 시 불가
            {
                System.out.println("비밀번호가 중복됩니다.");
                return;
            }
        }
    }

    Member userInformation = new Member(name, age, id, pw);

    for (int i = 0; i < members.length; i++) {

        if (members[i] == null) {
            members[i] = userInformation;
            System.out.println(userInformation.getName() + "님의 아이디가 생성되셨습니다.");
            System.out.println(i+"번째");
            break;
        }
    }
}
```

#### login() (로그인)

```java
public static void login() //로그인
{
    System.out.print("아이디: ");
    String id = sc.next();
    System.out.print("비밀번호: ");
    String pw = sc.next();
    for (int i = 0; i < members.length; i++) {
        if (members[i] != null) {
            if ((id.equals(members[i].getId())) && (pw.equals(members[i].getPassword()))) {
                System.out.println("로그인 되었습니다.");
                System.out.println("계정 관리는 1, 로그아웃은 2");
                int loginUser = sc.nextInt();
                if (loginUser == 1) {
                    management(i);
                } else {
                    return; //로그아웃
                }
            }
            else
            {
                System.out.println("없는 계정입니다.");
                break;
            }
        }
    }
}
```

#### management() (계정관리)

```java
public static void management(int i) //계정관리
{
    System.out.println("계정 탈퇴는 1, 계정 정보 변경은 2");
    int User = sc.nextInt();
    if(User==1){
        System.out.println("비밀번호를 입력하세요.");
        String exPw = sc.next();
        if(exPw.equals(members[i].getPassword())){
            System.out.println(members[i].getName()+"계정이 삭제되었습니다. 감사합니다.");
            members[i]=null;
            return;
        }
        else{
            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }
    else if(User==2) {
        System.out.println("변경할 이름을 입력하세요.: ");
        String changeName = sc.next();
        System.out.println("변경할 나이을 입력하세요.: ");
        int changeAge = sc.nextInt();
        System.out.println("변경할 아이디를 입력하세요.: ");
        String changeId = sc.next();
        for(int j=0; j<members.length; j++){
            if (members[j] != null) {
                if(i==j){
                    System.out.println("현재 아이디를 유지합니다.");
                }
                else{
                    if(changeId.equals(members[j].getId())) //아이디 중복될 시 불가
                    {
                        System.out.println("아이디가 중복됩니다.");
                        return;
                    }
                }
            }
        }
        System.out.println("현재 비밀번호를 입력하세요.");
        String exPw = sc.next();
        if (exPw.equals(members[i].getPassword())) {
            System.out.println("변경할 비밀번호를 입력하세요.: ");
            String changePw = sc.next();
            for(int j=0; j<members.length; j++){
                if (members[j] != null) {
                    if(i==j){
                        System.out.println("현재 비밀번호를 유지합니다.");
                    }
                    else{
                        if(changePw.equals(members[j].getPassword())) //비밀번호 중복될 시 불가
                        {
                            System.out.println("비밀번호가 중복됩니다.");
                            return;
                        }
                    }
                }
            }
            members[i].setName(changeName);
            members[i].setAge(changeAge);
            members[i].setId(changeId);
            members[i].setPassword(changePw);
            System.out.println("변경되었습니다.");
        }
        else{
            System.out.println("현재 비밀번호가 틀렸습니다.");
            return;
        }
    }
    else return
```

#### allId() (전체 계정 보기)

```java
public static void allId() //전체 계정 보기
{
    System.out.println("관리자 비밀번호를 입력하세요.");
    int mpw = sc.nextInt();
    if (mpw == 818) {
        if (members[0] == null) {
            System.out.println("등록된 아이디가 없습니다.");
            return;
        }
        System.out.println("전체 아이디 목록");
        for (int i = 0; i<members.length; i++) {
            if(members[i]!=null){
                //Member member = members[i];
                System.out.print(members[i].getName());
                System.out.print("           ");
                System.out.print(members[i].getAge());
                System.out.print("           ");
                System.out.print(members[i].getId());
                System.out.print("           ");
                System.out.print(members[i].getPassword());
                System.out.println();
            }
        }
    } else {
        System.out.println("관리자만 전체 아이디를 볼 수 있습니다.");
    }
}
```



## -

this is java 249p 13번~15번 문제를 발전시켰다.

[^13번]: 이름, 아이디, 패스워드, 나이를 가지는 Member 클래스를 선언하시오.
[^14번]: Member 객체에 name 필드와 id 필드를 외부에서 받은 값으로 초기화하는 생성자를 선언하시오.
[^15번]: MemberService 클래스에 login() 메소드와 logout()를 선언하려고 한다. login()메소드는 매개값 id가 "hong", pw가 "12345"일 경우 true로 리턴하고 그외에는 false를 리턴하도록 한다. logout()메소드는 "로그아웃 되었습니다."가 출력되도록 한다.

그리고 19번 문제의 코드를 참고해서 만들었다. **한 번 정도만 더 만들어보면 온전히 혼자 만들 수 있을 것 같다. 자바로 무언갈 하다시피 한 게 처음이라 뿌듯했다.** 이걸 서버로 구현을 할 수 있어야 하는데....

**get이랑 set을 더 잘 알게 된 것 같다. 그리고 확실히 매개값을 넘길 때가 c언어보다 편한 느낌...? java 배열이 아직 좀 더 헷갈리긴 한다.**



아이디 중복 확인 할 때 members[i]!=null라고 작성했었다. 어차피 0부터 계정이 채워나가지니까 이렇게 하는 게 원래보다 (현재 코드) 더 간결하고 포문 돌아가는 데 낭비가 없다는 생각이었다.

그런데 계정 삭제를 구현하면서... 만약 첫 번째로 생성된 계정이 삭제되고 그 후에 계정을 만들지 않았다면 members[0] 값이 null값이라는 사실을 생각해냈다.

```java
for(int i=0; members[i]!=null; i++){ //members[i]!=null이 안되는 이유... members[0]이 0일수도잇으니까
    if(id.equals(members[i].getId())) //아이디 중복될 시 불가
    {
        System.out.println("아이디가 중복됩니다.");
        return;
    }
}
```

그래서 이걸 바보같이 그냥

```java
for(int i=0; members.lenght; i++){ 
    if(id.equals(members[i].getId())) //아이디 중복될 시 불가
    {
        System.out.println("아이디가 중복됩니다.");
        return;
    }
}
```

로 고쳤다. 당연히 오류가났다. NullPointerException이엇다. 잘보니 당연한 결과였다. members[i]에는 null이 들어있을텐데 거기서 어떻게 id값을 얻어올까.... 그래면 null이 아닐 때라는 이프문을 하나 더 써야했다. 그리고 이 점때문에 내가 members[i]!=null 로 바꿨던 점도 다시 생각났다. 