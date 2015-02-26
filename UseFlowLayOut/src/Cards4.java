import javax.swing.*;

import java.awt.*;
import java.util.*;

public class Cards4 extends JFrame{

	public Cards4(){
		
		JPanel p1 = new JPanel(new GridLayout(1,4,5,5));
		
		Random rn = new Random();
		int rn1 = rn.nextInt(54);
		int rn2 = rn.nextInt(54);
		int rn3 = rn.nextInt(54);
		int rn4 = rn.nextInt(54);
		ImageIcon im1 = new ImageIcon("C:/Users/uday/Desktop/book/image/card" + "/" +rn1+ ".png");
		ImageIcon im2 = new ImageIcon("C:/Users/uday/Desktop/book/image/card" + "/" +rn2+ ".png");
		ImageIcon im3 = new ImageIcon("C:/Users/uday/Desktop/book/image/card" + "/" +rn3+ ".png");
		ImageIcon im4 = new ImageIcon("C:/Users/uday/Desktop/book/image/card" + "/" +rn4+ ".png");
		ImageIcon im5 = new ImageIcon("C:/Users/uday/Desktop/book/image/card/b1fv.png");
		
	setLayout(new GridLayout(1,4,5,5));
	
	JButton lbl = new JButton(im5);
	lbl.setPressedIcon(im1);
	JButton lbl1 = new JButton(im5);
	lbl1.setPressedIcon(im2);
	JButton lbl2 = new JButton(im5);
	lbl2.setPressedIcon(im3);
	JButton lbl3 = new JButton(im5);
	lbl3.setPressedIcon(im4);
	
	add(lbl);
	add(lbl1);
	add(lbl2);
	add(lbl3);
		
	}
	
public static void main(String args[]){
		
		Cards4 frame = new Cards4();
		
		frame.setTitle("Random Four Cards");
		frame.setSize(300, 170);
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
