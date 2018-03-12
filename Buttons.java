package gui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import java.awt.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class Buttons extends JFrame{
	private JButton jb=new JButton("JButton");
	private BasicArrowButton 
	up=new BasicArrowButton(BasicArrowButton.NORTH),
	down=new BasicArrowButton(BasicArrowButton.SOUTH),
	left=new BasicArrowButton(BasicArrowButton.WEST),
	right=new BasicArrowButton(BasicArrowButton.EAST);
	public Buttons()
	{
		setLayout(new FlowLayout());
		add(jb);
		add(new JToggleButton("JToggleButton"));
		add(new JCheckBox("JCheckBox"));
		add(new JRadioButton("JRadioButton"));
		JPanel jp=new JPanel();
		jp.setBorder(new TitledBorder("Directions"));
		jp.add(up);
		jp.add(down);
		jp.add(left);
		jp.add(right);
		add(jp);
	}
	public static void main(String[] args)
	{
		run(new Buttons());
	}
}
