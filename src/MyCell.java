import java.awt.*;
import javax.swing.*;

public class MyCell extends JPanel {
	
	private static final Color DEFAULT_BACKGROUND = Color.WHITE;
	private static final Color VISITED_BACKGROUND = Color.YELLOW;
	private static final Color WALL_BACKGROUND = Color.BLACK;
	public static final Color START_BACKGROUND = Color.GREEN;
	public static final Color END_BACKGROUND = Color.RED;
	private static final MyMouseListener LISTENER = new MyMouseListener();
	
	private CellType type = CellType.PATH;
	public Point index;
	
	private enum CellType {
		START, PATH, WALL, END, VISITED
	}
	
	public MyCell(int row, int column) {
		setBackground(DEFAULT_BACKGROUND);
		addMouseListener(LISTENER);
		
		index = new Point(row, column);
	}
	
	public void reset() {
		type = CellType.WALL;
		changeToPath();
	}
	
	public boolean isWall() {
		return type == CellType.WALL;
	}
	
	public boolean isVisited() {
		return type == CellType.VISITED || type == CellType.START;
	}
	
	public boolean isEnd() {
		return type == CellType.END;
	}
	
	public void visitCell() {
		if(type == CellType.PATH) {
			type = CellType.VISITED;
			setBackground(VISITED_BACKGROUND);
		}	
	}
	
	public void changeToWall() {
		if(type == CellType.PATH) {
			type = CellType.WALL;
			setBackground(WALL_BACKGROUND);
		}
	}
	
	public void changeToPath() {
		if(type == CellType.WALL) {
			type = CellType.PATH;
			setBackground(DEFAULT_BACKGROUND);
		}
	}
	
	public void changeToStart() {
		type = CellType.START;
		setBackground(START_BACKGROUND);
	}
	
	public void changeToEnd() {
		type = CellType.END;
		setBackground(END_BACKGROUND);
	}
}
