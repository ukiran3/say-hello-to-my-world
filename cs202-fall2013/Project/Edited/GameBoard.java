package project.thisGuysGame;

public class GameBoard {
	String gameBoard[][];
	int rows, columns;

	public GameBoard(int x, int y) {
		gameBoard = new String[x][y];
		this.rows = y;
		this.columns = x;
	}

	void display_current_board() {
		for (int x = 0; x < columns; x++) {
			for (int y = 0; y < rows; y++) {
				if (gameBoard[x][y] != null) {
					System.out.print("[" + gameBoard[x][y] + "]");
				} else {
					System.out.print("[ ]");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}

	void setGameBoard(int x, int y, String string) {
		this.gameBoard[x][y] = string;
	}

	String get_current_status(int i, int j) {
		return gameBoard[i][j];
	}

	void updateBoard(Wolf[] wolf, Sheep[] sheep, Tree[] tree, Grass[] grass) {
		for (int x = 0; x <= columns; x++) {
			for (int y = 0; y <= rows; y++) {
/*
				for (int j = 0; j < grass.length; j++) {
					if (grass[j]grass. == x && grass[j].n == y) {
						gameBoard[x][y] = "G";
					}
				}
				for (int j = 0; j < tree.length; j++) {
					if (tree[j].m == x && tree[j].n == x) {
						this.gameBoard[x][y] = "T";
					}
				}
*/				for (int j = 0; j < sheep.length; j++) {
					if (sheep[j].sheep_pos_i == x && sheep[j].sheep_pos_j == y && sheep[j].getAlive()) {
						this.gameBoard[x][y] = "S";
					}
				}
				for (int j = 0; j < wolf.length; j++) {
					if (wolf[j].wolf_pos_i == x && wolf[j].wolf_pos_j == y) {
						this.gameBoard[x][y] = "W";
					}
				}
			}
		}

	}
}