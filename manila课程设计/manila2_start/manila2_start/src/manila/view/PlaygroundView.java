package manila.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import manila.controller.GameController;
import manila.motor.Boat;
import manila.motor.Game;
import manila.motor.Position;

/**
 * 游戏场景界面类
 */
public class PlaygroundView extends JPanel {
	/** 游戏场景宽度 */
	private static final int GROUND_W = 400;
	/** 游戏场景高度 */
	private static final int GROUND_H = 800;  
	
	/** 一段航程在界面上的长度（直线的间隔） */
	public static final int SEA_INTERVAL = 35;
	/** 第一条大海线段的起点x坐标*/
	private static final int SEA_START_X = 50; 
	/** 第一条大海线段的起点y坐标 */
	private static final int SEA_START_Y = 200;
	/** 大海线段的宽 */
	private static final int SEA_W = 300;
	
	/** 一条小船的宽度 */
	public static final int BOAT_W = 50;
	/** 一条小船的高度 */
	public static final int BOAT_H = 140;
	/** 船之间的横向间隔 */
	private static final int BOAT_DISTANCE = 50;
	/** 最左边小船左上角x坐标 */
	private static final int BOAT_START_X = 75;
	/** 最左边小船右上角y坐标 */
	private static final int BOAT_START_Y = SEA_START_Y+Game.SEA_LENGTH*SEA_INTERVAL;
	
	/** 小船上位置的宽度 */
	private static final int POS_W = 40;
	/** 小船上位置的高度 */
	private static final int POS_H = 20;
	/** 小船上最上面位置左上角的x坐标 */
	private static final int POS_START_X = 5;
	/** 小船上最上面位置左上角的y坐标 */
	private static final int POS_START_Y = 20;
	/** 小船上位置间在y方向上的间隔 */
	private static final int POS_INTERVAL = 10;
	
	private Game game;
	
	public PlaygroundView(Game g){
		this.game = g;
		this.setPreferredSize(new Dimension(GROUND_W, GROUND_H));
		this.addMouseListener(new GameController(this.game));
		
		this.initBoats();
	}
	
	/**
	 * 对小船们的位置进行初始化
	 */
	private void initBoats() {
		Boat[] boats = this.game.getBoats();
		for(int i=0;i<boats.length;i++){
			boats[i].setPosX(BOAT_START_X+i*(BOAT_W+BOAT_DISTANCE));
			boats[i].setPosY(BOAT_START_Y);
		}
	}

	public void paintComponent(Graphics g) {
        super.paintComponent(g);       
    }
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	    Graphics2D g2 = (Graphics2D) g;
	    
	    this.drawSea(g2);
	    this.drawBoats(g2);
	}
	
	/**
	 * 画出大海（一组线段）
	 * @param g2  图形类
	 */
	public void drawSea(Graphics2D g2){
		for(int i=0;i<=Game.SEA_LENGTH;i++){
	    	g2.draw(new Line2D.Double(SEA_START_X, SEA_START_Y+i*SEA_INTERVAL, 
	    			SEA_START_X+SEA_W, SEA_START_Y+i*SEA_INTERVAL));
	    }
	}
	
	/**
	 * 根据小船的信息在界面上画出一条小船以及船上的所有位置
	 * @param g2 图形类
	 * @param b 一个小船对象
	 */
	public void drawBoat(Graphics2D g2, Boat b){
		g2.setColor(Color.GRAY);
		g2.fill(new Rectangle2D.Double(b.getPosX(), b.getPosY(), BOAT_W, BOAT_H));
		
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		g2.drawString(b.getCargo_value()+"", b.getPosX()+14, b.getPosY()+18);
		
		Position[] pos_list = b.getPos_list();
		for(int i=0; i<pos_list.length; i++){
			if(pos_list[i].getSailorID() == -1){
				g2.setColor(Color.BLACK);
				Rectangle2D r_pos = new Rectangle2D.Double(b.getPosX()+POS_START_X, 
						b.getPosY()+POS_START_Y+i*(POS_H+POS_INTERVAL),
						POS_W, POS_H);
				g2.draw(r_pos);
				g2.setFont(new Font("SansSerif", Font.PLAIN, 14));
				g2.drawString(pos_list[i].getPrice()+"", (int)r_pos.getX()+POS_W/2-4, (int)r_pos.getY()+POS_H/2+5);
			}
			else{
				g2.setColor(this.game.getPlayerByID(pos_list[i].getSailorID()).getC());
				g2.fill(new Rectangle2D.Double(b.getPosX()+POS_START_X, 
						b.getPosY()+POS_START_Y+i*(POS_H+POS_INTERVAL),
						POS_W, POS_H));
			}
		}
	}
	
	/**
	 * 画出所有的小船
	 * @param g2 图形类
	 */
	public void drawBoats(Graphics2D g2){
		Boat[] boats = this.game.getBoats();
		for(int i=0;i<boats.length;i++){
			this.drawBoat(g2, boats[i]);
		}
	}
}
