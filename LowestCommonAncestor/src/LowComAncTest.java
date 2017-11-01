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
		
}
