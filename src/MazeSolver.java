
public abstract class MazeSolver {
	
	private static MyCell[][] cellMatrix;	// Rows, Columns
	private static int rows;
	private static int cols;
	
	public static void setMatrix(MyCell[][] matrix) {
		
		cellMatrix = matrix;
		rows = cellMatrix.length;
		cols = cellMatrix[0].length;
	}
}
