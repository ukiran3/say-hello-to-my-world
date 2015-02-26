import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class futureValue extends JFrame
{
	JTextField invAmount = new JTextField(4);
	JTextField years = new JTextField(4);
	JTextField annInvRate = new JTextField(4);
	JTextField fValue = new JTextField(4);
	JButton cal = new JButton("Calculate");
	public futureValue()
	{
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4,2,5,5));
		jp.add(new JLabel("Investment Amount"));
		jp.add(invAmount);
		jp.add(new JLabel("Years"));
		jp.add(years);
		jp.add(new JLabel("Annual Investment Rate"));
		jp.add(annInvRate);
		jp.add(new JLabel("Future Value"));
		jp.add(fValue);
		fValue.setEditable(false);
		add(jp,BorderLayout.CENTER);
		add(cal,BorderLayout.SOUTH);
		invAmount.addActionListener(new ButtonListener());
		years.addActionListener(new ButtonListener());
		annInvRate.addActionListener(new ButtonListener());
		fValue.addActionListener(new ButtonListener());
		cal.addActionListener(new ButtonListener());
	}
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == cal)
			{
				fValue.setText(""+Double.parseDouble(invAmount.getText()) * Math.pow(1 + Double.parseDouble(annInvRate.getText()), Double.parseDouble(years.getText()) * 12));
				System.out.println(Double.parseDouble(invAmount.getText()));
				System.out.println(Math.pow(1 + Double.parseDouble(annInvRate.getText()), Double.parseDouble(years.getText()) * 12));
			}
		}
	}
	public static void main(String[] args)
	{
		futureValue frame = new futureValue();
		frame.setSize(400, 300);
		frame.setTitle("Calculate future Value");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
