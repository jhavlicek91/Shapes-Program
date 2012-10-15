import java.awt.Color;
import java.awt.Graphics;


public abstract class Shape {
	
	Color c = Color.BLACK;
	boolean filled;
	String type;

	//Draws a shape on the canvas
	public abstract void drawMe(Graphics g);
	//Determines if a click is inside the boundaries of a shape
	public abstract boolean isClickInside(int x, int y);
	//changes a shapes size 
	public abstract void update(int x, int y);
	
}
