package edu.calstatela.cs202.gala.RancherGame;


public interface Moveable {

	public void moveStay(Board position);
	
	public void moveNorth(Board position);
	
	public void moveSouth(Board position);
	
	public void moveEast(Board position);
	
	public void moveWest(Board position);
	
	public void moveRandom(Board position);
}
