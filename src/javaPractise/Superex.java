package javaPractise;


class Colore
{
	String color="white";
	Colore()
	{
		System.out.println("Constructor ");
	}
}

class Animal extends Colore
{
	String color="black";
	
	 Animal()
	{
		super();
		System.out.println("Child class constructor");
		System.out.println("Child class color :" + color);
		System.out.println("Super class color :" + super.color);
	}
	void  display()
	{
		System.out.println("Child class method");
	}
}
public class Superex {
	
	public static void main(String[] arg)
	{
		System.out.println("Hi");
		Animal obj=new Animal();
		obj.display();
		
		
	}

}
