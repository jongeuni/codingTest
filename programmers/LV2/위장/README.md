## [위장](https://programmers.co.kr/learn/courses/30/lessons/42578) - 42578

스파이들은 매일 다른 옷을 조합해 입어 자신을 위장한다. 

| 종류 | 이름                       |
| ---- | -------------------------- |
| 얼굴 | 동그란 안경, 검정 선글라스 |
| 상의 | 파란색 티셔츠              |
| 하의 | 청바지                     |
| 겉옷 | 긴 코트                    |

스파이가 가진 옷이 위와 같고, 오늘 스파이가 동그랑 안경, 긴 코트를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용해야 한다.

스파이가 가진 의상들이 담긴 2차원 배열 *clothes*가 주어질때, 서로 다른 옷의 조합의 수를 return하도록 함수를 작성해라.

- 입력 예시

```
[["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]
```

<br>

### HOW

결론적으로 조합의 수를 리턴하면 된다.  clothes 배열이 주어지는데 예시를 보면 배열의 두 번째 값이 집합의 이름, 즉 '상의'나 '하의' 등과 같다고 볼 수 있다. 각 집합별로 몇 개의 원소를 가지는지 파악해야 한다.

각 집합이 가지고 있는 원소의 갯수가 정해지면 1씩 더해준 뒤 집합별로 곱해주고 마지막에 1을 빼주면 된다. 각 집합은 선택이 안 될 가능성이 존재한다. 그래서 원소 갯수 + 1(선택되지 않을 경우)를 한다. 하지만 집합 중 하나는 꼭 선택이 되어야 하기 때문에 마지막 다 곱해준 것에서 1을 빼준다.

<br>

### Code

```java
HashMap<String, Integer> map = new HashMap<String, Integer>();
for (int i= 0; i < clothes.length; i++) {
    String key = clothes[i][1];
    map.put(key,map.getOrDefault(key, 0)+1);
}
```

clothes 구조를 보았을 때 \[N][1]값은 옷의 종류이다. key에 옷의 종류를 담는다. map의 key는 옷의 종류가 된다.

`getOrDefault(Object key, V DefaultValue)`: 찾는 key가 존재하면 해당 key에 매핑되어 있는 값을 반환하고 그렇지 않으면 디폴트 값이 반환된다.

HashMap의 경우 동일 키 값을 추가할 경우 value 값은 덮어쓰기가 된다. 따라서 기존 key 값의 value를 계속 사용하고싶을경우 `getOrDefault(...)` 메서드를 사용할수있다.

처음에 map은 텅텅 비어있으니까 옷 종류가 뭐든 value는 디폴트값인 1이 들어갈 것이다. for문이 또 돌았을 때 똑같은 옷 종류(똑같은 키 값)이 나오면 value에 들어있는 1에 +를 한 2가 다시 들어갈 것이다. 만약 모자 key의 value라면 모자 옷 갯수가 2개라는 것을 알 수 있다. (자연스럽게 옷 종류 별 갯수가 map에 저장된다.)

```
key: 옷 종류
value: 옷 종류별 갯수
```

for문을 다 돌면  key에 옷의 종류, value에 종류별 갯수가 든 hashmap이 완성된다.

```java
int answer = 1
for(String key : map.keySet()) {
    answer *= (map.get(key)+1);
}
return answer-1;
```

종류별 갯수에 그 종류가 안 나올 경우의 수를 하나 더하고 그 갯수들을 전부 곱해준다.

return할 때 -1을 해주는데 스파이가 옷을 하나도 안 걸칠 경우는 없기 때문이다.

그리고 answer을 1로 초기화 해 줘야 하는데 0이면 곱했을 경우 무조건 0이 되기 때문이다.

<br>

### Code

```java
package programmers_해시_위장;

import java.util.HashMap;

public class HashSpyHide {
	
	public static int clothesCount(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i= 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			
			map.put(key,map.getOrDefault(key, 0)+1);
		}
		
		int answer = 1;
		
		for (String key : map.keySet()) {
			answer *= (map.get(key)+1);
		}
		return answer - 1;
	}
	
	public static void main(String[] args) {
		String[][] clothes = new String[][] {
			{"yellowhat", "headgear"}, 
			{"bluesunglasses", "eyewear"}, 
			{"green_turban", "headgear"}
		};
		clothesCount(clothes);
	}

}
```

