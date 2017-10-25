import java.util.*;

//source: https://www.youtube.com/watch?v=fjT3WDKiAkI

class Graph{
	class Edge{
		int v,w;
		public Edge(int v, int w){
			this.v=v; this.w=w;
		}
		@Override
		public String toString(){
			return "(" + v +","+w+")";
		}
	}
	List<Edge> g[];
	public Graph(int n){
		g=new LinkedList[n];
		for(int i =0;i<g.length;i++){
			g[i]=new LinkedList<Edge>();
		}
	}
	boolean isConnected(int u, int v){
		for(Edge i: g[u]){
			if(i.v==v) return true;}
			return false;
	}
	
	void addEdge(int u ,int v, int w){
		g[u].add(0, new Edge(v,w));
	}
	
	@Override
	public String toString(){
		String result = "";
		for(int i = 0 ; i < g.length;i++){
			result+=i+"=>"+g[i] + "\n";
		}
		return result;
			
	}
}
public class LowComAnc{
	public static void main (String[] args){
		Graph G = new Graph(10);
		G.addEdge(0,2,10);
		G.addEdge(0,5,15);
		G.addEdge(2,5,10);
		G.addEdge(9,3,16);
		
		
		System.out.println(G);;
		System.out.println(G.isConnected(2,3));
		System.out.println(G.isConnected(9,16));
		
	}
}