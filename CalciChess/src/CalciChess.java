import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalciChess extends JFrame
{
	public JButton add = new JButton("+");
	public JButton sub = new JButton("-");
	public JButton mul = new JButton("X");
	public JButton div = new JButton("/");
	public JButton n0 = new JButton("0");
	public JButton n1 = new JButton("1");
	public JButton n2 = new JButton("2");
	public JButton n3 = new JButton("3");
	public JButton n4 = new JButton("4");
	public JButton n5 = new JButton("5");
	public JButton n6 = new JButton("6");
	public JButton n7 = new JButton("7");
	public JButton n8 = new JButton("8");
	public JButton n9 = new JButton("9");
	public JButton equal = new JButton("=");
	public JButton point = new JButton(".");
	
	public JTextField text = new JTextField("");
	
	String str = new String("Hello");
	
	public CalciChess()
	{
		setLayout(new BorderLayout());
		JPanel jf = new JPanel();
		jf.setLayout(new GridLayout(4,4,5,5));
		jf.add(n1);
		jf.add(n2);
		jf.add(n3);
		jf.add(add);
		jf.add(n4);
		jf.add(n5);
		jf.add(n6);
		jf.add(sub);
		jf.add(n7);
		jf.add(n8);
		jf.add(n9);
		jf.add(mul);
		jf.add(point);
		jf.add(n0);
		jf.add(equal);
		jf.add(div);
		text.setEditable(true);
		add(text, BorderLayout.NORTH);
		add(jf, BorderLayout.CENTER);
		n0.addActionListener(new ButtonListener());
		n1.addActionListener(new ButtonListener());
		n2.addActionListener(new ButtonListener());
		n3.addActionListener(new ButtonListener());
		n4.addActionListener(new ButtonListener());
		n5.addActionListener(new ButtonListener());
		n6.addActionListener(new ButtonListener());
		n7.addActionListener(new ButtonListener());
		n8.addActionListener(new ButtonListener());
		n9.addActionListener(new ButtonListener());
		add.addActionListener(new ButtonListener());
		sub.addActionListener(new ButtonListener());
		mul.addActionListener(new ButtonListener());
		div.addActionListener(new ButtonListener());
		point.addActionListener(new ButtonListener());
		equal.addActionListener(new ButtonListener());
	}
	
	class ButtonListener implements ActionListener
	{
		ArrayList<String> al = new ArrayList<String>();
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == n0)
			{
				text.setText(text.getText().concat("0"));
			}
			if(e.getSource() == n1)
			{
				text.setText(text.getText().concat("1"));
			}
			if(e.getSource() == n2)
			{
				text.setText(text.getText().concat("2"));
			}
			if(e.getSource() == n3)
			{
				text.setText(text.getText().concat("3"));
			}
			if(e.getSource() == n4)
			{
				text.setText(text.getText().concat("4"));
			}
			if(e.getSource() == n5)
			{
				text.setText(text.getText().concat("5"));
			}
			if(e.getSource() == n6)
			{
				text.setText(text.getText().concat("6"));
			}
			if(e.getSource() == n7)
			{
				text.setText(text.getText().concat("7"));
			}
			if(e.getSource() == n8)
			{
				text.setText(text.getText().concat("8"));
			}
			if(e.getSource() == n9)
			{
				text.setText(text.getText().concat("9"));
			}
			if(e.getSource() == add)
			{
				text.setText(text.getText().concat(" + "));
			}
			if(e.getSource() == sub)
			{
				if(text.getText().isEmpty())
					text.setText(text.getText().concat("-"));
				else
					text.setText(text.getText().concat(" - "));
			}
			if(e.getSource() == mul)
			{
				text.setText(text.getText().concat(" X "));
			}
			if(e.getSource() == div)
			{
				text.setText(text.getText().concat(" / "));
			}
			if(e.getSource() == point)
			{
				text.setText(text.getText().concat("."));
			}
			if(e.getSource() == equal)
			{
				//System.out.println(text.getText());
				text.setText(calculate(text.getText()));
			}
		}
		public String calculate(String str1)
		{
			double total;
			al.clear();
			String[] strs = str1.split(" ");
			for(int i = 0; i < strs.length; i++)
			{
				if(!strs[i].isEmpty())
					al.add(strs[i]);
			}
			System.out.println(al);
			total = bodmass();
			return String.valueOf(total);
		}
		public double bodmass() throws NumberFormatException
		{
			if(al.contains("/"))
			{
				int i = al.indexOf("/");
				
					al.set(i - 1, String.valueOf(Double.valueOf(al.get(i - 1)) / Double.valueOf(al.get(i + 1))));
					al.remove(i);
					al.remove(i);
					bodmass();
				
					
			}
			if(al.contains("X"))
			{
				int i = al.indexOf("X");
				
					al.set(i - 1, String.valueOf(Double.valueOf(al.get(i - 1)) * Double.valueOf(al.get(i + 1))));
					al.remove(i);
					al.remove(i);
					bodmass();
				
			}
			if(al.contains("+"))
			{
				int i = al.indexOf("+");
					al.set(i - 1, String.valueOf(Double.valueOf(al.get(i - 1)) + Double.valueOf(al.get(i + 1))));
					al.remove(i);
					al.remove(i);
					bodmass();
			}
			
			if(al.contains("-"))
			{
				int i = al.indexOf("-");
				
					al.set(i - 1, String.valueOf(Double.valueOf(al.get(i - 1)) - Double.valueOf(al.get(i + 1))));
					al.remove(i);
					al.remove(i);
					bodmass();
			}
			return Double.valueOf(al.get(0));
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			CalciChess frame = new CalciChess();
			frame.setTitle("UseGridLayOut");
			frame.setSize(300, 200);
	    	frame.setLocationRelativeTo(null); // Center the frame
	    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setVisible(true);
		}
		catch(NumberFormatException e)
		{
			System.out.println("The error is: " +e);
		}
	}
}