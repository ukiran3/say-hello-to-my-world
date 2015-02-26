import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class shopInventory extends JFrame {

	Inventory[] invent= new Inventory[100];
	Inventory[] invent1= new Inventory[1];
	TransactionFile[] transaction= new TransactionFile[100];
	File transactionFile= new File("C:/Users/uday/workspace/InventoryFinal/src/opt1.txt");
	PrintWriter output= new PrintWriter(transactionFile);

	private	JTextField txtCode= new JTextField();
	private  JTextField txtQuan= new JTextField();
	private  JButton jbtAdd = new JButton("Add Item");
	private JButton jbtCheck = new JButton("Print-Check");
	private JButton jbtUpdate = new JButton("View File");
	private JButton jbtEnd= new JButton("End Day");
	private JButton jbtNewCustomer= new JButton("New Customer");
	


    private JTextArea jtaRec = new JTextArea("                                              Customer's Receipt\n", 30,20);
    private JTextArea jtaUpdate= new JTextArea(" ",30,40);
    private JTextArea jtaTransaction = new JTextArea(" ",30,40); 
    private double sum=0;
    private double taxTotal=0;
    private int i=0;
   
	public shopInventory() throws FileNotFoundException
	{
		//Inventory[] invent= new Inventory[10];
		for (int z=0; z<invent.length; z++)
		{
			invent[z]= new Inventory();
		}
		for (int z=0; z<transaction.length; z++)
		{
			transaction[z]= new TransactionFile();
		}
		
		
		File inventoryFile = new File("C:/Users/uday/workspace/InventoryFinal/src/opt.txt");
	//	File transactionFile = new File(args[1]);
		if (!inventoryFile.exists())
		{
			JOptionPane.showMessageDialog(null, "Inventory File Does Not Exist");
			//System.exit(0);
		}
	
	    Scanner scanner = new Scanner(inventoryFile);
		int i=0;
		while (scanner.hasNext())
		{
			//  if (Integer.parseInt(scanner.next())==0)
			 // {
				//  break;
			  //}
			
		      invent[i].setItemCode(Integer.parseInt(scanner.next()));
			  invent[i].setItemName(scanner.next());
			  invent[i].setUnitPriceItem(Double.parseDouble(scanner.next()));
			  invent[i].setTaxCode(Integer.parseInt(scanner.next()));
			  invent[i].setQuantityLeft(Integer.parseInt(scanner.next()));
			  invent[i].setReorderLevel(Integer.parseInt(scanner.next()));
			  i=i+1;  
			
		
		
		
		
		}
		scanner.close();
		
		JPanel inventoryPanel = new JPanel();
	     JTextArea jtaDesc = new JTextArea(" ",20,40);
	     jtaDesc.setLineWrap(true);
	     jtaDesc.setWrapStyleWord(true);
	     jtaDesc.setEditable(false);
	    
	    jtaDesc.append("Item-Code"+ "     "+  "Item Name"+ "             "+ "Unit Price\n" );
	    jtaDesc.append("=======================================================================================\n");
	    for (int j=0; j<invent.length; j++)
	    {
	    	
	   jtaDesc.append(String.valueOf(invent[j].getItemCode())+ "             " + invent[j].getItemName()+ "                "+ String.valueOf(invent[j].getUnitPriceItem())+ "\n");
	   
	    	
	    }
	    
	    
	     JScrollPane pane= new JScrollPane(jtaDesc);
	     Border lineBorder= new LineBorder(Color.BLACK,2);
	     inventoryPanel.setBorder(lineBorder);
	     inventoryPanel.setLayout(new BorderLayout());
	     JLabel inventoryLabel= new JLabel("                                                      LIST OF INVENTORY ITEMS");
	     inventoryLabel.setForeground(Color.RED);
	    //updateLabel.setBackground(Color.BLUE);
	     inventoryPanel.add(inventoryLabel, BorderLayout.NORTH);
	     inventoryPanel.add(pane, BorderLayout.CENTER);
	     //inventoryPanel.add(pane);
	     
	 //    setLayout(new BorderLayout());
	 //    add(inventoryPanel, BorderLayout.EAST);
	     
	     JPanel receiptPanel = new JPanel();
	     jtaRec.setLineWrap(true);
	     jtaRec.setWrapStyleWord(true);
	     jtaRec.setEditable(false);
	     jtaRec.append("=======================================================================\n");
	     
	    
	     jtaRec.append("Code"+"     "+"Name"+"                        "+"Quantity"+"                 "+ "Cost\n");
	          
	    JScrollPane pane2= new JScrollPane(jtaRec);
	    JPanel bPanel = new JPanel();
	    bPanel.setLayout(new GridLayout(5,1));
	    bPanel.add(jbtAdd);
	    bPanel.add(jbtCheck);
	    bPanel.add(jbtUpdate);
	    bPanel.add(jbtEnd);
	    bPanel.add(jbtNewCustomer);
	    JPanel tPanel= new JPanel();
	    tPanel.setLayout(new GridLayout(2,2));
	    
	    tPanel.add(new JLabel("Enter Item Code"));
	    tPanel.add(txtCode);
	    tPanel.add(new JLabel("Enter Quantity"));
	    tPanel.add(txtQuan);
	    JLabel receiptLabel= new JLabel("                                           WELCOME TO EASY SHOP!!!!");
	    receiptLabel.setForeground(Color.RED);
	    
	    receiptPanel.setLayout(new BorderLayout());
	    receiptPanel.add(receiptLabel, BorderLayout.NORTH);
	     receiptPanel.add(pane2,BorderLayout.CENTER);
	     
	     receiptPanel.add(tPanel,BorderLayout.SOUTH);
	     receiptPanel.add(bPanel,BorderLayout.EAST);
	    // receiptPanel.add(receiptLabel, BorderLayout.NORTH);
	     receiptPanel.setBorder(lineBorder);
	     
	  //   add(receiptPanel,BorderLayout.WEST);
	
	     jtaUpdate.setLineWrap(true);
	     jtaUpdate.setWrapStyleWord(true);
	     jtaUpdate.setEditable(false);
	     JScrollPane pane3= new JScrollPane(jtaUpdate);
	     JPanel updatePanel = new JPanel();
	     updatePanel.setLayout(new BorderLayout());
	     JLabel updateLabel= new JLabel("                                                   UPDATED INVENTORY FILE");
	     updateLabel.setForeground(Color.RED);
	    //updateLabel.setBackground(Color.BLUE);
	     updatePanel.add(updateLabel, BorderLayout.NORTH);
	     updatePanel.add(pane3, BorderLayout.CENTER);
	     updatePanel.setBorder(lineBorder);
	   //  add(updatePanel, BorderLayout.CENTER);
	     jtaTransaction.setLineWrap(true);
	     jtaTransaction.setWrapStyleWord(true);
	     jtaTransaction.setEditable(false);
	     JScrollPane pane4= new JScrollPane(jtaTransaction);
	     JPanel transPanel = new JPanel();
	     transPanel.setLayout(new BorderLayout());
	     JLabel transLabel= new JLabel("                                                   UPDATED TRANSACTION FILE");
	     transLabel.setForeground(Color.RED);
	    //updateLabel.setBackground(Color.BLUE);
	     transPanel.add(transLabel, BorderLayout.NORTH);
	     transPanel.add(pane4, BorderLayout.CENTER);
	     transPanel.setBorder(lineBorder);
	     
	setLayout(new GridLayout(2,2));
	add(receiptPanel);
	add(inventoryPanel);
	 add(updatePanel);
	 add(transPanel);
	     
		
	     jbtAdd.addActionListener(new ButtonListener());
	     jbtCheck.addActionListener(new ButtonListener());
	     jbtUpdate.addActionListener(new ButtonListener());
	     jbtEnd.addActionListener(new ButtonListener());
	     jbtNewCustomer.addActionListener(new ButtonListener());
		
		
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			//double sum=0;
//			transaction[i].setCode(9991);
//		    transaction[i].setQuantity(0);
            int tax=0; 
            String tax1="";
			double price=0;
			String price1="";
			String sum1="";
			String itemName = null;
 		      DecimalFormat df = new DecimalFormat("#0.00");
			if (e.getSource() == jbtAdd)
			{
				int item= Integer.parseInt(txtCode.getText());
			    int quantity= Integer.parseInt(txtQuan.getText());
			
			    if(transaction[i].getCode()==0)
				{
					
				transaction[i].setCode(9991);
				transaction[i].setQuantity(0);
				}
			    if(transaction[i].getCode()==9992)
				{
				i=i+1;	
				transaction[i].setCode(9991);
				transaction[i].setQuantity(0);
				}
				i++;
				
				transaction[i].setCode(item);
				transaction[i].setQuantity(quantity);
				
			    
			    for (int k=0; k<invent.length; k++)
		          {
		        	  
		        	    if (item==invent[k].getItemCode())
		       	        {
		       		       
		       		      itemName= invent[k].getItemName();
		       		      tax=invent[k].getTaxCode();
		       		      if (tax==1)
		       		      {
		       		    	  
		       		    	  taxTotal= taxTotal+ (.1*invent[k].getUnitPriceItem());
		       		      }
		       		   sum= sum + invent[k].getUnitPriceItem()*quantity+taxTotal;
		       		      invent[k].setQuantityLeft(invent[k].getQuantityLeft()-quantity);
		       		      price= invent[k].getUnitPriceItem()*quantity;
		       		      
		       		      price1=df.format(price);
		       		     
		       		      break;
		       		      
		       		    }
		           }
		      
			  jtaRec.append(String.valueOf(item)+"       "+itemName+"                        "+ String.valueOf(quantity)+"                "+ price1+"\n");  
			  
				
			}
			
			
			if (e.getSource()==jbtCheck)
			{
				i=i+1;
				transaction[i].setCode(9992);
				transaction[i].setQuantity(0);
			      sum1=df.format(sum);
       		      tax1=df.format(taxTotal);
       		      sum=0;
       		      taxTotal=0;
       		
				jtaRec.append("**********************************************************************\n");
				jtaRec.append("Total Taxes:-"+tax1+ "\n)");
				jtaRec.append("Grand Total:- "+ sum1+"\n");
				jtaRec.append("**********************************************************************\n");
				
			}
				
			if (e.getSource()==jbtUpdate)
			{
				
			
				for (int j=0; j<invent.length; j++)
				{
					for (int z=j+1; z<invent.length; z++)
					{
					if (invent[j].getItemCode()>invent[z].getItemCode())
					{
						invent1[0]= invent[j];
						invent[j]= invent[z];
						invent[z]= invent1[0];
						
					}
				  }
					
				}
			
				jtaUpdate.setText("");
				
				
				jtaUpdate.append("Item-Code"+ "             "+  "Item Name"+ "               "+ "Quantity Left\n" );
			    for (int j=0; j<invent.length; j++)
			    {
			    	
			   jtaUpdate.append(String.valueOf(invent[j].getItemCode())+ "                  " + invent[j].getItemName()+ "                "+ String.valueOf(invent[j].getQuantityLeft())+ "\n");
			   
			    	
			    }
				
			}
			
			if (e.getSource()==jbtEnd)
			{
				i=i+1;
				transaction[i].setCode(9993);
				transaction[i].setQuantity(0);
				
				for (int k=0; k<transaction.length; k++)
				{
				    if (transaction[k].getCode()==0 && transaction[k].getQuantity()==0)
				    {
				    	break;
				    }
					output.print(transaction[k].getCode()+"  ");
					output.println(transaction[k].getQuantity());
					jtaTransaction.append(String.valueOf(transaction[k].getCode())+"    "+String.valueOf(transaction[k].getQuantity())+ "\n"  );
					
					
					
				}
				output.close();
			}

			if (e.getSource()==jbtNewCustomer )
			{
				
				jtaRec.setText("");
			    jtaRec.append("                                              Customer's Receipt\n"); 
			    jtaRec.append("=======================================================================\n");
			     
			    jtaRec.append("Code"+"     "+"Name"+"                        "+"Quantity"+"                 "+ "Cost\n");
				
				
			}
			
		}

		
		
		
	}

	public static void main(String[] args) throws FileNotFoundException {
	
		shopInventory frame = new shopInventory();
		frame.setSize(800,700);
		frame.setTitle("Inventory System");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		

	}

}
