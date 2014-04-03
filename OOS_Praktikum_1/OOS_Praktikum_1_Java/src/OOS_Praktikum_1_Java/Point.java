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
package OOS_Praktikum_1_Java;

public class Point	{
	private int x;
	private int y;
	
	public Point()	{}
	public Point(Point p)	{
		setLocation(p);
	}
	public Point(int x, int y)	{
		setLocation(x, y);
	}
	
	public Point getLocation()	{
		return new Point(this);
	}
	public void setLocation(Point p)	{
		setLocation(p.x, p.y);
	}
	public void setLocation(int x, int y)	{
		this.x=x;
		this.y=y;
	}
	public void move(int dx, int dy)	{
		x+=dx;
		y+=dy;
	}
	
	public boolean equals(Point p)	{
		return p.x == x && p.y == y;
	}
	public String toString()	{
		return "position: X="+x+", Y="+y;
	}
	
}