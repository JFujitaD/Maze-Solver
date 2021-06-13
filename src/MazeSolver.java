import java.awt.Point;

public abstract class MazeSolver {
	
	private static MyCell[][] cellMatrix;	// Rows, Columns
	private static Point startPoint;
	private static Point endPoint;
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
		if(startPoint == null) {
			cellMatrix[row][column].changeToStart();
			startPoint = new Point(row, column);
		}
		else {
			cellMatrix[startPoint.x][startPoint.y].changeToPath();
			cellMatrix[row][column].changeToStart();
			startPoint = new Point(row, column);
		}
	}
	
	public static void setEndCell(int row, int column) {
		if(endPoint == null) {
			cellMatrix[row][column].changeToEnd();
			startPoint = new Point(column, row);
		}
		else {
			cellMatrix[endPoint.x][endPoint.y].changeToPath();
			cellMatrix[row][column].changeToEnd();
			endPoint = new Point(row, column);
		}
	}
	
	public static boolean solve(SearchAlgorithm algorithm) {
		if(startPoint != null && endPoint != null) {
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
		/*
		    Start by putting any one of the graph's vertices on top of a stack.
		    Take the top item of the stack and add it to the visited list.
		    Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the top of the stack.
		    Keep repeating steps 2 and 3 until the stack is empty.
	    */

		
	}
}
