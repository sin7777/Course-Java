package manila.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manila.controller.PirateActionController;
import manila.controller.SetBoatController;
import manila.model.Boat;
import manila.model.Game;

/**
 * 海盗行动，出现在海盗执行行动时
 * @author Zuo
 */
public class PirateActionView extends JFrame{
	
	//表示对第一艘船的选择，以此类推
	private JButton choice1;
	private JButton choice2;
	
	private PirateActionController pac;
	private Game game;
	private int boatId;
	
	/**
	 * @param g 游戏Game
	 * @param boatId 被海盗所掠夺的船的id
	 */
	public PirateActionView(Game g, int boatId) {
		this.game = g;
		this.boatId = boatId;
		this.pac = new PirateActionController(this);
		
		this.setSize(new Dimension(400, 200));
		this.setResizable(false);
		this.setLocation(300, 100);
		
		this.choice1 = new JButton("进港");
		this.choice2 = new JButton("击沉");
		
		JPanel main = new JPanel();
		main.setLayout(new GridLayout(4,1));
		
		this.choice1.addActionListener(this.pac);
		this.choice2.addActionListener(this.pac);
		this.choice1.setActionCommand("enter");
		this.choice2.setActionCommand("wreck");
		
		main.add(new JLabel("你已经成功掠夺了这艘船！", JLabel.CENTER));
		main.add(new JLabel("现在你将决定这艘船的命运", JLabel.CENTER));
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
