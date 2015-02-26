import java.util.*;
public class TestSAL extends SortArrayList
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= size; i++)
		{
			System.out.println("Enter the " +i+ "th number: ");
			list.add(input.nextInt());
		}
		System.out.println("The Sorted list is: ");
			sort(list);
	}
}
