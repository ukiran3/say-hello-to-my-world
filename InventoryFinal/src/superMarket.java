import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

import java.awt.*;
public class superMarket extends JFrame
{
	JButton jb = new JButton("Buy Now!");
	JButton ok = new JButton("New Customer?");
	JButton ok1 = new JButton("End of Day?");
	JButton ok2 = new JButton("Print Cash Register Ticket");
	JTextField code1 = new JTextField(5);
	JTextField quan1 = new JTextField(3);
	File file = new File("C:/Users/uday/workspace/InventoryFinal/src/opt.txt");
	public Inventory[] inv = new Inventory[100];
	public Transacctions[] trans = new Transacctions[100];
	public int size = 0, size1 = 0;
	double tax = 0,subTotal = 0;
	public superMarket() throws Exception
	{
		//for(int i = 0; i < inv.length; i++)
		{
			//inv[i] = new Inventory();
		}
		trans[size1] = new Transacctions(9991, 0);
		size1++;
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine())
		{
			int i = scan.nextInt();
			String str = scan.next();
			double j = scan.nextDouble();
			int k = scan.nextInt();
			int l = scan.nextInt();
			int m = scan.nextInt();
			inv[size] = new Inventory(i,str,j,k,l,m);
			size++;
		}
		//for(int f = 0; f < size; f++)
		{
			//System.out.println(inv[f].code+" "+inv[f].description+" "+inv[f].unitPrice+" "+inv[f].taxCode+" "+inv[f].quantity+" "+inv[f].reOrderLevel);
		}
		JPanel jp = new JPanel();
		jp.setLayout(new BorderLayout());
		jp.add(new printInventory(inv, size), BorderLayout.CENTER);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(4,3,5,5));
		jb.setBackground(Color.BLACK);
		jb.setForeground(Color.CYAN);
		
		ok.setBackground(Color.GREEN);
		ok.setForeground(Color.BLACK);
		
		ok1.setBackground(Color.GREEN);
		ok1.setForeground(Color.BLACK);
		
		ok2.setBackground(Color.BLACK);
		ok2.setForeground(Color.CYAN);
		
		jb.addActionListener(new ButtonListener());
		ok.addActionListener(new ButtonListener());
		ok1.addActionListener(new ButtonListener());
		ok2.addActionListener(new ButtonListener());
		JLabel jl = new JLabel("Enter Code: ");
		jl.setFont(new Font("sansSerif", 10, 30));
		jp1.add(jl);
		jp1.add(code1);
		JLabel jl1 = new JLabel("Enter Quantity: ");
		jl1.setFont(new Font("sansSerif", 10, 30));
		jp1.add(jl1);
		jp1.add(quan1);
		jp1.add(jb);
		jp1.add(ok);
		jp1.add(ok1);
		jp1.add(ok2);
		jp.add(jp1, BorderLayout.SOUTH);
		add(jp);
	}
	public class ButtonListener extends JPanel implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
			if(e.getSource() == jb)
			{
				int code = Integer.valueOf(code1.getText());
				int quant = Integer.valueOf(quan1.getText());
				if(searc(code, quant) || !searc(code, quant))
				{
					trans[size1] = new Transacctions(code, quant);
					size1++;
				}
				else
				{
					System.out.println("The code or quantity you entered is incorrect...");
				}
			}
			if(e.getSource() == ok)
			{
				trans[size1] = new Transacctions(9992, 0);
				size1++;
				trans[size1] = new Transacctions(9991, 0);
				size1++;
			}
			if(e.getSource() == ok1)
			{
				trans[size1] = new Transacctions(9992, 0);
				size1++;
				trans[size1] = new Transacctions(9993, 0);
				size1++;
				System.out.println("The transaction list is as follows:");
				for(int i = 0; i < size1; i++)
				{
					System.out.println(trans[i].getIcode()+" "+trans[i].getQuan());
				}
			}
			if(e.getSource() == ok2)
			{
				System.out.println("Cash Register Ticket...");
				System.out.println("_______________________");
				System.out.println("Description: Cost:");
				System.out.println("________________________________________");
				for(int i = 0; i < size1; i++)
				{
					if(trans[i].getIcode() != 9991 && trans[i].getIcode() != 9992 && trans[i].getIcode() != 9993)
					{
						for(int j = 0; j < size; j++)
						{
							if(inv[j].getCode() == trans[i].getIcode())
							{
								tax = tax + inv[j].getTaxCode() * trans[i].getQuan() * 0.1 * inv[j].getUnitPrice();
								subTotal = subTotal + (trans[i].getQuan() * inv[j].getUnitPrice());
								System.out.printf(inv[j].getDescription()+"   %.2f",(trans[i].getQuan() * inv[j].getUnitPrice()));
								System.out.println(" \n              Quantity:    Unit-Price:");
								System.out.println(" \n                 "+trans[i].getQuan()+"     "+inv[j].getUnitPrice());
							}
						}
					}
				}
				System.out.printf("\nSubTotal    ====        %.2f",subTotal);
				System.out.printf("\nTotal Tax   ====        %.2f",tax);
				System.out.printf("\nGrand Total ========    %.2f",(subTotal + tax));
			}
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		public boolean searc(int code, int quan) throws Exception
		{
			boolean torf = false;
			int count = 0;
			for(int i = 0; i < size; i++)
			{
				if(inv[i].getCode() == code)
				{
					count++;
				}
			}
			if(count > 0)
			{
				torf = true;
				for(int i = 0; i < size; i++)
				{
					if(inv[i].getCode() == code)
					{
						if(inv[i].getQuantity() >= quan)
						{
							inv[i].setQuantity(inv[i].getQuantity() - quan);
							PrintWriter pw = new PrintWriter(file);
							File file1 = new File("C:/Users/uday/workspace/InventoryFinal/src/opt1.txt");
							Scanner sc = new Scanner(file1);
							
							while(sc.hasNextLine())
							{
								String str = sc.nextLine();
								if(str.contains(String.valueOf(code)))
								{
									if(sc.hasNextLine())
										pw.println(inv[i].getCode()+" "+inv[i].getDescription()+" "+inv[i].getUnitPrice()+" "+inv[i].getTaxCode()+" "+inv[i].getQuantity()+" "+inv[i].getReOrderLevel());
									else
										pw.print(inv[i].getCode()+" "+inv[i].getDescription()+" "+inv[i].getUnitPrice()+" "+inv[i].getTaxCode()+" "+inv[i].getQuantity()+" "+inv[i].getReOrderLevel());
								}
								else
								{
									if(sc.hasNextLine())
										pw.println(str);
									else
										pw.print(str);
								}
							}
							pw.close();
							sc.close();
							Inventory temp = new Inventory();
							for(int f = 0; f < size; f++)
							{
								for(int k = f; k < size; k++)
								{
									if(inv[f].getCode() > inv[k].getCode())
									{
										
										temp = inv[f];
										inv[f] = inv[k];
										inv[k] = temp;
									}
								}
								
							}
							for(int f = 0; f < size; f++)
							{
								if(inv[f].getQuantity() < inv[f].getReOrderLevel())
								{
									inv[f].setFlag(true);
								}
							}
							for(int f = 0; f < size; f++)
							{
								if(inv[f].getFlag() != true)
									System.out.println(inv[f].getCode()+" "+inv[f].getDescription()+" "+inv[f].getUnitPrice()+" "+inv[f].getTaxCode()+" "+inv[f].getQuantity()+" "+inv[f].getReOrderLevel());
								else
									System.out.println(inv[f].getCode()+" "+inv[f].getDescription()+" "+inv[f].getUnitPrice()+" "+inv[f].getTaxCode()+" "+inv[f].getQuantity()+" "+inv[f].getReOrderLevel()+" :flagged");
							}
							torf = true;
						}
						else
						{
							torf = false;
						}
					}
				}
			}
			return torf;
		}
	}
	public static void main(String args[])
	{
		try
		{
			superMarket frame = new superMarket();
			frame.setSize(1080,700);
			frame.setTitle("Inventory System");
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		catch(Exception e)
		{
			System.out.println("the " +e.getLocalizedMessage());
		}
	}
}
class printInventory extends JPanel
{
	Inventory[] inv = new Inventory[100];
	int size = 0;
	public printInventory()
	{
		
	}
	public printInventory(Inventory[] inv, int size)
	{
		this.inv = inv;
		this.size = size;
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.BOLD, 25));
		g.drawString("CODE: DESCRIPTION:   UNIT_PRICE:  TAX_CODE:  QUANTITY:  RE-ORDER_LEVEL:", 10, 20);
		g.drawString("______________________________________________________________________________", 10, 20);
		g.drawString("______________________________________________________________________________", 10, 21);
		for(int f = 0; f < size; f++)
		{
			g.setFont(new Font("sansSerif", 16, 25));
			StringBuffer str = new StringBuffer(inv[f].getDescription());
			if(str.length() < 10)
			{
				for(int i = 0; i < 10 ; i++)
				{
					str.append("_");
				}
				String.valueOf(str).replaceAll("_", " ");
			}
			g.drawString(""+inv[f].getCode()+"  	"+String.valueOf(str).substring(0, 10)+"             "+inv[f].getUnitPrice()+"                   "+inv[f].getTaxCode()+"                    "+inv[f].getQuantity()+"                "+inv[f].getReOrderLevel(), 25, 25 * (f + 2));
			g.drawString("________________________________________________________________________", 25, 25 * (f + 2));
			
		}
	}
}