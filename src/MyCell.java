import java.awt.*;
import javax.swing.*;

public class MyCell extends JPanel {
	
	private static final Color DEFAULT_BACKGROUND = Color.WHITE;
	private static final Color VISITED_BACKGROUND = Color.GREEN;
	private static final Color WALL_BACKGROUND = Color.BLACK;
	private static final MyMouseListener LISTENER = new MyMouseListener();
	
	public boolean isWall = false;
	
	public MyCell() {
		
		setBackground(DEFAULT_BACKGROUND);
		addMouseListener(LISTENER);
	}
	
	public void visitCell() {
		setBackground(VISITED_BACKGROUND);
	}
	
	public void changeToWall() {
		isWall = true;
		setBackground(WALL_BACKGROUND);
	}
	
	public void changeToPath() {
		isWall = false;
		setBackground(DEFAULT_BACKGROUND);
	}
}
