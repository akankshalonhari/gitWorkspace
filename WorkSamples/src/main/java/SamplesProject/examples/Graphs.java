package SamplesProject.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graphs {

	public Graphs(){
	    /*  Graph g = new Graph(5);
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 0);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 2);
	        g.addEdge(3, 4);
	        g.addEdge(4, 3);
	        
	    * graph with 5 nodes for distance not working  
	     *  g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 0);
	        g.addEdge(1, 4);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 2);
	        g.addEdge(3, 4);
	        g.addEdge(4, 1);
	        g.addEdge(5, 3); 
	        
	        g.printGraph(g);
	        
	        System.out.print("BFS starting from node 2 :");
	        g.BFS(1);
	        System.out.print("DFS starting from node 2 :");
	        g.DFStraversal(1);
	        //System.out.print("Shortest paths starting from node 0 :");        
	        g.shortestPathsToAllVertex(0); 
	        
	         System.out.println(" path exists? : " + g.searchAB(g, 1, 4));
	        */
	}
}
/*
class Graph{
	int V;
	LinkedList<Integer>[] neighbours ; 
	StringBuilder bfs = new StringBuilder();
	StringBuilder dfs = new StringBuilder();
	public Graph(int vertices){
		this.V = vertices;
		this.neighbours = new LinkedList[vertices];
		for(int i=0; i<vertices ;i++){
			neighbours[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int a, int b){
		neighbours[a].add(b);
	}
	
	void printGraph(Graph g){
		for(int j=0; j<g.V ; j++){
			System.out.println("Vertex: " + j + " neighbors: " + Arrays.toString(neighbours[j].toArray()));
		}
	}
	
	// Implementing Dijkstra`s algorithm to find minimum distance path to each vertex //
	void shortestPathsToAllVertex(int start){
		int[] dist = new int[V];
		boolean[] visited = new boolean[V];
		for(int i=0; i<dist.length;i++){
			dist[i] = Integer.MAX_VALUE;
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(visited));
	
		dist[start] = 0;
		
		for(int j=0; j<V-1; j++){
			System.out.println(" j "+ j);
			System.out.println(Arrays.toString(dist));
			System.out.println(Arrays.toString(visited));
			
			int next = minDist(dist, visited);
			System.out.println(" min dis " + next);
			visited[next]= true;
			
			for(int v=0; v<V ; v++){
				System.out.println(Arrays.toString(dist));
				System.out.println(Arrays.toString(visited));
			
				if(!visited[v] && dist[next] != Integer.MAX_VALUE && ((dist[next]+1)< dist[v])){
					System.out.println(" dist[v] " + dist[v] + " dist[next] " + dist[next]);
					dist[v] = dist[next] + 1;
				}
			}
		}
		
		System.out.print("Shortest paths starting from node 0 :" + Arrays.toString(dist));   
	}
	
	int minDist(int[] dist, boolean[] visited){
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		
		for(int v=0; v<V ; v++){
			if(visited[v]==false && dist[v] <= min){
				min = dist[v];
				min_index=v;
			}
		}
		return min_index;
	}
	
	// find if there is a path between A and B in given graph //
	public boolean searchAB(Graph g, int a, int b){
		if(a == b)
			return true;
		
		HashMap<Integer , Boolean> visited = new HashMap<Integer, Boolean>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(a); //adding the next element to be explored
		visited.put(a, true); //keeping track of the current element already visited
		int start = -1;
		while(!queue.isEmpty()){
			start = queue.remove();
			if(start != -1){
				for(int neighbor : neighbours[start]){
					if(!visited.containsKey(neighbor)){ //checks if current neighbor is in visited list
						if(neighbor == b){
							return true;
						} else {
							queue.add(neighbor); //adding the next neighbor to be explored
							visited.put(neighbor, true); //keeping track of the current neighbor already visited
						}
					}
				}
			}
		}
		return false;
 	}
	
	void BFS(int start){
		boolean[] visited = new boolean[V]; //defaulting all vertices to false i.e un-visited 
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.add(start);
		//System.out.println(" start " + start);
		//System.out.println(" visited " + Arrays.toString(visited));
		
		while(queue.size() != 0){
			//System.out.println(" queue " + queue.toString());
			start = queue.remove();
			bfs.append(" -> " + start);
			//System.out.println(" dequed"+ start);
			Iterator<Integer> itr = neighbours[start].listIterator();
			while(itr.hasNext()){
				//System.out.println(" queue " + queue.toString());
				int next = itr.next();
				//System.out.println(" next " + next);
				if(!visited[next]){
					visited[next] = true;
					//System.out.println(" visited " + Arrays.toString(visited));
					queue.add(next);
				}
			}
		}
		System.out.println(" BFS " + bfs);
	}


	void DFS(int start, boolean[] visited){
		visited[start] = true;
		dfs.append(" -> " + start );
		Iterator<Integer> itr = neighbours[start].listIterator();
		while(itr.hasNext()){
			int next = itr.next();
			//System.out.println("next :" + next);
			//System.out.println(" visited " + Arrays.toString(visited));
			if(!visited[next])
				DFS(next, visited);
		}
	}
	
	void DFStraversal(int start){
		boolean[] visited = new boolean[V];
		
		DFS(start, visited);
		System.out.println(" DFS " + dfs);
	}
}*/