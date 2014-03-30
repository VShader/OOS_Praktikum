package OOS_Praktikum_1_Java;

public class OOS_Praktikum_1_Java {

	public static void main(String[] args) {
		System.out.println("Hallo World");
		pascalsTriangle(11);
		
		Shape[] formen = new Shape[4];
		formen[0] = new KreisAgg(4, 5, 10);
		formen[1] = new Rechteck(1, 2, 20, 10);
		formen[2] = new KreisAgg(0, 1, 5);
		formen[3] = new Rechteck(10, 4, 4, 2);
		
		for(int i=0; i<formen.length; ++i)	{
			System.out.println(formen[i].flaechenInhalt());
		}

	}
	
	public static void pascalsTriangle(int deph)	{
		int[][] triangle = new int[deph][];
		for(int i=0; i<deph; ++i)	{
			// breite der Zeile ist = tiefe
			triangle[i] = new int[i+1];
			triangle[i][0] = 1;
			// jr zeigt auf das Element rechts von jl
			for(int jl=0, jr=1; jr<i; ++jl, ++jr)	{
				triangle[i][jr] = triangle[i-1][jl] + triangle[i-1][jr];
			}
			triangle[i][i] = 1;
		}
			
		for(int i=0; i<triangle.length; ++i)	{
			for(int j=0; j<triangle[i].length; ++j)	{
				System.out.print(triangle[i][j]);
				System.out.print(' ');
			}
			System.out.print('\n');
		}
	}
}
