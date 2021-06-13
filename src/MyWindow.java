import java.awt.*;
import javax.swing.*;

public class MyWindow extends JFrame {
	
	private static final String TITLE = "Maze Solver";
	private static final String INFO = "Information Panel";
	private static final Font FONT = new Font("Serif", Font.BOLD, 64);
	private static final Dimension DIMENSION = new Dimension(1500, 1500);
	private static final Point CELLS = new Point(20, 20);	// Rows, Columns
	private static final Point GAPS = new Point(5, 5);
	private static final Color GRID_BACKGROUND = Color.BLACK;
	private static final Color INFO_BACKGROUND = Color.GRAY;
	
	private static JPanel gridContainer = new JPanel();
	private static JPanel infoContainer = new JPanel();
	
	public MyWindow() {
		
		applyGrid();
		addCells();
		addInfoPanel();
		
		loadWindow();
	}
	
	private void addInfoPanel() {
		JLabel infoLabel = new JLabel();
		infoLabel.setText(INFO);
		infoLabel.setFont(FONT);
		
		infoContainer.setBackground(INFO_BACKGROUND);
		infoContainer.add(infoLabel);
		
		add(infoContainer, BorderLayout.NORTH);
	}
	
	private void applyGrid() {
		
		GridLayout gridLayout = new GridLayout(CELLS.x, CELLS.y, GAPS.x, GAPS.y);
		gridContainer.setBackground(GRID_BACKGROUND);
		gridContainer.setLayout(gridLayout);
	}
	
	private void addCells() {
		
		for(int r = 0; r < CELLS.x; r++) {
			for(int c = 0; c < CELLS.y; c++) {
				gridContainer.add(new MyCell());
			}
		}
		add(gridContainer, BorderLayout.CENTER);
	}
	
	private void loadWindow() {
		
		setTitle(TITLE);
		setSize(DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new MyWindow();
	}

}
