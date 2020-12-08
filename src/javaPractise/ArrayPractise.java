package javaPractise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;

public class ArrayPractise {
	
	//Create array and add some colors
	public static void main(String[] args)
	{
		List<String> alst=new ArrayList<String>();
	
		alst.add("Ishan");
		alst.add("Dev");
		alst.add("sri");
		int size;
		size=alst.size();
		for(String s:alst)
		{
			System.out.println("Elements : " + s);
		}
		String[] starr=new String[alst.size()];
		alst.toArray(starr);
		for(String arprint:starr)
		{
			System.out.println("List to Array : :" +arprint);
		}
		
		alst.add(0,"ZPinky");
		
		//Retrieve from the specific location
		System.out.println("from 2 nd position :" +alst.get(2));
		
		
		//From Specific index append a string
		String addstr=alst.get(2).concat("Dev");
		alst.set(3, "SriDev");
		System.out.println("Alist :" +alst);
		
		if(alst.contains("xyz"))
		{
			System.out.println("Given string is available in the List ");
		}				
		else
		{
			System.out.println("Given string is  NOT available in the List ");
		}
		
		List<String> nlst = new ArrayList<String>();
		nlst.addAll(alst);
		System.out.println("New List "+ nlst);
		
		
		Collections.sort(alst);
		
		System.out.println("Alist: " +alst);
		List<String> clst = new ArrayList<String>();
		List<String> cl = new ArrayList<String>();
		clst.add("1");
		clst.add("12");
		clst.add("123");
		clst.add("21");
		cl.addAll(alst);
		cl.addAll(clst );
		System.out.println("Combined array :" + cl);
		
		  Collections.copy(clst, alst);
		  System.out.println(" Collection Copy" + alst);
		  Assert asst = null ;
		  asst.assertEquals(clst, alst,"Both are not equal");
		  System.out.println("Both list are equal");
		  Collections.reverse(clst);
		  System.out.println(" Collection reverse" + clst);
		  Assert ass = null ;
		  ass.assertEquals(clst, alst,"Both Lists are not equal");
		  System.out.println("New List ::: "+ clst);	
	}
}
