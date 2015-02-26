package project.thisGuysGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Sheep {
	int sheep_pos_i, sheep_pos_j, n, m;
	boolean alive = true;

	public Sheep(int n, int m) {
		this.n = n;
		this.m = m;
		Random ran = new Random();
		sheep_pos_i = ran.nextInt(n);
		sheep_pos_j = ran.nextInt(m);
	}

	void Move_Sheep(GameBoard gameBoard) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int move = 0, proceed = 0;
		gameBoard.setGameBoard(sheep_pos_i, sheep_pos_j, null);
		do {
			try {
				move = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
			} catch (IOException e) {
			}
			switch (move) {
			case 2:
				if (sheep_pos_i != n - 1) {
					sheep_pos_i = sheep_pos_i + 1; // bottom
				}
				break;
			case 8:
				if (sheep_pos_i != 0){
					sheep_pos_i = sheep_pos_i - 1; // top
				}
				break;
			case 6:
				if (sheep_pos_j != m - 1){
					sheep_pos_j = sheep_pos_j + 1; // right
				}
				break;
			case 4:
				if (sheep_pos_j != 0) {
					sheep_pos_j = sheep_pos_j - 1; // left
				}
				break;
			}
			String h = gameBoard.get_current_status(sheep_pos_i, sheep_pos_j);
			if (h == "T") {
				System.out.println("Sheep Can't climb a Tree");
				proceed = 1;
			} else {
				if (h == "W") {
					System.out.println("Sheep Can't Commit Sucide");
					proceed = 1;
				}else{
					proceed = 0;
				}
			}
		} while (proceed != 0);
		gameBoard.setGameBoard(sheep_pos_i,sheep_pos_j,"S");
	}
	void setdeath(){
		this.alive = false;
	}
	boolean getAlive(){
		return alive;
	}
}