#include <iostream>
#include "Shapes.hpp"
using namespace std;

void pascalsTriangle(int deph);

int main()
{
	cout << "Hello World" <<endl;
    pascalsTriangle(11);

    Shape* formen[4];
    formen[0] = new KreisAgg(4, 5, 10);
    formen[1] = new Rechteck(1, 2, 20, 10);
    formen[2] = new KreisAgg(0, 1, 5);
    formen[3] = new Rechteck(10, 4, 4, 2);

    Shape* test = formen[0]->clone();
    Point* ente = test->getLocation();
    delete test;

    for(int i=0; i<4; ++i)	{
                cout << formen[i]->flaechenInhalt() << endl;
            }
    for(int i=0; i<4; ++i)  {
        delete formen[i];
    }

	return 0;
}

void pascalsTriangle(int deph)	{
        int** triangle = new int* [deph];
		for(int i=0; i<deph; ++i)	{
			// breite der Zeile ist = tiefe
			triangle[i] = new int[i+1];
			triangle[i][0] = 1;
			// jr zeigt auf das Element rechts von jl
			for(int jl=0, jr=1; jr<i; ++jl, ++jr)	{
				triangle[i][jr] = triangle[i-1][jl] + triangle[i-1][jr];
			}
			triangle[i][i] = 1;
		}

		for(int i=0; i<deph; ++i)	{
            for(int j=0; j<=i; ++j)	{
				cout << triangle[i][j] << ' ';
			}
			cout << endl;
		}

		for(int i=0; i<deph; ++i)	{
			delete [] triangle[i];
		}
		delete [] triangle;
	}
