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
#ifndef POINT_HPP
#define POINT_HPP

class Point	{
private:
    int x;
    int y;

public:
    Point()	{}
    Point(int x, int y) : x(x), y(y) {}


    // !!! WARNING !!! not a good idea!
    // Use copy constructor or assignment operator!
    Point* getLocation()	{
        return new Point(*this);
    }

    void setLocation(const Point &p)	{
        setLocation(p.x, p.y);
    }
    void setLocation(int x, int y)	{
        this->x=x;
        this->y=y;
    }

    void move(int dx, int dy)	{
        x+=dx;
        y+=dy;
    }


    virtual bool equals(const Point &p) const	{
        return p.x == x && p.y == y;
    }

    virtual std::string toString()	{
        return "position: X="
                +std::to_string(x)
                +", Y="+std::to_string(y);
    }

};

#endif // POINT_HPP
