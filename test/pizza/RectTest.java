package pizza;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import matrix.MyMatrix;
import matrix.Rect;

public class RectTest {
	MyMatrix game = null;
	Rect rect = null;
	
	@Before
	public void setUp() throws Exception {
		 game = new MyMatrix("resources/small.in");
		 rect = new Rect(game.getRows(), game.getCols());
	}

	@After
	public void tearDown() throws Exception {
		game = null;
		rect = null;
	}

	@Test
	public void testSplit() {
		int h = 5;
		assertTrue(check(rect.split(h)));
		assertEquals(2, 2);
	}

	private static boolean check(Set<Rect> set){
		for(Rect r: set) 
			System.out.println(r.toString());
		
		final int verse = -1;
		Rect res[] = {
				new Rect(0, 0, 0, 2, verse),
				new Rect(0, 3, 0, 6, verse),
				new Rect(1, 0, 2, 0, verse),
				new Rect(1, 1, 2, 2, verse),
				new Rect(1, 3, 2, 4, verse),
				new Rect(1, 5, 2, 6, verse),
				new Rect(3, 0, 3, 2, verse),
				new Rect(3, 2, 3, 6, verse),
				new Rect(4, 0, 5, 0, verse),
				new Rect(4, 1, 5, 2, verse),
				new Rect(4, 3, 5, 4, verse),
				new Rect(4, 5, 5, 6, verse)
		};
		
		if(res.length != set.size())
			return false;
		
		for(Rect r : res){
			if(!set.contains(r))
				return false;
		}
		
		return true;
	}
	
}

