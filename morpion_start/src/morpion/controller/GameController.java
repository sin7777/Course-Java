package morpion.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import morpion.model.Player;
import morpion.view.GameView;

/**
 * 游戏控制器，用于响应玩家的鼠标操作
 *
 */
public class GameController implements MouseListener {
	/** 棋盘视图的引用 */
	private GameView gv;
	
	public GameController(GameView gv){
		this.gv = gv;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 3.1
		// 如果当前游戏仍未结束
		if(!this.gv.getGame().isGameEnded()){
			System.out.println("Clicked");  // remove it
			// 获取光标所在棋盘格
		
			// 如果当前光标所在block没有棋子
				// 在棋盘格中填充当前玩家对应的棋子
				
				// 重画棋盘
				
				// 更新游戏状态，并判断游戏是否结束
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
