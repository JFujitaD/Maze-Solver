import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean solvable = MazeSolver.solve(MazeSolver.SearchAlgorithm.DEPTH_FIRST);
		
		if(solvable)
			MyWindow.infoLabel.setText("Maze has been solved");
		else
			MyWindow.infoLabel.setText("Maze is unsolvable");
	}

}
