
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class ShapeCanvas extends Canvas implements ActionListener {
	
	public Frame app;
	String line = "";
    String[] temp;
    Color col = Color.BLACK;
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	String filename = "", directory="";
	String toDo = "Delete";
	int height = 1000;
	int width = 1000;
	
	public ShapeCanvas(Frame app, MenuItem mi, MenuItem s) {
		this.app = app;
		setSize(height, width);
		setBackground(Color.WHITE);
		
		s.addActionListener(new Saver(this));
		addMouseMotionListener(new Mousey(this));
		mi.addActionListener(this);
		addMouseListener(new Clicker(this));
	}

	public void actionPerformed(ActionEvent arg0) {
		
		//Pop up a file dialog
		FileDialog open = new FileDialog(app);
		open.setVisible(true);
		
		//Get the received file + directory
		filename = open.getFile();
		directory = open.getDirectory();
		System.out.println(directory+filename);
		
		try {
			
			FileInputStream ifstream = new FileInputStream(directory + filename);
			DataInputStream in = new DataInputStream(ifstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			shapes.clear();
			col = null;
  		    if(filename != null)
  		    while ((line = br.readLine()) != null && line != "")   {
  		    	
  		    	temp = line.split(" ");

  		    	//Read in lines from a text file and populate the arraylist shapes with the appropiate shapes
  		    	if(temp[0].equals("circle")) {
  		    		shapes.add(new Circle(Integer.parseInt( temp[1] ), Integer.parseInt( temp[2] ), Integer.parseInt( temp[3] ), col, false));
  		    	}
  		    	
  		    	else if(temp[0].equals("filledcircle")){
  		    		shapes.add(new Circle(Integer.parseInt( temp[1] ), Integer.parseInt( temp[2] ), Integer.parseInt( temp[3] ), col, true));
  		    	}
  		    	
  		    	else if(temp[0].equals("rectangle")) {
  		    		shapes.add(new Rectangle(Integer.parseInt( temp[1] ), Integer.parseInt( temp[2] ), Integer.parseInt( temp[3] ), Integer.parseInt( temp[4] ), col, false));
  		    	}
  		    	
  		    	else if(temp[0].equals("filledrectangle")) {
  		    		shapes.add(new Rectangle(Integer.parseInt( temp[1] ), Integer.parseInt( temp[2] ), Integer.parseInt( temp[3] ), Integer.parseInt( temp[4] ), col, true));
  		    	}
  		    	
  		    	else if(temp[0].equals("line") || temp[0].equals("Line")) {
  		    		shapes.add(new Line(Integer.parseInt( temp[1] ), Integer.parseInt( temp[2] ), Integer.parseInt( temp[3] ), Integer.parseInt( temp[4] ), col));
  		    	}
  		    	  		    	
  		    	else if(temp[0].equals("square")) {
  		    		shapes.add(new Square(Integer.parseInt( temp[1]), Integer.parseInt( temp[2]), Integer.parseInt( temp[3] ), col, false));
  		    	}
  		    	
  		    	else if(temp[0].equals("filledsquare")){
  		    		shapes.add(new Square(Integer.parseInt( temp[1]), Integer.parseInt( temp[2]), Integer.parseInt( temp[3] ), col, true));
  		    	}
  		    	
  		    	else if(temp[0].equals("color")) {
  		    		col =  new Color( Integer.parseInt( temp[1]), Integer.parseInt( temp[2] ), Integer.parseInt( temp[3] ));
  		    	}
  		    	
  		    	else System.err.println("BAD LINE"+temp[0]);
  		    	
		  }
  		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		repaint();
		
		
	}
	
	public void paint(Graphics g) {
		
		for( Shape s : shapes ) {
			
			s.drawMe(g);
			
		}
			
	}


	

}
