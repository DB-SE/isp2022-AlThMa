package interfaces;

import main.GraphArt;

public interface IOutput {
	
	public String toAdjMatrix(GraphArt graph);
	public void print(GraphArt graph);

}