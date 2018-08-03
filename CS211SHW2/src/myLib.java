//Created by John Chung King Sow
//CS211S Fall 2017 
//Instructor Abbas Moghtanei 
//Library of Useful Functions Homework No 2 
//The objective is to create a library of useful methods and a tester program. The file name is to be called MyLib.java  

public class myLib 
{

	//**********************************print() method 

	  public static void print(String lines)

	  {

	     System.out.print(lines);

	  }

	//**********************************println() method 

	  public static void println(Object ... o)

	  {

	     if(o.length == 0)

	     {

	        System.out.print("");

	     }

	     else if(o.length == 1)

	     {

	        System.out.print("" + o[0]);

	     }

	     else for(Object obj : o)

	     {

	        System.out.print("" + obj + "\t");

	     }

	     System.out.println("");

	  }

	//**********************************die() method 

	  public static void die(String ... errorMessage)

	  {

	     if(errorMessage.length > 0) 

	     {

	        System.err.println("There are not enough args" + errorMessage[0]); 

	     }

	     System.exit(1);

	  }

	//**********************************add() method 

	public static int add(int ... args)

	{

	int sum=0;

	if(args.length<2) 

	   {

	  println("To perform the operation, you need at least two numbers for addition");

	  die();

	}else

	{

	   for(int i=0;i<args.length;i++)

	   {

	sum = sum + args[i];

	   }

	}

	return(sum);

	}

	//**********************************subtract() method 

	public static int subtract(int ...args)

	{

	int subtract=0;

	if(args.length<2) 

	{

	println("To perform the operation, you need at least two numbers for subtraction");

	die();

	}else

	{

		subtract= (args[0] - args[1]);

	}

	   return(subtract);

	}

	//**********************************division() method 

	public static double division(double ... args)

	{

	double division = 1.0;

	if(args.length<2) 

	   {

	println("To perform the operation, you need at least two numbers for division");

	die();

	}else

	{
	   

	   for(int i=0;i<args.length;i++)

	   {

		   division = args[0]/args[1];

	   }

	}

	return(division);

	}

	//**********************************multiply() method 

	public static int multiply(int ... args)

	{

	int multiply = 1;

	if(args.length<2) 

	   {

	println("To perform the operation, you need at least two numbers for multiplication");

	die();

	}else

	{

	   for(int i=0; i<args.length;i++)

	   {

	multiply= multiply * args[i];

	   }

	}

	return multiply;

	}

	}



	

