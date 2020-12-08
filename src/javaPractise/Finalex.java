package javaPractise;


public class Finalex {

	final int x=20;
	void print()
	{
		// x=15;
		System.out.println("X value is :" + x);
	}
	
	public static void main(String[] arg)
	{
		Finalex ob=new Finalex();
		ob.print();
	}
	
}
