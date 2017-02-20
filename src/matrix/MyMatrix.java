package matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MyMatrix<T> implements Matrix<T> {

	ArrayList<ArrayList<T>> arr = new ArrayList<ArrayList<T>>();
	Cell c = null;

	public MyMatrix(String path) {
		int r, c, h, l = 0;
		ArrayList<T> mat = new ArrayList<>();
		try {
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuffer sb = new StringBuffer();
			int cont = 0;
			String lines = br.readLine();
			
			while (br.ready()) {
				String line = br.readLine();

			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	private class Cell<T> {

		T object;
		// boolean taken;

		public Cell(T objetct) {
			this.object = object;
			// this.taken = false;
		}

	}

	@Override
	public T get(int row, int col) {
		ArrayList<T> a = arr.get(row);
		return a.get(col);
	}

}
