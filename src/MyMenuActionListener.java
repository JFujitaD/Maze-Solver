import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class MyMenuActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JMenuItem source = (JMenuItem)arg0.getSource();
		String button = source.getText();
		
		switch(button) {
			case "Random Walls":
				randomWalls();
				break;
		}
	}
	
	private void randomWalls() {
		MazeSolver.setRandomWalls();
	}

}
