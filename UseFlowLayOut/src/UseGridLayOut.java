//import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
public class UseGridLayOut extends JFrame
{
	public UseGridLayOut()
	{
	    setLayout(new GridLayout(4,1,5,5));
	    add(new JButton("Department of Computer Science"));
	    add(new JButton("School of Computing"));
	    add(new JButton("Armstrong Atalntic State University "));
	    add(new JButton("Tel: (912)921-6440"));
	}
	
	public static void main(String[] args)
	{
		 	UseGridLayOut frame = new UseGridLayOut();
   		    frame.setTitle("UseGridLayOut");
		    frame.setSize(300, 200);
		    frame.setLocationRelativeTo(null); // Center the frame
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
	}
}
