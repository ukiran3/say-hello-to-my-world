package edu.calstatela.cs202.gala.RancherGame;

public class Wolf {
	int wolf_pos_i,wolf_pos_j,n,m;
	public Wolf(int n,int m) {
		this.n = n;
		this.m = m;
		wolf_pos_i = 1;
		wolf_pos_j = m-1;
	}
	String[][] Move_Wolf(String a[][]){
		a[wolf_pos_i][wolf_pos_j] = null;
		int change = 0;
		do{
		int move = (int) (Math.ceil(((Math.random() * 10) % n)));
		switch (move) {
		case 1:
			if (wolf_pos_i != (n-1)) {
				wolf_pos_i = wolf_pos_i + 1; // bottom
				change = 1;
			}
			break;
		case 2:
			if (wolf_pos_i != 0) {
				wolf_pos_i = wolf_pos_i - 1; // top
				change = 1;
			}
			break;
		case 3:
			if (wolf_pos_j != (n-1)) {
				wolf_pos_j = wolf_pos_j + 1; // right
				change = 1;
			}
			break;
		case 4:
			if (wolf_pos_j != 0) {
				wolf_pos_j = wolf_pos_j - 1; // left
				change = 1;
			}
			break;
		}
		}while(change != 1);
		a[wolf_pos_i][wolf_pos_j] = "W";
		return a;
	}
}
