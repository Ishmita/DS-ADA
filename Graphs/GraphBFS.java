// GraphBFS.java
// Time Complexity : O(v+e) 
import java.util.*;

class Graph {
	private LinklistOperations[] vertices;
	private boolean visited[];
	private int vertexNames[];

	Graph(LinklistOperations v[], int vn[]) {
		vertices = v;
		visited = new boolean[v.length];
		for (int i =0; i < v.length ; i++) {
			visited[i] = false;
		}
		vertexNames = vn;
	}
	
	public LinklistOperations[] getVertices() {
		return vertices;
	} 
	
	public boolean[] getVisitedList() {
		return visited;
	}
	
	public int[] getVertexNames() {
		return vertexNames;
	}
	
	public void addEdge(int i , int j) {
		if (i >= 0 && j >=0 && i < vertices.length && j < vertices.length) {
			vertices[i].insertEnd(j);
			//vertices[j].insertEnd(i);
		}
	}
	
	public boolean isConnected(int i , int j) {
		LinklistOperations u = vertices[i];
		Node head = u.getHead();
		
		Node temp = head;
		while (temp != null) {
			if (temp.getData() == j) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public void DFS(int index) {
		LinklistOperations u = vertices[index];
		Node temp = u.getHead();
		System.out.println(vertexNames[temp.getData()]);
		visited[index] = true;
		
		temp = temp.getNext();
		while (temp != null) {
			if (!visited[temp.getData()]) {
				DFS(temp.getData());
			}
			temp = temp.getNext();
		}
	}
	
	public void bfs(int index) {
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(index);
		int level = 0, count = 1;
		
		while (queue.size() > 0) {
			try {
				LinklistOperations u = vertices[queue.get(0)];
				visited[queue.get(0)] = true;
				queue.remove(0);
				count--;
								
				Node head = u.getHead();
				Node temp = head.getNext();
				System.out.println(head.getData() + " at level: " + level);
								
				if (count == 0) {
					level += 1; 
				}
				
				while (temp != null) {
					if (!visited[temp.getData()]) {
						queue.add(temp.getData());
					}
					temp = temp.getNext();
				}
				
				if (count == 0 && queue.size() != 0) {
					count = queue.size();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}

class GraphBFS {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 6, 8, 9};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0,4);
			g.addEdge(1,3);
			g.addEdge(0,1);
			g.addEdge(5,4);
			g.addEdge(2,5);
			
			System.out.println(g.isConnected(2,3));
			System.out.println(g.isConnected(4,5));
			System.out.println(g.isConnected(1,0));
			//g.DFS(0);
			g.bfs(0);
	}
}