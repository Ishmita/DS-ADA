// ShortestPath1.java
// for unweighted graphs
// Time Complexity: O(v+e)

import java.util.*;
class DistanceCal {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private int path[];
	private int distance[]; 
	
	public DistanceCal(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		path = new int[vertices.length];
		distance = new int[vertices.length];
		
		for (int i = 0 ; i < vertices.length; i++) {
			distance[i] = -1;
		}
	}
	
	public void mBFS(int i) {
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(i);
		distance[i] = 0;
		
		while (queue.size() > 0) {
			try {
				int index = queue.get(0);
				
				LinklistOperations u = vertices[index];
				visited[index] = true;
				queue.remove(0);
				Node head = u.getHead();
				Node temp = head.getNext();
				
				System.out.println(head.getData());

				while(temp!=null) {
					if (!visited[temp.getData()]) {
						queue.add(temp.getData());
						path[temp.getData()] = index;
						distance[temp.getData()] = distance[index] + 1;
					}
					temp = temp.getNext();
				}	
			} catch(Exception e){
				e.printStackTrace();
			}			
		}
	}
	
	public void printDistance() {
		for (int i = 0 ;i < distance.length; i++) {
			System.out.println("distance of [" + i + "] from source: " + distance[i]);
		}
	}
}

class ShortestPath1 {
	
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
			
			DistanceCal p = new DistanceCal(g);
			p.mBFS(0);
			p.printDistance();
	}
}