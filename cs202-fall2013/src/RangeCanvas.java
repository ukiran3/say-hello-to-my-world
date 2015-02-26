import java.awt.Color;
import java.awt.Graphics;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

class RangeCanvas extends JPanel implements BoardSettings {
	
	private static final long serialVersionUID = 1L;
	protected ArrayList<Entity> animals = new ArrayList<Entity>();
	protected ArrayList<Entity> trees = new ArrayList<Entity>();
	String sh[][];	
	
	@Override
	protected void paintComponent(Graphics pen) 
	{
		super.paintComponent(pen);
		//System.out.println(timer.getInitialDelay());

		int ystep = B_HEIGHT/20;
		int xstep = B_WIDTH/20;

		for (int i = 0; i < 11; i++) {
			pen.drawLine(0, i*ystep, B_WIDTH, i*ystep);
		}
		
		for (int i = 0; i < 11; i++) {
			pen.drawLine(i*xstep, 0, i*xstep, B_HEIGHT);
		}
		
		// -- begin example --
		// you should remove these when your code is working
		//animals.add( new Sheep(5, 5, new Color(255,255,255)) );
		//animals.add( new Wolf(5, 6, Color.red) );
		//animals.add( new Wolf(5, 4, Color.red) );
		//animals.add( new Wolf(4, 5, Color.black) );
		//animals.add( new Wolf(6, 5, Color.black) );
		//animals.add( new Wolf(6, 7, Color.blue) );
		// -- end example --
		
		for (Entity animal : trees) {
			animal.paint(pen);
		}
		
		if(animals.size() > 2)
		for(int i = 0; i< animals.size(); i++)
		{
			if(i < 3)
			System.out.println("Sheep"+i+" =("+animals.get(i).x * 30+","+animals.get(i).y * 30+") : ");
			else
				System.out.println("Wolf"+i+" =("+animals.get(i).x * 30+","+animals.get(i).y * 30+") : ");
		}
		
		for (Entity animal : animals) {
			animal.paint(pen);
		}
		
	}

	public ArrayList<Entity> CreateAnimalsWithRandomLocations(int NS, int NW) 
	{
		// 1. create NS number of sheep and assign them random locations
		// 2. create NW number of wolves and assign them random locations
		// 3. add the entities above to the animals ArrayList
		
		// -- begin update code --
		Random random = new Random();
		ArrayList<Entity> nanimals = new ArrayList<Entity>();
		ArrayList<Entity> ntrees = new ArrayList<Entity>();
		
		for(int x = 0; x < 11; x++)
		{
			for(int y = 0; y < 11; y++)
			{
				ntrees.add(new Grass(x,y,Color.green));
			}
		}

		for(int i = 0; i < random.nextInt(10); i++)
		{
		    int x = random.nextInt(11);
			int y = random.nextInt(11);
				
			ntrees.add(new Tree(x,y,Color.GRAY));
		}

		sh = new String[20][20];

		for(int i = 0; i < NS; i++)
		{
			int x, y;
			do
			{
				x = random.nextInt(11);
				y = random.nextInt(11);
				
			}while(sh[x][y] != null);
			
			sh[x][y] = "sheep"+i;
			
			System.out.println("Sheep"+i+" =("+x * 30+","+y * 30+") : " +sh[x][y]);
			
			nanimals.add(new Sheep(x, y, Color.BLUE));
		}
		for(int j = 0; j < NW; j++)
		{
			int x, y;
			do
			{
				x = random.nextInt(11);
				y = random.nextInt(11);
				
			}while(sh[x][y] != null);
			
			sh[x][y] = "wolf"+j;			
			
			System.out.println("Wolf"+j+" =("+x * 30 +","+y * 30+") : " +sh[x][y]);
			
			nanimals.add(new Wolf(x, y, Color.red));
		}
		
		trees = ntrees;
				animals = nanimals;
		return nanimals;
		
		// -- end update code --
	}
	
	public ArrayList<Entity> addSecondPlayer(int NS) 
	{
		// 1. create NS number of sheep and assign them random locations
		// 2. create NW number of wolves and assign them random locations
		// 3. add the entities above to the animals ArrayList
		
		// -- begin update code --
		Random random = new Random();

		for(int i = 0; i < NS; i++)
		{
			int x, y;
			do
			{
				x = random.nextInt(11);
				y = random.nextInt(11);
				
			}while(sh[x][y] != null);
			
			sh[x][y] = "sheep"+i;
			
			System.out.println("Pink Sheep"+i+" =("+x * 30+","+y * 30+") : " +sh[x][y]);
			
			animals.add(new Sheep(x, y, Color.pink));
		}
		
		return animals;
		
		// -- end update code --
	}
	
