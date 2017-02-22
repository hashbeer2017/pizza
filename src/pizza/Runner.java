package pizza;

import java.util.Set;

import matrix.MyMatrix;
import matrix.Rect;

public class Runner {

	public static void main(String[] args) {
		// Inizializzare la matrice
		MyMatrix game = new MyMatrix("resources/small.in");

		// Associare un rect alla matrice
		Rect rect = new Rect(game.getNumRows(), game.getNumCols());

		// Effettuare lo split, considerare solo i nodi foglia.

		// Verificare se i nodi foglia vanno presi o vanno scartati

		Set<Rect> set = rect.getSlices(game.getH());

		// # of slices
		System.out.println(set.size() + "slices.");
		// slices
		for (Rect r : set) {
			System.out.println("Slice between rows (" + r.getUL() + ") and columns (" + r.getDR() + ")");
		}

	}

}
