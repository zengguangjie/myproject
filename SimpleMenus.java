package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class SimpleMenus extends JFrame{
	private JTextField textField=new JTextField(15);
	private ActionListener aListener=new ActionListener() {
		
		public void actionPerformed(ActionEvent e)
		{
			textField.setText(((JMenuItem)e.getSource()).getText());
		}
	};
	private JMenu[] menus= {
			new JMenu("Winken"),new JMenu("Blinken"),new JMenu("Nod")
	};
	private JMenuItem[] menuItems= {
			new JMenuItem("Fee"), new JMenuItem("Fi"),
			new JMenuItem("Fo"), new JMenuItem("Zip"),
			new JMenuItem("Zap"), new JMenuItem("Zot"),
			new JMenuItem("Olly"), new JMenuItem("Oxen"),
			new JMenuItem("Free")
	};
	public SimpleMenus()
	{
		for(int i=0;i<menuItems.length;i++)
		{
			menuItems[i].addActionListener(aListener);
			menus[i%3].add(menuItems[i]);
		}
		JMenuBar mBar=new JMenuBar();
		for(JMenu jMenu:menus)
			mBar.add(jMenu);
		setJMenuBar(mBar);
		setLayout(new FlowLayout());
		add(textField);
	}
	public static void main(String[] args)
	{
		run(new SimpleMenus(),200,150);
	}
}
