#### fileinandout.c

```c
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include "Declaration.h"

int main()
{
    int a, b;
    scanf("%d %d", &a, &b);
    add(a, b);
    sub(a, b);
    mul(a, b);
    div(a, b);


    return 0;
}

```

####  define.c

``` c
#pragma once
#include <stdio.h>
#include "Declaration.h"

void add(int num1, int num2)
{
    printf("%d\n", num1 + num2);
}
void sub(int num1, int num2)
{
    printf("%d\n", num1 - num2);
}
void mul(int num1, int num2)
{
    printf("%d\n", num1 * num2);
}
void div(int num1, int num2)
{
    printf("%d", num1 / num2);
}
```

#### Declaration.h (헤더파일)

``` c
#pragma once
//#include <stdio.h>
void add(int num1, int num2);
void sub(int num1, int num2);
void mul(int num1, int num2);
void div(int num1, int num2);
```

