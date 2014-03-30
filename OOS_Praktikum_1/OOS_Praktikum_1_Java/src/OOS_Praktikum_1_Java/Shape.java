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
		if(comp.centralPosition.equals(centralPosition)) 
			return true;
		else return false;
	}
	public abstract Shape clone();
	public String toString()	{
		return centralPosition.toString();
	}
}
