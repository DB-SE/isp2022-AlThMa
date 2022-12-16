package main;

import java.util.Arrays;
import java.util.List;

import interfaces.IAlgorithms;
import interfaces.IEdges;
import interfaces.INodeMarkers;

import loader.PluginLoader;

public class GraphRoot {
	
	public static void main(String[] args) {
        
		int n = 10;
		GraphArt graph = new GraphArt(n);
		
		graph.add(1, 2, 6);
        graph.add(2, 3, 9);
        graph.add(4, 3, 4);
        graph.add(4, 5, 4);
        graph.add(1, 6, 3);
        graph.add(6, 7, 2);
        graph.add(7, 8, 8);
        graph.add(8, 9, 8);
        graph.add(1, 9, 9);
        graph.add(6, 9, 9);
        graph.add(2, 6, 4);
        graph.add(3, 7, 9);
        graph.add(3, 8, 7);
        graph.add(0, 8, 9);
        graph.add(0, 3, 5);
        graph.add(0, 4, 1);
        graph.add(0, 5, 3);
        graph.add(8, 5, 10);
        graph.add(9, 5, 18);
        graph.add(6, 8, 9);
        graph.add(2, 7, 2);
        
        graph.addNode(new Node());
        
        System.out.println(graph.toAdjMatrix());
		
		System.out.println("Ausgaben:");
		
		List<IAlgorithms> algorithmusPlugins = PluginLoader.load(IAlgorithms.class);
		System.out.println(algorithmusPlugins.toString());
		for (IAlgorithms algorithms : algorithmusPlugins) { 
			algorithms.run(graph);
		}
		
		System.out.println("\n Ende des Programms");
	}
}
