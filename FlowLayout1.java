package gui;

import javax.swing.*;
import java.awt.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class FlowLayout1 extends JFrame
{
	public FlowLayout1()
	{
		setLayout(new FlowLayout());
		for(int i=0;i<20;i++)
		{
			add(new JButton("JButton "+i));
		}
	}
	public static void main(String[] args)
	{
		run(new FlowLayout1(), 300, 300);
	}
}
