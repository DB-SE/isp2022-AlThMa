public class Main {
	
  	public String toAdjMatrix() {
  		
        StringBuilder out = new StringBuilder("  ");
        out.append("\n");
        for (int i = 0; i < n; i++) {
            out.append(i).append(" ");
            for (int j = 0; j < n; j++) {
                out.append(edgeList.get(i).get(j)).append(" ");
            }
            out.append("\n");
        }
        return String.valueOf(out);
	}
}