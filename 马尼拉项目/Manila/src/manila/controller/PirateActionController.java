package manila.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import manila.view.PirateActionView;

/**
 * 用于监听PirateActionView的类
 * @author Zuo
 */
public class PirateActionController implements ActionListener{

	private PirateActionView pav;
	
	public PirateActionController(PirateActionView pav) {
		this.pav = pav;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("enter")) {
			if(this.pav.getGame().robBoatById(this.pav.getBoatId(), true)) {
				this.pav.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "", "掠夺失败！", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getActionCommand().equals("wreck")) {
			if(this.pav.getGame().robBoatById(this.pav.getBoatId(), false)) {
				this.pav.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "", "掠夺失败！", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
