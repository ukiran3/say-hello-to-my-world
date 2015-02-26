package edu.calstatela.cs202.gala.project;


import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class panelClass extends JPanel{
	ArrayList<TestMammal> animals = new ArrayList<TestMammal>();
	ArrayList<TestPlant> plants = new ArrayList<TestPlant>();
	int B_HEIGHT = 0;
	int B_WIDTH = 0;
	
	public void setHeight(TestBoard tb)
	{
		B_HEIGHT = tb.getRow();
	}
	
	public int getHeight()
	{
		return B_HEIGHT;
	}
	
	public void setWidth(TestBoard tb)
	{
		B_WIDTH = tb.getColumn();
	}
	
	public int getWidth()
	{
		return B_WIDTH;
	}
	
	//Add all animals to arraylist
	public void setAnimals(TestBoard tb)
	{
		for(TestSheep s : tb.getSheepArray())
		{
			animals.add(s);
		}
		
		for(TestWolf w : tb.getWolfArray())
		{
			animals.add(w);
		}
	}
	
	//Add all plants to arraylist
	public void setPlants(TestBoard tb)
	{
		for(testTree t : tb.getTreeArray())
		{
			plants.add(t);
		}
		
		for(testGrass g : tb.getGrassArray())
		{
			plants.add(g);
		}
	}
	
	public void paintComponent(Graphics pencil)
	{
		super.paintComponent(pencil);
		
		int ystep = this.B_HEIGHT/20;
		int xstep = this.B_WIDTH/20;

		for (int i = 0; i < 11; i++) {
			pencil.drawLine(0, i*ystep, this.B_WIDTH, i*ystep);
		}
		
		for (int i = 0; i < 11; i++) {
			pencil.drawLine(i*xstep, 0, i*xstep, this.B_HEIGHT);
		}
		
		
		for (TestMammal animal : animals) {
			animal.paint(pencil);
		}
		
		for(TestPlant plant : plants)
		{
			plant.paint(pencil);
		}
	}
	
}
