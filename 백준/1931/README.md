## [1931](https://www.acmicpc.net/problem/1931) 회의실 배정 

한 개의 회의실이 있고 이를 사용하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의에 대해 시작 시간과 끝나는 시간이 주어져 있다. 각 회의가 겹치지 않게 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 회의는 한 번 시작하면 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.

```
*예제입력
4
1 4
3 5
0 6
5 7
```

<BR>

### How

빨리 끝나는 회의 순으로 정렬 후 순차적으로 탐색하며 선택된 회의 끝나는 시간이 다음 회의의 시작시간보다 작거나 같을 때 카운트 한다.

#### 그리디 알고리즘 (탐욕법)

위 문제는 그리디 알고리즘으로 빠르고 효율적으로 결과를 도출해낼 수 있다고 한다.

*그리디 알고리즘*이란 **현재 상황에서 가장 좋은 결과**를 선택해 나가는 방식이다. 최종적인 결과 도출이 최적이라는 것을 보장하지는 않는다.

1. 종료 시간이 가장 빠른 것을 선택한다. [참고](https://hongjw1938.tistory.com/172)

   최대한 많은 활동을 해야하므로 언제 시작하든 전체에서 가장 종료 시간이 빠른 것부터 선택해야 한다. 종료 시간을 기준으로 정렬한다.

2. 끝났을 때 바로 다음에 선택할 수 있는 활동을 찾아 수행한다.

3. 위 과정을 반복한다.

<BR>

### Code

```java
Scanner sc = new Scanner(System.in);
int num = sc.nextInt();

int[][] arr = new int[num][2];
for (int i = 0; i<num; i++) {
    arr[i][0] = sc.nextInt();
    arr[i][1] = sc.nextInt();
}
```

값을 입력받는다. num에는 총 회의 갯수가 들어간다. int[num]\[2]인 이유는 시작시간, 종료시간 두 가지가 들어오기 때문이다. 

```java
Arrays.sort(arr, (o1, o2)->{
    if(o1[1]==o2[1])
        return Integer.compare(o1[0], o2[0]);
    return Integer.compare(o1[1], o2[1]);
});
```

회의 끝나는시간이 빠른 것을 기준으로 정렬한다. 만약 끝나는시간이 같다면 시작 시간이 빠른 것을 앞에 둔다.

```java
int cnt = 0;
int finishTime = 0;
for(int j = 0; j<num; j++) {
    if(finishTime <= arr[j][0]) {
        cnt++;
        finishTime = arr[j][1];
    }
}
```

현재 선택된 종료 시간과  같거나 더 늦은 시작시간일경우 count 해 주고 그 회의의 종료시간을 finishTime에 넣어준다.

<br>

### Code

```java
package beakjoon_1931;

import java.util.Arrays;
import java.util.Scanner;

class EfficientMeeting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int cnt = 0;
		int finishTime = 0;
		
		int[][] arr = new int[num][2];
		
		for (int i = 0; i<num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, (o1, o2)->{
			if(o1[1]==o2[1])
				return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		});
		
		for(int j = 0; j<num; j++) {
			if(finishTime <= arr[j][0]) {
				cnt++;
				finishTime = arr[j][1];
			}
		}

		System.out.println(cnt);
		
		sc.close();
	}
}
```

