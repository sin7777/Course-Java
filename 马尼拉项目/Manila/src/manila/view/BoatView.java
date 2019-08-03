package manila.view;

import javax.swing.JPanel;

import manila.model.Game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class BoatView extends JLayeredPane implements ActionListener{
	
	private int boatID;
	private JLabel background;
	private JButton total;
	private ArrayList<JButton> buttonlist;
	private Image backimage;
	private String name;
	
	private int psNum = 0;
	private int posNum = 3;
	
	private Game g;
	
	public BoatView(String cargoName, int ID, Game ga)
	{
		try 
		{
		    File bg = new File("./src/" + cargoName + ".png");
			backimage = ImageIO.read(bg);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boatID = ID;
		g = ga;
		psNum = 0;
		if (cargoName.equals("jade"))
			posNum = 4;
		name = cargoName;
		
		this.setLayout(null);
		if (boatID == 0) this.setBounds(678, 190, 120, 30);
		if (boatID == 1) this.setBounds(671, 249, 120, 30);
		if (boatID == 2) this.setBounds(666, 311, 120, 30);
					
		background = new JLabel();
		background.setIcon(new ImageIcon(backimage));
		background.setBounds(0,0,120,30);
		this.add(background,new Integer(100));
				
		total = new JButton("");
		total.setBounds(0,0,120,30);
		total.setOpaque(false);
		total.addActionListener(this);
		total.setActionCommand("total");
		this.add(total,new Integer(0));

		this.validate();
		this.setVisible(true);
	}
	
	public void onboardByID(int playerid)
	{
		Image sailimage = null;
		try 
		{
		    File bg = new File("./src/" + g.getPlayers().get(playerid).getName() + "sailor.png");
			sailimage = ImageIO.read(bg);
		} 
		catch (IOException es)
		{
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		// TODO Auto-generated method stub
		if (g.setEmployee(0, boatID))
			this.setVisible(false);
			if (psNum < posNum)
			{
				//System.out.println("./src/" + g.getCurrentPlayer().getName() + "sailor.png");
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				if (posNum == 4)
					sailor.setBounds(36 + psNum * 21,5,20,20);
				if (posNum == 3)
					sailor.setBounds(36 + psNum * 21,5,20,20);
				this.add(sailor,new Integer(200));
				psNum++;
				g.switchPlayer();
			}
			this.validate();
			this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Image sailimage = null;
		try 
		{
		    File bg = new File("./src/" + g.getCurrentPlayer().getName() + "sailor.png");
			sailimage = ImageIO.read(bg);
		} 
		catch (IOException es)
		{
			// TODO Auto-generated catch block
			es.printStackTrace();
		}
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("total") && (g.getSetnum() < g.getPlayers().size()) && g.setEmployee(0, boatID))
		{
			this.setVisible(false);
			if (psNum < posNum)
			{
				//System.out.println("./src/" + g.getCurrentPlayer().getName() + "sailor.png");
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				if (posNum == 4)
					sailor.setBounds(36 + psNum * 21,5,20,20);
				if (posNum == 3)
					sailor.setBounds(36 + psNum * 21,5,20,20);
				this.add(sailor,new Integer(200));
				psNum++;
				g.switchPlayer();
				System.out.println("ssss");
			}
			this.g.getGame_view().update();
			this.validate();
			this.setVisible(true);
		}
	}
	
}
