import java.awt.*;
import javax.swing.*;

public class MyWindow extends JFrame {
	
	private static final String TITLE = "Maze Solver";
	private static final Dimension DIMENSION = new Dimension(1000, 1000);
	private static final Point CELLS = new Point(10, 10);	// Rows, Columns
	private static final Point GAPS = new Point(10, 10);
	private static final Color BACKGROUND = Color.black;
	private static JPanel gridContainer;
	
	public MyWindow() {
		
		setTitle(TITLE);
		setSize(DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		applyGrid();
		addCells();
	}
	
	private void applyGrid() {
		
		GridLayout gridLayout = new GridLayout(CELLS.x, CELLS.y, GAPS.x, GAPS.y);
		gridContainer = new JPanel();
		gridContainer.setBackground(BACKGROUND);
		
		add(gridContainer, BorderLayout.CENTER);
		gridContainer.setLayout(gridLayout);
	}
	
	private void addCells() {
		
		for(int r = 0; r < CELLS.x; r++) {
			for(int c = 0; c < CELLS.y; c++) {
				gridContainer.add(new MyCell());
			}
		}
	}
	
	public static void main(String[] args) {
		
		new MyWindow();
	}

}
