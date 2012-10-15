import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Saver implements ActionListener {

	ShapeCanvas sc;
	Color prevColor = null;
	Circle c;
	Rectangle r;
	Square sq;
	Line l;
	
	public Saver(ShapeCanvas sc){
		this.sc = sc;
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		//Pop up a file dialog
		FileDialog open = new FileDialog(sc.app, "Save File", FileDialog.SAVE);
		open.setVisible(true);
		
		//Get the received file + directory
		String filename = open.getFile();
		String directory = open.getDirectory();
		
		FileWriter fstream;
		
		try {
			fstream = new FileWriter(directory+filename);
			BufferedWriter output = new BufferedWriter(fstream);
			
			//Write appropriate text to a file for each shape in the arraylist shapes
			for( Shape s: sc.shapes){
				
				//check to see if a shapes color is different than the previosu ones, if so
				//add a color line to the file
				if(s.c != prevColor && s.c != null){
					output.write("color ");
					output.write(Integer.toString(s.c.getRed()) + " " + Integer.toString(s.c.getGreen()) + " " + Integer.toString(s.c.getBlue()));
					output.write("\n");
				}
				
				if(s.type.equals("Circle")) {
					c = (Circle) s;
					if(s.filled)
						output.write("filledcircle ");
					else output.write("circle ");
					output.write(Integer.toString(c.centerX) + " " + Integer.toString(c.centerY) + " " + Integer.toString((int)c.radius));
					output.write("\n");
					prevColor = s.c;
				}

				else if(s.type.equals("Rectangle")) {
					r = (Rectangle) s;
					if(s.filled)
						output.write("filledrectangle ");
					else output.write("rectangle ");
					output.write(Integer.toString(r.centerX) + " " + Integer.toString(r.centerY) + " " + Integer.toString(r.length) + " " + Integer.toString(r.width));
					output.write("\n");
					prevColor = s.c;
				}

				else if(s.type.equals("Square")) {
					sq = (Square) s;
					if(s.filled)
						output.write("filledsquare ");
					else output.write("square ");
					output.write(Integer.toString(sq.centerX) + " " + Integer.toString(sq.centerY) + " " + Integer.toString(sq.h_w));
					output.write("\n");
					prevColor = s.c;
				}

				else if(s.type.equals("Line")) {
					l = (Line) s;
					output.write("line ");
					output.write(Integer.toString(l.topX) + " " + Integer.toString(l.topY) + " " + Integer.toString(l.bottomX) + " " + Integer.toString(l.bottomY));
					output.write("\n");
					prevColor = s.c;
				}
			}
			
			output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
