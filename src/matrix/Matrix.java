package matrix;

public interface Matrix<T> extends Iterable<T>{
	
	public T get(int row, int col);

}
