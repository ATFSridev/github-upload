package javaPractise;

public class ReverseString {
	
	public static void main(String[] arg)
	{
		String str="Srigowri";
		System.out.println("String Length ::"+str.length());
		
		System.out.println("Given String :" + str );
		System.out.println("Reverse String :" + reversestring(str));
	}

	public static String reversestring(String str)
	{
		String rev="";
		for(int i=(str.length()-1);i>=0;i--)
		{
			char rr=str.charAt(i);
			rev=rev+rr;
			
		}
		return rev;
		
	}
}
