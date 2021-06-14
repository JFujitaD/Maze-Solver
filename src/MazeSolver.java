import java.awt.Point;
import java.util.*;

public abstract class MazeSolver {
	
	private static MyCell[][] cellMatrix;	// Rows, Columns
	private static Point startPoint;
	private static Point endPoint;
	private static int rows;
	private static int cols;
	private static final float WALL_CHANCE = 0.4f;
	
	public enum SearchAlgorithm {
		BREADTH_FIRST, DEPTH_FIRST
	}
	
	public static void reset() {
		startPoint = null;
		endPoint = null;
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				cellMatrix[r][c].reset();
			}
		}
	}
	
	public static void setRandomWalls() {
		Random rand = new Random();
		reset();
		
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				if(rand.nextFloat() < WALL_CHANCE)
					cellMatrix[r][c].changeToWall();
			}
		}
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
			cellMatrix[startPoint.x][startPoint.y].reset();
			cellMatrix[row][column].changeToStart();
			startPoint = new Point(row, column);
		}
	}
	
	public static void setEndCell(int row, int column) {
		if(endPoint == null) {
			cellMatrix[row][column].changeToEnd();
			endPoint = new Point(row, column);
		}
		else {
			cellMatrix[endPoint.x][endPoint.y].reset();
			cellMatrix[row][column].changeToEnd();
			endPoint = new Point(row, column);
		}
	}
	
	public static boolean solve(SearchAlgorithm algorithm) {
		if(startPoint != null && endPoint != null) {
			switch(algorithm) {
				case BREADTH_FIRST:
					return breadthFirstSearch();
				case DEPTH_FIRST:
					return depthFirstSearch();
			}
			return true;
		}
		return false;
	}
	
	private static boolean breadthFirstSearch() {
		Queue<MyCell> queue = new LinkedList<>();
		ArrayList<MyCell> neighbors;
		MyCell cell = cellMatrix[startPoint.x][startPoint.y];
		queue.add(cell);
		
		while(true) {
			neighbors = getNeighbors(cell);
			
			for(MyCell neighbor : neighbors) {
				if(neighbor.isEnd())
					return true;
				neighbor.visitCell();
				queue.add(neighbor);
			}
			if(queue.isEmpty())
				break;
			cell = queue.remove();
		}
		
		return false;		
	}
	private static boolean depthFirstSearch() {
		Stack<MyCell> stack = new Stack<>();
		ArrayList<MyCell> neighbors;
		MyCell cell = cellMatrix[startPoint.x][startPoint.y];
		stack.push(cell);
		
		while(!stack.isEmpty()) {
			// Get the neighbors of the cell
			neighbors = getNeighbors(cell);
			
			// While the cell has neighbors
			while(!neighbors.isEmpty()) {
				// Add first valid neighbor to stack
				for(MyCell neighbor : neighbors) {
					// If cell is the goal, return true
					if(neighbor.isEnd())
						return true;
					
					cell = neighbor;
					cell.visitCell();
					stack.push(cell);
					break;
				}
				neighbors = getNeighbors(cell);
			}
			cell = stack.pop();
		}
		
		return false;
	}
	
	private static ArrayList<MyCell> getNeighbors(MyCell cell){
		ArrayList<MyCell> neighbors = new ArrayList<>();
		MyCell neighbor;
		
		int r = cell.index.x;
		int c = cell.index.y;
		
		// East
		if(c + 1 < cols) {
			neighbor = cellMatrix[r][c + 1];
			if(!neighbor.isWall() && !neighbor.isVisited())
				neighbors.add(neighbor);
		}
		// South
		if(r + 1 < rows) {
			neighbor = cellMatrix[r + 1][c];
			if(!neighbor.isWall() && !neighbor.isVisited())
				neighbors.add(neighbor);
		}
		// North
		if(r - 1 >= 0 ) {
			neighbor = cellMatrix[r - 1][c];
			if(!neighbor.isWall() && !neighbor.isVisited())
				neighbors.add(neighbor);
		}	
		// West
		if(c - 1 >= 0) {
			neighbor = cellMatrix[r][c - 1];
			if(!neighbor.isWall() && !neighbor.isVisited())
				neighbors.add(neighbor);
		}
		
		return neighbors;
	}
}
