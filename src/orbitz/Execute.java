package orbitz;

import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

//import prac.java;
public class Execute {
	public static void main(String[] args)
	{
		int[] arry = {'1','5','3','7','2'};
		
		//Arrays.sort(arry);
		//System.out.println("Ayyars" + Arrays.toString(arry));
		
		DateFormat dtformat = new SimpleDateFormat("yyyy/M/d");
		Date dt = new Date();
		String cdate = (dtformat).format(dt);
		String[] arr=cdate.split("/");
		
		
		System.out.println("current year" + arr[0]);
		System.out.println("current Month" + arr[1]);
		System.out.println("current Day" + arr[2]);
		
		//prac obj=new prac();
		//int x= prac.sum(5,6);
		//System.out.println("x:"+ x);
		
		//int y=prac.sum(5,6,7);
		//System.out.println("y:"+ y);
		
	/*Scanner in = new Scanner(System.in);
	int ia = in.nextInt();
	
	Scanner intt = new Scanner(System.in);
	int ya = in.nextInt();
	
	int c= ia+ya;
	System.out.println("c:"+c);*/
		
		/*Scanner inp=new Scanner(System.in);
		int a=inp.nextInt();
		
		for(int i=1;i<=10;i++)
		{
			System.out.println(a+"*"+i+":"+a*i);
		}*/
		
		

	}

}
