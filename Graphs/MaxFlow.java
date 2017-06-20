// MaxFlow.java
// Time Complexity: O(V(E^2))

import java.util.*;
class Flow {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private int parent[];
	private int maxFlow = 0;
	private int residue[][];
		
	public Flow(Graph g, int residue[][]) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		parent = new int[vertices.length];
		
		for (int i = 0 ; i < vertices.length; i++) {
			parent[i] = -1;
		}
		this.residue = residue;
	}
	
	public void mBFS(int index, int goal) {
		
		while (true) {
			boolean found = false;
			for (int i = 0 ; i < vertices.length; i++) {
				visited[i] = false;
				parent[i] = -1;
			}
			
			ArrayList<Integer> queue = new ArrayList<Integer>();
			queue.add(index);
			visited[index] = true;
			
			System.out.println("next bfs");
			
			while (queue.size()> 0) {
				int top = queue.get(0);
				LinklistOperations u = vertices[top];
				Node head = u.getHead();
				Node temp = head.getNext();
				System.out.println(top);
				
				queue.remove(0);
				while(temp != null) {
					int j = temp.getData();
					if (!visited[j] && residueCap(top , j) >0) {
						parent[j] = top;
						if (j == goal) {
							found = true;
							break;
						}
						queue.add(j);
						visited[j] = true;
					}
					temp = temp.getNext();
				}
				if (found) {
					break;
				}
			}
			if (!found) {
				break;
			} else {
				int min = calMaxFlow(index,goal);
				updateResideCap(min, index, goal);
			}
		}
	}
	
	private int residueCap(int source , int destination) {
		return residue[source][destination];
	}
	
	private int calMaxFlow(int source,int goal) {
		int i = goal;
		int min= 999;
		while (i != source) {
			int r = residueCap(parent[i], i);
			System.out.println("from: "+parent[i]+ " to: "+i);			
			if (min > r) 
				min = r;
			i = parent[i];
		}
		System.out.println("min after bfs: "+min);
		maxFlow += min;
		return min;
	}
	
	private void updateResideCap(int min, int source, int goal) {
		int i = goal;
		while (i != source) {
			System.out.println("from: "+parent[i]+ " to: "+i);			
			System.out.println("initial residue: "+residue[parent[i]][i]);			
			
			residue[parent[i]][i] -= min;
			residue[i][parent[i]] += min;
			System.out.println("updated residue, p -> i: "+residue[parent[i]][i]);			
			System.out.println("initial residue, i -> p: "+residue[i][parent[i]]);			

			i = parent[i];
		}
	}
	
	public int getMaxFlow() {
		return maxFlow;
	}
}

class MaxFlow {
	public static void main(String s[]) {
		int vertexNames[] = {1, 4, 5, 9, 7, 6, 2};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g2 = new Graph(vertices, vertexNames);
			// Undirected graph required
			g2.addEdge(0, 1);
			g2.addEdge(0, 3);
			g2.addEdge(1, 2);
			g2.addEdge(2, 4);
			g2.addEdge(2, 3);
			g2.addEdge(2, 0);
			g2.addEdge(3, 4);
			g2.addEdge(3, 5);
			g2.addEdge(4, 1);
			g2.addEdge(4, 6);
			g2.addEdge(5, 6);
			
			int resid[][] = {{-1, 3, 0, 3, -1, -1, -1}, 
						 {0, -1, 4, -1, 0, -1, -1}, 
						 {3, 0, -1, 1, 2, -1, -1}, 
						 {0, -1, 0, -1, 2, 6, -1}, 
						 {-1, 1, 0, 0, -1, -1, 1}, 
						 {-1, -1, -1, 0, -1, -1, 9}, 
						 {-1, -1, -1, -1, 0 , 0, -1}};
			
			Flow f = new Flow(g2, resid);
			f.mBFS(0, 6);
			System.out.println("Max flow: "+ f.getMaxFlow());
	}
}