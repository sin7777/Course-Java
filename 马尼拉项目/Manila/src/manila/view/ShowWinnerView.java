package manila.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manila.model.Game;
import manila.model.Player;

/**
 * 游戏结束时显示胜者与各玩家财产
 * @author Zuo
 */
public class ShowWinnerView extends JFrame implements ActionListener{

	private JButton confirm;
	
	private Game game;
	
	public ShowWinnerView(Game game) {
		this.game = game;
		
		this.setSize(new Dimension(200, 200));
		this.setResizable(false);
		this.setLocation(300, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel main = new JPanel();
		
		this.confirm = new JButton("确认");
		this.confirm.addActionListener(this);
		this.confirm.setActionCommand("confirm");
		
		switch(this.game.getPlayers().size()) {
		case 3:
			main.setLayout(new GridLayout(10,1));
			break;
		case 4:
			main.setLayout(new GridLayout(12,1));
			break;
		case 5:
			main.setLayout(new GridLayout(14,1));
			break;
		}
		main.add(new JLabel("最终的胜者：", JLabel.CENTER));
		main.add(new JLabel(this.game.getPlayers().get(this.game.checkWin()).getName(), JLabel.CENTER));
		main.add(new JLabel("各玩家的资产情况：：", JLabel.CENTER));
		for(Player p : this.game.getPlayers()) {
			main.add(new JLabel(p.getName(), JLabel.CENTER));
			main.add(new JLabel("总资产：" + String.valueOf(p.getProperty(this.game.getBlack_market())), JLabel.CENTER));
		}
		main.add(this.confirm);
		
		this.setContentPane(main);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("confirm")) {
			this.dispose();
			System.exit(0);
		}
	}
}
