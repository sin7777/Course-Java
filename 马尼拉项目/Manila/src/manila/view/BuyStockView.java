package manila.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manila.controller.BuyStockController;
import manila.model.Game;

/**
 * 船长（负责人）每航程前可以选择购买股票
 * @author Zuo
 */
public class BuyStockView extends JFrame{

	//表示选择第几种货物的按钮
	private JButton choice1;
	private JButton choice2;
	private JButton choice3;
	private JButton choice4;
	private JButton giveUp;
	
	
	private Game game;
	private BuyStockController bsc;
	
	public BuyStockView(Game game) {
		this.game = game;
		this.bsc = new BuyStockController(this);
		
		this.setSize(new Dimension(200, 200));
		this.setResizable(false);
		this.setLocation(300, 100);
		
		JPanel main = new JPanel();
		
		this.choice1 = new JButton("肉豆蔻");
		this.choice2 = new JButton("丝绸");
		this.choice3 = new JButton("人参");
		this.choice4 = new JButton("玉石");
		this.giveUp = new JButton("放弃");
		
		main.setLayout(new GridLayout(6,1));
		main.add(new JLabel("选择你想要购买的股票", JLabel.CENTER));
		main.add(this.choice1);
		main.add(this.choice2);
		main.add(this.choice3);
		main.add(this.choice4);
		main.add(this.giveUp);
		
		this.choice1.addActionListener(this.bsc);
		this.choice2.addActionListener(this.bsc);
		this.choice3.addActionListener(this.bsc);
		this.choice4.addActionListener(this.bsc);
		this.giveUp.addActionListener(this.bsc);
		
		this.choice1.setActionCommand("nutmeg");
		this.choice2.setActionCommand("silk");
		this.choice3.setActionCommand("ginseng");
		this.choice4.setActionCommand("jade");
		this.giveUp.setActionCommand("giveUp");
		
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
