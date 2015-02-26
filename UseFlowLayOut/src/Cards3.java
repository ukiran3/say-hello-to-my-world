
import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Cards3 extends JFrame
{
	public Cards3()
	{
		
			Random rn = new Random();
			int rn1 = rn.nextInt(54);
			int rn2 = rn.nextInt(54);
			int rn3 = rn.nextInt(54);
			int rn4 = rn.nextInt(54);
			ImageIcon im1 = new ImageIcon("C:/Users/uday/Desktop/book/image/card" + "/" +rn1+ ".png");
			ImageIcon im2 = new ImageIcon("C:/Users/uday/Desktop/book/image/card" + "/" +rn2+ ".png");
			ImageIcon im3 = new ImageIcon("C:/Users/uday/Desktop/book/image/card" + "/" +rn3+ ".png");
			ImageIcon im4 = new ImageIcon("C:/Users/uday/Desktop/book/image/card" + "/" +rn4+ ".png");
			
		setLayout(new GridLayout(1,4,5,5));
		
		JButton lbl = new JButton(im1);
		JButton lbl1 = new JButton(im2);
		JButton lbl2 = new JButton(im3);
		JButton lbl3 = new JButton(im4);
		
		add(lbl);
		add(lbl1);
		add(lbl2);
		add(lbl3);
		
		
	}
 public static void main(String[] args)
 {
	 	Cards3 frame = new Cards3();
		    frame.setTitle("UseGridLayOut");
	    frame.setSize(300, 200);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
  }
}
