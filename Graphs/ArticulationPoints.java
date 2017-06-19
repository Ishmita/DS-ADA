// ArticulationPoints.java
// Time Complexity: O(v+e)

import java.util.*;

class Points {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private ArrayList<Integer> vertex;
	private int time;
	private int low[];
	private int descoveryTime[];
	private int parent[];
	private int numV;
	
	public Points(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		numV = vertices.length;
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		vertex = new ArrayList<Integer>();
		low = new int[numV];
		parent = new int[numV];
		descoveryTime = new int[numV];
		for (int i = 0 ;i < numV; i++) {
			low[i] = 0;
			parent[i] = -1;
			descoveryTime[i] = 0;
		}
	}
	
	public void mDFS(int i) {
		
		LinklistOperations u = vertices[i];
		Node head = u.getHead();
		Node temp = head.getNext();
		
		visited[i] = true;
		descoveryTime[i] = low[i] = time++;
		
		int child = 0;
		
		while (temp != null) {
			int j = temp.getData();
			if (!visited[j]) {
				parent[j] = i;
				child++;
				
				mDFS(j);
				
				low[i] = Math.min(low[i], low[j]);
				if (parent[i]!= -1 && low[j] >= descoveryTime[i]) 
					vertex.add(i);
				if (parent[i] == -1 && child > 1) 
					vertex.add(i);
			} else if (j != parent[i]){
				low[i] = Math.min(low[i], descoveryTime[j]);
			}
			temp = temp.getNext();
		}
	}
	
	public void addEdge(int i , int j) {
		if (i >= 0 && j >=0 && i < vertices.length && j < vertices.length) {
			vertices[i].insertEnd(j);
			vertices[j].insertEnd(i);
		}
	}
	
	public void print() {
		for (Integer i: vertex) {
			System.out.println(vertexNames[i]);
		}
	}
}


class ArticulationPoints {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 6,7,3,2,8};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0,1);
			g.addEdge(0,4);
			g.addEdge(1,2);
			g.addEdge(1,3);
			g.addEdge(1,0);
			g.addEdge(2,1);
			g.addEdge(2,3);
			g.addEdge(3,1);
			g.addEdge(3,2);
			g.addEdge(4,0);
			g.addEdge(4,5);
			g.addEdge(4,7);
			g.addEdge(5,4);
			g.addEdge(5,7);
			g.addEdge(5,6);
			g.addEdge(6,5);
			g.addEdge(7,5);
			g.addEdge(7,4);
			
			Points p = new Points(g);
			p.mDFS(0);
			p.print();
					
	}
}