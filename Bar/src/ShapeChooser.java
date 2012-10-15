import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;



public class ShapeChooser implements ActionListener{

	ShapeCanvas sc;
	String choice;
	JColorChooser cc;
	
	public ShapeChooser(String shape, ShapeCanvas sc){
		//When an item in the Tools menu is clicked, set choice equal to what shape
		//will be drawn if you click the screen
		this.sc = sc;
		this.choice = shape;
		
	}
	

	public void actionPerformed(ActionEvent arg0) {
		sc.toDo = choice;
		//If the color item of the tools menu is chosen, a colorchooser will pop up
		if(choice.equals("Color")){
			sc.col = JColorChooser.showDialog(
                    sc.app,
                    "Choose a Color",
                    Color.BLACK);
		}

	}


}
