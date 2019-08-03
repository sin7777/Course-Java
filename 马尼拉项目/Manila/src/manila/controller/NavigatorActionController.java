package manila.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import manila.view.NavigatorActionView;

/**
 * 用于监听NavigatorActionView的类
 * @author Zuo
 */
public class NavigatorActionController implements ActionListener{

	NavigatorActionView nav;
	
	public NavigatorActionController(NavigatorActionView nav) {
		this.nav = nav;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("ahead1") && this.nav.getGame().getMap().getBoats().get(0).getState() == 1) {
			this.nav.getGame().moveBoatByConstant(0, 1);
			this.nav.dispose();
		}
		if(e.getActionCommand().equals("ahead1") && this.nav.getGame().getMap().getBoats().get(0).getState() == 0) {
			JOptionPane.showMessageDialog(null, "船已经沉了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("ahead1") && this.nav.getGame().getMap().getBoats().get(0).getState() == 2) {
			JOptionPane.showMessageDialog(null, "船已到港了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getActionCommand().equals("ahead2") && this.nav.getGame().getMap().getBoats().get(1).getState() == 1) {
			this.nav.getGame().moveBoatByConstant(1, 1);
			this.nav.dispose();
		}
		if(e.getActionCommand().equals("ahead2") && this.nav.getGame().getMap().getBoats().get(1).getState() == 0) {
			JOptionPane.showMessageDialog(null, "船已经沉了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("ahead2") && this.nav.getGame().getMap().getBoats().get(1).getState() == 2) {
			JOptionPane.showMessageDialog(null, "船已到港了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getActionCommand().equals("ahead3") && this.nav.getGame().getMap().getBoats().get(2).getState() == 1) {
			this.nav.getGame().moveBoatByConstant(2, 1);
			this.nav.dispose();
		}
		if(e.getActionCommand().equals("ahead3") && this.nav.getGame().getMap().getBoats().get(2).getState() == 0) {
			JOptionPane.showMessageDialog(null, "船已经沉了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("ahead3") && this.nav.getGame().getMap().getBoats().get(2).getState() == 2) {
			JOptionPane.showMessageDialog(null, "船已到港了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getActionCommand().equals("back1") && this.nav.getGame().getMap().getBoats().get(0).getState() == 1) {
			this.nav.getGame().moveBoatByConstant(0, -1);
			this.nav.dispose();
		}
		if(e.getActionCommand().equals("back1") && this.nav.getGame().getMap().getBoats().get(0).getState() == 0) {
			JOptionPane.showMessageDialog(null, "船已经沉了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("back1") && this.nav.getGame().getMap().getBoats().get(0).getState() == 2) {
			JOptionPane.showMessageDialog(null, "船已到港了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getActionCommand().equals("back2") && this.nav.getGame().getMap().getBoats().get(1).getState() == 1) {
			this.nav.getGame().moveBoatByConstant(1, -1);
			this.nav.dispose();
		}
		if(e.getActionCommand().equals("back2") && this.nav.getGame().getMap().getBoats().get(1).getState() == 0) {
			JOptionPane.showMessageDialog(null, "船已经沉了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("back2") && this.nav.getGame().getMap().getBoats().get(1).getState() == 2) {
			JOptionPane.showMessageDialog(null, "船已到港了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(e.getActionCommand().equals("back3") && this.nav.getGame().getMap().getBoats().get(2).getState() == 1) {
			this.nav.getGame().moveBoatByConstant(2, -1);
			this.nav.dispose();
		}
		if(e.getActionCommand().equals("back3") && this.nav.getGame().getMap().getBoats().get(2).getState() == 0) {
			JOptionPane.showMessageDialog(null, "船已经沉了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("back3") && this.nav.getGame().getMap().getBoats().get(2).getState() == 2) {
			JOptionPane.showMessageDialog(null, "船已到港了", "别再挪了", JOptionPane.INFORMATION_MESSAGE);
		}
		this.nav.getGame().getGame_view().updateboat();
		this.nav.getGame().getGame_view().update();
	}

}
