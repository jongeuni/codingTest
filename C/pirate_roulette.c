#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int main()
{
    int MAX;
    printf("선원의 수(N)는? (1<N)");
    scanf("%d", &MAX);

    int* A = (int*)malloc(MAX * sizeof(int));
    int* R = (int*)malloc(MAX * sizeof(int));
    int a = 1, step = 3, remain;

    A[0] = 1;
    R[0] = 1;
    while (a < MAX) {
        A[a] = a + 1; R[a] = R[a - 1] + step;
        if (R[a] > A[a]) R[a]=R[a] - A[a];
        // printf("%3d" ==> %3d\n", A[a],R[a]); 중간과정 확인
        a++;
    }
    printf("%3d ==> %3d\n", A[a - 1], R[a - 1]);

    return 0;
}
