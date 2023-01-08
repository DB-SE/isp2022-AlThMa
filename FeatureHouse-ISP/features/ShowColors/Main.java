
public class Main {
	@Override
  	public String toAdjMatrix() {
  		
        StringBuilder out = new StringBuilder("  ");
        for (int i = 0; i < n; i++) {
            out.append(ConsoleColors.COLOR_ARRAY[colors.get(i)][0]);
            out.append(i).append(" ");
        }
        out.append("\n");
        for (int i = 0; i < n; i++) {
            out.append(ConsoleColors.COLOR_ARRAY[colors.get(i)][0]);
            out.append(i).append(" ");
            out.append(ConsoleColors.RESET);
            for (int j = 0; j < n; j++) {
                out.append(edgeList.get(i).get(j)).append(" ");
            }
            out.append(ConsoleColors.RESET);
            out.append("\n");
        }
        out.append(ConsoleColors.RESET);
        return String.valueOf(out);
	}
}