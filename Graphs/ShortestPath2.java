// ShortestPath2.java
// for weighted graphs without negative wts

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
			distance[i] = -1;
		}
	}
	
	public void mBFS(int i) {
		PriorityQueue<QueueNode> queue = new PriorityQueue<QueueNode>(vertices.length, new Comparator<QueueNode>() {
			public int compare(QueueNode n1, QueueNode n2) {
				return n1.getDistance() > n2.getDistance()? 1 : (n1.getDistance() < n2.getDistance() ? -1 : 0);
			}
		});
		
		distance[i] = 0;
		QueueNode n = new QueueNode(i, distance[i]);
		// priority queue initially comtainsonly one element i.e. source with distance 0
		queue.add(n);
		
		while (queue.size() > 0) {
			try {
				QueueNode top = queue.poll();
				int index = top.getIndex();
				
				LinklistOperations u = vertices[index];
				Node head = u.getHead();
				Node temp = head.getNext();
				

				while(temp!=null) {
					int newDist = distance[index] + weight[index][temp.getData()];
					// if encountered first time, add to priority queue with new distance as priority
					if (distance[temp.getData()] == -1) {
						path[temp.getData()] = index;
						distance[temp.getData()] = newDist;
						QueueNode n1 = new QueueNode(temp.getData() , distance[temp.getData()]);
						queue.add(n1);
					}
					// if update required, lookup the required object from priority queue and update distance
					if (distance[temp.getData()] > newDist) {
						Iterator it = queue.iterator();
						QueueNode n2 = null;
						while(it.hasNext()) {
							n2 = (QueueNode) it.next();
							if (n2.getIndex() == temp.getData()) {
								n2.setDistance(newDist);
							}
						}
						path[temp.getData()] = index;
						distance[temp.getData()] = newDist;
					}
					temp = temp.getNext();
				}	
			} catch(Exception e){
				e.printStackTrace();
			}			
		}
	}
	
	public void printDistance() {
		for (int i = 0 ;i < distance.length; i++) {
			System.out.println("distance of [" + i + "] from source: " + distance[i]);
		}
	}
}

class QueueNode {
	
	private int index;
	private int distance;
	
	public QueueNode(int i , int d) {
		index = i;
		distance = d;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setDistance(int dist) {
		distance = dist;
	}
	
	public int getDistance() {
		return distance;
	}
}

class ShortestPath2 {
	
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
			g.addEdge(3,4);
			
			int wt[][] = {{0 , 2, 999, 999, 8 , 999}, 
						  {999, 0 , 999, 3, 999, 999}, 
						  {999, 999, 0, 999, 999, 1}, 
						  {999, 999, 999, 0, 1, 999}, 
						  {999, 999, 999, 999, 0, 999},
						  {999, 999, 999, 999, 2, 0}};
			
			Path p = new Path(g, wt);
			p.mBFS(0);
			p.printDistance();
	}
}