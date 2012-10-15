import java.awt.Color;
import java.awt.Graphics;


public class Line extends Shape {
	
	int topX, topY, bottomX, bottomY;
	
	public Line(int x1, int y1, int x2, int y2, Color c) {
		this.topX = x1;
		this.topY = y1;
		this.bottomX = x2;
		this.bottomY = y2;
		
		this.c = c;
		this.type = "Line";
	}

	public void drawMe(Graphics g) {
		g.setColor(c);
		g.drawLine(topX, topY, bottomX, bottomY );
		
	}

	public boolean isClickInside(int x, int y) {
		
		double distance = Math.sqrt(Math.pow(bottomX - topX, 2) + Math.pow(bottomY - topY, 2));
			    
	    double distance2 =  Math.sqrt(Math.pow(x - topX, 2) + Math.pow(y - topY, 2));
	    double distance3 =  Math.sqrt(Math.pow(x - bottomX, 2) + Math.pow(y - bottomY, 2));
	    double sum = (distance2 + distance3);
	    double diff = Math.abs(distance - sum);
	    
	    if(diff < 1 )
	    	return true;
	    return false;
	    
	}


	public void update(int x, int y) {
		if(x < 1000 && x > 0)
			bottomX = x;
		if(y < 1000 && y > 0)
			bottomY = y;
	}

}
