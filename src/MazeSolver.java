import java.awt.Point;
import java.util.*;

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
			endPoint = new Point(column, row);
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
	
	private static void breadthFirstSearch() {
		
	}
	private static void depthFirstSearch() {
		/*
		    1. Start by putting any one of the graph's vertices on top of a stack.
		    2. Take the top item of the stack and add it to the visited list.
		    3. Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the top of the stack.
		    4. Keep repeating steps 2 and 3 until the stack is empty.
	    */

		// Used to keep track of cells that need to be visited.
		ArrayList<MyCell> visited = new ArrayList<>();
		ArrayList<MyCell> neighbors;
		Stack<MyCell> stack = new Stack<>();
		
		// Starting point
		MyCell start = cellMatrix[startPoint.x][startPoint.y];
		stack.push(start);
		
		// Continue until stack is empty
		while(!stack.isEmpty()) {
			MyCell unvisitedCell = stack.pop();
			// If the given cell is the end, break.
			if(unvisitedCell.isEnd())
				break;
			unvisitedCell.visitCell();
			visited.add(unvisitedCell);
			
			// Get adjacent cells and add them to stack if they haven't been visited
			neighbors = getNeighbors(unvisitedCell);
			for(MyCell neighbor : neighbors) {
				if(!visited.contains(neighbor)) {
					stack.push(neighbor);
				}
			}
		}
	}
	
	private static ArrayList<MyCell> getNeighbors(MyCell cell){
		ArrayList<MyCell> neighbors = new ArrayList<>();
		MyCell neighbor;
		
		int r = cell.index.x;
		int c = cell.index.y;
		
		// North
		if(r - 1 >= 0 ) {
			neighbor = cellMatrix[r - 1][c];
			if(!neighbor.isWall())
				neighbors.add(neighbor);
		}	
		// East
		if(c + 1 < cols) {
			neighbor = cellMatrix[r][c + 1];
			if(!neighbor.isWall())
				neighbors.add(neighbor);
		}
		// South
		if(r + 1 < rows) {
			neighbor = cellMatrix[r + 1][c];
			if(!neighbor.isWall())
				neighbors.add(neighbor);
		}
		// West
		if(c - 1 >= 0) {
			neighbor = cellMatrix[r][c - 1];
			if(!neighbor.isWall())
				neighbors.add(neighbor);
		}
		
		return neighbors;
	}
}
