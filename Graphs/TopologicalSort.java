// TopologicalSort.java
// Time Complexity: O(v*(v+e))

import java.util.*;

class Sort {
	private Graph g;
	private int[] indegree;
	private ArrayList<Integer> queue; 
	private LinklistOperations[] vertices;
	boolean[] visited;
	private int[] vertexNames;
	
	public Sort(Graph g) {
		this.g = g;
		indegree = new int[g.getVertices().length];
		for (int i = 0;i< indegree.length;i++) {
			indegree[i] = 0;
		}
		vertexNames = g.getVertexNames();
		this.vertices = g.getVertices();
		visited = g.getVisitedList();
		queue = new ArrayList<Integer>();
	}
	
	public void calIndegree(int index) {
		LinklistOperations u = vertices[index];
		Node temp = u.getHead();
		//System.out.println(vertexNames[temp.getData()]);
		visited[index] = true;
		
		temp = temp.getNext();
		while (temp != null) {
			indegree[temp.getData()] += 1;
			calIndegree(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public void topologicalSort() {
		
		for (int i = 0; i< vertices.length; i++) {
			System.out.println("indegree[" + i +  "]: "+ indegree[i]);
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while (queue.size() > 0) {
			int index = queue.remove(0);
			LinklistOperations u = vertices[index];
			
			Node head = u.getHead();
			System.out.println(vertexNames[head.getData()]);
			Node temp = head.getNext();
			
			while(temp != null) {
				indegree[temp.getData()] -= 1;
				if (indegree[temp.getData()] == 0) {
					queue.add(temp.getData());
				}
				temp = temp.getNext();
			}
		}
	}
}

class TopologicalSort {
	public static void main(String str[]) {
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
			
			Sort s = new Sort(g);
			for (int i = 0; i < vertices.length; i++) {
				if (!s.visited[i]) {
					s.calIndegree(i);				
				}
			}
			s.topologicalSort();
	}
}