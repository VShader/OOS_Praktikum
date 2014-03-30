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


public class KreisAgg extends Shape{
	private int radius;
	
	public KreisAgg()	{}
	public KreisAgg(KreisAgg k)	{
		super(k.centralPosition);
		setRadius(k.radius);
	}
	public KreisAgg(int x, int y, int r)	{
		super(x, y);
		setRadius(r);
	}
	
	public void setRadius(int r)	{
		radius=r;
	}
	public double flaechenInhalt() {
		return Math.PI*radius*radius;
	}
	
	public boolean equals(KreisAgg comp)	{
		if(super.equals(comp) 
				&& comp.radius == radius)	return true;
		else return false;
	}
	public Shape clone()	{
		return new KreisAgg(this);
	}
	public String toString()	{
		return super.toString()+" radius: "+radius;
	};
}
