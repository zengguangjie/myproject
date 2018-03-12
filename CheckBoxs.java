package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class CheckBoxs extends JFrame{
	private JTextArea textArea=new JTextArea(6,15);
	private JCheckBox
	cb1=new JCheckBox("CheckBox 1"),
	cb2=new JCheckBox("CheckBox 2"),
	cb3=new JCheckBox("CheckBox 3");
	public CheckBoxs()
	{
		cb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				trace("1",cb1);
			}
		});
		cb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				trace("2",cb2);
			}
		});
		cb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				trace("3",cb3);
			}
		});
		setLayout(new FlowLayout());
		add(cb1);
		add(cb2);
		add(cb3);
		add(new JScrollPane(textArea));
	}
	private void trace(String s,JCheckBox cb)
	{
		if(cb.isSelected())
			textArea.append("Box "+s+" Set\n");
		else
			textArea.append("Box "+s+" Cleared\n");
	}
	public static void main(String[] args)
	{
		run(new CheckBoxs());
	}
}
