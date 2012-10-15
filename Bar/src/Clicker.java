import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Clicker implements MouseListener {
	
	ShapeCanvas sc;
	boolean erased = false;
	
	public Clicker(ShapeCanvas sc){
		this.sc = sc;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
	public void mousePressed(MouseEvent me) {

		int i = sc.shapes.size() - 1;
		
		//If delete has been selected check to see if the click was inside of a shape on the
		//screen, and remove one shape per click
		if(sc.toDo.equals("Delete") && sc.shapes.size() != 0){
			erased = false;
		
			while( i >= 0 && !erased ) {
				Shape s = sc.shapes.get(i);
				if(s.isClickInside(me.getX(), me.getY())) {
					sc.shapes.remove(i);
					erased = true;
				}
				i--;
			}
		}
		
		//When the canvas is initially clicked, create a new shape 
		//based on what was selected from the tools menu
		if(sc.toDo.equals("Square")){
			sc.shapes.add(new Square(me.getX(), me.getY(), 0, sc.col, false));
		}	
		if(sc.toDo.equals("FilledSquare")){
			sc.shapes.add(new Square(me.getX(), me.getY(), 0, sc.col, true));
		}	
		if(sc.toDo.equals("Circle")){
			sc.shapes.add(new Circle(me.getX(), me.getY(), 0, sc.col, false));
		}
		if(sc.toDo.equals("FilledCircle")){
			sc.shapes.add(new Circle(me.getX(), me.getY(), 0, sc.col, true));
		}
		if(sc.toDo.equals("Rectangle")){
			sc.shapes.add(new Rectangle(me.getX(), me.getY(), 0, 0, sc.col, false));
		}
		
		if(sc.toDo.equals("FilledRectangle")){
			sc.shapes.add(new Rectangle(me.getX(), me.getY(), 0, 0, sc.col, true));
		}

		if(sc.toDo.equals("Line")){
			sc.shapes.add(new Line(me.getX(), me.getY(), me.getX(), me.getY(), sc.col));
		}	
		
		sc.repaint();


	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		

	}

}
