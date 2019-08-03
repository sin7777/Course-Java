package manila.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manila.view.PirateAboardView;

/**
 * 用于监听PirateAboardView类
 * @author Zuo
 */
public class PirateAboardController implements ActionListener{

	private PirateAboardView pav;
	
	public PirateAboardController(PirateAboardView pav) {
		this.pav = pav;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("yes")) {
			this.pav.getGame().pirateAboard(this.pav.getBoatId());
			this.pav.dispose();
		}
		if(e.getActionCommand().equals("no")) {
			this.pav.dispose();
		}
	}

}
