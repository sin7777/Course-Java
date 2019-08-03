package manila.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import manila.controller.ButtonList;
import manila.model.Boat;
import manila.model.Game;

public class GameView extends JFrame implements ActionListener {
	
	private Game game;
	private JLabel background;
	private ArrayList<BoatView> bvlist;
	
	private ArrayList<Image> backimage;
	private ArrayList<JLabel> valuelist;
	private ArrayList<JLabel> sailorlist;
	private ButtonList buttonlist;
	private JButton loadCargoButton;
	private JButton choosbossbutton;
	private JButton buystocksbutton;
	private JButton dacebutton;
	private JButton movebutton;
	private JButton navibutton;
	private JButton nextvoyage;
	private JButton paystocks;
	private JButton jiesuan;
	
	private JPanel player;
	
	private JLayeredPane jl = null;
	
	public GameView(String name, int playNum)
	{	
		super("JLayeredPane");
		jl = this.getLayeredPane();
		
		backimage = new ArrayList<Image>();
		bvlist = new ArrayList<BoatView>();
		loadinImage();
		
		this.setTitle(name);
		this.game = new Game(playNum, this);
		this.buttonlist = new ButtonList();
		this.valuelist = new ArrayList<JLabel>();
		this.sailorlist = new ArrayList<JLabel>();
		this.player = new JPanel();
		player.setBounds(0, 440, 800, 240);
		player.setLayout(new GridLayout(1,playNum));
		
		// 设置窗体属性
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(100,100,800,680);
		this.setResizable(false);
		

		loadinValue();
				
		//BoatView bv = new BoatView("dd", 0);
		//this.add(bv);
		
		background = new JLabel();
		background.setIcon(new ImageIcon(backimage.get(0)));
		background.setBounds(0,0,800,400);
		jl.add(background,new Integer(0));
		
		loadinButtons();
		
		loadCargoButton = new JButton("装载货物");
		loadCargoButton.setBounds(100, 400, 100, 40);
		loadCargoButton.addActionListener(this);
		loadCargoButton.setActionCommand("loadCargoButton");
		jl.add(loadCargoButton, new Integer(100));
		
		choosbossbutton = new JButton("竞选船老大");
		choosbossbutton.setBounds(0, 400, 100, 40);
		choosbossbutton.addActionListener(this);
		choosbossbutton.setActionCommand("choosbossbutton");
		jl.add(choosbossbutton, new Integer(100));
		
		dacebutton = new JButton("下一回合");
		dacebutton.setBounds(500, 400, 100, 40);
		dacebutton.addActionListener(this);
		dacebutton.setActionCommand("dacebutton");
		jl.add(dacebutton, new Integer(100));
		
		movebutton = new JButton("放置船只");
		movebutton.setBounds(200, 400, 100, 40);
		movebutton.addActionListener(this);
		movebutton.setActionCommand("movebutton");
		jl.add(movebutton, new Integer(100));
		
		buystocksbutton = new JButton("购买股票");
		buystocksbutton.setBounds(300, 400, 100, 40);
		buystocksbutton.addActionListener(this);
		buystocksbutton.setActionCommand("buystocksbutton");
		jl.add(buystocksbutton, new Integer(100));
		
		nextvoyage = new JButton("下一航程");
		nextvoyage.setBounds(700, 400, 100, 40);
		nextvoyage.addActionListener(this);
		nextvoyage.setActionCommand("nextvoyage");
		jl.add(nextvoyage, new Integer(100));
		
		paystocks = new JButton("抵押股票");
		paystocks.setBounds(400, 400, 100, 40);
		paystocks.addActionListener(this);
		paystocks.setActionCommand("paystocks");
		jl.add(paystocks, new Integer(100));
		
		jiesuan = new JButton("结算分红");
		jiesuan.setBounds(600, 400, 100, 40);
		jiesuan.addActionListener(this);
		jiesuan.setActionCommand("jiesuan");
		jl.add(jiesuan, new Integer(100));
		
		loadinplayer();
		this.add(player);
		this.setVisible(true);
	}
	
