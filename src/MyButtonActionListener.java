import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyButtonActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JButton source = (JButton)arg0.getSource();
		String button = source.getText();
		
		switch(button) {
			case "Select Start":
				selectStart();
				break;
			case "Select Goal":
				selectGoal();
				break;
			case "Solve":
				solve();
				break;
			case "Reset":
				reset();
				break;
		}
		
		
	}
	
	private void selectStart() {
		MyWindow.infoLabel.setText("Select a starting point");
		MyWindow.startSelectMode = true;
		MyWindow.goalSelectMode = false;
	}
	
	private void selectGoal() {
		MyWindow.infoLabel.setText("Select an ending point");
		MyWindow.goalSelectMode = true;
		MyWindow.startSelectMode = false;
	}
	
	private void solve() {
		boolean solvable = MazeSolver.solve(MazeSolver.SearchAlgorithm.DEPTH_FIRST);
		
		if(solvable)
			MyWindow.infoLabel.setText("Maze has been solved");
		else
			MyWindow.infoLabel.setText("Maze is unsolvable");
	}
	
	private void reset() {
		MazeSolver.reset();
	}
}
