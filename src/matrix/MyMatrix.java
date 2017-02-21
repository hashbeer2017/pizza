package matrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MyMatrix<T> implements Matrix<T> {

	private ArrayList<ArrayList<T>> arr = new ArrayList<ArrayList<T>>();
	private int r, c, h, l;

	public MyMatrix(String path) {
		int i = 0;
		try {
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String lines = br.readLine();
			this.r = Character.getNumericValue(lines.charAt(0));
			this.c = Character.getNumericValue(lines.charAt(2));
			this.l = Character.getNumericValue(lines.charAt(4));
			this.h = Character.getNumericValue(lines.charAt(6));

			while (br.ready() && i < getNumRows()) {
				String line = br.readLine();
				ArrayList<T> temp = new ArrayList<T>();
				for (int g = 0; g < line.length(); g++)
					temp.add((T) (line.charAt(g) + ""));
				arr.add(temp);
				i++;
				temp = null;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getNumCols() {
		return this.c;
	}

	public int getNumRows() {
		return this.r;
	}

	public int getL() {
		return this.l;
	}

	public int getH() {
		return this.h;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	private static class Cell<T> {

		T object;
		// boolean taken;

		public Cell(T objetct) {
			this.object = object;
			// this.taken = false;
		}

	}

	public String getMatrix() {
		String res = "";
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(i).size(); j++) {
				res += arr.get(i).get(j);
			}
			res += "\n";
		}
		return res;
	}

	@Override
	public T get(int row, int col) {
		return arr.get(row).get(col);
	}

	public static void main(String[] args) {
		MyMatrix<Cell> m = new MyMatrix<Cell>("small.in");
		System.out.println("Numero di righe: " + m.getNumRows());
		System.out.println("Numero di colonne: " + m.getNumCols());
		System.out.println("L: " + m.getL());
		System.out.println("H: " + m.getH());
		System.out.println();
		System.out.println("Matrice: ");
		System.out.println();
		System.out.println(m.getMatrix());
	}

	@Override
	public ArrayList<T> getRow(int row) {
		return arr.get(row);
	}

}
