package javaPractise;

import java.util.HashSet;

public class HashSete {
	
	public static void main(String[] args)
	{
		HashSet<String>seth =new HashSet<String>();

		System.out.println("Set is  empty : " + seth.isEmpty());
		seth.add("ll");
		seth.add("sl");
		seth.add("gl");
		seth.add("hl");
		System.out.println("Set Details Empty :" + seth.isEmpty());
		
		for(String sl : seth )
		{
			System.out.println("  ::" + sl);
		}
		
		
		//Conver Hash into Array
		String[] harray = new String[seth.size()];
		seth.toArray(harray);
		for(int i=0;i<harray.length;i++)
		{
			System.out.println(harray[i]);
		}
				
		
	} 

}
