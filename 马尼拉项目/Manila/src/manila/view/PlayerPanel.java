package manila.view;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manila.model.Player;

public class PlayerPanel extends JPanel{
	
	private JLabel name, balance, availemployee;
	private Image jade,ginseng,silk,nutmeg,tubiao;
	
	public PlayerPanel(Player p)
	{
		try 
		{
		    File bg;
		    bg = new File("./src/jadestocks.png");
			jade = ImageIO.read(bg);
			bg = new File("./src/ginsengstocks.png");
			ginseng = ImageIO.read(bg);
			bg = new File("./src/silkstocks.png");
			silk = ImageIO.read(bg);
			bg = new File("./src/nutmegstocks.png");
			nutmeg = ImageIO.read(bg);
			bg = new File("./src/" + p.getName()+ "sailor.png");
			tubiao = ImageIO.read(bg);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setLayout(null);
		this.setBounds(0, 0, 160, 240);
		
		name = new JLabel("PlayerName:" + p.getName());
		name.setBounds(0, 0, 160, 30);
		this.add(name);
		
		balance = new JLabel("Balance:" + p.getBalance());
		balance.setBounds(0,30,160,30);
		this.add(balance);
		
		availemployee = new JLabel("AvailEmployeeNum:" + p.getAvail_employee());
		availemployee.setBounds(0,60,160,30);
		this.add(availemployee);
		
		JLabel s = new JLabel("Stocks:");
		s.setBounds(0,90,160,30);
		this.add(s);
		
		JPanel stocks = new JPanel();
		stocks.setBounds(0,120,160,60);
		stocks.setLayout(new FlowLayout());
		for (int i : p.getStocks())
		{
			JLabel ne = new JLabel();
			ne.setSize(30,30);
			if (i == 4) 
			{
				ne.setIcon(new ImageIcon(jade));
				stocks.add(ne);
			}
			if (i == 3) 
			{
				ne.setIcon(new ImageIcon(ginseng));
				stocks.add(ne);
			}
			if (i == 2) 
			{
				ne.setIcon(new ImageIcon(silk));
				stocks.add(ne);
			}
			if (i == 1) 
			{
				ne.setIcon(new ImageIcon(nutmeg));
				stocks.add(ne);
			}
		}
		this.add(stocks);
		
		JLabel tubiaos = new JLabel();
		tubiaos.setBounds(70, 180, 20, 20);
		tubiaos.setIcon(new ImageIcon(tubiao));
		this.add(tubiaos);
	}

}
