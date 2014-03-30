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


public class Rechteck extends Shape{
	private int length;
	private int width;
	
	public Rechteck() {}
	public Rechteck(Rechteck r)	{
		super(r.centralPosition);
		setLenght(r.length);
		setWidth(r.width);
	}
	public Rechteck(int x, int y, int lenght, int width)	{
		super(x, y);
		this.length=lenght;
		this.width=width;
	}
	
	public void setLenght(int l)	{
		length=l;
	}
	public void setWidth(int w)	{
		width=w;
	}
	public double flaechenInhalt()	{
		return length*width;
	}
	
	public boolean equals(Rechteck comp)	{
		if(super.equals(comp)
				&& comp.length == length
				&& comp.width == width)
			return true;
		else return false;
	}
	public Shape clone()	{
		return new Rechteck(this);
	}
	public String toString() {
		return super.toString()+" length: "+length+" width: "+width;
	}
	
}
