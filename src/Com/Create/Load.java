package Com.Create;

import java.util.Scanner;

public class Load {
	public static Integer[][] loadint(String fname, int x, int y) {
//		File f = new File(Load.class.getResourceAsStream(name));
		Integer[][] value = new Integer[x][y];
		@SuppressWarnings("resource")
		Scanner load = new Scanner(Load.class.getResourceAsStream("/Com/Create/" + fname));

		int i = 0;
		int j = 0;
		while (load.hasNextInt()) {
			if (x == i) {
				j++;
				i = 0;
			}
			value[i][j] = load.nextInt();
			i++;
		}
		return value;
	}
}
