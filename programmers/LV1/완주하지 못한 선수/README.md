## [완주하지 못한 선수](https://programmers.co.kr/learn/courses/30/lessons/42576) - 42576

수많은 마라톤 선수들 중 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주했다. 

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 함수를 작성해라.

**<제한사항>**

1. completion의 길이는 participant의 길이보다 1 작다.

2. 참가자 중에는 동명이인이 있을 수 있다.

- 입력 예시

```
- participant
["marina", "josipa", "nikola", "vinko", "filipa"]
- completion
["josipa", "filipa", "marina", "nikola"]
```

<BR>

### HOW

Sorting과 Loop를 이용한 방법과, Hash를 사용하는 방법 이렇게 두 가지가 있다.

문제를 간단하게 생각해보면 [participant에는 N명의 참가자의 이름이 들어있고, completion에는 N-1명의 완주자들이 있다.] 그 한 명을 찾으면 된다.

1. Sorting을 사용하는 방법

Sorting으로 각각의 배열을 정렬한 뒤에 Loop를 통해 1:1 비교를 한다. 서로 다른 항목이 나온다면 그 사람이 완주하지 못한 사람이라는 것을 알 수 있다.

2. Hash를 사용하는 방법

일단 Hash를 사용하기 전에 나는 궁금증이 있었다. HashMap은 key가 중복 저장이 안 되는데, 배열에는 중복되는 이름의 사람이 들어갈 수 있다는 것. value를 조금 더 생각해보면 해결되는 문제다.

단순히 0과 1로 있다 없다를 표현하는 것으로는 안 되고 그 이름을 가진 참가자가 몇 명인지를 알아야 한다. 그래서 마라톤 참가 선수의 이름을 key 값으로, 사람의 명 수는 value로 넣어준다. `HashMap<String, Integer>`이 만들어 질 것이다.

다음 단계에서는 완주한 사람들의 value를 하나씩 뺀다. 그러면 value가 0이 아닌 사람이 완주하지 못한 선수가 된다. 전체 키를 하나씩 확인해서 value가 0이 아닌 경우 answer에 담아주는 동작을 하는 그 키의 이름이 완주하지 못한사람이다.

<BR>

### CODE

```java
HashMap<String, Integer> map = new HashMap<>();
for(String man : participant) {
    map.put(man, map.getOrDefault(man, 0)+1);
}
```

participant (참가자)를 해시 맵에 넣는다. key는 참가자의 이름으로 한다.

```java
for(String man : completion) {
    map.put(man, map.get(man)-1);
}
```

completion 루프를 돌면서 해당하는 이름의 key의 value는 -1씩 해준다.

```java
for(String key : map.keySet()) {
    if(map.get(key)>0) {
        answer = key;
        break;
    }
}        
return answer;
```

만약 value가 0이상 (0이 아니거나)인 경우 answer에 그 key 값을 넣어준다.

<br>

### CODE

- Hash 사용

```JAVA
package programmers_해시_완주하지못한선수;

import java.util.Arrays;
import java.util.HashMap;
public class Marathoners {
	public static String findPlayerDidntFinishRace(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String man : participant) {
        	map.put(man, map.getOrDefault(man, 0)+1);
        }
        for(String man : completion) {
        	map.put(man, map.get(man)-1);
        }
        for(String key : map.keySet()) {
        	if(map.get(key)>0) {
        		answer = key;
        		break;
        	}
        }
        return answer;
    }
    
    public static void main(String[] args) {
		String[] participant = new String[] {"mislav", "stanko", "mislav", "ana"};
		String[] completion = new String[] {"stanko", "ana", "mislav"};
		
		System.out.println("답: "+findPlayerDidntFinishRace(participant, completion));
	}
}
```

- Hash 미사용

```java
public static String findPlayerBySorting(String[] participant, String[] completion) {
    Arrays.sort(participant);
	Arrays.sort(completion);
	int i = 0;
	for(i=0; i<completion.length; i++) {
		if(!participant[i].equals(completion[i]))
			break;
    }
    return participant[i];
}
```

