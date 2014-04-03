/*
 * Copyright (c) <2014> <Tobias Weitz>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
#include <iostream>

#include "Point.hpp"
#include "KreisVererb.hpp"
#include "KreisAgg.hpp"
#include "Rechteck.hpp"

using namespace std;


void pascalsTriangle(int deph);

class safeP {
public:
    int* p;
};

int main()
{
	cout << "Hello World" <<endl;
    pascalsTriangle(11);

    Shape* formen[4];
    formen[0] = new KreisAgg(4, 5, 10);
    formen[1] = new Rechteck(1, 2, 20, 10);
    formen[2] = new KreisAgg(0, 1, 5);
    formen[3] = new Rechteck(10, 4, 4, 2);


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
