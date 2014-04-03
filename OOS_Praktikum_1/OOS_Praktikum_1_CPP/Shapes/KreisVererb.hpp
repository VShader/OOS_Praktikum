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
#ifndef KREISVERERB_HPP
#define KREISVERERB_HPP

#include "Point.hpp"

class KreisVererb : public Point{
private:
    int radius;

public:
    KreisVererb() {}
    KreisVererb(int x, int y, int r) : Point(x, y), radius(r)	{}
    KreisVererb(const Point &p, int r) : Point(p), radius(r)	{}


    void setRadius(int r)	{
        radius = r;
    }

    double flaechenInhalt()	{
        return M_PI*radius*radius;
    }
};

#endif // KREISVERERB_HPP