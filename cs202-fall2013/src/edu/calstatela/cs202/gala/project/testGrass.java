package edu.calstatela.cs202.gala.project;

import java.awt.Color;
import java.awt.Graphics;

public class testGrass extends TestPlant {

	private int grassLevel;
	private static Color c = new Color(25, 51, 0);
	
	public testGrass() {
		super("G", 0, 0);
		grassLevel = 0;
	}
	
	public int randomizeGrassLevel(int min, int max)
	{
		int result = (int)(Math.random() * (max - min) + min);
		return result;
	}
	
	public void setGrassLevel(int level)
	{

		if(level == 0)
		{
			this.grassLevel = 0;
		} else if(level == 1)
		{
			this.grassLevel = 1;
		} else if (level == 2)
		{
			this.grassLevel = 2;
		} else if (level == 3)
		{
			this.grassLevel = 3;
		}

	}
	
	public int getGrassLevel()
	{
		return this.grassLevel;
	}
	
	public void increaseGrassLevel()
	{
		this.grassLevel++;
	}
	
	public void decreaseGrassLevel()
	{
		this.grassLevel--;
	}

	@Override
	void paint(Graphics pen) {
		// TODO Auto-generated method stub
		
	}
	
//	public void setGrassLevel(TestBoard tb)
//	{
//		int rowLimit = tb.getRow();
//		int columnLimit = tb.getColumn();
//		
//		int level = -1;
//		
//		for(int row = 0; row < rowLimit - 1; row++)
//		{
//			for(int column = 0; column < columnLimit; column++)
//			{
//				if((!tb.board[row][column].equals("T")))
//				{
//					level = randomizeGrassLevel(0, 4);
//					if(level == 0)
//					{
//						tb.board[row][column] = grassLevel_0;
//					} else if(level == 1)
//					{
//						tb.board[row][column] = grassLevel_1;
//					} else if(level == 2)
//					{
//						tb.board[row][column] = grassLevel_2;
//					} else if(level == 3)
//					{
//						tb.board[row][column] = grassLevel_3;
//					}
//				}
//			}
//		}
//	}


}
