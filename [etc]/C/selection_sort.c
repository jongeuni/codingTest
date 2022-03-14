#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define MAX 5
int main()
{
    int arr[MAX] = { 0 };
    // 배열에 값 넣기
    for (int i = 0; i < MAX; i++) {
        scanf("%d", &arr[i]);
    } 

    for (int i = 0; i < MAX-1; i++) {
        for (int j = i; j < MAX; j++) {
            if (arr[i] < arr[j]) { //내림차순
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    for (int i = 0; i < MAX; i++) {
        printf("%d", arr[i]);
    }
    return 0;
}
