## Palindrome.py

```python
def is_palindrome(word):
    check = True
    for i in range(int(len(word)/2)):
        if word[i]!=word[-1-i]:
            check = False
            return check
            break
    return check
```

파이썬의 for문는 문자열 또는 리스트가 들어간다. 그래서 범위로 설정해 주고 싶은 경우에는 range를 써 주어야 한다.

위 같은 경우에는 문자열을 받아 그게 회문(팰린드롬)인지 판별 후 맞으면 True 틀리면 False를 return 해주는 코드이다. len(word)로 문자열의 길이를 구하고 2로 나눈다. 그리고 그걸 int로 변환해준다. 또 그걸 다시 range로 변환하면 된다.

word[-1]을 하면 배열의 맨 뒤가 출력된다. 

그러니가 위 코드는 앞 글자와 뒷 글자를 비교하게 되는 것이다.

