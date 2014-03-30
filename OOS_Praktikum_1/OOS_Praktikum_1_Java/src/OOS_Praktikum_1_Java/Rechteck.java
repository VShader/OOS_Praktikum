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
