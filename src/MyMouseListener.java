import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener{
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		MyCell cell = (MyCell)arg0.getComponent();
		
		if(MyWindow.startSelectMode) {
			MyWindow.infoLabel.setText(MyWindow.INFO);
			MyWindow.startSelectMode = false;
			MazeSolver.setStartCell(cell.index.x, cell.index.y);
		}
		else if(MyWindow.goalSelectMode) {
			MyWindow.infoLabel.setText(MyWindow.INFO);
			MyWindow.goalSelectMode = false;
			MazeSolver.setEndCell(cell.index.x, cell.index.y);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(!MyWindow.startSelectMode && !MyWindow.goalSelectMode) {
			MyCell cell = (MyCell)arg0.getComponent();
			
			if(MyWindow.leftClickDown) {
				cell.changeToWall();
			}
			else if(MyWindow.rightClickDown) {
				cell.changeToPath();
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if(!MyWindow.startSelectMode && !MyWindow.goalSelectMode) {
			MyCell cell = (MyCell)arg0.getComponent();
			
			if(arg0.getButton() == MouseEvent.BUTTON1) {
				MyWindow.leftClickDown = true;
				cell.changeToWall();
			}
			else if(arg0.getButton() == MouseEvent.BUTTON3) {
				MyWindow.rightClickDown = true;
				cell.changeToPath();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		MyWindow.leftClickDown = false;
		MyWindow.rightClickDown = false;
	}

}
