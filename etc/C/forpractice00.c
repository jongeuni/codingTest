#include <stdio.h>

// 오른쪽 위 직각삼각형 만들기

int main()
{
    int array[5][5] = {0};
    int count = 0;
    for (int i = 0; i < 5; i++) {
        for (int j = i; j < 5; j++) {
            count++;
            array[i][j] = count;
           
        }
    }

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            printf("%d   ",array[i][j]);
        }
        printf("\n");
    }

    return 0;
}
