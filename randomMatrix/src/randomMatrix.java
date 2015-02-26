import java.util.*;
public class randomMatrix
{
	ArrayList <Integer> row = new ArrayList<Integer>();
	ArrayList <Integer> col = new ArrayList<Integer>();
	int size;
	public randomMatrix()
	{
		
	}
	public randomMatrix(int size)
	{
		this.size = size;
	}
	public int[][] createMatrix()
	{
		Random random = new Random();
		int[][] mat = new int[size][size];
		for(int j = 0; j < size; j++)
		{
			for(int k = 0; k < size; k ++)
			{
				int l = random.nextInt(2);
				mat[j][k] = l;
			}
		}
		return mat;
	}
	public void printMatrix(int[][] mat)
	{
		for(int j = 0; j < size; j++)
		{
			for(int k = 0; k < size; k ++)
			{
				System.out.print(" " + mat[j][k] + " ");
			}
			System.out.println();
		}
	}
	public void findRow(int[][] mat)
	{
		int count = 0;
		for(int j = 0; j < size; j++)
		{
			for(int k = 0; k < size; k ++)
			{
				if(mat[j][k] == 1)
				{
					count++;
				}
			}
			row.add(count);
			count = 0;
		}
		System.out.println(row);
		rowMax(size);
	}
	public void findCol(int[][] mat)
	{
		int count = 0;
		for(int j = 0; j < size; j++)
		{
			for(int k = 0; k < size; k ++)
			{
				if(mat[k][j] == 1)
				{
					count++;
				}
			}
			col.add(count);
			count = 0;
		}
		System.out.println(col);
		colMax(size);
	}
	public void rowMax(int a)
	{
		System.out.print("The largest Row index: ");
		int m = row.get(0);
		for(int j = 1; j < row.size(); j++)
		{
			if(m <= row.get(j))
			{
				m = row.get(j);
			}
		}
		//System.out.println(m);
		for(int k = 0; k < row.size(); k++)
		{
			if(row.indexOf(m) >= 0)
			{
				System.out.print(" " + row.indexOf(m) + " ");
				row.set(row.indexOf(m), 0);
			}
		}
		System.out.println();
	}
	public void colMax(int a)
	{
		System.out.print("The largest Column index: ");
		int m = col.get(0);
		for(int j = 1; j < col.size(); j++)
		{
			if(m <= col.get(j))
			{
				m = col.get(j);
			}
		}
		//System.out.println(m);
		for(int k = 0; k < col.size(); k++)
		{
			if(col.indexOf(m) >= 0)
			{
				System.out.print(" " + col.indexOf(m) + " ");
				col.set(col.indexOf(m), 0);
			}
		}
	}
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		randomMatrix rMatrix = new randomMatrix();
		//randomMatrix rMatrix1 = new randomMatrix(7);
		System.out.println("Enter the array size: ");
		rMatrix.size = input.nextInt();
		int[][] mat = rMatrix.createMatrix();
		rMatrix.printMatrix(mat);
		rMatrix.findRow(mat);
		rMatrix.findCol(mat);
	}
}
