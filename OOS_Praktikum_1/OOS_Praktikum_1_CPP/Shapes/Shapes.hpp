#include <string>
#define _USE_MATH_DEFINES
#include <math.h>

#ifndef SHAPES_HPP
#define SHAPES_HPP

class Point	{
private:
    int x;
    int y;

public:
    Point()	{}
    Point(int x, int y) : x(x), y(y) {}

    Point* getLocation()	{
        return new Point(*this);
    }
    void setLocation(Point &p)	{
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

    virtual bool equals(Point &p)	{
        if(p.x == x && p.y == y)	return true;
        else return false;
    }
    virtual std::string toString()	{
        return "position: X="
                +std::to_string(x)
                +", Y="+std::to_string(y);
    }

};

class Shape {
protected:
    Point centralPosition;

public:
    Shape()	{
    }
    Shape(Point &p) : centralPosition(p)	{
//        centralPosition = new Point(p);
    }
    Shape(int x, int y) : centralPosition(x, y)	{
//        this();
//        setLocation(x, y);
    }

    void setLocation(int x, int y)	{
        centralPosition.setLocation(x, y);
    }
    Point* getLocation()	{
            return new Point(centralPosition);
    }
    virtual double flaechenInhalt() = 0;

    virtual bool equals(Shape &comp)	{
        if(comp.centralPosition.equals(centralPosition))
            return true;
        else return false;
    }
    virtual Shape* clone() = 0;
    virtual std::string toString()	{
        return centralPosition.toString();
    }
};



class KreisVererb : public Point{
private:
    int radius;

public:
    KreisVererb() {}
    KreisVererb(int x, int y, int r) : Point(x, y), radius(r)	{}

    void setRadius(int r)	{
        radius = r;
    }
    double flaechenInhalt()	{
        return M_PI*radius*radius;
    }
};

class KreisAgg : public Shape{
private:
    int radius;

public:
    KreisAgg()	{}
    KreisAgg(int x, int y, int r) : Shape(x, y), radius(r)	{}

    void setRadius(int r)	{
        radius=r;
    }
    double flaechenInhalt() {
        return M_PI*radius*radius;
    }

    bool equals(KreisAgg comp)	{
        if(Shape::equals(comp)
                && comp.radius == radius)	return true;
        else return false;
    }
    Shape* clone()	{
        return new KreisAgg(*this);
    }
    std::string toString()	{
        return Shape::toString()+" radius: "+std::to_string(radius);
    }
};

class Rechteck : public Shape{
private:
    int length;
    int width;

public:
    Rechteck() {}
    Rechteck(int x, int y, int lenght, int width) : Shape(x, y),
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

    bool equals(Rechteck comp)	{
        if(Shape::equals(comp)
                && comp.length == length
                && comp.width == width)
            return true;
        else return false;
    }
    Shape* clone()	{
        return new Rechteck(*this);
    }
    std::string toString() {
        return Shape::toString()+" length: "+std::to_string(length)
                +" width: "+std::to_string(width);
    }

};

#endif //SHAPES_HPP
