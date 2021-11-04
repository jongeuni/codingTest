## [전화번호 목록](https://programmers.co.kr/learn/courses/30/lessons/42577)

전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 한다.

구조대: 119 / 박준영: 97 674 223 / 지영석: 11 9552 4421

이 경우 구조대는 지영석의 접두어이다. 

전화번호부에 적힌 전화번호를 담은 배열 phone_book이 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 함수를 작성하라.

- 입력 예시

```
["119", "97674223", "1195524421"]
```

<br>

### HOW

전화번호를 한 글자씩 자르면서, 그 번호가 전화번호부에 있는지 확인하면 된다.

<br>

### Code

```java
Map<String, String> newPhoneDir = new HashMap<>();
for(String phoneNum: phoneDir) {
    newPhoneDir.put(phoneNum, phoneNum);
}
```

HashMap을 만들고, 거기에 전화번호들을 넣는다.

```java
for(String check : phoneDir) {
    for(int i=0; i<check.length(); i++) {
        if(newPhoneDir.containsKey(check.substring(0,i))) {
            return false;
        }
    }
}
return true;
```

매개변수로 넘겨진 전화번호부를 for문에 넣고 전화번호를 하나씩 꺼낸다. 그리고 그 전화번호의 글자수만큼 다시 for문을 돌린다. 전화번호를 한 글자씩 자르며 map에 (newPhoneDir) 그 번호가 있는지 확인하고, 만약 있다면 false를 return 한다.

<br>

### Code

```java
package programmers_해시_전화번호목록;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
	public static boolean prefixCheck(String[] phoneDir) {
		Map<String, String> newPhoneDir = new HashMap<>();
        
		for(String phoneNum: phoneDir) {
			newPhoneDir.put(phoneNum, phoneNum);
		}
		
		for(String check : phoneDir) {
			for(int i=0; i<check.length(); i++) {
				if(newPhoneDir.containsKey(check.substring(0,i))) {
					return false;
				}
			}
		}
		return true;
    }
    
    public static void main(String[] args) {
		String[] phoneDir = new String[] {"119", "97674223", "1195524421"};
		prefixCheck(phoneDir);
	}
}
```

---

리스트를 사용하면 안 되나라는 의문이 들었다. 그래서 List를 이용해서도 작성해봤다.

```java
public boolean prefixCheckUseList(String[] phoneDir) {
		List<String> newPhoneDir = new ArrayList<>();
    
		for(String phoneNum: phoneDir) {
			newPhoneDir.add(phoneNum);
		}
    
		for(String check : phoneDir) {
			for(int i=0; i<check.length(); i++) {
				if(newPhoneDir.contains(check.substring(0,i))) {
					return false;
				}
			}
		}
		return true;
	}
}
```

```
효율성 테스트
테스트 1 〉	통과 (5.93ms, 58.6MB)
테스트 2 〉	통과 (2.35ms, 56MB)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 83.3
효율성: 8.3
합계: 91.7 / 100.0
```

놀랍게도 효율성 테스트에서 실패했다. Hash를 사용하면 Key와 Value에 둘 다 같은 값을 저장해서 비효율적이라고 생각했기에 List 사용이 더 낫지 않을까 싶었는데 아니었다.
