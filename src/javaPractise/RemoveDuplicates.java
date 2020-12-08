package javaPractise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
	
	public static void main(String[] arg)
	{
		System.out.println(" Enter the string");
		Scanner  sc = new Scanner(System.in);
		String str=sc.nextLine();
		System.out.println(removeDups(str));
		
		
	}
	
	public static String removeDups(String str)
	{
		Set<Character> set = new HashSet();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<str.length();i++)
		{
			Character c = str.charAt(i);
			if(!set.contains(c))
			{
				set.add(c);
				sb=sb.append(c);
			}
		}
		
		return sb.toString();
		
	}

}
