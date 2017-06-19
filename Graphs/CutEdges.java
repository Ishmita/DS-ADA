//CutEdges.java
import java.util.*;
// Time Complexity: O(e*(v+e))

class Points {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private int count;
	private int pos = 1;
	private ArrayList<Edge> edges;
	
	public Points(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		edges = new ArrayList<Edge>();
	}
	
	public void countPoints() {
		
		for (int index = 0 ; index < vertices.length; index++) {
			pos = 1;
			LinklistOperations u = vertices[index];
			Node head = u.getHead();
			Node temp = head.getNext();
			int adjListlLen = 0;
			pos = 0;
			
			while (temp != null) {
				adjListlLen++;
				temp = temp.getNext();
			}
			
			while (pos != adjListlLen) {
				Node deletedNode = u.delPosition(2);
				System.out.println("edge deleted between: " + head.getData() +" and: "+ deletedNode.getData());
				count = 0;
				for (int i = 0 ;i < vertices.length; i++) {
					if (!visited[i]) {
						visited[i] = true;
						DFS(i);
						System.out.println();
						count++;
					}
				}
				
				if (count > 1) {
					Edge e = new Edge(head.getData(), deletedNode.getData());
					edges.add(e);
				}
				addEdge(head.getData(), deletedNode.getData());
				System.out.println("edge added between: " + head.getData() +" and: "+ deletedNode.getData());				

				pos++;
				for (int i = 0  ;i < vertices.length; i++) {
					visited[i] = false;
				}
			}
		}
	}
	
	public void addEdge(int i , int j) {
		if (i >= 0 && j >=0 && i < vertices.length && j < vertices.length) {
			vertices[i].insertEnd(j);
			//vertices[j].insertEnd(i);
		}
	}
	
	public void DFS(int index) {
		LinklistOperations u = vertices[index];
		Node temp1 = u.getHead();
		System.out.println(temp1.getData());
		visited[index] = true;
		
		temp1 = temp1.getNext();
		while (temp1 != null) {
			if (!visited[temp1.getData()]) {
				DFS(temp1.getData());
			}
			temp1 = temp1.getNext();
		}
	}
	
	public void print() {
		for (Edge e: edges) {
			System.out.println(e.getSource() +"->"+ e.getDestination());
		}
	}
}

class Edge {
	private int source;
	private int destination;
	
	public Edge(int s, int d) {
		source = s;
		destination = d;
	}
	
	public void setSource(int s) {
		source = s;
	}
	
	public void setDestination(int d) {
		destination = d;
	}
	
	public int getSource() {
		return source;
	}
	
	public int getDestination() {
		return destination;
	}
}	

class CutEdges {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 6};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0,2);
			g.addEdge(0,3);
			g.addEdge(0,1);
			g.addEdge(2,0);
			g.addEdge(2,1);
			g.addEdge(1,3);
			
			Points p = new Points(g);
			p.countPoints();
			p.print();
					
	}
}