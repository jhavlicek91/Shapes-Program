import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	int upperX, upperY, length, width, centerX, centerY, startX, startY;
	
	public Rectangle(int centerX, int centerY, int length, int width, Color c, boolean fill){
		
		this.upperX = centerX - (length / 2);
		this.upperY = centerY - (width / 2);
		this.centerX = centerX;
		this.centerY = centerY;
		this.startX = centerX;//needed because when creating new rectangles, centerX passed in is not really the center of the shape
		this.startY = centerY;
		this.length = length;
		this.width = width;
		
		this.c = c;
		this.filled = fill;
		this.type = "Rectangle";
	}


	public void drawMe(Graphics g) {
		g.setColor(c);
		if(filled)
			g.fillRect(upperX, upperY, length, width);
		else g.drawRect(upperX, upperY, length, width);
		
	}


	public boolean isClickInside(int x, int y) {
		if(x > upperX && x < (upperX + length ) && y > upperY && y < (upperY + width))
			return true;
		return false;
		
	}


	public void update(int x, int y) {

		//Make sure rectangle isn't drawn outside the canvas
		if(x > 0 && x < 1000 && y > 0 && y < 1000){
			upperX = startX;
			upperY = startY;
			
			length = Math.abs(x - upperX);
			width = Math.abs(y - upperY);
			
			if(x < upperX)
				upperX -= length;
			if(y < upperY)
				upperY -= width;
			
			centerX = upperX + length / 2;
			centerY = upperY + width / 2;
			}
		
		}
}
