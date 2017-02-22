package pizza;

import java.util.HashSet;
import java.util.Set;

import matrix.MyMatrix;
import matrix.Rect;

public class SliceManager {
	private static final char TOMATO = 'T';
	private static final char MUSHROOM = 'M';
	
	private MyMatrix<Character> game;
	private Rect rect;
	
	public SliceManager(MyMatrix<Character> game) {
		this.game = game;
		this.rect = new Rect(game.getNumRows(), game.getNumCols());
	}
	
	public Set<Rect> cut(int h, int l) {
		Set<Rect> result = new HashSet<Rect>();
		
		// Tagliamo la pizza
		Set<Rect> initialSlices = rect.split(h);
		
		// Filtriamo i pezzi della pizza che vanno mantenuti
		for(Rect slice : initialSlices){
			int tomatoes = 0;
			int mushrooms = 0;
			
			for(int row = slice.getU(); row < slice.getD(); row++){
				for(int col = slice.getL(); col < slice.getR(); col++){
					char item = game.get(row, col);
					if (item == TOMATO){
						tomatoes++;
					} else if (item == MUSHROOM) {
						mushrooms++;
					}
				}
			}
			
			if(tomatoes >= l && mushrooms >= l){
				result.add(slice);
			}
		}
		
		return result;
	}
}
