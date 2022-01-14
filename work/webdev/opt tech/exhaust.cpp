#include <iostream>
#include <cmath>

using namespace std;

// #define f(x) pow(x, 3) + 1
#define f(x) pow(x, 4) - 5

float x1, delta, x2, x3, a, b;

int cal(float x1, float x2, float x3, float d)
{
    cout << x1 << "," << x2 << "," << x3 << "," << d << endl;

    if (f(x1) >= f(x2) && f(x2) <= f(x3))
    {

        cout << "f(x1): " << f(x1) << " f(x2): " << f(x2) << " f(x3): " << f(x3) << endl;
        cout << "terminate" << endl;
        cout << "Min lies in : (" << x1 << "," << x3 << ")" << endl;
        return 0;
    }
    else
    {
        cout << "not terminate" << endl;
        cout << "f(x1): " << f(x1) << " f(x2): " << f(x2) << " f(x3): " << f(x3) << endl;
        x1 = x2;
        x2 = x3;
        x3 = x2 + d;

        if (x3 <= b)
        {
            cal(x1, x2, x3, delta);
        }
        else
        {
            cout << "Min does not lie in interval" << endl;
            cout << "OR\n Boundary points are minimum points" << endl;
            return 0;
        }
    }
    return 0;
}

int main()
{
    cout << "Enter the interval: (a,b) " << endl;
    cin >> a >> b;

    cout << "Enter initial value: " << endl;
    cin >> x1;

    int n = 10;

    delta = (b - a) / n;
    x2 = x1 + delta;
    x3 = x2 + delta;

    if (x3 <= b)
    {
        cal(x1, x2, x3, delta);
    }

    return 0;
}
