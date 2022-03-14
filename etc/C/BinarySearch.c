#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int binarySearch(int arr[], int length, int target) {
    int first = 0;
    int last = length - 1;
    int mid;

    while (first <= last) {
        
        mid = (first + last) / 2;
        /*printf("%d\n", last);
        printf("first: %d, last: %d\n", first, last);
        printf("mid: %d\n", mid);*/
        if (target == arr[mid]) {
            //printf("target 찾음");
            return mid; 
        }
        else if (target < arr[mid]) {
            last = mid - 1;
        }
        else {
            first = mid + 1;
        }
    }
    return -1; // 찾지 못함.
}

int main()
{
    // 이진탐색, 인덱스를 반환한다.
    int arr[] = { 0,1,2,3,4,5,6,7,8,9,15,18 };
    int index = 0, eof = 1;
    char target = 1;
    
    while (eof!=-1) {
        printf("탐색할 값 (종료시 ctrl+z 계속 입력): ");
        
        eof = scanf("%d", &target);

        if (eof == -1) {
            break;
        }
        //printf("eof: %d\n", eof);
        index = binarySearch(arr, sizeof(arr) / sizeof(int), (int)target);
        if (index==-1) {
            printf("<<탐색 실패>>\n");
        }
        else {
            printf("%d번째\n", index+1);
        }
    }
    return 0;
}
