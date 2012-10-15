import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	
	int upperX, upperY, centerX, centerY, circumference;
	double distance, radius;
	
	public Circle(int centerX, int centerY, int radius, Color c, boolean fill) {
		
		this.upperX = centerX - radius;
		this.upperY = centerY - radius;
		this.centerX = centerX;
		this.centerY = centerY;
		this.circumference = 2 * radius;
		
		this.c = c;
		this.filled = fill;
		this.type = "Circle";
		this.radius = radius;
	}

	public void drawMe(Graphics g) {
		g.setColor(this.c);
		if(filled)
			g.fillOval(upperX,  upperY, circumference, circumference);
		else g.drawOval(upperX,  upperY, circumference, circumference);
		
	}

	public boolean isClickInside(int x, int y) {
		distance = Math.sqrt(Math.pow(x - centerX, 2.0) + Math.pow(y - centerY, 2.0));
		  if(distance <= (circumference / 2))
		   return true;
		  
		  return false;
		
	}


	public void update(int x, int y) {
		this.radius = Math.sqrt(Math.pow(centerX - x, 2.0) + Math.pow(centerY - y, 2.0));
		
		//Make sure circle isn't drawn outside the canvas
		if(centerX - radius >= 0 && centerY - radius >= 0 && centerX + radius <= 1000 && centerY + radius <= 1000) {
			upperX = (int) (centerX - radius);
			upperY = (int) (centerY - radius);
			circumference = (int) (2 * radius);
		}
		
	}

}
