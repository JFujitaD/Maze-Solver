import java.awt.*;

import javax.swing.*;

public class MyWindow extends JFrame {
	
	private static final String TITLE = "Maze Solver";
	public static final String INFO = "Press SOLVE when ready";
	private static final Font FONT1 = new Font("Serif", Font.BOLD, 64);
	private static final Font FONT2 = new Font("Serif", Font.PLAIN, 32);
	private static final Dimension DIMENSION = new Dimension(1500, 1500);
	private static final Point CELLS = new Point(10, 10);	// Rows, Columns
	private static final Point GAPS = new Point(5, 5);
	private static final Color GRID_BACKGROUND = Color.BLACK;
	private static final Color INFO_BACKGROUND = Color.GRAY;
	private static final Color BUTTON_BACKGROUND = Color.GRAY;
	
	private static final MyButtonActionListener BUTTON_LISTENER = new MyButtonActionListener();
	private static final MyMenuActionListener MENU_LISTENER = new MyMenuActionListener();
	
	public static JLabel infoLabel = new JLabel(INFO);
	public static boolean leftClickDown = false;
	public static boolean rightClickDown = false;
	public static boolean startSelectMode = false;
	public static boolean goalSelectMode = false;
	
	public MyWindow() {
		loadGrid();
		addInfoPanel();
		addButtonPanel();
		addMenu();
		
		loadWindow();
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
	
	private void addInfoPanel() {
		infoLabel.setFont(FONT1);
		
		JPanel infoContainer = new JPanel();
		infoContainer.setBackground(INFO_BACKGROUND);
		infoContainer.add(infoLabel);
		
		add(infoContainer, BorderLayout.NORTH);
	}
	
	private void loadWindow() {
		setTitle(TITLE);
		setSize(DIMENSION);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	private void addButtonPanel() {	
		GridLayout gridLayout = new GridLayout(1, 4);	// Rows, Columns
		
		JButton setStartButton = new JButton("Select Start");
		setStartButton.setFont(FONT2);
		setStartButton.setBackground(MyCell.START_BACKGROUND);
		setStartButton.addActionListener(BUTTON_LISTENER);
		
		JButton setGoalButton = new JButton("Select Goal");
		setGoalButton.setFont(FONT2);
		setGoalButton.setBackground(MyCell.END_BACKGROUND);
		setGoalButton.addActionListener(BUTTON_LISTENER);
		
		JButton solveButton = new JButton("Solve");
		solveButton.setFont(FONT2);
		solveButton.addActionListener(BUTTON_LISTENER);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setFont(FONT2);
		resetButton.addActionListener(BUTTON_LISTENER);
		
		JPanel buttonContainer = new JPanel();
		buttonContainer.setBackground(BUTTON_BACKGROUND);
		buttonContainer.setLayout(gridLayout);
		buttonContainer.add(setStartButton);
		buttonContainer.add(setGoalButton);
		buttonContainer.add(resetButton);
		buttonContainer.add(solveButton);
		
		add(buttonContainer, BorderLayout.SOUTH);
	}
	
	private void addMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Actions");
		menu.setFont(FONT2);
		
		JMenuItem randomWalls = new JMenuItem("Random Walls");
		randomWalls.setFont(FONT2);
		randomWalls.addActionListener(MENU_LISTENER);
		
		menu.add(randomWalls);
		menuBar.add(menu);
		
		setJMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		new MyWindow();
	}

}
