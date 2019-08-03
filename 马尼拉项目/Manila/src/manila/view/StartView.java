package manila.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;

public class StartView extends JFrame implements ActionListener{
	
	private ArrayList<JButton> playnumlist;
	
	public StartView() 
	{
		playnumlist = new ArrayList<JButton>();
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(100,100,245,110);
		this.setResizable(false);
		
		loadinButton();
		
		this.setVisible(true);
	}
	
	private void loadinButton()
	{
		JButton newbutton = new JButton("3 player");
		newbutton.setBounds(0, 0, 80, 80);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("3 player");
		this.add(newbutton);
		playnumlist.add(newbutton);
		
		newbutton = new JButton("4 player");
		newbutton.setBounds(80, 0, 80, 80);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("4 player");
		this.add(newbutton);
		playnumlist.add(newbutton);
		
		newbutton = new JButton("5 player");
		newbutton.setBounds(160, 0, 80, 80);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("5 player");
		this.add(newbutton);
		playnumlist.add(newbutton);
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("3 player"))
		{
			GameView gv = new GameView("Manila", 3);
			this.dispose();
		}
		if (arg0.getActionCommand().equals("4 player"))
		{
			GameView gv = new GameView("Manila", 4);
			this.dispose();
		}
		if (arg0.getActionCommand().equals("5 player"))
		{
			GameView gv = new GameView("Manila", 5);
			this.dispose();
		}
		
	}
	
	

}
