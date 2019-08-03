package manila.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import manila.view.BuyStockView;

/**
 * 此类用于监听BuyStockView
 * @author Zuo
 */
public class BuyStockController implements ActionListener{

	private BuyStockView bsv;
	
	public BuyStockController(BuyStockView bsv) {
		this.bsv = bsv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("nutmeg")) {
			if(this.bsv.getGame().getCapatainPlayer().buyStock(1, this.bsv.getGame().getBlack_market())) {
				this.bsv.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "购买失败！", "购买失败!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getActionCommand().equals("silk")) {
			if(this.bsv.getGame().getCapatainPlayer().buyStock(2, this.bsv.getGame().getBlack_market())) {
				this.bsv.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "购买失败！", "购买失败!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getActionCommand().equals("ginseng")) {
			if(this.bsv.getGame().getCapatainPlayer().buyStock(3, this.bsv.getGame().getBlack_market())) {
				this.bsv.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "购买失败！", "购买失败!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getActionCommand().equals("jade")) {
			if(this.bsv.getGame().getCapatainPlayer().buyStock(4, this.bsv.getGame().getBlack_market())) {
				this.bsv.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "购买失败！", "购买失败!", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		if(e.getActionCommand().equals("giveUp")) {
			this.bsv.dispose();
		}
		bsv.getGame().getGame_view().update();
	}
}
