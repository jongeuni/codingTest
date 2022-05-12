## [Majority Element - 169](https://leetcode.com/problems/majority-element/)

Given an array `nums` of size `n`, return *the majority element*.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

> majority element (다수의 요소)
>
> 다수의 요소는 n(nums의 길이)/2 이상이다. 다수의 요소는 항상 존재한다고 가정한다.

```
Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

<br>

### Code

```java
double time = nums.length/2.0;
```

다수의 요소는 n/2 이상이다. 그냥 `num.lenght/2`를 할 경우 3/2는 1의 값이 나오기에 1 이상의 갯수가 있기만 하면 다수의 요소로  [5,6,6]이 들어오고, 다수의 요소라고 판단되기때문에 소수점까지 계산해야 한다.

```java
for (int num: nums) {
    int count = 0;
    for(int n : nums) {
        if (n==num) {
            count++;
        }
    }
    if(count>=time) {
        return num;
    }
}
```

nums에서 숫자를 하나씩 꺼내고, 다시 한 번 nums를 돌면서 일치하면 count 하는 방식이다. 그리고 그 count 한 숫자가 time 이상이라면 다수의 요소라고 판단하고 리턴해준다.

<br>

### Code

```java
class Solution {
    public int majorityElement(int[] nums) {
        double time = nums.length/2.0;
        
        for (int num: nums) {
            int count = 0;
            for(int n : nums) {
                if (n==num) {
                    count++;
                }
            }
            if(count>=time) {
                return num;
            }
        }
        return -1;
    }
}
```

다수의 요소가 무조건 존재한다고 가정하므로 마지막에는 return -1을 해준다.



