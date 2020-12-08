package javaPractise;

public class Palindrome {
	
	public static void main(String[] arg)
	{
		
		String str="CLASS";
		String reverse=palindrome(str);
		
		System.out.println("Given string is ::"+str);
		System.out.println("Reverse string is ::"+reverse);
		if(str.equals(reverse))
		{
				System.out.println("Given string is palindrome");
		}
		else
		{
			System.out.println("Given string is  NOT  a palindrome");

		}
		
	}
	
	public static String palindrome(String str)
	{
		String reverse="";
		for(int i=str.length()-1;i>=0;i--)
		{
			char c=str.charAt(i);
			reverse=reverse+c;
		}
		
		return reverse;
		
	}

}
