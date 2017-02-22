package matrix;

import java.util.HashSet;
import java.util.Set;

public class Rect {
	private Coord upperLeft;
	private Coord downRight;
	private Set<Rect> children = new HashSet<Rect>();
	private int lastSplitDirection;

	private static final int HORIZONTAL = 0;
	private static final int VERTICAL = 1;

	public Rect(int rows, int cols) {
		this.upperLeft = new Coord(0, 0);
		this.downRight = new Coord(rows-1, cols-1);
		this.lastSplitDirection = VERTICAL;
	}
	
	public Rect(int up, int left, int down, int right, int verse) {
		this.upperLeft = new Coord(up, left);
		this.downRight = new Coord(down, right);
		this.lastSplitDirection = verse;
	}

	public int[] getUL(){
		int res[] = {upperLeft.row, upperLeft.col};
		return res;
	}
	
	public int[] getDR(){
		int res[] = {downRight.row, downRight.col};
		return res;
	}
	
	public int getU() {
		return upperLeft.row;
	}
	
	public int getL() {
		return upperLeft.col;
	}
	
	public int getD() {
		return downRight.row;
	}
	
	public int getR() {
		return downRight.col;
	}
	
	public Set<Rect> getSlices(int h){
		return null;
	}
	
	private boolean isLeaf() {
		return this.children.isEmpty();
	}
	
	private boolean isSplittable(int h){
		int width = (downRight.col - upperLeft.col) + 1;
		int height = (downRight.row - upperLeft.row) + 1;
		int res = width * height;
		return res >= h;
	}
	
	/**
	 * Ogni volta che un quadrilatro diventa più piccolo di h, esso non va splittato.
	 * H è un parametro dato dalla traccia.
	 * Una volta che il metodo viene chiamato, esso genera tutti i possibili quadrilateri
	 * che soddisfano il vincolo.
	 * Per funzionare, il quadrilatero radice deve essere inizializzato correttamente
	 * @param h
	 */
	private void treeGeneration(int h){
		if (isSplittable(h)) {
			if (this.lastSplitDirection == HORIZONTAL) {
				int end = downRight.col;
				int start = upperLeft.col;
				int mid = (end - start) / 2;
				
				children.add(new Rect(upperLeft.row, upperLeft.col, downRight.row, downRight.col - mid - 1, VERTICAL));
				children.add(new Rect(upperLeft.row, upperLeft.col + mid, downRight.row, downRight.col, VERTICAL));
			} else {
				int end = downRight.row;
				int start = upperLeft.row;
				int mid = (end - start) / 2;
				
				children.add(new Rect(upperLeft.row, upperLeft.col, downRight.row - mid, downRight.col, HORIZONTAL));
				children.add(new Rect(upperLeft.row + mid, upperLeft.col, downRight.row, downRight.col, HORIZONTAL));
			}
			
			for(Rect child : children){
				child.treeGeneration(h);
			}
		}
	}

	
	public Set<Rect> split(int h){
		// Genera la struttura ricorsiva.
		treeGeneration(h);
		// Ritorna solo le foglie della struttura ricorsiva
		return loop(this, new HashSet<Rect>());
	}
	
	
	
	private Set<Rect> loop(Rect father, Set<Rect> partialResult){
		for(Rect r : father.children){
			if(r.isLeaf())
				partialResult.add(r);
			else
				loop(r, partialResult);
		}
		return partialResult;
	}
	
	@Override
	public String toString() {
		return "UL: (" + upperLeft.row + "," + upperLeft.col + ") DR: (" + downRight.row + "," + downRight.col + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		Rect other = (Rect) obj;
		return this.upperLeft.equals(other.upperLeft) && this.downRight.equals(other.downRight);
	}
	
	@Override
	public int hashCode() {
		String s = "" + upperLeft.toString() + downRight.toString();
		return Integer.parseInt(s);
	}
	
	private class Coord {
		int row;
		int col;

		public Coord(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public String toString() {
			return row + "" + col;
		}

		@Override
		public boolean equals(Object obj) {
			Coord other = (Coord) obj;
			return this.row == other.row && this.col == other.col;
		}
		
	}
	
}
