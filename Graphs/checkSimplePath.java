// CheckSimplePath.java

class SimplePath {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private int res = 1;
	private int count = 0;
	
	public SimplePath(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
	}
	
	public int mDFS(int source, int dest) {
		
		if (source == dest) {
			return 0;
		}
		
		LinklistOperations u = vertices[source];
		Node head = u.getHead();
		Node temp = head.getNext();
		
		visited[source] = true;
		
		while (temp != null) {
			System.out.println("head: "+ head.getData()+" temp: "+ temp.getData() + " is visited: " + visited[temp.getData()]);			
			if (!visited[temp.getData()]) {
				res = mDFS(temp.getData() , dest);
				if (res == 0) {
					count++;
					res = 1;
				}
			}
			temp = temp.getNext();
		}
		visited[source] = false;
		return res;
	}
	
	public int getCount() {
		return count;
	}
}

class CheckSimplePath {
	
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
			
			SimplePath p = new SimplePath(g);
			int res = p.mDFS(2, 3);
			int c = p.getCount();
			if (c == 0) {
				System.out.println("no simple path");
			} else {
				System.out.println("simple path exists");
				System.out.println("no of simple paths: "+c);
			}
			
	}
}