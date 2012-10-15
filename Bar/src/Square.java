import java.awt.Color;
import java.awt.Graphics;


public class Square extends Shape {
	
	int upperX, upperY, h_w, centerX, centerY;
	
	public Square(int centerX, int centerY, int length, Color c, boolean fill) {
		
		this.upperX = centerX - (length / 2);
		this.upperY = centerY - (length / 2);
		this.centerX = centerX;
		this.centerY = centerY;
		this.h_w = length;
		
		this.filled = fill;
		this.c = c;
		this.type = "Square";	
	}

	public void drawMe(Graphics g) {
		g.setColor(c);
		if(filled)
			g.fillRect(upperX, upperY, h_w, h_w);
		else g.drawRect(upperX, upperY, h_w, h_w);
		
	}


	public boolean isClickInside(int x, int y) {
		if(x > upperX && x < (upperX + h_w) && y > upperY && y < (upperY + h_w))
			return true;
		return false;
		
	}

	public void update(int x, int y) {
		
		double width = Math.abs(x - centerX);
		double height = Math.abs(y - centerY);
		
		int hw;
		if(height > width) 
			hw = 2 *(int) height;
		else 
			hw = 2 * (int) width;
		
		
		//Make sure square isn't drawn outside the canvas
		if(centerX - hw / 2 > 0 && centerY - hw / 2 > 0 && centerX + hw / 2 < 1000 && centerY + hw / 2 < 1000) {
			h_w = hw;
			
			upperX = centerX - h_w / 2;
			upperY = centerY - h_w / 2;
			

		}
		
		

	}

}
