package model;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import view.MainView;

public class OperationPanel extends JPanel{
	private ArrayList<Club> clubs;
	private ArrayList<Activity> activities;
	private JButton[] clubButtons;
	private JButton[] activitiesButtons;
	private MainView mainView;
	private JTextField text;
	private JComboBox box;
	
	public void updateArrays()
	{
		updateBox();
		updateText();
		
		int px=0,py=0;
		
		JLabel label1=new JLabel("CLUBS");
		label1.setLocation(px,py);
		label1.setSize(40, 40);
		label1.setVisible(true);
		this.add(label1);
		py+=50;
		for(int i=0;i<clubButtons.length;i++)
		{
			clubButtons[i]=new JButton(clubs.get(i).getName());
			clubButtons[i].setLocation(px, py);
			clubButtons[i].setSize(100,100);
			clubButtons[i].setFont(new Font("宋体",Font.BOLD,16));
			clubButtons[i].setVisible(true);
			Club club=clubs.get(i);
			clubButtons[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i=0;i<clubButtons.length;i++)
						clubButtons[i].setVisible(false);
					for(int i=0;i<activitiesButtons.length;i++)
						activitiesButtons[i].setVisible(false);
					mainView.updateBeginDate();
					OperationPanel.this.remove(box);
					OperationPanel.this.remove(text);
					
					JButton b=new JButton(club.toString() + "<br>点击返回");
					b.setSize(200, 300);
					b.setVisible(true);
					b.setLocation(900, 400);
					OperationPanel.this.add(b);
					mainView.repaint();
					b.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							mainView.updateBeginDate();
							OperationPanel.this.remove((JButton) e.getSource());
							for(int i=0;i<clubButtons.length;i++)
								clubButtons[i].setVisible(true);
							for(int i=0;i<activitiesButtons.length;i++)
								activitiesButtons[i].setVisible(true);
							updateBox();
							updateText();
							mainView.repaint();
						}
						
					});
				}
				
			});
			py+=80;
			this.add(clubButtons[i]);
		}
		py=0;
		px=1000;
		JLabel label2=new JLabel("ACTIVITIES");
		label2.setLocation(px,py);
		label2.setSize(40, 40);
		label2.setVisible(true);
		this.add(label2);
		py+=30;
		for(int i=0;i<activitiesButtons.length;i++)
		{
			activitiesButtons[i]=new JButton(activities.get(i).getName());
			activitiesButtons[i].addActionListener(null);
			activitiesButtons[i].setSize(100,100);
			activitiesButtons[i].setLocation(px, py);
			activitiesButtons[i].setVisible(true);
			Activity activity=activities.get(i);
			activitiesButtons[i].addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int i=0;i<activitiesButtons.length;i++)
						activitiesButtons[i].setVisible(false);
					for(int i=0;i<clubButtons.length;i++)
						clubButtons[i].setVisible(false);
					mainView.updateBeginDate();
					OperationPanel.this.remove(box);
					OperationPanel.this.remove(text);
					
					JButton b=new JButton(activity.toString() + "<br>点击返回");
					b.setSize(200, 300);
					b.setVisible(true);
					b.setLocation(900, 400);
					OperationPanel.this.add(b);
					mainView.repaint();
					b.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							mainView.updateBeginDate();
							OperationPanel.this.remove((JButton) e.getSource());
							for(int i=0;i<clubButtons.length;i++)
								clubButtons[i].setVisible(true);
							for(int i=0;i<activitiesButtons.length;i++)
								activitiesButtons[i].setVisible(true);
							updateBox();
							updateText();
							mainView.repaint();
						}
						
					});
				}
				
			});
			py+=80;
			this.add(activitiesButtons[i]);
		}
	}
	
	public OperationPanel(MainView mainView,ArrayList<Club> clubs,ArrayList<Activity> activities)
	{
		this.setLayout(null);
		
		this.clubs=clubs;
		this.activities=activities;
		this.mainView=mainView;
		
		clubButtons=new JButton[clubs.size()];
		activitiesButtons=new JButton[activities.size()];
		
		updateArrays();
	}
	
	public void updateText()
	{
		text=new JTextField();
		text.setLocation(1200, 100);
		text.setSize(100, 20);
		this.add(text);
		text.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				mainView.updateBeginDate();
				String[] s=new String[3];
				s = text.getText().split("[.]");
				long[] is=new long[3];
				long time=0;

				if(s.length>3||s.length<1)
					return;
				try{
					for(int i=0;i<s.length;i++)
						is[i]=Integer.parseInt(s[i]);
				}catch(Exception e1){
					return;
				}
				time+=is[0]*365*24*3600*1000;
				if(is.length>1)
					time+=is[1]*30*24*3600*1000;
				if(is.length>2)
					time+=is[2]*24*3600*1000;
				
				for(int i=0;i<2;i++)
					System.out.println(is[i]);
				
				for(int i=0;i<activities.size();i++)
				{
					if(time<activities.get(i).getEstablishTime())
						activitiesButtons[i].setVisible(false);
					else
						activitiesButtons[i].setVisible(true);
				}

				for(int i=0;i<clubs.size();i++)
				{
					clubButtons[i].setVisible(false);
				}
				mainView.repaint();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				if(text.getText().isEmpty())
				{
					for(int i=0;i<clubButtons.length;i++)
						clubButtons[i].setVisible(true);
					for(int i=0;i<activitiesButtons.length;i++)
						activitiesButtons[i].setVisible(true);
					return;
				}
				insertUpdate(e);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				insertUpdate(e);
			}
			
		});
	}
	
	private void updateBox()
	{
		String[] ss=new String[3];
		ss[0]="排序方式";
		ss[1]="按照时间排序";
		ss[2]="按照人数排序";
		box=new JComboBox(ss);
		box.setLocation(300, 50);
		box.setSize(200, 50);
		box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainView.updateBeginDate();
				int index=((JComboBox) e.getSource()).getSelectedIndex();
				if(index==2)
				{
					OperationPanel.this.removeAll();
					Collections.sort(clubs, new ComparatorByMemberNumber());
					updateArrays();
					mainView.repaint();
				}
				else if(index==1)
				{
					OperationPanel.this.removeAll();
					Collections.sort(clubs, new ComparatorByEstablishTime());
					Collections.sort(activities, new ComparatorByEstablishTime());
					updateArrays();
					mainView.repaint();
				}
				else if(index==0)
				{
					OperationPanel.this.removeAll();
					Collections.sort(clubs,new ComparatorByInitialOrder());
					Collections.sort(activities,new ComparatorByInitialOrder());
					updateArrays();
					mainView.repaint();
				}
			}
			
		});
		this.add(box);
	}

}
