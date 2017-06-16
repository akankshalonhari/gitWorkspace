package SamplesProject.examples;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Vector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*** Hello world! ***/

@RestController
@EnableAutoConfiguration
public class App 
{	
	@RequestMapping("/")
    String hello() {
        return "Hello welcome to Akanksha`s world!";
    }
	
    public static void main(String[] args){
        SpringApplication.run(App.class, args);
     
        /*Graph g = new Graph(5);
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
        
        g.printGraph(g);*/
    }   
}

/*
class Graph{
	int V;
	LinkedList<Integer>[] neighbours ; 
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
	
}*/