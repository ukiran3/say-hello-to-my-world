import java.util.*;
public class FileSav
{
	 
    public static void swap(int [] values)
    {
        int temp;
         
         
          for(int i=0;i<values.length;i++)
          {                  
           for(int k=1;k<values.length-1;k++)
           {
               if(values[k-1]>values[k])
               {
                  temp=values[k-1];
                  values[k-1]=values[k];
                  values[k]=temp;
               }
                 
           }
           
          } 
         
        for(int i=0;i<values.length;i++)
        {
            System.out.println(values[i]);
        }
         
    }
    public static void main(String[] args) throws Exception {
        java.io.File file = new java.io.File("d:\\Exercise9_19.txt");
        int nums[]=new int[100];
        int index=0;
        if(file.exists())
        {
             
            System.out.println("File already exists");
            
            java.io.File readFile = new java.io.File("d:\\Exercise9_19.txt");
            java.util.Scanner input = new java.util.Scanner(readFile);
         
            while (input.hasNext())
            {
            nums[index]= input.nextInt();
             
              
            index=index+1;
            }
            input.close();
            swap(nums);
             
            
         
        }
        else
        {
             
            java.io.PrintWriter output = new java.io.PrintWriter(file);
            Random numbers = new Random();
            for (int i = 0; i < 100; i++)
            {
            	int num = numbers.nextInt();
            	output.print(num+" ");
            }
        output.close();
        }
         
   }
    
}