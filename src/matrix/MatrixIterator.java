package matrix;

import java.util.ArrayList;
import java.util.Iterator;

public class MatrixIterator<T> implements Iterator<T>{
	
	private ArrayList<T> currentRow;
	private int nRow;
	private int nCol;

	private int x = 0;
	private int y = 0;
	private MyMatrix<T> matrix;
	 
	public MatrixIterator(MyMatrix<T> matrix) {
		this.currentRow = matrix.arr.get(0);
		
		this.nRow = matrix.arr.size();
		this.nCol = matrix.arr.get(0).size();
		this.matrix = matrix;
	}
	
	@Override
	public boolean hasNext() {
		if(x < currentRow.size())
			return true;
		else
			if(y <= nCol)
				return true;
		
		return false;
	}

	@Override
	public T next() {
		T item =  matrix.get(x, y);
		x++;
		
		if(x > currentRow.size()){
			x = 0;
			y++;
		}
		
		return item;
	}
	
}
