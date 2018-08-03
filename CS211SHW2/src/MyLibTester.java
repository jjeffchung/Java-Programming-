//John Chung King Sow
//CS211S Fall 2017 
//Instructor Abbas Moghtanei 
//Library of Useful Functions Homework No 2 
//This is the tester program.


public class MyLibTester {
	public static void main(String[] args) 
	{
	int sum = myLib.add(5,7,8,9);
	
	myLib.println("The result of the addition of is: " + sum);
	
	int subt = myLib.subtract(10,5);
	
	myLib.println("The result of the subtraction is:" + subt);
	
	int mult = myLib.multiply(5,6);
	
	myLib.println("The result of the multiplication is:" + mult);
	
	double div = myLib.division(6,2);
	
	myLib.println("The result of the division is:" + div);
	
	myLib.println("These are some useful functions to know of.");
	
	myLib.print("Thank You and Good Bye.");
	
	myLib.die();
	
	}
}
