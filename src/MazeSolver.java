import java.awt.Point;

public abstract class MazeSolver {
	
	private static MyCell[][] cellMatrix;	// Rows, Columns
	private static MyCell startCell;
	private static MyCell endCell;
	private static int rows;
	private static int cols;
	
	public enum SearchAlgorithm {
		BREADTH_FIRST, DEPTH_FIRST
	}
	
	public static void setMatrix(MyCell[][] matrix) {
		cellMatrix = matrix;
		rows = cellMatrix.length;
		cols = cellMatrix[0].length;
	}
	
	public static void setStartCell(int row, int column) {
		cellMatrix[row][column].changeToStart();
	}
	
	public static void setEndCell(int row, int column) {
		cellMatrix[row][column].changeToEnd();		
	}
	
	public static boolean solve(SearchAlgorithm algorithm) {
		if(startCell != null && endCell != null) {
			switch(algorithm) {
				case BREADTH_FIRST:
					breadthFirstSearch();
					break;
				case DEPTH_FIRST:
					depthFirstSearch();
			}
			return true;
		}
		return false;
	}
	
	public static void breadthFirstSearch() {
		
	}
	public static void depthFirstSearch() {
		
	}
}
