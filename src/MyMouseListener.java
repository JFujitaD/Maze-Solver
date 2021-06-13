import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener{
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
		MyCell cell = (MyCell)arg0.getComponent();
		
		if(MyWindow.leftClickDown) {
			cell.changeToWall();
		}
		else if(MyWindow.rightClickDown) {
			cell.changeToPath();
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
		MyCell cell = (MyCell)arg0.getComponent();
		
		if(arg0.getButton() == MouseEvent.BUTTON1)
			MyWindow.leftClickDown = true;
		else if(arg0.getButton() == MouseEvent.BUTTON3)
			MyWindow.rightClickDown = true;
			
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		MyWindow.leftClickDown = false;
		MyWindow.rightClickDown = false;
	}

}
