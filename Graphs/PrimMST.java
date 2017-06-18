// PrimMST.java
import java.util.*;
class MinimumSpanningTree {
	
	private Graph g;
	private LinklistOperations vertices[];
	private boolean visited[];
	private int vertexNames[];
	private int path[];
	private int distance[];
	private int weight[][];
	private ArrayList<Integer> treeNodes;
	
	public MinimumSpanningTree(Graph g, int wt[][]) {
		this.g = g;
		vertices = g.getVertices();
		vertexNames = g.getVertexNames();
		visited = g.getVisitedList();
		path = new int[vertices.length];
		distance = new int[vertices.length];
		weight = wt;
		treeNodes = new ArrayList<Integer>();
		for (int i = 0 ; i < vertices.length; i++) {
			distance[i] = 999;
		}
	}
	
	public void mBFS(int i) {
		PriorityQueue<QueueNode> queue = new PriorityQueue<QueueNode>(vertices.length , new Comparator<QueueNode>() {
			public int compare(QueueNode n1, QueueNode n2) {
				return n1.getDistance() > n2.getDistance() ? 1 : (n1.getDistance() < n2.getDistance() ? -1 :0 );
			}
		});
		
		distance[i] = 0;
		QueueNode n = new QueueNode(i , distance[i]);
		queue.add(n);
		
		
		while (queue.size() > 0) {
			
			QueueNode top = queue.poll();
			if (!treeNodes.contains(top.getIndex())) {
				treeNodes.add(top.getIndex());
				
				int index = top.getIndex();
				LinklistOperations u = vertices[top.getIndex()];
				Node head = u.getHead();
				Node temp = head.getNext();
				
				while(temp!= null) {
					int newDist = distance[index] + weight[index][temp.getData()];
					
					if (distance[temp.getData()] == 999) {
						path[temp.getData()] = index;
						distance[temp.getData()] = weight[index][temp.getData()];
						QueueNode n1 = new QueueNode(temp.getData() , distance[temp.getData()]);
						queue.add(n1);
					}
					
					if (distance[temp.getData()] > newDist) {
						path[temp.getData()] = index;
						distance[temp.getData()] = weight[index][temp.getData()];
						
						Iterator it = queue.iterator();
						QueueNode n2 = null;
						while(it.hasNext()) {
							n2 = (QueueNode) it.next();
							if (n2.getIndex() == temp.getData()) {
								n2.setDistance(distance[temp.getData()]);
							}
						}
					}
					temp = temp.getNext();
				}
			}
		}	
	}
	
	public void printDistance() {
		for (int i = 0 ;i < vertices.length; i++) {
			System.out.println("distance of [" + i + "] from source: " + distance[i]);
			//System.out.println(treeNodes.get(i));
		}
	}
}

class PrimMST {
	
	public static void main(String s[]) {
			int vertexNames[] = {1, 4, 5, 6, 8, 9};
			
			LinklistOperations vertices[] = new LinklistOperations[vertexNames.length];
			
			for (int i = 0; i < vertexNames.length; i++) {
				vertices[i] = new LinklistOperations();
				vertices[i].insertEnd(i);
			}
			
			Graph g = new Graph(vertices, vertexNames);
			
			g.addEdge(0,1);
			g.addEdge(1,0);
			g.addEdge(0,3);
			g.addEdge(3,0);
			g.addEdge(3,1);
			g.addEdge(1,3);
			g.addEdge(3,4);
			g.addEdge(4,3);
			g.addEdge(1,4);
			g.addEdge(4,1);
			g.addEdge(1,2);
			g.addEdge(2,1);
			g.addEdge(2,4);
			g.addEdge(4,2);
			
			int wt[][] = {{0 , 2, 999, 6, 999}, 
						  {2, 0 , 3, 8, 5}, 
						  {999, 3, 0, 999, 7}, 
						  {6, 8, 999, 0, 9}, 
						  {999, 5, 7, 9, 0}};
			
			MinimumSpanningTree p = new MinimumSpanningTree(g, wt);
			p.mBFS(0);
			p.printDistance();
	}
}