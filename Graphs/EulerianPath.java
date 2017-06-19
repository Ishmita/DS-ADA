// EulerianPath.java

class Detect {
	
	private Graph g;
	private LinklistOperations vertices[];
	boolean visited[];
	private int vertexNames[];
	private int indegree[];
	
	public Detect(Graph g) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		indegree = new int[vertices.length];
		for (int i = 0 ;i < vertices.length; i++) {
			indegree[i] = 0;
		}
	}
	
	public void calDegree(int i) {
		LinklistOperations u = vertices[i];
		Node head = u.getHead();
		Node temp = head.getNext();
		
		visited[i] = true;
		while(temp != null) {
			indegree[temp.getData()] += 1;
			if (!visited[temp.getData()]) {
				calDegree(temp.getData());
			}
			temp = temp.getNext();
		} 
	}
	
	public void print() {	
		for (int i = 0 ;i < vertices.length; i++) {
			System.out.println(indegree[i]);
		}
	}
	public boolean checkConnection() {
		int i;
		for (i = 0 ;i < vertices.length; i++) {
			if (indegree[i] > 0) 
				break;
		}
		
		g.DFS(i);
		visited = g.getVisitedList();
		
		for (int j = 0 ;j < vertices.length; j++) {
			if (indegree[j] > 0 && !visited[j]) 
				return false;
		}
		return true;
	}
	
	public int checkDegree() {
		if (checkConnection()) {
			int count = 0;
			
			for (int i = 0 ; i< vertices.length; i++) {
				if ((indegree[i] & 1) != 0) 
					count++;
			}
			
			if (count == 2) {
				return 1;			// Eulerian Path
			}
			
			if (count == 0) {
				return 2;			// Eulerian Cycle
			}
			
			return 0;
			
		} else {
			return 0;
		}
	}

}

class EulerianPath {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g4 = new Graph(vertices, vertexNames);
			
			g4.addEdge(0, 1);
			g4.addEdge(1, 2);
			g4.addEdge(2, 0);
			
			Detect e = new Detect(g4);
			for (int i = 0 ;i < vertices.length; i++) {
				if (!e.visited[i])
					e.calDegree(i);
			}
			
			e.print();
			
			int res = e.checkDegree();
			if (res == 0) 
				System.out.println("Not Eulerian");
			else if (res == 2)
				System.out.println("Eulerian cycle present");
			else if (res == 1)
				System.out.println("Eulerian path present");
	}
}