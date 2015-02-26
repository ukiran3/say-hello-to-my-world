package edu.calstatela.cs202.gala.RancherGame;

import java.util.ArrayList;

public class Board {

	private int row;
	private int column;
	private int[][] board;
	ArrayList<Object> entities;
	
	public Board()
	{
		row = 0;
		column = 0;
		board = new int[0][0];
		entities = new ArrayList<Object>();
	}
	
	public void setRow(int row)
	{
		this.row = row;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public void setColumn(int column)
	{
		this.column = column;
	}
	
	public int getColumn()
	{
		return column;
	}
	
	public void setBoard()
	{
		board = new int[getRow()][getColumn()];
	}
	
	public void displayBoard()
	{
		for(int row = 0; row < getRow(); row++)
		{
			System.out.println();
			for(int column = 0; column < getColumn(); column++)
			{
				System.out.println(board[row][column] + " ");
			}
		}
	}
	
	public void updateBoard(Object object, int row, int column)
	{
		
	}
	
	public String getCurrentStatus(String a [][],int row,int column){
		return a[row][column];
	}
}
