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
