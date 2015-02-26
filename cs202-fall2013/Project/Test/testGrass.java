package edu.calstatela.cs202.gala.Test;

public class testGrass extends TestPlant {

	private String grassLevel_0;
	private String grassLevel_1;
	private String grassLevel_2;
	private String grassLevel_3;
	
	public testGrass() {
		super("G", 0, 0);
		grassLevel_0 = " ";
		grassLevel_1 = ".";
		grassLevel_2 = "||";
		grassLevel_3 = "#";
	}
	
	public int randomizeGrassLevel(int min, int max)
	{
		int result = (int)(Math.random() * (max - min) + min);
		return result;
	}
	
	public void setGrassLevel(TestBoard tb)
	{
		int rowLimit = tb.getRow();
		int columnLimit = tb.getColumn();
		
		int level = -1;
		
		for(int row = 0; row < rowLimit - 1; row++)
		{
			for(int column = 0; column < columnLimit; column++)
			{
				if((!tb.board[row][column].equals("T")))
				{
					level = randomizeGrassLevel(0, 4);
					if(level == 0)
					{
						tb.board[row][column] = grassLevel_0;
					} else if(level == 1)
					{
						tb.board[row][column] = grassLevel_1;
					} else if(level == 2)
					{
						tb.board[row][column] = grassLevel_2;
					} else if(level == 3)
					{
						tb.board[row][column] = grassLevel_3;
					}
				}
			}
		}
	}


}
