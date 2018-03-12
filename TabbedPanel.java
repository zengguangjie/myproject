package gui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class TabbedPanel extends JFrame{
	private String[] flavours= {"Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"};
	private JTabbedPane tabs=new JTabbedPane();
	private JTextField txt=new JTextField(20);
	public TabbedPanel()
	{
		int i=0;
		for(String flavour:flavours)
			tabs.addTab(flavour, new JButton("Tabbed pane "+i++));
		tabs.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				txt.setText("Tab selected: "+tabs.getSelectedIndex());
			}
		});
		add(BorderLayout.SOUTH, txt);
		add(tabs);
	}
	public static void main(String[] args)
	{
		run(new TabbedPanel(), 400, 250);
	}
}
