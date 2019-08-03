package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import model.*;

public class MainView extends JFrame{
	private ArrayList<Club> clubs;
	private ArrayList<Activity> activities;
	private String[][] images=new String[10][];
	private boolean openingStatus=true;
	private boolean operationStatus=false;
	ImagePanel imagePanel;
	OperationPanel operationPanel;
	long timeMaxGap=10000;
	Date beg;
	Random rand=new Random(47);
	
	public MainView()
	{
		super();
		
		Controller controller=new Controller(this);
		
		beg=new Date(0);
		
		clubs=Club.createClubs();
		activities=Activity.createActivities();
		imagePanel=new ImagePanel();
		operationPanel=new OperationPanel(this,clubs,activities);
		loadImage();
		
		// 设置窗体属性
		this.setSize(new Dimension(1920,1080));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(0,0);
		
		imagePanel.setVisible(true);
		imagePanel.addMouseListener(new Controller(this));
		this.add(imagePanel);
		
		operationPanel.setVisible(true);
		operationPanel.addMouseListener(new Controller(this));
		
		this.setVisible(true);
		
		while(true)
		{
			if(System.currentTimeMillis()-beg.getTime()>timeMaxGap)
			{
				operationStatus=false;
				openingStatus=true;
				imagePanel.setVisible(true);
				this.remove(operationPanel);
			}
			playImage();
			if(openingStatus==false)
			{
				imagePanel.setVisible(false);
				if(operationStatus==false)
				{
					this.add(operationPanel);
					operationStatus=true;
				}
			}
		}
		
	}
	
	private void playImage()
	{
		for(int i=0;i<10;i++)
		{
			for(int r=0;r<2;r++)
			{
				if(!openingStatus)
					return;
				
				int cur=rand.nextInt(10);
				imagePanel.setImage(images[i][cur]);
				imagePanel.repaint();
				operationStatus=false;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public boolean getOpeningStatus()
	{
		return openingStatus;
	}
	
	private void loadImage() {
		for(int i=0;i<10;i++)
		{
			images[i]=new String[10];
			for(int r=0;r<10;r++)
			{
				String s="pic";
				String s2=Integer.toString(i);
				String s3=Integer.toString(r);
				String res=s + "/" + s2 + "/" + s3 + ".jpg";
				images[i][r]=res;
			}
		}
	}

	public static void main(String[] args)
	{
		new MainView();
	}

	public void setOpeningStatus(boolean res) {
		// TODO Auto-generated method stub
		openingStatus=res;
	}

	public void updateBeginDate() {
		// TODO Auto-generated method stub
		beg.setTime(System.currentTimeMillis());
	}
}
