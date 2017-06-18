// KruskalMST.java

import java.util.*;
class MinimumSpanningTree {
	
	private Graph g;
	private LinklistOperations vertices[];
	private int vertexNames[];
	private ArrayList<Edge> treeEdges;
	private Edge edges[];
	
	public MinimumSpanningTree(Graph g, Edge e[]) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		treeEdges = new ArrayList<Edge>();
		edges = e;
	}

	public void unionfind() {
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(vertices.length , new Comparator<Edge>() {
			public int compare(Edge n1, Edge n2) {
				return n1.getWeight() > n2.getWeight() ? 1 : (n1.getWeight() < n2.getWeight() ? -1 :0 );
			}
		});
		
		for (int i = 0; i < edges.length; i++) {
			queue.add(edges[i]);
		}
		
		DisjointSets d = new DisjointSets();
		int vv[] = new int[vertices.length];
		for (int i = 0 ;i < vertices.length; i++) {
			vv[i] = vertices[i].getHead().getData();
		}
		d.makeSet(vv);
		
		while (queue.size() > 0) {
			Edge e = queue.poll();
			int u = e.getSource();
			int v = e.getDestination();
			if (!d.find(u, v)) {
				treeEdges.add(e);
				d.union(u , v);
			}
		}
	}
	
	public void print() {
		for (int i = 0 ; i < treeEdges.size() ; i++) {
			Edge e = treeEdges.get(i);
			System.out.println(e.getSource() + "->" + e.getDestination());
		}
	}
}

class Edge {
	private int source;
	private int destination;
	private int wt;
	
	public Edge(int s, int d, int w) {
		source = s;
		destination = d;
		wt = w;
	}
	
	public void setSource(int s) {
		source = s;
	}
	
	public void setDestination(int d) {
		destination = d;
	}
	
	public void setWeight(int w) {
		wt = w;
	}
	
	public int getSource() {
		return source;
	}
	
	public int getDestination() {
		return destination;
	}
	
	public int getWeight() {
		return wt;
	}
}	

class Kruskal {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 6, 8, 9};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0,1);
			g.addEdge(1,0);
			g.addEdge(0,3);
			g.addEdge(3,0);
			g.addEdge(3,1);
			g.addEdge(1,3);
			g.addEdge(3,4);
			g.addEdge(4,3);
			g.addEdge(1,4);
			g.addEdge(4,1);
			g.addEdge(1,2);
			g.addEdge(2,1);
			g.addEdge(2,4);
			g.addEdge(4,2);
			
			int wt[][] = {{0 , 2, 999, 6, 999}, 
						  {2, 0 , 3, 8, 5}, 
						  {999, 3, 0, 999, 7}, 
						  {6, 8, 999, 0, 9}, 
						  {999, 5, 7, 9, 0}};
			
			Edge e[] = new Edge[14];
			
			e[0] = new Edge(0,1,0);
			e[1] = new Edge(1,0, 2);
			e[2] = new Edge(0,3,wt[0][3]);
			e[3] = new Edge(3,0, wt[3][0]);
			e[4] = new Edge(3,1,wt[3][1]);
			e[5] = new Edge(1,3, wt[1][3]);
			e[6] = new Edge(3,4,wt[3][4]);
			e[7] = new Edge(4,3,wt[4][3]);
			e[8] = new Edge(1,4, wt[1][4]);
			e[9] = new Edge(4,1,wt[4][1]);
			e[10] = new Edge(1,2, wt[1][2]);
			e[11] = new Edge(2,1, wt[2][1]);
			e[12] = new Edge(2,4,wt[2][4]);
			e[13] = new Edge(4,2,wt[4][2]);

			
			MinimumSpanningTree p = new MinimumSpanningTree(g, e);
			p.unionfind();
			p.print();
	}
}