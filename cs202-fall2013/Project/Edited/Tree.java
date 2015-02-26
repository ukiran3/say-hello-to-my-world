package project.thisGuysGame;

public class Tree {
	int tree_pos_i,tree_pos_j,n,m;
	public Tree(int n,int m) {
		this.n = n;
		this.m = m;
	}
	String[][] Place_tree(String a[][]){
		int count = 0;
		do {
			int i = (int) (Math.ceil(((Math.random() * 10) % (n-1))));
			int j = (int) (Math.ceil(((Math.random() * 10) % (m-1))));
			a[i][j] = "T";
			count++;
		} while (count != (n/2));
		return a;
	}
}
