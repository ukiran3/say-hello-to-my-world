package edu.calstatela.cs202.gala.Test;

public class TestWolf extends TestMammal {

	public TestWolf() {
		super("W", 0, 0);
	}

	@Override
	public int moveNorth(int x, int y) {
		//Move UP
		return y--;
	}

	@Override
	public int moveEast(int x, int y) {
		//Move RIGHT
		return x++;
	}

	@Override
	public int moveWest(int x, int y) {
		//Move LEFT
		return x--;
	}

	@Override
	public int moveSouth(int x, int y) {
		//Move DOWN
		return y++;
	}

	@Override
	public int moveRandom(int x, int y, TestBoard tb) {
		//Move Where-ever
				int rowLimit = tb.getRow();
				int columnLimit = tb.getColumn();
				
				//Decide whether to move by x or y; 0 = x, 1 = y
				int chance = (int)(Math.random() * (2 - 0) + 0);
				int compass = -1;
				
				if(chance == 0) //If we should move X
				{
					compass = direction(0, 2);
					//0 = increment, 1 = decrement
					if(compass == 0)
					{
						return x++;
					} else if(compass == 1)
					{
						return x--;
					}
				} else if(chance == 1) //If we should move Y
				{
					compass = direction(0, 2);
					//0 = increment, 1 = decrement
					if(compass == 0)
					{
						return x++;
					} else if(compass == 1)
					{
						return x--;
					}
				}
				return -1; //Means an error has occurred
	}

	@Override
	public int direction(int min, int max) {
		int result = (int)(Math.random() * (max - min) + min);
		return result;
	}

}
