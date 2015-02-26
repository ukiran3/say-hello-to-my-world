package edu.calstatela.cs202.gala.game;

import java.io.FileNotFoundException;
import java.util.Random;

import edu.calstatela.cs202.gala.RancherGame.TestConfig;

public class Game {
	static int column = 10;
	static int row = 10;
	int moves = 100;
	int no_of_sheep = 2;

	public static void main(String args[]) {
		// TestConfig test = TestConfig();
		Game game = new Game();
		Sheep[] sheep = new Sheep[3];
		//int lost = 0;
		Tree[] tree = new Tree[2];
		GameBoard gameBoard = new GameBoard(column, row);
		Grass[] grass = new Grass[0];
		Wolf[] wolf = new Wolf[18];
		Random random = new Random();

		TestConfig tc = new TestConfig();
		try {
			tc.read("config.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		for (int j = 0; j < sheep.length; j++) {
			sheep[j] = new Sheep(column, row);
			gameBoard.setGameBoard(sheep[j].sheep_pos_i, sheep[j].sheep_pos_j,
					"S");
			//gameBoard.display_current_board();
		}
		for (int j = 0; j < wolf.length; j++) {
			wolf[j] = new Wolf(column, row);
			gameBoard.setGameBoard(wolf[j].wolf_pos_i, wolf[j].wolf_pos_j, "W");
			//gameBoard.display_current_board();
		}
		
		for (int j = 0; j < grass.length; j++) {
			grass[j] = new Grass(random.nextInt(8), random.nextInt(8));
			gameBoard.setGameBoard(grass[j].m, grass[j].n, "G");
			//gameBoard.display_current_board();
		}
		for (int j = 0; j < tree.length; j++) {
			tree[j] = new Tree(random.nextInt(8), random.nextInt(8));
			gameBoard.setGameBoard(tree[j].m, tree[j].n, "T");
			//gameBoard.display_current_board();
		}
		gameBoard.display_current_board();
		int i = 0;
		do {
			for (int z = 0; z < sheep.length; z++) {
				if (sheep[z].getAlive()) {
					gameBoard.display_current_board();
					System.out.println("Use Num Key Pad to move Sheep" + z);
					sheep[z].Move_Sheep(gameBoard);
					gameBoard.updateBoard(wolf, sheep, tree, grass);
				}
			}
			i++;
			for (int z = 0; z < wolf.length; z++) {
				wolf[z].Move_Wolf(gameBoard);
			}
			gameBoard.updateBoard(wolf, sheep, tree, grass);
			for (int j = 0; j < sheep.length; j++) {
				for (int k = 0; k < wolf.length; k++) {
					if (wolf[k].wolf_pos_i == sheep[j].sheep_pos_i && wolf[k].wolf_pos_j == sheep[j].sheep_pos_j) {
						sheep[j].setdeath();
					}

				}
			}
			if (game.Check_dead(sheep)) {
			}
		} while (i != game.moves);
		/*if (0 == 1) {
			System.out.println("You Won");
		}*/
	}

	boolean Check_dead(Sheep[] sheep) {
		if (0>=countingSheep(sheep)) {
			System.out.println("You Lost. Sheep Died...");
			return true;
		} else {
			return false;
		}
	}

	int countingSheep(Sheep[] sheep) {
		int sheepAlive = 0;
		for (int w = 0; w < sheep.length; w++) {
			if (sheep[w].getAlive()) {
				sheepAlive++;
			}
		}
		return sheepAlive;
	}
}