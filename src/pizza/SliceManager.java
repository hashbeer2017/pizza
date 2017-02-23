package pizza;

import java.util.HashSet;
import java.util.Set;

import matrix.MyMatrix;
import matrix.Slice;

public class SliceManager {
	private static final char TOMATO = 'T';
	private static final char MUSHROOM = 'M';
	
	private MyMatrix<Character> game;
	private Slice rect;
	
	public SliceManager(MyMatrix<Character> game) {
		this.game = game;
		this.rect = new Slice(game.getNumRows(), game.getNumCols());
	}
	
	public Set<Slice> cut(int h, int l) {
		Set<Slice> result = new HashSet<Slice>();
		
		// Tagliamo la pizza
		Set<Slice> initialSlices = rect.split(h);
		
		// Filtriamo i pezzi della pizza che vanno mantenuti
		for(Slice slice : initialSlices){
			int tomatoes = 0;
			int mushrooms = 0;
			
			for(int row = slice.getU(); row <= slice.getD(); row++){
				for(int col = slice.getL(); col <= slice.getR(); col++){
					char item = (char) game.get(row, col);
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
