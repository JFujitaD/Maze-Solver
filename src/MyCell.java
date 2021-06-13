import java.awt.*;
import javax.swing.*;

public class MyCell extends JPanel {
	
	private static final Color DEFAULT_BACKGROUND = Color.WHITE;
	private static final Color VISITED_BACKGROUND = Color.BLUE;
	private static final Color WALL_BACKGROUND = Color.BLACK;
	private static final Color START_BACKGROUND = Color.GREEN;
	private static final Color END_BACKGROUND = Color.RED;
	private static final MyMouseListener LISTENER = new MyMouseListener();
	
	public CellType type = CellType.PATH;
	
	public enum CellType {
		START, PATH, WALL, END, VISITED
	}
	
	public MyCell() {
		setBackground(DEFAULT_BACKGROUND);
		addMouseListener(LISTENER);
	}
	
	public void visitCell() {
		type = CellType.VISITED;
		setBackground(VISITED_BACKGROUND);
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
