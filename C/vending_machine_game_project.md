## 자판기 게임

### 기능

1. **물품 관리**
2. **물품 보기**
3. **게임**

**물품 관리**

1. **물품 등록**
2. **물품 삭제**

### 내용

1. 관리자는 자판기 물품을 관리할 수 있다.
2. 물품 가격을 맞추면 물품을 획득할 수 있다.
3. 물품 가격을 입력했을 때 up, down으로 알려준다.

### 조건

1. 물품 가격이 0원 이하일 수는 없다.
2. 세 개의 기능을 함수로 분리한다.
3. 파일 분할을 사용한다.

### 소스 코드

#### vm.h (헤더파일)

```c
#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define pw 818 //관리자 비밀번호
#define max_num 50

typedef struct
{
	int num; //물품 번호
	char name[20]; //물품 이름
	int price; //물품 가격
}VM;

void product_registration(VM* save);
void product_view(VM* save);
void product_delete(VM* save);
void Manager(VM* save);
void game(VM* save, int _num);
void User(VM* save);
```

#### vending_machine.c

```c
#include "VM.h"
int main()
{
	VM save[max_num];
	char q,m;
	printf("종료는 z을 입력, 계속하려면 아무거나 누르세요.\n");
	scanf("%c", &q);
	while (q != 'z')
	{
		printf("관리자라면 0, 아니라면 1을 입력하세요.\n");
		scanf(" %c", &m);
		switch (m)
		{
		case '0':
			Manager(save);
			break;
		case '1':
			User(save);
			break;
		case 'z':
			return 0;
		default:
			printf("다시 입력해주세요.\n");
			break;
		}
	}
	return 0;
}
```

#### Manager.c (관리자)

```c
#include "VM.h"

void Manager(VM* save)
{
	int m_pw; //관리자인지 아닌지 구분하는 변수
	int product;
	printf("관리자 비밀번호를 입력하세요.\n");
	scanf("%d", &m_pw);

	if (m_pw == pw)
	{
		printf("물품 등록은 1, 물품 삭제는 2, 물품 보기는 3, 관리자 로그아웃은 0을 입력하세요.\n");
		scanf("%d", &product);
		while (product != 0)
		{
			if (product == 1)
			{
				product_registration(save);
			}
			else if (product == 2)
			{
				product_delete(save);
			}
			else if (product == 3)
			{
				product_view(save);
			}
			else
			{
				printf("다시 입력해주세요.\n");
			}
			printf("물품 등록은 1, 물품 삭제는 2, 물품 보기는 3, 관리자 로그아웃은 0을 입력하세요.\n");
			scanf("%d", &product);
		}
	}
	else
	{
		printf("틀렸습니다.\n");
	}
}
```

#### product_registration.c (물품 등록)

```c
#include "VM.h"

void product_registration(VM* save)
{
	int _num, x, price;
	printf("등록할 물품의 번호를 입력하세요.\n");
	scanf("%d", &_num);
	for (x = 0; x < max_num; x++)
	{
		if (save[x].num == _num)
		{
			printf("이미 등록된 물품 번호입니다.\n");
			printf("등록된 물품: %s\n", save[x].name);
			return;
		}
	}
	if (_num <= max_num && _num > 0)
	{
		save[_num].num = _num;
		printf("물품 번호가 등록되었습니다.\n");
	}
	else
	{
		printf("물품번호의 최대는 %d번 입니다.\n", max_num);
		return;
	}
	printf("등록할 물품의 이름을 입력하세요.\n");
	scanf("%s", save[_num].name);
	printf("물품의 가격을 입력하세요.(최대 1,000,000원.)\n");
	scanf("%d", &price);
	//scanf("%d", save[_num].price); //&연산자를 붙여줘야 한다
	if (price <= 1000000 && price >= 0)
	{
		save[_num].num = _num;
		save[_num].price = price;
		printf("%s 물품 등록이 완료됐습니다.\n", save[_num].name);
	}
	else
	{
		printf("물품의 가격은 0이상 1,000,000 이하만 가능합니다.\n");
		save[_num].num = 0;
	}
}
```

#### product_delete.c (물품 삭제)

```c
#include "VM.h"
void product_delete(VM* save)
{
	int _num;
	printf("삭제할 물품의 번호를 입력하세요.\n");
	scanf("%d", &_num);
	if (save[_num].num <= 50 && save[_num].num > 0)
	{
		save[_num].num = 0;
		printf("%s 물품이 삭제되었습니다.\n", &save[_num].name);
	}
	else
	{
		printf("잘못입력하셨습니다.\n"); //999치면 안됨.
	}
}
```

#### product_view.c (물품 보기)

```c
#include "VM.h"

void product_view(VM* save)
{
	int x, y, count = 0, count2 = 0;
	printf("-----------------------------------------------------\n");
	for (x = 1; x <= max_num / 5; x++)
	{
		for (y = 1; y <= 5; y++)
		{
			count++;
			printf("%5d 번째", count);
		}
		putchar('\n');
		for (y = 1; y <= 5; y++)
		{
			count2++;
			if (save[count2].num <= 50 && save[count2].num > 0)
			{
				printf("%10s", save[count2].name);
			}
			else
			{
				printf("          ");
			}

		}
		putchar('\n');
	}
	printf("\n----------------------------------------------------\n");
}
```

#### User.c (사용자)

```c
#include "VM.h"

void User(VM* save)
{
	int _num;
	printf("물품의 가격을 맞출시 물품을 획득할 수 있습니다.\n");
	printf("획득하고 싶은 물품의 번호를 입력하세요. (51입력시 전체 물품 목록 보기.)\n");
	scanf("%d", &_num);
	if (_num == 51)
	{
		product_view(save);
	}
	else if (_num <= 50 && _num > 0)
	{
		game(save, _num); //물품 맞추기
	}
	else
	{
		printf("없는 물품입니다.\n");
		return;
	}
}
```

#### game.c (게임)

```c
#include "VM.h"

void game(VM* save, int _num)
{
	int EX;

	if (save[_num].num <= 50 && save[_num].num > 0)
	{
		printf("예상 가격을 입력하세요. 종료하고 싶을 시 z를 입력하세요. (최대가격은 1,000,000원입니다. 최소가격은 0원입니다.)\n");
		while (getchar() != '\n'); //버퍼 비우기.
		scanf("%c", &EX);
		while ((char)EX != 'z')
		{
			if (save[_num].price == EX)
			{
				printf("정답!!!!!! 짱!!!!!!\n");
				return;
			}
			else
			{
				if (EX < save[_num].price)
				{
					printf("up.\n");
				}
				else
				{
					printf("down.\n");
				}
			}
			printf("예상 가격을 입력하세요.\n");
			scanf("%d", &EX);
		}
	}
	else
	{
		printf("없는 물품입니다.\n");
	}

}
```