	public void reloading()
	{
		loadinValue();
		updateValue();
		
		//BoatView bv = new BoatView("dd", 0);
		//this.add(bv);
		
		background = new JLabel();
		background.setIcon(new ImageIcon(backimage.get(0)));
		background.setBounds(0,0,800,400);
		jl.add(background,new Integer(0));
		
		loadinButtons();
		
		loadCargoButton = new JButton("装载货物");
		loadCargoButton.setBounds(100, 400, 100, 40);
		loadCargoButton.addActionListener(this);
		loadCargoButton.setActionCommand("loadCargoButton");
		jl.add(loadCargoButton, new Integer(100));
		
		choosbossbutton = new JButton("竞选船老大");
		choosbossbutton.setBounds(0, 400, 100, 40);
		choosbossbutton.addActionListener(this);
		choosbossbutton.setActionCommand("choosbossbutton");
		jl.add(choosbossbutton, new Integer(100));
		
		dacebutton = new JButton("下一回合");
		dacebutton.setBounds(500, 400, 100, 40);
		dacebutton.addActionListener(this);
		dacebutton.setActionCommand("dacebutton");
		jl.add(dacebutton, new Integer(100));
		
		movebutton = new JButton("放置船只");
		movebutton.setBounds(200, 400, 100, 40);
		movebutton.addActionListener(this);
		movebutton.setActionCommand("movebutton");
		jl.add(movebutton, new Integer(100));
		
		buystocksbutton = new JButton("购买股票");
		buystocksbutton.setBounds(300, 400, 100, 40);
		buystocksbutton.addActionListener(this);
		buystocksbutton.setActionCommand("buystocksbutton");
		jl.add(buystocksbutton, new Integer(100));
		
		nextvoyage = new JButton("下一航程");
		nextvoyage.setBounds(700, 400, 100, 40);
		nextvoyage.addActionListener(this);
		nextvoyage.setActionCommand("nextvoyage");
		jl.add(nextvoyage, new Integer(100));
		
		paystocks = new JButton("抵押股票");
		paystocks.setBounds(400, 400, 100, 40);
		paystocks.addActionListener(this);
		paystocks.setActionCommand("paystocks");
		jl.add(paystocks, new Integer(100));
		
		jiesuan = new JButton("结算分红");
		jiesuan.setBounds(600, 400, 100, 40);
		jiesuan.addActionListener(this);
		jiesuan.setActionCommand("jiesuan");
		jl.add(jiesuan, new Integer(100));
		
		loadinplayer();
		this.add(player);
		this.setVisible(true);
	}
	
	private void loadinplayer()
	{
		player.removeAll();
		for (int i = 0; i < game.getPlayers().size(); i++)
		{
			PlayerPanel pp = new PlayerPanel(game.getPlayers().get(i));
			player.add(pp);
		}
	}
	
