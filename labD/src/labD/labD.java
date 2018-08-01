
//This labD was made by the team of John Chung King Sow and Tatsuya Hayashi. The assignment is to use recursion to
//draw squares with one square on each corner of each square and we used a Java applet. 

package labD;
import javax.swing.*;
import java.awt.*;


public class labD extends JApplet {


	//Declaring the instance data variables  
	int width = 250; //initial width of the largest square
	int height = 250; //initial height of the largest square
	final int MINIMUM_SIDE_LENGTH = 30;	//Minimum length of square's size 
	double scaledDownValue = 0.5;	//The factor to shrink the size of each round of squares 	

	public void init() //Initialization 

	{   
		setBackground(Color.gray);  
		setSize(600,600);  //Setting the size of the window 	

	}

	public void paint(Graphics pen) 
	{	
		int x_Largecoor = 200;	
		int y_Largecoor  = 200;
		paintWithRecursion(pen, x_Largecoor , y_Largecoor , width, height);  //We first draw the large square 

	}//end paint method 


	private void paintWithRecursion(Graphics pen, int x_coor, int y_coor, int width, int height) 
	{

		setForeground(Color.gray);

		pen.setColor(Color.red); //Squares will be filled with the color: red    

		pen.fillRect(x_coor, y_coor, width, height); // draw solid squares

		pen.setColor(Color.yellow);  //draws the outline of square with the color yellow to create a color pop 

		pen.drawRect(x_coor, y_coor, width, height); 

		//start drawing smaller squares by sending coordinates of smaller squares to 4 recursion calls. 
		if (width> MINIMUM_SIDE_LENGTH)  
		{	

			width = (int)(width * scaledDownValue);

			height = (int)(height * scaledDownValue);

			paintWithRecursion(pen, x_coor + 2*width - (width/2), y_coor-(height/2), width, height); //4 small squares 

			paintWithRecursion(pen, x_coor -(width/2), y_coor-(height/2), width, height);  

			paintWithRecursion(pen, x_coor + 2*width - (width/2), y_coor + 2*height - (height/2), width, height);   

			paintWithRecursion(pen, x_coor -(width/2), y_coor + 2*height - (height/2), width, height);   

		}

	}

}