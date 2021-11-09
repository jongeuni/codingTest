## [K번째 수](https://programmers.co.kr/learn/courses/30/lessons/42748?language=java) - 42748

- 입출력 예시

```
array
[1, 5, 2, 6, 3, 7, 4]
commands
[[2, 5, 3], [4, 4, 1], [1, 7, 3]]
* return
[5,6,3]
```

array의 2번째부터 5번째까지 자르면 [5,2,6,3]이다. 1에서 나온 배열을 정렬하면 [2,3,5,6]이고 2에서 나온 배열의 3번째 숫자는 5이다. 그래서 return 배열의 첫 값에는 5가 담긴다.

<br>

### HOW

Arrays의 copyOfRange() 메서드를 사용해서 배열을 자르고 그걸 정렬 후 commands\[i][2]-1 인덱스 값을 answer에 저장한다.

<br>

### Code

```java
int[] answer = new int[commands.length];
```

commands의 길이로 배열을 하나 생성한다. commands의 각 행은 답으로 반환될 숫자에 대한 설명이기 때문이다. (i부터 j까지 자르고 그 배열의 k번째 인덱스를 반환하라.)

```java
for(int i = 0; i<commands.length; i++) {
    int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
    Arrays.sort(arr);
    answer[i] = arr[commands[i][2]-1];
}
return answer;
```

내가 계속 틀렸던 부분은 commands\[i][0]-1 부분이다. -1를 안 해서 계속 오류가 났다.  array를 commands\[i][0]부터 commands\[i][1]까지 자른다. -1을 하는 이유는 commands가 숫자를 0부터 세지 않기 때문이다. 그러니까 [1,2,3]을 2번째부터 3번째까지 자르면 [2,3]이다.

그리고 그렇게 잘라진 배열을 정렬해준다.

answer에 commands\[i][2]번째 arr 값을 담아준다. 역시 0번째부터 세지 않기때문에 -1을 해준다.

<br>

### Code

```java
package programmers_정렬_K번째수;

import java.util.Arrays;

public class NthNumber {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		System.out.println("답: "+nthNumber(array, commands));
	}
	
	public static int[] nthNumber(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i = 0; i<commands.length; i++) {
			int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(arr);
			answer[i] = arr[commands[i][2]-1];
		}
        return answer;
    }
}
```