	public boolean startTimer(ArrayList<Entity> nanimals) 
	{
		int NS = 0, NW = 0;
		for(Entity animal: nanimals)
		{
			String str = String.valueOf(animal.getClass());
			if(str.equals("class Sheep"))
			{
				NS++;
			}
			if(str.equals("class Wolf"))
			{
				NW++;
			}
		}
		System.out.println("Number of Sheep playing:" +NS);
		System.out.println("Number of Wolf playing:" +NW);
		//ArrayList<Entity> nanimals = new ArrayList<Entity>();
		//nanimals = makeRandomMovementWolf(nanimals, NS);

		for(int i = 0; i < NS; i++)
		{
			for(int j = NS; j < NW; j++)
			{
				if(nanimals.get(i).x == nanimals.get(j).x && nanimals.get(i).y == nanimals.get(j).y)
				{
					nanimals.remove(i);
				}
			}
			nanimals = makeRandomMovementSheep(nanimals, i);
		}
		this.animals = nanimals;
		if(NS != 0)
		return true;
		else
		{
			System.out.println("Game Terminates...!!!");
		return false;
		}
	}
	
	public ArrayList<Entity> makeRandomMovementSheep(ArrayList<Entity> nanimals,int SI)
	{
		Random random = new Random();
		int x = random.nextInt(4);
		if(x == 0)
		{
			if(nanimals.get(SI).x < 10)
				nanimals.get(SI).x++;
			else
				makeRandomMovementSheep(nanimals,SI);
		}	
		else
				if(x == 1)
				{
					if(nanimals.get(SI).x > 0)
						nanimals.get(SI).x--;
					else
						makeRandomMovementSheep(nanimals,SI);
				}
				else
				{
					if(x == 2)
					{
						if(nanimals.get(SI).y < 10)
							nanimals.get(SI).y++;
						else
							makeRandomMovementSheep(nanimals,SI);
					}
					else
					{
						if(nanimals.get(SI).y > 0)
							nanimals.get(SI).y--;
						else
							makeRandomMovementSheep(nanimals,SI);
					}
				}
		
		return nanimals;
	}
	
	public ArrayList<Entity> makeRandomMovementWolf(ArrayList<Entity> nanimals)
	{
		int NS = 0, NS2 = 0;
		for(Entity animal: animals)
		{
			String str = String.valueOf(animal.getClass());
			if(str.equals("class Sheep") && animal.c == Color.pink)
			{
				NS2++;
			}
			if(str.equals("class Sheep") && animal.c == Color.blue)
			{
				NS++;
			}
			if(str.equals("class Wolf"))
			{
				//NW++;
			}			
		}
		Random random = new Random();
		for( int SI = NS; SI < nanimals.size() - NS2; SI++)
		{
		//	nanimals.get(i).x = x;
			//nanimals.get(i).y = y;
		int x = random.nextInt(4);
		if(x == 0)
		{
			if(nanimals.get(SI).x < 10)
				nanimals.get(SI).x++;
			else
				makeRandomMovementWolf(nanimals);
		}	
		else
				if(x == 1)
				{
					if(nanimals.get(SI).x > 0)
						nanimals.get(SI).x--;
					else
						makeRandomMovementWolf(nanimals);
				}
				else
				{
					if(x == 2)
					{
						if(nanimals.get(SI).y < 10)
							nanimals.get(SI).y++;
						else
							makeRandomMovementWolf(nanimals);
					}
					else
					{
						if(nanimals.get(SI).y > 0)
							nanimals.get(SI).y--;
						else
							makeRandomMovementWolf(nanimals);
					}
				}
		}
		
		return nanimals;
	}
	
