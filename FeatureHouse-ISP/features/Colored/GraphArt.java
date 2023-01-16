public class GraphArt{
   private List<Integer> colors;
	
	public void add(int node1, int node2, int weight){
    	original(node1,node2,weight);
        colors = new ArrayList<Integer>();
        for (int i = 0; i < 30; i++) {
        	colors.add(0 + (int)(Math.random() * (ConsoleColors.COLOR_ARRAY.length - 1)));
        }
    }
	
	public String toColorAdjMatrix() {
  		private String[] COLOR_ARRAY = {"BLACK","RED","GREEN","YELLOW","BLUE","PURPLE","CYAN","WHITE"};
		
        StringBuilder out = new StringBuilder("  ");
        for (int i = 0; i < n; i++) {
            out.append(COLOR_ARRAY[colors.get(i)][0]);
            out.append(i).append(" ");
        }
        out.append("\n");
        for (int i = 0; i < n; i++) {
            out.append(COLOR_ARRAY[colors.get(i)][0]);
            out.append(i).append(" ");
            for (int j = 0; j < n; j++) {
                out.append(edgeList.get(i).get(j)).append(" ");
            }
            out.append("\n");
        }
        return String.valueOf(out);
	}
		
}