package pizza;

import matrix.MyMatrix;
import matrix.Rect;

public class Runner {

	public static void main(String[] args) {
		// Inizializzare la matrice
		MyMatrix game = new MyMatrix("resources/small.in");
		
		// Associare un rect alla matrice
		Rect rect = new Rect(game.getRows(), game.getCols());
		
		
		// Effettuare lo split, considerare solo i nodi foglia.
		
		// Verificare se i nodi foglia vanno presi o vanno scartati
		
	}

}
