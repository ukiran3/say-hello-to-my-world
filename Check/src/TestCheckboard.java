import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestCheckboard extends JFrame
{

	TestCheckboard()
	{    
		JButton[][] jbt= new JButton[8][8];
		for (int c=0; c<8; c++)
		{
			for (int d=0; d<8; d++)
			{
			jbt[c][d]= new JButton();
		}
		}
			setLayout(new GridLayout(8,8));
		 boolean check= true;
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{ 
				if (check==true)
				{
				  
				   jbt[i][j].setBackground(Color.WHITE);
					add(jbt[i][j]);
				    
				    check=false;
				}
				else	
				{
					
					add(jbt[i][j]);
					   jbt[i][j].setBackground(Color.BLACK);
				    check=true;
				}	
			}
			if (i%2==0)
				{check=false;}
			else {check=true;}
			
		}
		
		//ButtonlistenerClass listener= new ButtonlistenerClass();
		for (int a=0; a<8; a++)
		{
			for (int b=0; b<8; b++)
			{     
				ButtonlistenerClass listener= new ButtonlistenerClass(a,b);
				 jbt[a][b].addActionListener(listener);	   
             }
		}
	}
	
	public static void main(String[] args)
	{
		

		TestCheckboard frame = new TestCheckboard();
		 frame.setSize(400, 400); 
		 frame.setLocationRelativeTo(null);
		 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true); // Display the frame
	}
}

class ButtonlistenerClass implements ActionListener
{
	public ButtonlistenerClass()
	{
		
	}
	private int x;
	private int y; 
	public ButtonlistenerClass(int x, int y)
	{
		this.x=x;							//08672244346
		this.y=y;
	}

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("You Clicked the row "+(this.x+1) + " and column "+ (this.y+1));
	}
		
}
