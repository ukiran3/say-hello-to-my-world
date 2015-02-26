import java.util.*;
public class Shuffle
{
	public static void shuffle(ArrayList<Integer> list)
	{
		ArrayList <Integer> list1 = new ArrayList();
		list1 = list;
		for(int j = 0; j < list.size(); j++)
		{
			Random random = new Random();
			int a = random.nextInt(list.size());
			list1.add(list.get(a));
			list.remove(a);
		}
		list = list1;
	}
	public static void main(String args[])
	{
		ArrayList <Integer> list = new ArrayList();
		//Shuffle list1 = new Shuffle();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Integers: ");
		String a = input.nextLine();
		String a1[] = a.split(" ");
		for(int i = 0; i < a1.length; i++)
			list.add(Integer.valueOf(a1[i]));
		
		shuffle(list);
		System.out.println(list.toString());
	}
}
