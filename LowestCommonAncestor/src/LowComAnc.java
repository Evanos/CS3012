import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LowComAnc {
    public static final int UNUSED = 0;
    public static final int USING= 1;
    public static final int COMPLETE = 2;

    private final ArrayList<Integer>[] graph;  
  
    public void Edge(int v, int w) {
        if (v >= 0 && v < graph.length && w >= 0 && w < graph.length)
            Edge(graph, v, w);
        else System.out.println("Edge " + v + "->" + w + " ignored due to non-existent vertex.");
    }

    
    private void Edge(ArrayList<Integer>[] graph, int v, int w) {
        ArrayList<Integer> adjList = graph[v]; 
        if (!adjList.contains(w)) {
            adjList.add(w);
            if (containsCycle()) {
                for (int i = 0; i < adjList.size(); i++) {
                    if (adjList.get(i) == w)
                        adjList.remove(i);
                }
                System.out.println("Cycle-completing edge " + v + "->" + w + " ignored.");
            }
        }
        else System.out.println("Duplicate edge " + v + "->" + w + " ignored.");
    }

    public LowComAnc(int v) {
        graph = (ArrayList<Integer>[]) new ArrayList[v];
        for (int i = 0; i < v; i++)
            graph[i] = new ArrayList<Integer>();
    }

    
    public boolean containsCycle() {
        int[] vertices =  new int[graph.length];
        Arrays.fill(vertices, UNUSED);

        for (int v = 0; v < graph.length; v++) {
            if (containsCycle(v, vertices))
                return true;
        }
        return false;
    }

    
    private boolean containsCycle(int vertex, int[] vertices) {
        switch (vertices[vertex]) {
            case USING:  
                return true;
            case COMPLETE:       
                return false;
            case UNUSED:
                vertices[vertex] = USING;
        }

        ArrayList<Integer> adjList = graph[vertex]; 
        for (int v : adjList) { 
            if (containsCycle(v, vertices))
                return true;
        }
        vertices[vertex] = COMPLETE; 
        return false;
    }

   
    public ArrayList<Integer> LCA(int v1, int v2) {
        ArrayList<Integer> LCA = new ArrayList<Integer>();
        if (v1 == v2) {
            LCA.add(v1);
            return LCA;
        }
        if (v1 < 0 || v1 >= graph.length || v2 < 0 || v2 >= graph.length) {
            return null;
        }

        ArrayList<Integer>[] parentTable = reverse(graph);

        boolean[] v1Ancestors = new boolean[graph.length];
        Arrays.fill(v1Ancestors, false);

        v1Ancestors[v1] = true;
        for (int v : parentTable[v1]) {
            FindAnc(parentTable, v1Ancestors, v);
        }

        Queue<Integer> currentLevel = new LinkedList<Integer>();
        Queue<Integer> nextLevel = new LinkedList<Integer>();
        for (int v : parentTable[v2])
            currentLevel.add(v);

        while (!currentLevel.isEmpty()) {
            while (!currentLevel.isEmpty()) {
                int v = currentLevel.remove();

                if (v1Ancestors[v])
                    LCA.add(v);

                if (LCA.isEmpty()) {
                    for (int w : parentTable[v])
                        nextLevel.add(w);
                }
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Integer>();
        }

        return LCA;
    }

   
    private void FindAnc(ArrayList<Integer>[] parentTable, boolean[] v1Ancestors, int vertex) {
        v1Ancestors[vertex] = true;
        for (int v : parentTable[vertex]) {
            FindAnc(parentTable, v1Ancestors, v);
        }
    }

    
    private ArrayList<Integer>[] reverse(ArrayList<Integer>[] graph) {
        ArrayList<Integer>[] reversed = (ArrayList<Integer>[]) new ArrayList[graph.length];
        for (int i = 0; i < reversed.length; i++)
            reversed[i] = new ArrayList<Integer>();
        
        for (int v = 0; v < graph.length; v++) {
            for (int w : graph[v])
                Edge(reversed, w, v);
        }
        return reversed;
    }

   
    public String toString() {
        return toString(graph);
    }

    private String toString(ArrayList<Integer>[] graph) {
        String string = "";
        for (int v = 0; v < graph.length; v++) {
            string += v + ", ";
            for (int vertex : graph[v]) 
                string += vertex + " ";
        }
        return string;
    }

}