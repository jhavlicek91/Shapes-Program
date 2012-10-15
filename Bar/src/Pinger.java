import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Pinger implements ActionListener {

	ShapeCanvas sc;
	
	public Pinger(ShapeCanvas sc) {
		this.sc = sc;
	}

	public void actionPerformed(ActionEvent arg0) {
		FileDialog pings = new FileDialog(sc.app, "Save File as .PNG", FileDialog.SAVE);
		pings.setVisible(true);
		
		String filename = pings.getFile();
		String directory = pings.getDirectory();
		
		File file = new File(directory+filename+".png");
		RenderedImage ri = createImage(sc);
		
		try {
			ImageIO.write(ri, "png", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	private static RenderedImage createImage(ShapeCanvas sc){
		BufferedImage bi = new BufferedImage(sc.getWidth(), sc.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g2 = bi.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, sc.getWidth(), sc.getHeight());
		
		for(int i = 0; i < sc.shapes.size(); i++)
		{
		Shape s = sc.shapes.get(i);
		s.drawMe(g2);
		}
		
		g2.dispose();
		return bi;
	}

}
