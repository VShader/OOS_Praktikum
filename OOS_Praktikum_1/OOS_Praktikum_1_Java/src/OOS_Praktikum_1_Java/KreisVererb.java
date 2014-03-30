package OOS_Praktikum_1_Java;

public class KreisVererb extends Point{
	private int radius;
	
	public KreisVererb() {}
	public KreisVererb(int x, int y, int r)	{
		super(x, y);
		setRadius(r);
	}
	public void setRadius(int r)	{
		radius = r;
	}
	public double flaechenInhalt()	{
		return Math.PI*radius*radius;
	}
}