package pizza;

import java.util.Set;

import matrix.MyMatrix;
import matrix.Slice;

public class Runner {

	public static void main(String[] args) {
		// Params
		String path = "resources/small.in";
		int l = 2;
		int h = 5;
		
		// Play
		MyMatrix<Character> game = new MyMatrix<Character>(path);
		SliceManager manager = new SliceManager(game);
		Set<Slice> set = manager.cut(h, l);

		// # of slices
		System.out.println(set.size() + " slices.");
		// slices
		for (Slice r : set) {
			int[] ul = r.getUL();
			int[] dr = r.getDR();
			System.out.println("Slice between rows (" + ul[0] + ", " + ul[1] + ") and columns (" + dr[0] + ", " + dr[1] + ")");
		}

	}

}
