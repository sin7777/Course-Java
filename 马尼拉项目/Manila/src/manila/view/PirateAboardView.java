package manila.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manila.controller.PirateAboardController;
import manila.model.Game;

/**
 * 海盗决定自身是否登船
 * @author Zuo
 */
public class PirateAboardView extends JFrame{

	private JButton choice1;
	private JButton choice2;
	
	private Game game;
	private int boatId;
	private PirateAboardController pac;
	
	public PirateAboardView(Game game, int boatId) {
		this.game = game;
		this.boatId = boatId;
		this.pac = new PirateAboardController(this);
		
		this.setSize(new Dimension(200, 200));
		this.setResizable(false);
		this.setLocation(300, 100);
		
		JPanel main = new JPanel();
		
		this.choice1 = new JButton("上船");
		this.choice2 = new JButton("放弃");
		
		this.choice1.addActionListener(this.pac);
		this.choice2.addActionListener(this.pac);
		this.choice1.setActionCommand("yes");
		this.choice2.setActionCommand("no");
		
		main.setLayout(new GridLayout(4,1));
		main.add(new JLabel("现在有一艘船来到了海盗面前", JLabel.CENTER));
		main.add(new JLabel("你决定", JLabel.CENTER));
		main.add(this.choice1);
		main.add(this.choice2);
		
		this.setContentPane(main);
		this.pack();
		this.setVisible(true);
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getBoatId() {
		return boatId;
	}

	public void setBoatId(int boatId) {
		this.boatId = boatId;
	}
	
}
