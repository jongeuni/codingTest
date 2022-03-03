## [Credit Card Mask](https://www.codewars.com/kata/5412509bd436bd33920011bc/train/java)

Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most secret question is still correct. However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.

Your task is to write a function `maskify`, which changes all but the last four characters into `'#'`.

<br>

무언갈 살  때, 신용 카드 번호, 전화번호, 비밀스러운 질문의 대답이 아직 유효한지 묻습니다. 그러나, 어깨 너머로 볼 수 있으니 너는 화면을 보는 걸 원하지 않을 것입니다. 대신 우리는 그것을 가려줍니다.

당신의 임무는 함수 마스크파이를 작성하는 것입니다. 이 마스크파이는 **마지막 4자를 제외한 모든 문자를 '#'로 변경**합니다.

<br>

```
Maskify.Maskify("4556364607935616"); // should return "############5616"
Maskify.Maskify("1");                // should return "1"
Maskify.Maskify("Skippy");           // should return "##ippy"
```

<br>

### How

두 가지 방법을 생각했다.

1. 네글자를 짜르고 #를 앞에 붙인다.

   뒤에 네글자를 자르고, 문자 총 길이 - 4만큼 #를 생성해서 둘이 합치는 방법이다.

2. 함수를 사용하여 뒤에 네 글자를 제외하고 #으로 변경한다.

나는 두 번째 방법을 하고 싶었다. 그런데 중요한 건 String은 불변이다. python으로 하면 쉬울 것 같다는 생각을 했다. python은 -4하면 되는데....

아래는 실패했다.

```java
public static String maskify(String str) {
	if(str.length()<=4) {
        return str;
    }
    StringBuilder strb = new StringBuilder(str);
    return strb.replace(0, str.lenght()-4, "#").toString();
}
```

그래서 첫 번째 방법을 선택했다. 아쉽다.

<br>

### Code

```java
public static String maskify(String str) {
    if(str.length()<=4) {
        return str;
    }
    String f = str.substring(str.length()-4);
    String s = "#".repeat(str.length()-4);
    return s+f;
}
```

결국 이렇게됐다.

조금 고쳐보았다. 

```java
public static String maskify(String str) {
    if(str.length()<=4) {
        return str;
    }
    
    int poundSignLen = str.length()-4;
    
    return "#".repeat(poundSignLen)+str.substring(poundSignLen);
}
```

<br>

### Code

```java
package codewars_7kyu;
public class CreditCardMask {
	public static void main(String[] args) {
        maskify("4556364607935616");
	}
	
	public static String maskify(String str) {
		if(str.length()<=4) {
	        return str;
	    }
	    int poundSignLen = str.length()-4;
	   
	    return "#".repeat(poundSignLen)+str.substring(poundSignLen);
	}
}
```

---

다른 사람의 코드.

```java
public static String maskify(String str) {
    return str.replaceAll(".(?=.{4})", "#");
}
```
