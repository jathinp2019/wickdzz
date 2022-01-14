#include <stdio.h>
#include <math.h>
double y0, y1, y2, y3, y4;
int f = 0, i = 1;

struct p
{
	double x, y;
};

double fun(struct p x)
{
	return ((x.x * x.x + x.y - 11) * (x.x * x.x + x.y - 11) + (x.y * x.y + x.x - 7) * (x.y * x.y + x.x - 7));
}

void main()
{
	struct p x0, x1, x2, x3, x4, xm, xmp, dx;

	printf("enter initial point");
	printf("x0 : ");
	scanf("%lf", &x0.x);
	printf("y0 : ");
	scanf("%lf", &x0.y);
	printf("dx : ");
	scanf("%lf", &dx.x);
	printf("dy : ");
	scanf("%lf", &dx.y);

	dx.x = dx.x / 2.0;
	dx.y = dx.y / 2.0;

	while (i <= 7)
	{

		x1.x = x0.x + dx.x;
		x1.y = x0.y + dx.y;
		x2.x = x0.x + dx.x;
		x2.y = x0.y - dx.y;
		x3.x = x0.x - dx.x;
		x3.y = x0.y - dx.y;
		x4.x = x0.x - dx.x;
		x4.y = x0.y + dx.y;

		y0 = fun(x0);
		y1 = fun(x1);
		y2 = fun(x2);
		y3 = fun(x3);
		y4 = fun(x4);

		printf("%.4f , %.4f = %.4f \n", x0.x, x0.y, y0);
		printf("%.4f , %.4f = %.4f \n", x1.x, x1.y, y1);
		printf("%.4f , %.4f = %.4f \n", x2.x, x2.y, y2);
		printf("%.4f , %.4f = %.4f \n", x3.x, x3.y, y3);
		printf("%.4f , %.4f = %.4f \n", x4.x, x4.y, y4);

		if (f == 0)
		{
			xmp = x0;
			f = 1;
		}

		if (y0 <= y1 && y0 <= y2 && y0 <= y3 && y0 <= y4)
			xm = x0;
		if (y1 <= y0 && y1 <= y2 && y1 <= y3 && y1 <= y4)
			xm = x1;
		if (y2 <= y1 && y2 <= y0 && y2 <= y3 && y2 <= y4)
			xm = x2;
		if (y3 <= y1 && y3 <= y2 && y3 <= y0 && y3 <= y4)
			xm = x3;
		if (y4 <= y1 && y4 <= y2 && y4 <= y3 && y4 <= y0)
			xm = x4;

		printf("%.4f , %.4f\n\n\n", xm.x, xm.y);

		if (xm.x == xmp.x && xm.y == xmp.y)
		{
			dx.x = dx.x / 2.0;
			dx.y = dx.y / 2.0;
		}
		else
		{
			xmp = x0;
			x0 = xm;
		}
		i++;
	}
	printf("Minimum point = %.4f , %.4f", xm.x, xm.y);
}