import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyWindow extends JFrame {
	
	private static final String TITLE = "Maze Solver";
	private static final String INFO = "Press SOLVE when ready";
	private static final Font FONT = new Font("Serif", Font.BOLD, 64);
	private static final Dimension DIMENSION = new Dimension(1500, 1500);
	private static final Point CELLS = new Point(25, 20);	// Rows, Columns
	private static final Point GAPS = new Point(5, 5);
	private static final Color GRID_BACKGROUND = Color.BLACK;
	private static final Color INFO_BACKGROUND = Color.GRAY;
	private static final Color BUTTON_BACKGROUND = Color.GRAY;
	
	public static JLabel infoLabel = new JLabel(INFO);
	public static boolean leftClickDown = false;
	public static boolean rightClickDown = false;
	
	public MyWindow() {
		loadGrid();
		addInfoPanel();
		addButtonPanel();
		
		// Testing Matrix
		MazeSolver.setStartCell(2, 4);
		MazeSolver.setEndCell(24, 19);
		// Testing Matrix
		
		loadWindow();
	}
	
	private void addInfoPanel() {
		infoLabel.setFont(FONT);
		
		JPanel infoContainer = new JPanel();
		infoContainer.setBackground(INFO_BACKGROUND);
		infoContainer.add(infoLabel);
		
		add(infoContainer, BorderLayout.NORTH);
	}
	
	private void addButtonPanel() {	
		JButton solveButton = new JButton("Solve");
		solveButton.setFont(FONT);
		solveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean solvable = MazeSolver.solve(MazeSolver.SearchAlgorithm.DEPTH_FIRST);
				
				if(solvable)
					infoLabel.setText("Maze has been solved");
				else
					infoLabel.setText("Maze is unsolvable");
			}
		});
		
		JPanel buttonContainer = new JPanel();
		buttonContainer.setBackground(BUTTON_BACKGROUND);
		buttonContainer.add(solveButton);
		
		add(buttonContainer, BorderLayout.SOUTH);
	}
	
	private void loadGrid() {
		GridLayout gridLayout = new GridLayout(CELLS.x, CELLS.y, GAPS.x, GAPS.y);
		
		JPanel gridContainer = new JPanel();
		gridContainer.setBackground(GRID_BACKGROUND);
		gridContainer.setLayout(gridLayout);
		
		addCells(gridContainer);
	}
	
	private void addCells(JPanel gridContainer) {
		MyCell[][] cellMatrix = new MyCell[CELLS.x][CELLS.y];	// Rows, Columns
		
		for(int r = 0; r < CELLS.x; r++) {
			for(int c = 0; c < CELLS.y; c++) {
				MyCell cell = new MyCell(r, c);
				gridContainer.add(cell);
				cellMatrix[r][c] = cell;
			}
		}
		add(gridContainer, BorderLayout.CENTER);
		MazeSolver.setMatrix(cellMatrix);
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
