
 import java.util.ArrayList;
import java.util.List;

//the source of this code is http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
/*   New Branch created    */
 
class Node {
    int data;
    Node left, right;
 
    Node(int value) {
        data = value;
        left = right = null;
    }
}
 
public class LowComAnc 
{
    Node root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();
 
    int findLCA(int x, int y) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, x, y);
    }
 
    private int findLCAInternal(Node root, int x, int y) {
 
        if (!findPath(root, x, path1) || !findPath(root, y, path2)) {
            return -1;
        }
 
        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
 
        return path1.get(i-1);
    }
 
    private boolean findPath(Node root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }
 
        path.add(root.data);
 
        if (root.data == n) {
            return true;
        }
 
        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }
 
        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }
 
        path.remove(path.size()-1);
 
        return false;
    }
    
    public static void main(String[] args){
    	System.out.print("Test for new branch");
    }

}
