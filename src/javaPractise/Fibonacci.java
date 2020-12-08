package javaPractise;

public class Fibonacci {
	
	public static void main(String[] arg)
	{
		int fb[]=new int[6];
		fb[0]=0;
		fb[1]=1;
		
		
		for(int i=2;i<fb.length;i++)
		{
			fb[i]=fb[i-1]+fb[i-2];
		}
		
		for(int i=0;i<fb.length;i++)
		{
			System.out.println(" " + fb[i]);
		}
		
	}

}
