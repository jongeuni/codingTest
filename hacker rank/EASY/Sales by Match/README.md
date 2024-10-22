## [Sales by Match](https://www.hackerrank.com/challenges/sock-merchant/problem)

There is a large pile of socks that must be paired by color. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

색깔별로 짝을 맞춰야 하는 양말들이 많이 쌓여있다. 각 양말의 색상을 나타내는 정수 배열이 주어진 경우, 색깔이 일치하는 양말 쌍이 몇 개 있는지 확인한다.

```
n = 7
ar = [1,2,1,2,1,3,2]
```

이 경우 1색깔을 가진 양말이 두 개, 2색깔을 가진 양말이 3개, 3색깔을 가진 양말이 1개 있으므로 짝이 맞는 것은 1색깔 한 쌍과 2색깔 한 쌍이다.

<br>

### How

처음에 감이 왔다. 그런데 푸는 과정에서 많은 실수들.

나는 이렇게 생각했다. 일단 정렬을 하고, 앞과 뒤가 같으면 카운트, 근데 거기에 맵을 더한다.

<br>

### Code

```java
Collections.sort(ar);
```

일단 양말을 정렬한다. 그러면 같은 색깔의 양말들은 뭉쳐있게 된다.

```java
Map<Integer, Integer> m = new HashMap<>();
int num=1;
for(int i = 0; i<n-1; i++) {
    if(ar.get(i)!=ar.get(i+1)) {
        m.put(ar.get(i), num);
        num=1; 
    } else {
        m.put(ar.get(i), num);
        num++;
    }
}
```

맵을 만든다. <양말 종류, 양말 종류별 갯수> 이런 식으로 값이 들어가게 된다. 

그리고 현재 값과 다음 값을 비교해 같으면 갯수를 더해준다. 만약 두 값이 다르다면 num을 1로 초기화 해준다. 여기서 약간 애를 먹었는데, 처음에 1이 아니라 0으로 초기화를 해주었다. 😥

```java
int result = 0;
for(int i : m.values()) {
    result += i/2;
}
return result;
```

values값을 2로 나누어 몫을 result에 저장하면 끝이다.

<br>

### Code

```java
package hackerranck_salesbymatch;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesByMatch {
	public static void main(String[] args) {
        int n = 10;
        List<Integer> ar = Arrays.asList(new Integer[] {1,1,3,1,2,1,3,3,3,3});
        int result = sockMerchant(n, ar);
        System.out.println(result);
	}
	
	public static int sockMerchant(int n, List<Integer> ar) {
		Collections.sort(ar);
		Map<Integer, Integer> m = new HashMap<>();
		int num=1;
		for(int i = 0; i<n-1; i++) {
			if(ar.get(i)!=ar.get(i+1)) {
				m.put(ar.get(i), num);
				num=1; // 이걸 1로 초기화 ㅜㅜ
			} else {
				m.put(ar.get(i), num);
				num++;
			}
		}
		
		int result = 0;
		for(int i : m.values()) {
			result += i/2;
		}
		return result;
	}
}
```

---

혼자 다 풀었다. 이게 맞나 싶지만. 일단 통과했으니까 됐어.