	public void moveSheepEast(int player, int x, int y)
	{
		int NS1 = 0, NS2 = 0;
		for(Entity animal: animals)
		{
			String str = String.valueOf(animal.getClass());
			if(str.equals("class Sheep") && animal.c == Color.blue)
			{
				NS1++;
			}
			if(str.equals("class Sheep") && animal.c == Color.pink)
			{
				NS2++;
			}
			if(str.equals("class Wolf"))
			{
				//NW++;
			}			
		}
		System.out.println("pink sheep" + NS2);
		if(player == 0)
		{
		Integer diffX = x - animals.get(0).x * 30,diffY = y - animals.get(0).y * 30, an = 0;
		if (diffX < 0) diffX = diffX * -1;
		if (diffY < 0) diffY = diffY * -1;
		System.out.println(diffX+":"+diffY);
		for(int i = 1; i < NS1; i++)
		{
			Integer currDX, currDY;

			currDX = x - animals.get(i).x * 30;
			currDY = y - animals.get(i).y * 30;
			
			if (currDX < 0) currDX = currDX * -1;
			if (currDY < 0) currDY = currDY * -1;
			System.out.println(currDX+":"+currDY);
			if(currDX < diffX || currDY < diffY)
			{
				diffX = currDX;
				diffY = currDY;
				an = i;
			}
		}
		if(animals.get(an).x < 10)
		{
			makeRandomMovementWolf(animals);
			if(NotClash(an, "E"))
			{
				animals.get(an).x++;
				//CheckForDeadSheep();
				System.out.println("animals size: "+animals.size());
			}
		}
		else
			System.out.println("Cannot make this move");
		System.out.println(an);
		}
		else
		{
			if(NS2 > 0)
			{
			Integer diffX = x - animals.get(animals.size() - NS2 ).x * 30,diffY = y - animals.get( animals.size() - NS2).y * 30, an = animals.size() - NS2;
			if (diffX < 0) diffX = diffX * -1;
			if (diffY < 0) diffY = diffY * -1;
			System.out.println(diffX+":"+diffY);
			for(int i = animals.size() - NS2 + 1; i < animals.size(); i++)
			{
				Integer currDX, currDY;
				
				currDX = x - animals.get(i).x * 30;
				currDY = y - animals.get(i).y * 30;
				
				if (currDX < 0) currDX = currDX * -1;
				if (currDY < 0) currDY = currDY * -1;
				System.out.println(currDX+":"+currDY);
				if(currDX < diffX || currDY < diffY)
				{
					diffX = currDX;
					diffY = currDY;
					an = i;
				}
			}
			if(animals.get(an).x < 10)
			{
				System.out.println(an);
				makeRandomMovementWolf(animals);
				if(NotClash(an, "E"))
				{
					animals.get(an).x++;
					System.out.println("East pink sheep:" +animals.get(an).x );
					//CheckForDeadSheep();
					System.out.println("animals size: "+animals.size());
				}
			}
			else
				System.out.println("Cannot make this move");
			
		}
		}
	}
	
	public void moveSheepWest(int player, int x, int y)
	{
		int NS1 = 0, NS2 = 0;
		for(Entity animal: animals)
		{
			String str = String.valueOf(animal.getClass());
			if(str.equals("class Sheep") && animal.c == Color.blue)
			{
				NS1++;
			}
			if(str.equals("class Sheep") && animal.c == Color.pink)
			{
				NS2++;
			}
			if(str.equals("class Wolf"))
			{
				//NW++;
			}			
		}
		if(player == 0)
		{
			Integer diffX = x - animals.get(0).x * 30,diffY = y - animals.get(0).y * 30, an = 0;
			if (diffX < 0) diffX = diffX * -1;
			if (diffY < 0) diffY = diffY * -1;
			System.out.println(diffX+":"+diffY);
			for(int i = 1; i < NS1; i++)
			{
				Integer currDX, currDY;
				
				currDX = x - animals.get(i).x * 30;
				currDY = y - animals.get(i).y * 30;
				
				if (currDX < 0) currDX = currDX * -1;
				if (currDY < 0) currDY = currDY * -1;
				System.out.println(currDX+":"+currDY);
				if(currDX < diffX || currDY < diffY)
				{
					diffX = currDX;
					diffY = currDY;
					an = i;
				}
			}
			if(animals.get(an).x > 0)
			{
				makeRandomMovementWolf(animals);
				if(NotClash(an, "W"))
				{
					animals.get(an).x--;
					//CheckForDeadSheep();
					System.out.println("animals size: "+animals.size());
				}
			}
			else
				System.out.println("Cannot make this move");
			System.out.println(an);
		}
		else
		{
			if(NS2 > 0)
			{
			Integer diffX = x - animals.get(animals.size() - NS2 ).x * 30,diffY = y - animals.get( animals.size() - NS2).y * 30, an = animals.size() - NS2;
			if (diffX < 0) diffX = diffX * -1;
			if (diffY < 0) diffY = diffY * -1;
			System.out.println(diffX+":"+diffY);
			for(int i = animals.size() - NS2 + 1; i < animals.size(); i++)
			{
				Integer currDX, currDY;
				
				currDX = x - animals.get(i).x * 30;
				currDY = y - animals.get(i).y * 30;
				
				if (currDX < 0) currDX = currDX * -1;
				if (currDY < 0) currDY = currDY * -1;
				System.out.println(currDX+":"+currDY);
				if(currDX < diffX || currDY < diffY)
				{
					diffX = currDX;
					diffY = currDY;
					an = i;
				}
			}
			if(animals.get(an).x > 0)
			{
				makeRandomMovementWolf(animals);
				if(NotClash(an, "W"))
				{
					animals.get(an).x--;
					//CheckForDeadSheep();
					System.out.println("animals size: "+animals.size());
				}
			}
			else
				System.out.println("Cannot make this move");
			System.out.println(an);
		}
		}
		}	

