package manila.controller;

import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonList extends ArrayList<JButton>{
	
	/**
	 * 通过名字或取按钮，
	 * 名字示例：shipyard1
	 * @return
	 */
	public JButton getByName(String name)
	{
		for(JButton jb : this)
			if (jb.getText().equals(name))
				return jb;
		return null;
	}

}