	private void loadinImage()
	{
		try 
		{
		    File bg;
		    bg = new File("./src/Map.bmp");
			backimage.add(ImageIO.read(bg));
			bg = new File("./src/value.png");
			backimage.add(ImageIO.read(bg));
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadinButtons()
	{
		JButton newbutton;
		//ImageIcon im = new ImageIcon("./src/button.png");
		
		newbutton = new JButton("");
		newbutton.setBounds(130, 30, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		/*newbutton.setContentAreaFilled(false);
		newbutton.setFocusPainted(false);
		newbutton.setBorder(null);
		newbutton.setIcon(im);*/
		newbutton.addActionListener(this);
		newbutton.setActionCommand("shipyard1");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(255, 30, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("shipyard2");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(376, 30, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("shipyard3");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(15, 347, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("dock1");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(73, 347, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("dock2");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(132, 347, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("dock3");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(229, 355, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("pirate1");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(225, 379, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("pirate2");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(396, 380, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("navigator1");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(343, 380, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("navigator2");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
		newbutton = new JButton("");
		newbutton.setBounds(492, 39, 20, 20);
		newbutton.setOpaque(true);
		newbutton.setContentAreaFilled(false);
		newbutton.setBorder(null);
		newbutton.addActionListener(this);
		newbutton.setActionCommand("insurer");
		jl.add(newbutton,new Integer(100));
		buttonlist.add(newbutton);
		
	}
	
	private void loadinValue()
	{			
		JLabel value = new JLabel("0");
		value.setIcon(new ImageIcon(backimage.get(1)));
		value.setBounds(729,94,23,25);
		jl.add(value,new Integer(100));
		valuelist.add(value);
		
		value = new JLabel("1");
		value.setIcon(new ImageIcon(backimage.get(1)));
		value.setBounds(729,68,23,25);
		jl.add(value,new Integer(100));
		valuelist.add(value);
		
		value = new JLabel("2");
		value.setIcon(new ImageIcon(backimage.get(1)));
		value.setBounds(729,43,23,25);
		jl.add(value,new Integer(100));
		valuelist.add(value);
		
		value = new JLabel("3");
		value.setIcon(new ImageIcon(backimage.get(1)));
		value.setBounds(729,17,23,25);
		jl.add(value,new Integer(100));
		valuelist.add(value);
	}

	public void updateValue()
	{
		valuelist.get(0).setBounds(729-(23*game.getBlack_market().getnutmeg()),94,23,25);
		valuelist.get(1).setBounds(729-(23*game.getBlack_market().getsilk()),68,23,25);
		valuelist.get(2).setBounds(729-(23*game.getBlack_market().getginseng()),43,23,25);
		valuelist.get(3).setBounds(729-(23*game.getBlack_market().getjade()),17,23,25);
		System.out.println(game.getBlack_market().getnutmeg());
		System.out.println(game.getBlack_market().getsilk());
		System.out.println(game.getBlack_market().getginseng());
		System.out.println(game.getBlack_market().getjade());
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setBackground(JLabel background) {
		this.background = background;
	}

	public ArrayList<BoatView> getBvlist() {
		return bvlist;
	}

	public void setBvlist(ArrayList<BoatView> bvlist) {
		this.bvlist = bvlist;
	}

	public ArrayList<Image> getBackimage() {
		return backimage;
	}

	public void setBackimage(ArrayList<Image> backimage) {
		this.backimage = backimage;
	}

	public ArrayList<JLabel> getValuelist() {
		return valuelist;
	}

	public void setValuelist(ArrayList<JLabel> valuelist) {
		this.valuelist = valuelist;
	}

	public ButtonList getButtonlist() {
		return buttonlist;
	}

	public void setButtonlist(ButtonList buttonlist) {
		this.buttonlist = buttonlist;
	}

	public JButton getLoadCargoButton() {
		return loadCargoButton;
	}

	public void setLoadCargoButton(JButton loadCargoButton) {
		this.loadCargoButton = loadCargoButton;
	}

	public JButton getChoosbossbutton() {
		return choosbossbutton;
	}

	public void setChoosbossbutton(JButton choosbossbutton) {
		this.choosbossbutton = choosbossbutton;
	}

	public JButton getBuystocksbutton() {
		return buystocksbutton;
	}

	public void setBuystocksbutton(JButton buystocksbutton) {
		this.buystocksbutton = buystocksbutton;
	}

	public JPanel getPlayer() {
		return player;
	}

	public void setPlayer(JPanel player) {
		this.player = player;
	}

	public JLayeredPane getJl() {
		return jl;
	}

	public void setJl(JLayeredPane jl) {
		this.jl = jl;
	}

	public void update()
	{
		this.setVisible(false);
		loadinplayer();
		this.validate();
		this.setVisible(true);
	}
	
	public void loadinboat()
	{
		for (BoatView bv : bvlist)
	    jl.add(bv,new Integer(100));
	}
	
	public void updateboat()
	{
		bvlist.get(0).setBounds(678 - game.getMap().getBoats().get(0).getPos_in_the_sea() * 33, 190 - game.getMap().getBoats().get(0).getPos_in_the_sea() * 3, 120, 30);
		bvlist.get(1).setBounds(671 - game.getMap().getBoats().get(1).getPos_in_the_sea() * 33, 249 - game.getMap().getBoats().get(1).getPos_in_the_sea() * 3, 120, 30);
		bvlist.get(2).setBounds(666 - game.getMap().getBoats().get(2).getPos_in_the_sea() * 33, 311 - game.getMap().getBoats().get(2).getPos_in_the_sea() * 3, 120, 30);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("choosbossbutton"))
		{
			if (game.getStage() == 0) 
			{
				ChoosingBossView cbv = new ChoosingBossView(game, this);
				game.setStage(1);
			}
			//update();
		}
		if(arg0.getActionCommand().equals("loadCargoButton"))
		{
			if (game.getStage() == 1)
			{
				CargoView cv = new CargoView(bvlist, game, this);
				game.setStage(2);
			}
			//update();
		}
		if(arg0.getActionCommand().equals("dacebutton"))
		{
			if (game.getStage() == 3)
			{
				game.moveBoats();
				game.setSetnum(0);
				game.setCurrent_playerId(game.getCaptainID());
				//System.out.println(game.getRound());
				updateboat();
				this.update();
				if (game.getRound() == 3)
				{
					if (game.getMap().getNavigators()[1].getplayer_id() != -1)
					{
						NavigatorActionView nav1 = new NavigatorActionView(game);
					}
					if (game.getMap().getNavigators()[0].getplayer_id() != -1)
					{
						NavigatorActionView nav2 = new NavigatorActionView(game);
						NavigatorActionView nav3 = new NavigatorActionView(game);
					}
				}
				if ((game.getRound() == 3) && (game.getMap().getPirates()[0].getplayer_id() != -1))
				{
					for (int i = 0; i < game.getMap().getBoats().size(); i++)
						if (game.getMap().getBoats().get(i).getPos_in_the_sea() == 13)
						{
							PirateAboardView pav = new PirateAboardView(game,i);
						}
				}
				if ((game.getRound() == 4) && (game.getMap().getPirates()[0].getplayer_id() != -1))
				{
					for (int i = 0; i < game.getMap().getBoats().size(); i++)
						if (game.getMap().getBoats().get(i).getPos_in_the_sea() == 13)
						{
							PirateActionView pav = new PirateActionView(game,i);
						}
				}
			}
			//update();
		}
		if(arg0.getActionCommand().equals("movebutton"))
		{
			if (game.getStage() == 2)
			{
				SetBoatView sbv = new SetBoatView(game);
				game.setStage(4);
			}
			//update();
		}
		if(arg0.getActionCommand().equals("shipyard1"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(2, 0))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(130, 30, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("shipyard2"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(2, 1))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(255, 30, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("shipyard3"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(2, 2))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(376, 30, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("dock1"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(1, 0))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(15, 347, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("dock2"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(1, 1))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(73, 347, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("dock3"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(1, 2))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(132, 347, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("pirate1"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(4, 0))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(229, 355, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("pirate2"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(4, 1))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(225, 379, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("navigator1"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(3, 0))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(396, 380, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("navigator2"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(3, 1))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(343, 380, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("insurer"))
		{
			if ((game.getStage() == 3) && (game.getSetnum() < game.getPlayers().size()) && game.setEmployee(5, 0))
			{
				Image sailimage = null;
				try 
				{
				    File bg = new File("./src/" + game.getCurrentPlayer().getName() + "sailor.png");
					sailimage = ImageIO.read(bg);
				} 
				catch (IOException es)
				{
					// TODO Auto-generated catch block
					es.printStackTrace();
				}
				JLabel sailor = new JLabel(" ");
				sailor.setIcon(new ImageIcon(sailimage));
				sailor.setOpaque(false);
				sailor.setBounds(492, 39, 20, 20);
				jl.add(sailor, new Integer(200));
				sailorlist.add(sailor);
				game.switchPlayer();
				System.out.println(game.getSetnum());
			}
			update();
		}
		if(arg0.getActionCommand().equals("buystocksbutton"))
		{
			if (game.getStage() == 4) 
			{
				BuyStockView bsv = new BuyStockView(game);
				game.setStage(3);
			}
			//update();
		}
		if(arg0.getActionCommand().equals("paystocks") && game.getCurrentPlayer().loan(game.getBank()))
		{
			this.update();
			//update();
		}
		if(arg0.getActionCommand().equals("jiesuan"))
		{
			if (game.getRound() == 4)
			{
			    game.distributeProfit();
			    if (game.checkWin() != -1)
			    {
				    ShowWinnerView swv = new ShowWinnerView(game);
			    }  
			    updateValue();
			    this.update();
			    game.setStage(6);
			}
			//update();
		}
		if(arg0.getActionCommand().equals("nextvoyage"))
		{
			if ((game.getStage() == 6) && (!game.isGameOver()))
			{
			    for (BoatView bv : bvlist)
				    jl.remove(bv);
			    bvlist = new ArrayList<BoatView>();
			    for (JLabel jls : sailorlist)
				    jl.remove(jls);
			    sailorlist = new ArrayList<JLabel>();
			    game.preparation();
			    updateValue();
			    this.update();
			}
			//update();
		}
	}
}
