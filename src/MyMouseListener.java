import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		MyCell cell = (MyCell)arg0.getComponent();
		
		if(arg0.getButton() == MouseEvent.BUTTON1)
			cell.changeToWall();
		else if(arg0.getButton() == MouseEvent.BUTTON3)
			cell.changeToPath();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
