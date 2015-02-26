import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;
public class UseFlowLayOut extends JFrame
{
	public UseFlowLayOut()
	{
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
	    JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
	    JButton jbt1 = new JButton("Button1");
		JButton jbt2 = new JButton("Button2");
		JButton jbt3 = new JButton("Button3");
		JButton jbt4 = new JButton("Button4");
		JButton jbt5 = new JButton("Button5");
		JButton jbt6 = new JButton("Button6");
	    panel.add(jbt1);
	    panel.add(jbt2);
	    panel.add(jbt3);
	    panel2.add(jbt4);
	    panel2.add(jbt5);
	    panel2.add(jbt6);
	    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
	    add(panel);
	    add(panel2);
	}
	 public static void main(String[] args)
	 {
		 	UseFlowLayOut frame = new UseFlowLayOut();
   		    frame.setTitle("UseFlowLayOut");
		    frame.setSize(300, 200);
		    frame.setLocationRelativeTo(null); // Center the frame
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
	  }
}
