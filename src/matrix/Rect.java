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
		this.downRight = new Coord(cols-1, rows-1);
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
	
	public Set<Rect> getSlices(int h){
		//to do
		return null;
	}
	
	private boolean isLeaf() {
		return this.children.isEmpty();
	}
	
	private boolean isSplittable(int h){
		int width = downRight.col - upperLeft.col;
		int height = downRight.row - upperLeft.row;
		return (width * height) >= h;
	}
	
	/**
	 * Ogni volta che un quadrilatro diventa pi� piccolo di h, esso non va splittato.
	 * H � un parametro dato dalla traccia.
	 * Una volta che il metodo viene chiamato, esso genera tutti i possibili quadrilateri
	 * che soddisfano il vincolo.
	 * Per funzionare, il quadrilatero radice deve essere inizializzato correttamente
	 * @param h
	 */
	private void treeGeneration(int h){
		if (!isSplittable(h))
			return;
		
		if (this.lastSplitDirection == HORIZONTAL) {
			int end = downRight.col;
			int start = upperLeft.col;
			int mid = (end - start) / 2;
			
			children.add(new Rect(upperLeft.row, upperLeft.col, downRight.row, mid, VERTICAL));
			children.add(new Rect(upperLeft.row, mid+1, downRight.row, downRight.col, VERTICAL));
		} else {
			int end = downRight.row;
			int start = upperLeft.row;
			int mid = (end - start) / 2;
			
			children.add(new Rect(upperLeft.row, upperLeft.col, mid, downRight.col, HORIZONTAL));
			children.add(new Rect(mid+1, upperLeft.col, downRight.row, downRight.col, HORIZONTAL));
		}
		
		for(Rect child : children){
			child.treeGeneration(h);
		}
	}

	public Set<Rect> split(int h){
		treeGeneration(h);
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
