## [18892](https://www.acmicpc.net/problem/18892) 가장 긴 증가하는 부분 수열 ks

N개의 정수로 이루어진 수열 A1, A2, ..., AN에서, 가장 긴 증가하는 부분 수열(LIS)의 길이를 L이라고 하자. LIS는 하나 또는 그 이상 있을 수 있다. 모든 LIS를 사전 순으로 정렬했을 때, K번째 오는 수열을 구해보자.

두 LIS Ai1, Ai2, ..., AiL와 Aj1, Aj2, ..., AjL이 있을 때, ik ≠ jk를 만족하는 k가 하나라도 존재하면 다른 LIS이다.

### LIS란?

Longest Increasing Subsequence

한 수열에서 특정 부분을 지워서 만들 수 있는 최장 증가 부분 수열

[10,20,10,30,20,50]의 리스트가 주어졌을 때

LIS: [10,20,30,50]