## [Is Subsequence - 392](https://leetcode.com/problems/is-subsequence/submissions/)

Given two string s and t, return true if s is a subsequence of t, or false otherwise.

> subsequence (부분 수열)
>
> 오리지널 String에서 특정 문자들을 지웠을 때 나올 수 있는 String을 뜻한다.

```
Input: s = "abc", t = "ahbgdc"
Output: true
```

<br>

### Code

```java
public static boolean isSubsequence(String s, String t) {
    int len = s.length();
	int count = 0;
		
    if(s.length()==0) {
        return true;
    }
    
    for(int i =0; i<s.length(); i++) {
        for(int j = j; j<t.length(); j++) {
            //Character.compare(t.charAt(j), s.charAt(i));
            if(t.charAt(j)==s.charAt(i)) {
                count++;
                break;
                // 만약 남은 글자수가 포함해야할 글자수보다 작다면?
            }
        }
    }
    
    if(count==len) {
        return true;
    }
    return false;
}
```

처음엔 이렇게 작성했다. 

```
"abcaaaa"
"ahbgdc"
```

그런데 인풋을 이렇게 주었더니 true 값이 반환되었다.  

생각해봤다. 이렇게... 이렇게 하면 j가 항상 처음으로 돌아가잖아. 잠깐, 처음으로 돌아가서 비교하면 안 되는데?? 근데 for문을 사용하려면 처음에 초기화를 해 주어야 한다. 그래서 약간 고민을 하다가 j=0+j를 생각해냈다. 밑에 j++를 붙여줄까 했지만 그렇게 하면 j가 두 번 +되는 상황이 벌여지기때문에 붙이지 않았다.

```java
int j = 0;
for(j=0+j; j<t.length(); j++) {
    if(t.charAt(j)==s.charAt(i)) {
        count++;
		break;
    }
}
```

392는 (나에게) 그렇게 쉽게 당해주지 않았다.

```
"aaaaaa"
"bbaaaa"
```

을 입력했을 때 false가 나와야하는데, true가 나왔다. 사실 위에 주석으로 단 것처럼 남은 글자수가 포함해야할 글자수보다 적다면 (포함되어야 할 글자수가 더 많다면) false를 리턴해준다라는 코드가 추가되면 끝날 일이지만 그러고 싶지 않았다. 문제는 아까 붙이지 않았던 j++이었다. 다시 생각해보니 *j가 +되지 않을 상황은 break가 걸렸을 때 뿐*이었다, 그러니 **그 곳에 j++를** 붙여주면 됐다.

<br>

***성공.***

![image](https://user-images.githubusercontent.com/66874658/156342963-8d61f5ba-1bf3-4e2c-9b31-fc60e292a5b1.png) 

처음 릿코드를 풀었고, 혼자 생각해서 풀었다. 기분이 좋았다. 😊🥰

<br>

### Code

```java
package leet_code_392;

public class Subsequence {
    public static void main(String[] args) {
		String a = "aaaaaa";
		String b = "bbaaaa";
        isSubsequence(a, b);
    }
	
	public static boolean isSubsequence(String s, String t) {
		int len = s.length();
		int count = 0;
		int j = 0;
		
		if(s.length()==0) {
			return true;
		}
		
		for(int i =0; i<s.length(); i++) {
			for(j=0+j; j<t.length(); j++) {
				if(t.charAt(j)==s.charAt(i)) {
					count++;
					break;
				}
			}
			j++;
		}
		
		if(count==len) {
			return true;
		}
		return false;
	}
}
```

<br>

---

![image](https://user-images.githubusercontent.com/66874658/156343948-0ad9d087-5d59-41cc-a011-e92179ed7225.png)

나는 여기. 중간 정도로 푼 것 같다. runtime 엄청 적게 걸린 사람들은 어떻게 풀었을지 궁금하다. 글자수까지 체크했나?
