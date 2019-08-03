package manila.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import manila.model.Game;

public class CargoView  extends JFrame implements ActionListener {
	
	private ArrayList<BoatView> boatlist;
	private ArrayList<JCheckBox> cblist;
	
	private int boatnum = 0;
	private int loadcargo[] = {0,0,0};
	
	private Game g;
	private GameView gv;
	
	public CargoView(ArrayList<BoatView> boatlists, Game ga, GameView gvs)
	{
		boatlist = boatlists;
		cblist = new ArrayList<JCheckBox>();
		g = ga;
		gv = gvs;
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(100,100,100,150);
		this.setResizable(false);
		
		loadinButton();
		
		this.setVisible(true);
	}
	
	private void loadinButton()
	{
		JCheckBox newjc = new JCheckBox("Jade");
		newjc.setBounds(0, 0, 100, 20);
		this.add(newjc);
		cblist.add(newjc);
		
		newjc = new JCheckBox("Ginseng");
		newjc.setBounds(0, 20, 100, 20);
		this.add(newjc);
		cblist.add(newjc);
		
		newjc = new JCheckBox("Silk");
		newjc.setBounds(0, 40, 100, 20);
		this.add(newjc);
		cblist.add(newjc);
		
		newjc = new JCheckBox("Nutmeg");
		newjc.setBounds(0, 60, 100, 20);
		this.add(newjc);
		cblist.add(newjc);
		
		JButton dec = new JButton("确认");
		dec.setBounds(0, 80, 100, 20);
		dec.addActionListener(this);
		dec.setActionCommand("dec");
		this.add(dec);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("dec"))
		{
			if (cblist.get(0).isSelected() && (boatnum < 3))
			{
				boatlist.add(new BoatView("jade", boatnum, g));
				loadcargo[boatnum] = 4;
				boatnum++;
			}
			if (cblist.get(1).isSelected() && (boatnum < 3))
			{
				boatlist.add(new BoatView("ginseng", boatnum, g));
				loadcargo[boatnum] = 3;
				boatnum++;
			}
			if (cblist.get(2).isSelected() && (boatnum < 3))
			{
				boatlist.add(new BoatView("silk", boatnum, g));
				loadcargo[boatnum] = 2;
				boatnum++;
			}
			if (cblist.get(3).isSelected() && (boatnum < 3))
			{
				boatlist.add(new BoatView("nutmeg", boatnum, g));
				loadcargo[boatnum] = 1;
				boatnum++;
			}
			g.loadCargo(loadcargo[0], loadcargo[1], loadcargo[2]);
			gv.loadinboat();
			gv.update();
			this.dispose();
		}
	}

}
