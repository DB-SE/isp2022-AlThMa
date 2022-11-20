import java.util.Arrays;
import java.util.List;


public class GraphRoot {
	
	public static void main(String[] args) {
	
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2, 6),
                new Edge(2, 3, 9),
                new Edge(4, 3, 4),
                new Edge(4, 5, 4),
                new Edge(1, 6, 3),
                new Edge(6, 7, 2),
                new Edge(7, 8, 8),
                new Edge(8, 9, 8),
                new Edge(1, 9, 9),
                new Edge(6, 9, 9),
                new Edge(2, 6, 4),
                new Edge(3, 7, 9),
                new Edge(3, 8, 7),
                new Edge(0, 8, 9),
                new Edge(0, 3, 5),
                new Edge(0, 4, 1),
                new Edge(0, 5, 3),
                new Edge(8, 5, 10),
                new Edge(9, 5, 18),
                new Edge(6, 8, 9),
                new Edge(2, 7, 2)
        );
        int n = 10;
        
		GraphArt graph = new GraphArt(edges, n);
		
		// #if DFS 
		//graph.tiefensuche();
		// #endif
		
		// #if MST 
//@		graph.minimalTree(graph);
		// #endif
		
		System.out.println(graph.toAdjMatrix());
		
		// Farb Test
		System.out.println(ConsoleColors.RED + "RED COLORED" +
				ConsoleColors.RESET + " NORMAL");
	
	}
}
