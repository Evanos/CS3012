import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class LowComAncTest {
	
	@Test
	public void EdgeTest(){
		LowComAnc test;
		
		test = new LowComAnc(5);
		assertEquals("0, 1, 2, 3, 4, ", test.toString());
		test.Edge(1, 3);
		test.Edge(1, 4);
		assertEquals("0, 1, 3 4 2, 3, 4, ", test.toString());
	
	}
		
	
	@Test
	public void LowComAncTest(){
		LowComAnc test;
		
		test = new LowComAnc(1);
		assertEquals("0, ", test.toString());
		
		test = new LowComAnc(0);
		assertEquals("",test.toString());
		
		test = new LowComAnc(2);
		assertEquals("0, 1, ", test.toString());
	}
	
	@Test (expected=NegativeArraySizeException.class)
	public void LowComAncTestNegative(){
		LowComAnc test = new LowComAnc(-1);
	}
	
	@Test
	public void testLCA(){
		LowComAnc test = new LowComAnc(10);
		test.Edge(0, 1);   //       0
						   //      / \
		test.Edge(0, 3);   //     1   3
		test.Edge(1, 2);   //      \ / \
		test.Edge(3, 2);   //       2   5
		test.Edge(3, 5);   //       |   |
		test.Edge(5, 7);   //       9   7
		test.Edge(2, 9);   //
		
		
		assertEquals("[3, 0]", test.LCA(5, 2).toString());
	    assertEquals("[0]", test.LCA(1, 3).toString());
	    assertEquals("[1]", test.LCA(1, 2).toString());
	    assertEquals("[3, 0]", test.LCA(7, 9).toString());
		
		
		assertEquals(null, test.LCA(-1, 11));
        assertEquals(null, test.LCA(5, -1));
	}
}
