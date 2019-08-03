package manila.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import manila.controller.DiceController;

import manila.motor.Game;
import manila.motor.Player;

/**
 * 游戏主界面，包含main函数
 */
public class GameView extends JPanel {
	/** 信息窗口的宽度 */
	private static final int INFO_W = 300;
	/** 信息窗口的高度 */
	private static final int INFO_H = 800;
    
	private Game game;
	
	/** 游戏场景窗口 */
	private PlaygroundView playground;
	/** 信息窗口 */
	private JPanel infoView;
	/** 玩家信息窗口 */
	private JPanel playersView;
	/** 摇骰子的窗口 */
	private JPanel diceView;
	
	/** 存放玩家信息视图的数组 */
	private PlayerView[] playersV;
	/** 控制摇骰子的按钮 */
	private JButton diceButton;
	
	public GameView(){
		this.game = new Game(this);
		
		this.playground = new PlaygroundView(this.game);
        this.infoView = new JPanel();
        
        this.makePlayerView();
        this.makeDiceView();
        
        this.infoView.setPreferredSize(new Dimension(INFO_W, INFO_H));
        this.infoView.setBackground(Color.GREEN);
        this.infoView.setLayout(new BorderLayout());
        this.infoView.add(playersView, BorderLayout.CENTER);
        this.infoView.add(diceView, BorderLayout.SOUTH);
        
        this.add(this.playground);
        this.add(this.infoView);
        
        this.setBackground(Color.RED);
        
	}
	
	/**
	 * 对玩家信息视图进行初始化
	 */
	public void makePlayerView(){
		this.playersView = new JPanel();
		// TODO
		
	}
	
	/**
	 * 对摇骰子的视图进行初始化
	 */
	public void makeDiceView(){
		this.diceView = new JPanel();
		this.diceView.setPreferredSize(new Dimension(INFO_W, 500));
		this.diceView.setBackground(Color.GRAY);
		this.diceButton = new JButton("Roll");
		this.diceButton.setFont(new Font("SansSerif", Font.PLAIN, 32));
		this.diceButton.addActionListener(new DiceController(this.game));
		this.diceView.add(this.diceButton);
	}
	
	/**
	 * 对玩家的显示在界面上的相关信息进行更新
	 * @param pid 对应玩家的ID
	 */
	public void updatePlayersView(int pid){
		for(PlayerView pv : this.playersV){
			// TODO: 更新玩家界面上的相关信息
			
		}
	}
	

	public PlaygroundView getPlayground() {
		return playground;
	}

	public void setPlayground(PlaygroundView playground) {
		this.playground = playground;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mw = new JFrame();
		mw.setTitle("Manila");
		GameView gv = new GameView();
		mw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mw.setContentPane(gv);
		mw.pack();
		mw.setVisible(true);
	}
	
}
