// ReverseGraph.java

/** 
* Important to make new vertices, 
* otherwise g and g2 both will contain
* the same object's reference id and any
* changes made from g2 will be reflected
* to g's vertices too.
* Time Complexity: O(v+e)
*/

class Reverse {
	
	private Graph g, g2;
	private LinklistOperations vertices[], vertices2[];
	private boolean visited[];
	private int vertexNames[], vertexNames2[];
	
	public Reverse(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		vertices2 = new LinklistOperations[vertices.length];
		vertexNames2 = new int[vertices.length];
		
		for (int i = 0 ;i < vertices.length; i++) {
			vertexNames2[i] = vertexNames[i];
			vertices2[i] = new LinklistOperations();
			vertices2[i].insertEnd(i);
		}
		g2 = new Graph(vertices2, vertexNames2);
	}
	
	public void mDFS(int i) {
		
		LinklistOperations u = vertices[i];
		Node head = u.getHead();
		Node temp = head.getNext();
		
		visited[i] = true;
		while (temp != null) {
			g2.addEdge(temp.getData() , head.getData());
			if (!visited[temp.getData()]) {
				mDFS(temp.getData());
			}
			temp = temp.getNext();
		}
	}
	
	public Graph getReversedGraph() {
		return g2;
	}
}

class ReverseGraph {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 7, 8, 9};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0, 1);
			g.addEdge(0,2);
			g.addEdge(1, 2);
			
			System.out.println(g.isConnected(1,0));
			System.out.println(g.isConnected(0,1));
			System.out.println(g.isConnected(1,2));
			System.out.println(g.isConnected(2,1));
			System.out.println(g.isConnected(0,2));
			System.out.println(g.isConnected(2,0));
			
			Reverse r = new Reverse(g);
			r.mDFS(0);
		
			System.out.println("g2's connections: ");
			Graph g2 = r.getReversedGraph();
			System.out.println(g2.isConnected(1,0));
			System.out.println(g2.isConnected(0,1));
			System.out.println(g2.isConnected(1,2));
			System.out.println(g2.isConnected(2,1));
			System.out.println(g2.isConnected(0,2));
			System.out.println(g2.isConnected(2,0));
			
	}
}
