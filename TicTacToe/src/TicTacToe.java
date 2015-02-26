import javax.swing.*;

import java.awt.GridLayout;
import java.util.Random;

public class TicTacToe extends JFrame {
	
	public TicTacToe(){
		
		//setLayout(new GridLayout(3,3));
		
		JPanel p1 = new JPanel(new GridLayout(3,3));
		
		ImageIcon image1 = new ImageIcon("C:/Users/uday/Desktop/book/image/o.gif");
		ImageIcon image2 = new ImageIcon("C:/Users/uday/Desktop/book/image/x.gif");
		
		for(int i = 0; i < 9; i++)
		{
			
			int number = (int)(Math.random() * 3);

			if(number == 1)
			{
				
				p1.add(new JLabel(image2));
			}
			
			else if(number == 2)
			{
				
				p1.add(new JLabel(image1));

			}
			
			else
			{
				p1.add(new JLabel(""));
			}
		}
		
		add(p1);

	}

public static void main(String args[]){
	
	TicTacToe frame = new TicTacToe();
	
	frame.setTitle("Tic Tac Toe...");
	frame.setSize(300, 170);
	frame.setLocationRelativeTo(null); 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
}

}