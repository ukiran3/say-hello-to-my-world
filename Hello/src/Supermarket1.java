import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Supermarket1 extends JFrame {

    private JTextField txtCode= new JTextField();
    private JTextField txtQuan= new JTextField();
    private  JButton btAdd = new JButton("Add To Cart");
    private  JButton btClr = new JButton("Clear");
    private JButton btPrint = new JButton("Print Payment Bill");
    private JButton btUpdateInvent = new JButton("View Updated Inventory Stock");
    private JButton btEOD= new JButton("End Of The Day");
    private JButton btNewTran= new JButton("New Transaction");
    private JTextArea jtaCRT = new JTextArea("", 30,20);
    private JTextArea jtaUpdatedInventoryList= new JTextArea("",30,40);
    private JTextArea jtaTransactionList = new JTextArea("",30,40); 
    private JTextArea jtaInventoryList = new JTextArea("",20,40);
    Inventory1[] inventItem = new Inventory1[100];
    Inventory1[] tempInventItem = new Inventory1[1];
    Transactions1[] transaction= new Transactions1[100];
    double sum=0;
    double totalTax=0;
    int i=0;

    public static void main(String[] args) throws FileNotFoundException {
    
  Supermarket1 frame = new Supermarket1();
  frame.setSize(800,600);
  frame.setTitle("Supermarket Inventory System");
  frame.setLocationRelativeTo(null);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setVisible(true);
  
  }
  
  
    
  File transactionFile= new File("C:/Users/uday/workspace/Hello/src/TransactionData");
  File inventoryFile = new File("C:/Users/uday/workspace/Hello/src/InventoryList.txt");
//  transactionData.setReadOnly();
//  PrintWriter output=new PrintWriter(new FileWriter(transactionFile),true);

 // PrintWriter p1=new PrintWriter(new FileWriter("transactionData.txt"),true);
  PrintWriter output= new PrintWriter(transactionFile);  //Users/Sravya/Desktop/
    
 public Supermarket1() throws FileNotFoundException
 {
 
  for (int k=0; k<inventItem.length; k++)
  {
   inventItem[k]= new Inventory1();
  }
  for (int k=0; k<transaction.length; k++)
  {
   transaction[k]= new Transactions1();
  }
  
  if (!inventoryFile.exists())
  {
   JOptionPane.showMessageDialog(null, "unable to find Inventory File");
  
  }
 
  Scanner scanner = new Scanner(inventoryFile);
  int i=0;
  while (scanner.hasNext())
  {
   
     inventItem[i].setItemCode(Integer.parseInt(scanner.next()));
     inventItem[i].setItemName(scanner.next());
     inventItem[i].setUnitPriceItem(Double.parseDouble(scanner.next()));
     inventItem[i].setTaxCode(Integer.parseInt(scanner.next()));
     inventItem[i].setQtyLeft(Integer.parseInt(scanner.next()));
     inventItem[i].setReorderLevel(Integer.parseInt(scanner.next()));
     i=i+1;  
   
  }
  scanner.close();
  
//////////////////////////////////////////////////////////////////////////////////////  
  JPanel inventoryItemsPanel = new JPanel();
      
      jtaInventoryList.setLineWrap(true);
      jtaInventoryList.setWrapStyleWord(true);
      jtaInventoryList.setEditable(false);
     jtaInventoryList.append("**************************************************************************\n");
     jtaInventoryList.append("Item Code     Item Description             Unit Price\n" );
     jtaInventoryList.append("**************************************************************************\n");
     for (int j=0; j<inventItem.length; j++)
     {
       if(inventItem[j].getItemCode()!=0)
       {
        jtaInventoryList.append(String.valueOf(inventItem[j].getItemCode())+ "                   " + inventItem[j].getItemName()+ "                               "+ String.valueOf(inventItem[j].getUnitPriceOfItem())+ "\n");
       }
     }
     
  
      JScrollPane pane= new JScrollPane(jtaInventoryList);
      Border lineBorder= new LineBorder(Color.BLACK,1);
      inventoryItemsPanel.setBorder(lineBorder);
      inventoryItemsPanel.setLayout(new BorderLayout());
      JLabel inventItemsLabel= new JLabel("                                                      Inventory List Items");
      inventItemsLabel.setForeground(Color.BLACK);
    
      inventoryItemsPanel.add(inventItemsLabel, BorderLayout.NORTH);
      inventoryItemsPanel.add(pane, BorderLayout.CENTER);
      JPanel tPanel= new JPanel();
     tPanel.setLayout(new GridLayout(3,2));
     
     tPanel.add(new JLabel("Enter Code Of The Item"));
     tPanel.add(txtCode);
     tPanel.add(new JLabel("Enter Quantity  Required"));
     tPanel.add(txtQuan);
     tPanel.add(btClr);
     tPanel.add(btAdd);
     
      inventoryItemsPanel.add(tPanel,BorderLayout.SOUTH);
      
      
      ///////////////////////////////////////////////////////////////////////////////
      
      JPanel crtPanel = new JPanel();
      jtaCRT.setLineWrap(true);
      jtaCRT.setWrapStyleWord(true);
      jtaCRT.setEditable(false);
      jtaCRT.append("**************************************************************************\n");
      jtaCRT.append("Item Code     Item Description                   Quantity               Cost\n");
      jtaCRT.append("**************************************************************************\n");
           
     JScrollPane pane2= new JScrollPane(jtaCRT);
     
     JLabel crtLabel= new JLabel("                                           Cash Regieter Ticket ");
     crtLabel.setForeground(Color.BLACK);
     
     crtPanel.setLayout(new BorderLayout());
     crtPanel.add(crtLabel, BorderLayout.NORTH);
     crtPanel.add(pane2,BorderLayout.CENTER);
      
     crtPanel.setBorder(lineBorder);
      
     JPanel bPanel1 = new JPanel();
     bPanel1.setLayout(new GridLayout(1,2));
     bPanel1.add(btPrint);
     bPanel1.add(btNewTran);
     crtPanel.add(bPanel1,BorderLayout.SOUTH);
      
   
 ////////////////////////////////////////////////////////////////////////////////////////
      jtaUpdatedInventoryList.setLineWrap(true);
      jtaUpdatedInventoryList.setWrapStyleWord(true);
      jtaUpdatedInventoryList.setEditable(false);
      JScrollPane pane3= new JScrollPane(jtaUpdatedInventoryList);
      
      JPanel updatedInventoryListPanel = new JPanel();
      updatedInventoryListPanel.setLayout(new BorderLayout());
      JLabel updateLabel= new JLabel("                                                   Updated Stock Inventory list");
      updateLabel.setForeground(Color.BLACK);
     
      updatedInventoryListPanel.add(updateLabel, BorderLayout.NORTH);
      updatedInventoryListPanel.add(pane3, BorderLayout.CENTER);
      updatedInventoryListPanel.setBorder(lineBorder);
      JPanel bPanel2 = new JPanel();
      bPanel2.setLayout(new GridLayout(1,1));
      bPanel2.add(btUpdateInvent);
      updatedInventoryListPanel.add(bPanel2,BorderLayout.SOUTH);
      jtaUpdatedInventoryList.append("**************************************************************************\n");
      jtaUpdatedInventoryList.append("Item Code             Item Description               Quantity Left\n" );
      jtaUpdatedInventoryList.append("**************************************************************************\n");
      
/////////////////////////////////////////////////////////////////////////////////////////////////  
      jtaTransactionList.setLineWrap(true);
      jtaTransactionList.setWrapStyleWord(true);
      jtaTransactionList.setEditable(false);
      JScrollPane pane4= new JScrollPane(jtaTransactionList);
      JPanel transactionListPanel = new JPanel();
      transactionListPanel.setLayout(new BorderLayout());
      JLabel transLabel= new JLabel("                                                   EOD Transaction Details ");
      transLabel.setForeground(Color.BLACK);
     
      transactionListPanel.add(transLabel, BorderLayout.NORTH);
      transactionListPanel.add(pane4, BorderLayout.CENTER);
      transactionListPanel.setBorder(lineBorder);
      JPanel bPanel3 = new JPanel();
     bPanel3.setLayout(new GridLayout(1,1));
     bPanel3.add(btEOD);
      transactionListPanel.add(bPanel3,BorderLayout.SOUTH);
      jtaTransactionList.append("**************************************************************************\n");
      jtaTransactionList.append("Item Code        Quantity\n");
      jtaTransactionList.append("**************************************************************************\n");

      

 ////////////////////////////////////////////////////////////////////////////////     
   setLayout(new GridLayout(2,2));
   add(inventoryItemsPanel);
   add(updatedInventoryListPanel);
   add(crtPanel);
   add(transactionListPanel);
   
   btAdd.addActionListener(new ButtonListener());
   btClr.addActionListener(new ButtonListener());
   btPrint.addActionListener(new ButtonListener());
   btUpdateInvent.addActionListener(new ButtonListener());
   btEOD.addActionListener(new ButtonListener());
   btNewTran.addActionListener(new ButtonListener());
  
 }
 
 private class ButtonListener implements ActionListener{
  
  public void actionPerformed(ActionEvent e)
  {
   
   int tax=0; 
   String taxStr="";
   double price=0;
   String priceStr="";
   String sumStr="";
   String itemName = null;
   DecimalFormat df = new DecimalFormat("#0.00");
   
   if (e.getSource()== btClr)
   {
           txtCode.setText("");
           txtQuan.setText("");
            
    }
   if (e.getSource()== btAdd)
   {
    int item= Integer.parseInt(txtCode.getText());
       int quantity= Integer.parseInt(txtQuan.getText());
   
       if(transaction[i].getCode()==0)
    {
     
    transaction[i].setCode(9991);
    transaction[i].setQty(0);
    }
       if(transaction[i].getCode()==9992)
    {
    i=i+1; 
    transaction[i].setCode(9991);
    transaction[i].setQty(0);
    }
    i++;
    
    transaction[i].setCode(item);
    transaction[i].setQty(quantity);
    
       
       for (int j=0; j<inventItem.length; j++)
            {
             
               if (item==inventItem[j].getItemCode())
                  {
                  
                 itemName= inventItem[j].getItemName();
                 tax=inventItem[j].getTaxCode();
                 if (tax==1)
                 {
                  totalTax= totalTax+ (.1*inventItem[j].getUnitPriceOfItem());
                 }
                 sum= sum + inventItem[j].getUnitPriceOfItem()*quantity+totalTax;
                 inventItem[j].setQtyLeft(inventItem[j].getQtyLeft()-quantity);
                 price= inventItem[j].getUnitPriceOfItem()*quantity;
                 priceStr=df.format(price);
                
                 break;
                 
               }
             }
        
     jtaCRT.append(String.valueOf(item)+"                "+itemName+"                                          "+ String.valueOf(quantity)+"                       "+ priceStr+"\n");  
     
    
   }
   
   
   if (e.getSource()==btPrint)
   {
    i=i+1;
    transaction[i].setCode(9992);
    transaction[i].setQty(0);
    sumStr=df.format(sum);
    taxStr=df.format(totalTax);
    sum=0;
    totalTax=0;
         
    jtaCRT.append("  **********************************************************************\n");
    jtaCRT.append("Total Tax: "+taxStr+ "\n");
    jtaCRT.append("  **********************************************************************\n");
    jtaCRT.append("Grand Total: "+ sumStr+"\n");
    jtaCRT.append("  **********************************************************************\n");
    
   }
    
   if (e.getSource()==btUpdateInvent)
   {
      jtaUpdatedInventoryList.setText("");
      jtaUpdatedInventoryList.append("**************************************************************************\n");
      jtaUpdatedInventoryList.append("Item Code             Item Description               Quantity Left\n" );
      jtaUpdatedInventoryList.append("**************************************************************************\n");
   
    for (int j=0; j<inventItem.length; j++)
    {
     for (int z=j+1; z<inventItem.length; z++)
     {
     if (inventItem[j].getItemCode()>inventItem[z].getItemCode())
     {
      tempInventItem[0]= inventItem[j];
      inventItem[j]= inventItem[z];
      inventItem[z]= tempInventItem[0];
      
     }
      }
     
    }
   for (int j=0; j<inventItem.length; j++)
   {  
     if(inventItem[j].getItemCode()!=0)
     {
     jtaUpdatedInventoryList.append(String.valueOf(inventItem[j].getItemCode())+ "                  " + inventItem[j].getItemName()+ "                "+ String.valueOf(inventItem[j].getQtyLeft())+ "\n");
     }
   }
    
   }
   
   if (e.getSource()==btEOD)
   {
     i=i+1;
    transaction[i].setCode(9993);
    transaction[i].setQty(0);
    
        for (int k=0; k<transaction.length; k++)
    {
        if (transaction[k].getCode()==0 && transaction[k].getQty()==0)
        {
         break;
        }
     output.print(transaction[k].getCode()+"  ");
     output.println(transaction[k].getQty());
     jtaTransactionList.append(String.valueOf(transaction[k].getCode())+"                    "+String.valueOf(transaction[k].getQty())+ "\n"  );
     
    }
    output.close();
   }

   if (e.getSource()==btNewTran )
   {
    
      jtaCRT.setText("");
      jtaCRT.append("                                              Customer Payment Receipt\n"); 
      jtaCRT.append("**************************************************************************\n");
      jtaCRT.append("Item Code"+"     "+"Item Description"+"                        "+"Quantity"+"                 "+ "Cost\n");
      jtaCRT.append("**************************************************************************\n");
    
    
   }
   
  }
  
 }
 


}
