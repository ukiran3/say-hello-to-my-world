package project.thisGuysGame;

public class Grass {
	public String L[];
	public int n,m;

	public Grass(int n, int m) {
		this.n = n;
		this.m = m;
		L = new String[4];
		L[0] = " ";
		L[1] = ".";
		L[2] = ";";
		L[3] = "|";
	}

	String[][] Place_Grass(String a[][]) {
		int count = 0;
		do {
			int i = (int) (Math.ceil(((Math.random() * 10) % (n-1))));
			int j = (int) (Math.ceil(((Math.random() * 10) % (n-1))));
			int Level = (int) (Math.ceil(((Math.random() * 10) % 3)));
			a[i][j] = L[Level];
			count++;
		} while (count != 10);
		return a;
	}

	String[][] Increase_Grass(String a[][]) {
		for (int i = 0; i <= a.length - 1; i++) {
			for (int j = 0; j <= a[i].length - 1; j++) {
				if (a[i][j] != null) {
					switch (a[i][j]) {
					case " ":
						a[i][j] = ".";
						break;
					case ".":
						a[i][j] = ";";
						break;
					case ";":
						a[i][j] = "|";
						break;
					}
				}
			}
		}
		return a;
	}
}
