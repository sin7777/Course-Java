package manila.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import manila.motor.Boat;
import manila.motor.Game;
import manila.motor.Player;

/**
 * 控制鼠标交互的事件监听类
 */
public class GameController implements MouseListener {
	
	private Game game;
	

	public GameController(Game g){
		this.game = g;
	}
	
	/**
	 * 根据鼠标是否点击在小船上，作出相应的相应
	 * @param x 鼠标光标x坐标
	 * @param y 鼠标光标y坐标
	 */
	public void clickedOnBoat(int x, int y){
		Boat[] boats = game.getBoats();
		for(int i=0; i<boats.length; i++){
			Boat b = boats[i];
			// 判断光标是否落在小船上
			// TODO: 如果是，则登船，修改相关对象的属性值，并修改显示界面，再修改game对象的属性
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(!this.game.isGameIsOver() && this.game.isChoosing()){
			this.clickedOnBoat(arg0.getX(), arg0.getY());
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
