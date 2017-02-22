package pizza;

import java.util.Set;

import matrix.MyMatrix;
import matrix.Rect;

public class Runner {

	public static void main(String[] args) {
		// Params
		String path = "resources/small.in";
		int l = 2;
		int h = 5;
		
		// Play
		MyMatrix<Character> game = new MyMatrix<Character>(path);
		SliceManager manager = new SliceManager(game);
		Set<Rect> set = manager.cut(h, l);

		// # of slices
		System.out.println(set.size() + "slices.");
		// slices
		for (Rect r : set) {
			System.out.println("Slice between rows (" + r.getUL() + ") and columns (" + r.getDR() + ")");
		}

	}

}
