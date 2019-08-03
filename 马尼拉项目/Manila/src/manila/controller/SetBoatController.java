package manila.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import manila.view.SetBoatView;

/**
 * 该类用于监听SetBoatView
 * @author Zuo
 *
 */
public class SetBoatController implements ActionListener{

	private SetBoatView sbv;
	
	public SetBoatController(SetBoatView sbv) {
		this.sbv = sbv;
	}
	
	/**
	 * 判断一个字符串是否只包含数字；
	 * @param str 需要判断的字符串；
	 * @return 判断结果，只含数字为true；
	 */
	public boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){   
		   if (!Character.isDigit(str.charAt(i))){
		       return false;
		     }
		    }
		  return true;
		 }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(isNumeric(this.sbv.getBoat1().getText()) && isNumeric(this.sbv.getBoat2().getText()) && isNumeric(this.sbv.getBoat3().getText())) 
		{
			if(e.getActionCommand().equals("confirm")) 
			{
				if(this.sbv.getGame().setStartingPoint(Integer.parseInt(this.sbv.getBoat1().getText()), Integer.parseInt(this.sbv.getBoat2().getText()), Integer.parseInt(this.sbv.getBoat3().getText()))) 
				{
					this.sbv.dispose();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "请重新输入", "输入不合法", JOptionPane.ERROR_MESSAGE);
				}
		    }
			sbv.getGame().getGame_view().updateboat();
			sbv.getGame().getGame_view().update();
		}
	}
}
