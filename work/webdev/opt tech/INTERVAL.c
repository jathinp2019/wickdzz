#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define f(x) pow(x, 4) - 5

float x, l, a, b, x1, x2, fun_x, f1, f2, i, ep;

int funct()
{
    while (i > 0)
    {
        fun_x = f(x);
        printf("f(%f)=%f\n", x, fun_x);
        x1 = a + (l / 4);
        printf("x1=%f\n", x1);
        x2 = b - (l / 4);
        printf("x2=%f\n", x2);
        f1 = f(x1);
        printf("f(%f)=%f\n", x1, f1);
        f2 = f(x2);
        printf("f(%f)=%f\n", x2, f2);
        if (f1 < fun_x)
        {
            printf("f(%f)<f(%f)\n", x1, x);
            b = x;
            printf("a=%f\n", a);
            x = x1;
            printf("x=%f\n", x);
            l = b - a;
            if (fabs(l) < ep)
            {
                break;
            }
        }
        else if (f2 < fun_x)
        {
            printf("f(%f)<f(%f)\n", x2, x);
            a = x;
            printf("b=%f\n", b);
            x = x2;
            printf("x=%f\n", x);
            l = b - a;
            if (fabs(l) < ep)
            {
                break;
            }
        }
        else
        {
            a = x1;
            printf("a=%f\n", a);
            b = x2;
            printf("b=%f\n", b);
            l = b - a;
            if (fabs(l) < ep)
            {
                break;
            }
        }
        i = i - 1;
    }
    printf("minimum lies between (%f,%f)", a, b);
    return 0;
}

int main()
{
    printf("enter the lower and upper bound");
    scanf("%f%f", &a, &b);
    printf("enter the erroe value");
    scanf("%f", &ep);
    x = (a + b) / 2;
    printf("x=%f\n", x);
    l = b - a;
    printf("l=%f\n", l);
    i = 100;

    return 0;
}