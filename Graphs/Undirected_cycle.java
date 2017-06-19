// Undirected_cycle.java

class Detect {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private int parent[];
	private int res = 0;
		
	public Detect(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		parent = new int[vertices.length];
		for (int i = 0 ;i<vertices.length; i++) {
			parent[i] = -1;
		}
	}
	
	
	public int mDFS(int i) {
		LinklistOperations u = vertices[i];
		Node head = u.getHead();
		Node temp = head.getNext();
		
		visited[i] = true;
		while(temp != null) {
			if (visited[temp.getData()] && parent[i] != temp.getData()) {
				return -1;
			} else if (!visited[temp.getData()]){
				parent[temp.getData()] = i;
				res = mDFS(temp.getData());
				if (res == -1) {
					return -1;
				}
			}
			temp = temp.getNext();
		}
		return res;
	}
}

class Undirected_cycle {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 6};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0,1);
			g.addEdge(0,2);
			g.addEdge(1,3);
			g.addEdge(2, 1);
			
			Detect p = new Detect(g);
			int res = p.mDFS(0);
			if (res == -1)
				System.out.println("cycle present");
			else 
				System.out.println("cycle not present");
				
					
	}
}