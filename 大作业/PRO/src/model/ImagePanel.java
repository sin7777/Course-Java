package model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private Image image;
	
	public void setImage(String imagePath)
	{
		ImageIcon imageIcon=new ImageIcon(imagePath);
		image=imageIcon.getImage();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		if(image==null)
			return;
		g.drawImage(image, 0, 0, 1920, 1080,null);
	}
}
