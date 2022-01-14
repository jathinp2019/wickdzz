#include <iostream>
#include <cmath>

using namespace std;

#define f(x) pow(x, 3) + 1
// #define f(x) pow(x, 4) - 5

float x0, inc, x_sub, x, x_add, xk[100], fk[100];

int cal(float inc, float xk[100], int k)
{
    xk[k + 1] = xk[k] + (pow(2, k) * inc);

    cout << " iteration - " << k + 1 << endl;

    if (f(xk[k + 1]) < f(xk[k]))
    {
        cout << "f(" << xk[k + 1] << ") < f(" << xk[k] << ")" << endl;
        k++;
        cal(inc, xk, k);
    }
    else
    {
        cout << "f(" << xk[k + 1] << ") > f(" << xk[k] << ")" << endl;
        cout << "Min lies in interval: (" << xk[k - 1]
             << "," << xk[k + 1]
             << ")" << endl;
    }

    return 0;
}

int main()
{
    int k = 0, i;

    cout << ("Initial guess and increment: ") << endl;
    cin >> x0 >> inc;

    x_sub = x0 - inc;
    x = x0;
    x_add = x0 + inc;

    cout << "f(x0) - |inc|) =" << f(x_sub) << endl;
    cout << "f(x0) =" << f(x) << endl;
    cout << "f(x0) + |inc|) =" << f(x_add) << endl;

    if (f(x_sub) > f(x) > f(x_add))
    {
        cout << "inc is +ve" << endl;
        inc = inc;
    }
    else
        inc = -inc;
    xk[k] = x0;
    cal(inc, xk, k);

    return 0;
}
