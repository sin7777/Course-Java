package manila.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import manila.controller.SetBoatController;
import manila.model.Game;

/**
 * 初始放置船的窗口，本类用于在每一航程开始前由船长（负责人）决定各船只初始位置；
 * @author Zuo
 */
public class SetBoatView extends JFrame{

	private JTextField boat1;
	private JTextField boat2;
	private JTextField boat3;
	
	private JButton confirm;
	
	private Game game;
	private SetBoatController sbc;
	
	public SetBoatView(Game g) {
		this.game = g;
		this.sbc = new SetBoatController(this);
		
		this.setSize(new Dimension(200, 200));
		this.setResizable(false);
		this.setLocation(300, 100);
		
		JPanel main = new JPanel();
		
		this.boat1 = new JTextField();
		this.boat2 = new JTextField();
		this.boat3 = new JTextField();
		this.confirm = new JButton("确认");
		
		
		main.setLayout(new GridLayout(6,1));
		main.add(new JLabel("请输入三个整数", JLabel.CENTER));
		main.add(new JLabel("依次表示三个航道上船只的初始位置", JLabel.CENTER));
		main.add(this.boat1);
		main.add(this.boat2);
		main.add(this.boat3);
		main.add(this.confirm);
		
		this.confirm.addActionListener(this.sbc);
		this.confirm.setActionCommand("confirm");
		
		this.setContentPane(main);
		this.pack();
		this.setVisible(true);
	}

	public JTextField getBoat1() {
		return boat1;
	}

	public void setBoat1(JTextField boat1) {
		this.boat1 = boat1;
	}

	public JTextField getBoat2() {
		return boat2;
	}

	public void setBoat2(JTextField boat2) {
		this.boat2 = boat2;
	}

	public JTextField getBoat3() {
		return boat3;
	}

	public void setBoat3(JTextField boat3) {
		this.boat3 = boat3;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	
}
