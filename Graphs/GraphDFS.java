// GraphDFS.java
// Time Complexity : O(v+e) 

class Graph {
	private LinklistOperations[] vertices;
	private boolean visited[];
	private int vertexNames[];
	
	Graph(LinklistOperations v[], int vn[]) {
		vertices = v;
		visited = new boolean[v.length];
		for (int i =0; i < v.length ; i++) {
			visited[i] = false;
		}
		vertexNames = vn;
	}
	
	public void addEdge(int i , int j) {
		if (i >= 0 && j >=0 && i < vertices.length && j < vertices.length) {
			vertices[i].insertEnd(j);
			vertices[j].insertEnd(i);
		}
	}
	
	public boolean isConnected(int i , int j) {
		LinklistOperations u = vertices[i];
		Node head = u.getHead();
		
		Node temp = head;
		while (temp != null) {
			if (temp.getData() == j) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}
	
	public void DFS(int index) {
		LinklistOperations u = vertices[index];
		Node temp = u.getHead();
		System.out.println(vertexNames[temp.getData()]);
		visited[index] = true;
		
		temp = temp.getNext();
		while (temp != null) {
			if (!visited[temp.getData()]) {
				DFS(temp.getData());
			}
			temp = temp.getNext();
		}
	}
}

class GraphDFS {
	
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
			
			System.out.println(g.isConnected(2,3));
			System.out.println(g.isConnected(4,5));
			System.out.println(g.isConnected(1,0));
			g.DFS(0);

	}
}