	public void moveSheepNorth(int player, int x, int y)
	{
		int NS1 = 0, NS2 = 0;
		for(Entity animal: animals)
		{
			String str = String.valueOf(animal.getClass());
			if(str.equals("class Sheep") && animal.c == Color.blue)
			{
				NS1++;
			}
			if(str.equals("class Sheep") && animal.c == Color.pink)
			{
				NS2++;
			}
			if(str.equals("class Wolf"))
			{
				//NW++;
			}			
		}
		
		if(player == 0)
		{
		Integer diffX = x - animals.get(0).x * 30,diffY = y - animals.get(0).y * 30, an = 0;
		if (diffX < 0) diffX = diffX * -1;
		if (diffY < 0) diffY = diffY * -1;
		System.out.println(diffX+":"+diffY);
		for(int i = 1; i < NS1; i++)
		{
			Integer currDX, currDY;

			currDX = x - animals.get(i).x * 30;
			currDY = y - animals.get(i).y * 30;
			
			if (currDX < 0) currDX = currDX * -1;
			if (currDY < 0) currDY = currDY * -1;
			System.out.println(currDX+":"+currDY);
			if(currDX < diffX || currDY < diffY)
			{
				diffX = currDX;
				diffY = currDY;
				an = i;
			}
		}
		if(animals.get(an).y > 0)
		{
			makeRandomMovementWolf(animals);
			if(NotClash(an, "N"))
			{
				animals.get(an).y--;
				//CheckForDeadSheep();
				System.out.println("animals size: "+animals.size());
			}
		}
		else
			System.out.println("Cannot make this move");
		System.out.println(an);
		}
		else
		{
			if(NS2 > 0)
			{
			Integer diffX = x - animals.get(animals.size() - NS2 ).x * 30,diffY = y - animals.get( animals.size() - NS2).y * 30, an = animals.size() - NS2;
			if (diffX < 0) diffX = diffX * -1;
			if (diffY < 0) diffY = diffY * -1;
			System.out.println(diffX+":"+diffY);
			for(int i = animals.size() - NS2 + 1; i < animals.size(); i++)
			{
				Integer currDX, currDY;
				
				currDX = x - animals.get(i).x * 30;
				currDY = y - animals.get(i).y * 30;
				
				if (currDX < 0) currDX = currDX * -1;
				if (currDY < 0) currDY = currDY * -1;
				System.out.println(currDX+":"+currDY);
				if(currDX < diffX || currDY < diffY)
				{
					diffX = currDX;
					diffY = currDY;
					an = i;
				}
			}
			if(animals.get(an).y > 0)
			{
				makeRandomMovementWolf(animals);
				if(NotClash(an, "N"))
				{
					animals.get(an).y--;
//					CheckForDeadSheep();
					System.out.println("animals size: "+animals.size());
				}
			}
			else
				System.out.println("Cannot make this move");
			System.out.println(an);
			}
		}

	}

