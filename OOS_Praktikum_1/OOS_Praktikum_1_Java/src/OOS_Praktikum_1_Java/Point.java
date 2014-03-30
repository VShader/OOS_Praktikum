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
		if(p.x == x && p.y == y)	return true;
		else return false;
	}
	public String toString()	{
		return "position: X="+x+", Y="+y;
	}
	
}