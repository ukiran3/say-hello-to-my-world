package edu.calstatela.cs202.gala.Test;

public interface Moveable {

	int moveNorth(int x, int y);
	
	int moveEast(int x, int y);
	
	int moveWest(int x, int y);
	
	int moveSouth(int x, int y);
	
	int moveRandom(int x, int y, TestBoard tb);
	
	int direction(int min, int max);
}
