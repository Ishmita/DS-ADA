// ShortestPath3.java
// for weighted graph with negative edges
import java.util.*;

class Path {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private int path[];
	private int distance[];
	private int weight[][];
	
	public Path(Graph g, int wt[][]) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		path = new int[vertices.length];
		distance = new int[vertices.length];
		weight = wt;
		for (int i = 0 ; i < vertices.length; i++) {
			distance[i] = 999;
		}
	}
	
	public void mBFS(int i) {
		
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(i);
		distance[i] = 0;
		vertices[i].getHead().setFlag(true);
		
		while(queue.size() >0) {
			int index = queue.get(0);
			LinklistOperations u = vertices[index];
			
			queue.remove(0);
			
			Node head = u.getHead();
			Node temp = head.getNext();
			head.setFlag(false);
			while (temp != null) {
				int newDist = distance[index] + weight[index][temp.getData()];
				
				if (newDist < distance[temp.getData()]) {
					distance[temp.getData()] = newDist;
					path[temp.getData()] = index;
					if (!temp.getFlag()) {
						queue.add(temp.getData());
						temp.setFlag(true);
					}
				}
				temp = temp.getNext();
			}
		}
	}
	
	public void printDistance() {
		for (int i = 0 ;i < distance.length; i++) {
			System.out.println("distance of [" + i + "] from source: " + distance[i]);
		}
	}
}

class ShortestPath3 {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 6, 8};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0,1);
			g.addEdge(1,3);
			g.addEdge(0,2);
			g.addEdge(1,2);
			g.addEdge(3,1);
			g.addEdge(1,4);
			g.addEdge(3,2);
			g.addEdge(4,3);
			
			int wt[][] = {{0 , -1, 4, 999, 999}, 
						  {999, 0 , 3, 2, 2}, 
						  {999, 999, 0, 999, 999}, 
						  {999, 1, 5, 0, 999}, 
						  {999, 999, 999, -3, 0}};
			
			Path p = new Path(g, wt);
			p.mBFS(0);
			p.printDistance();
	}
}