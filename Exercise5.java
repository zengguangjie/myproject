package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class Exercise5 extends JFrame
{
	private JTextField txt=new JTextField(20);
	private JButton 
	b1=new JButton("Button 1"),
	b2=new JButton("Button 2"),
	b3=new JButton("Button 3");
	private JCheckBox cb=new JCheckBox("CheckBox");
	public Exercise5()
	{
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				txt.setText("The first button");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				txt.setText("The second button");
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				txt.setText("The third button");
			}
		});
		cb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				txt.setText(cb.isSelected()?"cb set":"cb cleared");
			}
		});
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(b3);
		add(cb);
		add(txt);
	}
	public static void main(String[] args)
	{
		run(new Exercise5(), 800, 400);
	}
}
