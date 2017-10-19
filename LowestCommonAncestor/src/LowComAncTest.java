import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class LowComAncTest {

	@Test	
	public void testFindLCA(){
		LowComAnc tree = new LowComAnc();
		//Testing empty tree, should return -1
		assertEquals("Testing LCA on empty tree",-1, tree.findLCA(1, 2));
		
		tree.root = new Node(1);
		//test on non present nodes, should return -1
		assertEquals("Testing LCA on non present",-1, tree.findLCA(2,1));
		
		LowComAnc tree2 = new LowComAnc();
		//test on multi-node tree
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);
        tree2.root.right.left = new Node(6);
        tree2.root.right.right = new Node(7);
        
        assertEquals("Testing multi-node tree", 2, (int)tree2.findLCA(4,5));
	    assertEquals("Testing multi-node tree", 1, (int)tree2.findLCA(4,6));
	    assertEquals("Testing multi-node tree", -1, (int)tree2.findLCA(4,8));
	    assertEquals("Testing multi-node tree", 2, (int)tree2.findLCA(2,5));
	    assertEquals("Testing multi-node tree", 3, (int)tree2.findLCA(6,7));
		   
	}
		
}

