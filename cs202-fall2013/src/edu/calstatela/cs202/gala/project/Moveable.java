package edu.calstatela.cs202.gala.project;

public interface Moveable {

	int moveNorth(int y);
	
	int moveEast(int x);
	
	int moveWest(int x);
	
	int moveSouth(int x);
	
	int moveRandom(int coordinate);
	
	int direction(int min, int max);
}
