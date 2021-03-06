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

public abstract class Shape {
	protected Point centralPosition;
	
	public Shape()	{
		centralPosition = new Point();
	}
	public Shape(Point p)	{
		centralPosition = new Point(p);
	}
	public Shape(int x, int y)	{
		this();
		setLocation(x, y);
	}
	
	public void setLocation(int x, int y)	{
		centralPosition.setLocation(x, y);
	}
	public Point getLocation()	{
		return new Point(centralPosition);
	}
	public abstract double flaechenInhalt();
	
	boolean equals(Shape comp)	{
		return centralPosition.equals(comp.centralPosition); 
	}
	public abstract Shape clone();
	public String toString()	{
		return centralPosition.toString();
	}
}
