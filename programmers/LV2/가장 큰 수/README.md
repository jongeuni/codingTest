## [가장 큰 수](https://programmers.co.kr/learn/courses/30/lessons/42746) - 42746

0또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return하도록 함수를 작성하라.

- 입출력 예시

```
numbers
[6,10,2]
return
"6210"
```

<br>

### How

큰 수가 앞에 오도록 내림차순 정렬을 해야한다.

<br>

### Code

```java
String[] arr = new String[numbers.length];
for(int i=0; i<numbers.length; i++) {
	arr[i] = String.valueOf(numbers[i]);
}
```

numbers를 String으로 변환해서 배열에 넣는다.

```java
Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return (b+a).compareTo(a+b);
    }
});
```

`public static void sort ( T[] a, Comparator<? super T> c )` Arrays는 두 번째 인자로 Comparator 인터페이스를 받을 수 있다. 지정된 Comparator가 가리키는 순서에 따라 지정된 객체의 배열을 정렬한다. Comparator 인터페이스를 구현할 때 compare()를 구현해야 한다. [compareTo()](https://mine-it-record.tistory.com/133)는  두 개의 값을 비교하여 int 값으로 반환해주는 함수이다. 문자열의 비교 같은 경우는 같으면 0, 현재 비교 대상인 인스턴스보다 작으면 음수, 크면 양수로 결과를 반환해준다. 

> ` (a+b).compareTo(a+b)`을 하면 오름차순 정렬이 된다.

```java
return arr[0].equals("0") ? arr[0] : String.join("", arr);
```

첫번째 자리가 0이라면 arr[0] (0)을 넘겨주고 아니라면 arr 배열값을 String으로 바꿔서 넣어준다. 이렇게 삼항연산자를(join 메서드를) 사용하는게아니라.

```java
if (arr[0].equals("0")) return "0";
for(String a: arr) answer += a;
return answer;
```

0일 경우 0을 리턴하고 아니면 문자열을 더하게 할 수 있다.

### Code

```java
package programmers_정렬_가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
	public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {
        	@Override
        	public int compare(String a, String b) {
        		return (a+b).compareTo(b+a);
        	}
        });

        if(arr[0].equals("0")) return "0";
        
        for(String a: arr) answer += a;
        
        return answer;
    }
}
```