	public void moveSheepSouth(int player, int x, int y)
	{
		int NS1 = 0, NS2 = 0;
		for(Entity animal: animals)
		{
			String str = String.valueOf(animal.getClass());
			if(str.equals("class Sheep") && animal.c == Color.blue)
			{
				NS1++;
			}
			if(str.equals("class Sheep") && animal.c == Color.pink)
			{
				NS2++;
			}
			if(str.equals("class Wolf"))
			{
				//NW++;
			}			
		}
		if(player == 0)
		{
		Integer diffX = x - animals.get(0).x * 30,diffY = y - animals.get(0).y * 30, an = 0;
		if (diffX < 0) diffX = diffX * -1;
		if (diffY < 0) diffY = diffY * -1;
		System.out.println(diffX+":"+diffY);
		for(int i = 1; i < NS1; i++)
		{
			Integer currDX, currDY;

			currDX = x - animals.get(i).x * 30;
			currDY = y - animals.get(i).y * 30;
			
			if (currDX < 0) currDX = currDX * -1;
			if (currDY < 0) currDY = currDY * -1;
			System.out.println(currDX+":"+currDY);
			if(currDX < diffX || currDY < diffY)
			{
				diffX = currDX;
				diffY = currDY;
				an = i;
			}
		}
		if(animals.get(an).y < 10)
		{
			makeRandomMovementWolf(animals);
			if(NotClash(an, "S"))
			{
				animals.get(an).y++;
				//CheckForDeadSheep();
				System.out.println("animals size: "+animals.size());
			}
		}
		else
			System.out.println("Cannot make this move");
		System.out.println(an);
		}
		else
		{
			if(NS2 > 0)
			{
			Integer diffX = x - animals.get(animals.size() - NS2 ).x * 30,diffY = y - animals.get( animals.size() - NS2).y * 30, an = animals.size() - NS2;
			if (diffX < 0) diffX = diffX * -1;
			if (diffY < 0) diffY = diffY * -1;
			System.out.println(diffX+":"+diffY);
			for(int i = animals.size() - NS2 + 1; i < animals.size(); i++)
			{
				Integer currDX, currDY;
				
				currDX = x - animals.get(i).x * 30;
				currDY = y - animals.get(i).y * 30;
				
				if (currDX < 0) currDX = currDX * -1;
				if (currDY < 0) currDY = currDY * -1;
				System.out.println(currDX+":"+currDY);
				if(currDX < diffX || currDY < diffY)
				{
					diffX = currDX;
					diffY = currDY;
					an = i;
				}
			}
			if(animals.get(an).y < 10)
			{
				makeRandomMovementWolf(animals);
				if(NotClash(an, "S"))
				{
					animals.get(an).y++;
					//CheckForDeadSheep();
					System.out.println("animals size: "+animals.size());
				}
			}
			else
				System.out.println("Cannot make this move");
			System.out.println(an);
		}
		}
	}
	
	public boolean NotClash(int an, String d)
	{
		int x = animals.get(an).x;
		int y = animals.get(an).y;
		if(d.equals("S")) y++;
		if(d.equals("N")) y--;
		if(d.equals("E")) x++;
		if(d.equals("W")) x--;
		for(int i = 0; i < animals.size(); i++)
		{
			if(i != an && String.valueOf(animals.get(i).getClass()).equals("class Sheep") && animals.get(i).x == x && animals.get(i).y == y)
			{
				System.out.println("Sheep cannot clash with " +String.valueOf(animals.get(i).getClass()));
					return false;
			}
		}
		
		for(Entity tree: trees)
		{
			String str = String.valueOf(tree.getClass());
			if(str.equals("class Tree"))
			{
				if(tree.x == x && tree.y == y)
				{
					System.out.println("Sheep cannot climb the tree");
					return false;
				}
			}
		}
		
		return true;
	}
	
	public int CheckForDeadSheep()
	{
		int NS1 = 0, NS2 = 0, NW = 0, deadPl = 0;
		for(Entity animal: animals)
		{
			String str = String.valueOf(animal.getClass());
			if(str.equals("class Sheep") && animal.c == Color.blue)
			{
				NS1++;
			}
			if(str.equals("class Sheep") && animal.c == Color.pink)
			{
				NS2++;
			}
			if(str.equals("class Wolf"))
			{
				NW++;
			}			
		}
		ArrayList<Integer> deadSheepIndex = new ArrayList<Integer>();
		for(int i = 0; i < NS1; i++)
		{
			for(int j = NS1; j < NS1+NW; j++)
			if(animals.get(i).x == animals.get(j).x && animals.get(i).y == animals.get(j).y)
			{
				deadSheepIndex.add(i);
			}
		}
		
		for(int i = animals.size() - NS2; i < animals.size(); i++)
		{
			for(int j = NS1; j < NS1+NW; j++)
			if(animals.get(i).x == animals.get(j).x && animals.get(i).y == animals.get(j).y)
			{
				deadSheepIndex.add(i);
			}
		}
		
		for(int index = deadSheepIndex.size() - 1; index >= 0; index--)
		{
			System.out.println("Indexed "+deadSheepIndex.get(index)+" and x, y: "+animals.get(deadSheepIndex.get(index)).x +", "+animals.get(deadSheepIndex.get(index)).y + "This sheep is dead.");
			animals.remove(animals.get(deadSheepIndex.get(index)));
			System.out.println(animals.size());
		}
		
		if(NS1 == 0)
		{
			System.out.println("End of player1...");
			deadPl++;
		}
		if(NS2 == 0)
		{
			System.out.println("End of player2...");
			deadPl = 2;
		}
		if(NS1 == 0 && NS2 == 0)
		{
			System.exit(0);
		}
		return deadPl;
	}

	public RangeCanvas()
	{
		
	}
	
	public void ReadFromFile(File file) {
		// read data from files into the animals ArrayList
		// -- begin update code --
		
		// -- end update code --
	}
	
}
