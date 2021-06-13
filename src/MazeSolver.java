import java.awt.Point;

public abstract class MazeSolver {
	
	private static MyCell[][] cellMatrix;	// Rows, Columns
	private static int rows;
	private static int cols;
	
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
}
