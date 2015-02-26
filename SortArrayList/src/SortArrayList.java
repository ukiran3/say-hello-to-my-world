import java.util.*;
public class SortArrayList
{
	static int size;
	public SortArrayList()
	{
		
	}
	public SortArrayList(int size1)
	{
		size = size1;
	}
	public static void sort(ArrayList<Integer> list)
	{
		int temp = list.get(0);
		for(int i = 1; i < list.size(); i++)
		{
			if(temp >= list.get(i))
			{
				temp = list.get(i);
			}
		}
		if(list.indexOf(temp) >= 0)
		{
			System.out.print(" " +temp+ " ");
			list.remove(list.indexOf(temp));
			if(list.size() > 0)
				sort(list);
		}
	}
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		size = input.nextInt();
		if(size > 0)
		{
			for(int i = 1; i <= size; i++)
			{
				System.out.println("Enter the " +i+ "th number: ");
				list.add(input.nextInt());
			}
			System.out.println(list);
			System.out.println("The Sorted array is: ");
			sort(list);
		}
		else
		{
			System.out.println("Negative size is not allowed...");
		}
	}
}
