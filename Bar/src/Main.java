import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main {
	
	public static void main(String args[]) {
		Frame app = new Frame("Shape Canvas");
		ShapeCanvas sc;
		
		//Create Dropdown menu File and populate the menu
		MenuBar bar = new MenuBar();
		Menu fileMenu = new Menu("File");
		MenuItem open = new MenuItem("Open");
		MenuItem save = new MenuItem("Save");
		MenuItem savePNG = new MenuItem("Save as .PNG");
		
		//Create Dropdown menu Tools and populate the menu
		Menu Tools = new Menu("Tools");
		MenuItem Square = new MenuItem("Square");
		MenuItem filledSquare = new MenuItem("Filled Square");
		MenuItem Circle = new MenuItem("Circle");
		MenuItem filledCircle = new MenuItem("Filled Circle");
		MenuItem Rectangle = new MenuItem("Rectangle");
		MenuItem filledRectangle = new MenuItem("Filled Rectangle");
		MenuItem Line = new MenuItem("Line");
		MenuItem Color = new MenuItem("Choose Color");
		MenuItem Delete = new MenuItem("Delete");
		
		app.addWindowListener (new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		app.add( sc = new ShapeCanvas(app, open, save));
		
		//Set what happens when items in Tools menu are clicked
		Square.addActionListener(new ShapeChooser("Square", sc));
		filledSquare.addActionListener(new ShapeChooser("FilledSquare", sc));
		Circle.addActionListener(new ShapeChooser("Circle", sc));
		filledCircle.addActionListener(new ShapeChooser("FilledCircle", sc));
		Rectangle.addActionListener(new ShapeChooser("Rectangle", sc));
		filledRectangle.addActionListener(new ShapeChooser("FilledRectangle", sc));
		Line.addActionListener(new ShapeChooser("Line", sc));
		Delete.addActionListener(new ShapeChooser("Delete", sc));
		Color.addActionListener(new ShapeChooser("Color", sc));
		
		savePNG.addActionListener(new Pinger(sc));
		
		//Add Menus and Menuitems to the frame
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.add(savePNG);
		bar.add(fileMenu);
		
		Tools.add(Square);
		Tools.add(filledSquare);
		Tools.add(Circle);
		Tools.add(filledCircle);
		Tools.add(Rectangle);
		Tools.add(filledRectangle);
		Tools.add(Line);
		Tools.add(Color);
		Tools.add(Delete);
		bar.add(Tools);
		

		
		
		app.setMenuBar(bar);
		
		app.pack();
		app.setVisible(true);
		
	}

}
