#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int overflowPrevention=0;

#define STACK_SIZE 5 

printMenu()
{
    printf("\n\n+++++++++++++++++++++++++++++\n");
    printf("\t1 - 삽입 \n");
    printf("\t2 - 삭제 \n");
    printf("\t3 - 출력 \n");
    printf("\tq - 프로그램 종료 \n");
    printf("+++++++++++++++++++++++++++++\n");
    printf("메뉴를 선택하세요. >> \n");
    /*1 입력 : 스택의 삽입기능이 되게 하시오. 정수저장 스택이 꽉 차 있는 경우 "stack overflow" 메시지 출력
2 입력 : 스택 삭제기능이 되게 하시오. 단, 삭제시 1개의 데이타만 삭제됩니다. 스택이 비어있는 경우 "stack underflow" 메시지 출력
3 입력 : 스택에 저장되어 있는 데이타 전체를 출력하도록 하시오. q 입력 : 프로그램이 종료됩니다. 그 외 입력 : 해당 메뉴 없음을 출력*/
}

void stackPush(int *stack) {
    if (overflowPrevention >= 5) {
        printf("stack overflow가 발생합니다.\n");
    }
    else {
        int number;
        printf("stack에 Push할 정수 값을 입력하세요. > ");
        scanf("%d", &number);
        stack[overflowPrevention] = number;
        overflowPrevention++;
    }
        
    
}

void stackPop(int *stack) {
    if (overflowPrevention <= 0) {
        printf("Pop할 값이 없습니다.\n");
    }
    else {
        stack[overflowPrevention] == NULL;
        overflowPrevention--;
    }
}

void stackPrint(int *stack) {
    for (int i = 0; i < overflowPrevention; i++) {
        printf("%d",stack[i]);
    }
}

int main()
{
    char menu;
    int stack[STACK_SIZE];
    while (1) {
        printMenu();
        scanf(" %c", &menu);
        switch (menu) {
        case '1':

            stackPush(stack);
            break;
            // 삽입
        case '2':
            stackPop(stack);
            break;
            //삭제
        case '3':
            stackPrint(stack);
            break;
            //출력
        case 'q':
            return 0;
        default:
            printf("해당 메뉴 없음\n");
            break;
        }

    }
    return 0;
}
