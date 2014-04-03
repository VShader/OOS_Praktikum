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
#ifndef RECHTECK_HPP
#define RECHTECK_HPP

#include "Shape.hpp"

class Rechteck : public Shape{
private:
    int length;
    int width;

public:
    Rechteck() {}
    Rechteck(int x, int y, int lenght, int width) : Shape(x, y),
        length(lenght), width(width) {}
    Rechteck(const Point &p, int lenght, int width) : Shape(p),
        length(lenght), width(width) {}


    void setLenght(int l)	{
        length=l;
    }
    void setWidth(int w)	{
        width=w;
    }

    double flaechenInhalt()	{
        return length*width;
    }


    bool equals(const Rechteck &comp)	{
        return Shape::equals(comp)
                && comp.length == length
                && comp.width == width;
    }

    // !!! WARNING !!! not a good idea!
    // Use copy constructor or assignment operator!
    Shape* clone()	{
        return new Rechteck(*this);
    }

    std::string toString() {
        return Shape::toString()+" length: "+std::to_string(length)
                +" width: "+std::to_string(width);
    }

};

#endif // RECHTECK_HPP
