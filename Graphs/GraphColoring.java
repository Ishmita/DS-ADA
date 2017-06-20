// GraphColoring.java
// Time Complexity: O(V^2 + E)

import java.util.*;

class Coloring {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private int color[];
	private int k = 0;
		
	public Coloring(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		color = new int[vertices.length];
	}
	
	public void mBFS(int i) {
		
		ArrayList<Integer> queue = new ArrayList<Integer>();
		queue.add(i);

		while (queue.size() > 0) {
			int top = queue.get(0);
			LinklistOperations u = vertices[top];
			Node head = u.getHead();
			Node temp = head.getNext();
			visited[top] = true;
			ArrayList<Integer> connections = new ArrayList<Integer>();
			
			queue.remove(0);
			int max = -1, min = vertices.length;
			while (temp != null) {
				int j = temp.getData();
				connections.add(j);
				if (color[j] != -1 && color[j] > max) {
					max = color[j];
				} else if (color[j] != -1 && color[j] < min) {
					min = color[j];
				}
				if (!visited[j]) {
					queue.add(j);
				}
				temp = temp.getNext();
			}
			color[top] = calColor(min, max, connections);
		}
	}
	
	public int calColor(int min, int max, ArrayList<Integer> con) {
		boolean flag = true;
		for (int i = min; i < max; i++) {
			flag = true;
			Iterator it = con.iterator();
			while (it.hasNext()) {
				int u = (Integer)it.next();
				if (color[u] == i) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}
		return max+1;
	}
	
	public void print() {
		for (int i = 0 ;i < vertices.length; i++) {
			System.out.println("Color of: " + i+ " is: "+color[i]);
		}
	}
}

class GraphColoring {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 9, 7};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g2 = new Graph(vertices, vertexNames);
			
			g2.addEdge(0, 1);
			g2.addEdge(0, 2);
			g2.addEdge(1, 2);
			g2.addEdge(1, 4);
			g2.addEdge(2, 4);
			g2.addEdge(4, 3);
			
			Coloring c = new Coloring(g2);
			c.mBFS(0);
			c.print();
	}
}	