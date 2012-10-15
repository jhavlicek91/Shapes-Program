import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class Mousey implements MouseMotionListener {
	
	ShapeCanvas sc;
	
	public Mousey(ShapeCanvas sc){
		this.sc = sc;
	}

	
	public void mouseDragged(MouseEvent me2){
	
		
		//While mouse is being dragged, update the shapes being drawn on screen
		if(!sc.toDo.equals("Delete") && !sc.toDo.equals("Color")) {
		
			Shape s = sc.shapes.get(sc.shapes.size() - 1);
		
			s.update(me2.getX(), me2.getY());
		}
				
			
		sc.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
