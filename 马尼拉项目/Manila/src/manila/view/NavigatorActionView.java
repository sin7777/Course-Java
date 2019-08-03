package manila.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manila.controller.NavigatorActionController;
import manila.model.Game;

/**
 * 领航员行动窗口
 * @author Zuo
 */
public class NavigatorActionView extends JFrame{

	private JButton ahead1;
	private JButton ahead2;
	private JButton ahead3;
	private JButton back1;
	private JButton back2;
	private JButton back3;
	
	private Game game;
	private NavigatorActionController nac;
	
	public NavigatorActionView(Game game) {
		this.game = game;
		this.nac = new NavigatorActionController(this);
		
		this.setSize(new Dimension(200, 200));
		this.setResizable(false);
		this.setLocation(300, 100);
		
		JPanel main = new JPanel();
		JPanel main1 = new JPanel();
		main.setLayout(new BorderLayout());
		main1.setLayout(new GridLayout(2,3));
		
		this.ahead1 = new JButton("让装载" + this.game.getMap().getBoats().get(0).getCargoName() + "的船只前进一格");
		this.ahead2 = new JButton("让装载" + this.game.getMap().getBoats().get(1).getCargoName() + "的船只前进一格");
		this.ahead3 = new JButton("让装载" + this.game.getMap().getBoats().get(2).getCargoName() + "的船只前进一格");
		this.back1 = new JButton("让装载" + this.game.getMap().getBoats().get(0).getCargoName() + "的船只后退一格");
		this.back2 = new JButton("让装载" + this.game.getMap().getBoats().get(1).getCargoName() + "的船只后退一格");
		this.back3 = new JButton("让装载" + this.game.getMap().getBoats().get(2).getCargoName() + "的船只后退一格");
		
		this.ahead1.addActionListener(this.nac);
		this.ahead2.addActionListener(this.nac);
		this.ahead3.addActionListener(this.nac);
		this.back1.addActionListener(this.nac);
		this.back2.addActionListener(this.nac);
		this.back3.addActionListener(this.nac);
		
		this.ahead1.setActionCommand("ahead1");
		this.ahead2.setActionCommand("ahead2");
		this.ahead3.setActionCommand("ahead3");
		this.back1.setActionCommand("back1");
		this.back2.setActionCommand("back2");
		this.back3.setActionCommand("back3");
		
		main.add(new JLabel("领航员发挥职能：", JLabel.CENTER),BorderLayout.NORTH);
		main1.add(this.ahead1);
		main1.add(this.ahead2);
		main1.add(this.ahead3);
		main1.add(this.back1);
		main1.add(this.back2);
		main1.add(this.back3);
		main.add(main1,BorderLayout.CENTER);
		
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
	
	
}
