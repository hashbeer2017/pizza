package matrix;

import java.util.ArrayList;

public interface Matrix<T> extends Iterable<T> {

	public T get(int row, int col);

	public ArrayList<T> getRow(int row);
	// public ArrayList<T> getCol(int col);

}
