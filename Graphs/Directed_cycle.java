// Directed_cycle.java

// visited -> 0 (Undescovered)
// visited -> 1 (Under exploration)
// visited -> 2 (Explored)

class Detect {
	private Graph g;
	private LinklistOperations vertices[];
	private int visited[];
	private int vertexNames[];
	private int res = 0;
	
	public Detect(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = new int[vertices.length];
		for (int i = 0; i< vertices.length; i++) {
			visited[i] = 0;
		}
	}
	
	
	public int mDFS(int i) {
		LinklistOperations u = vertices[i];
		Node head = u.getHead();
		Node temp = head.getNext();
		
		visited[i] = 1;
		while(temp != null) {
			if (visited[temp.getData()] == 1) {
				// cycle present
				return -1;
			} else if (visited[temp.getData()] == 0){
				res = mDFS(temp.getData());
				if (res == -1)
					return res;
			}
			temp = temp.getNext();
		}
		visited[i] = 2;
		return res;
	}
}

class Directed_cycle {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0, 1);
			g.addEdge(0,2);
			g.addEdge(1, 2);
			
			Detect p = new Detect(g);
			int res = p.mDFS(0);
			if (res == -1)
				System.out.println("cycle present");
			else 
				System.out.println("cycle not present");				
	}
}