package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.mindview.util.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class TextPane extends JFrame{
	private JButton b=new JButton("Add text");
	private JTextPane tp=new JTextPane();
	private static Generator<String> sg=new RandomGenerator.String(7);
	public TextPane()
	{
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				for(int i=0;i<10;i++)
				{
					tp.setText(tp.getText()+sg.next()+"\n");
				}
			}
		});
		add(new JScrollPane(tp));
		add(BorderLayout.SOUTH,b);
	}
	public static void main(String[] args)
	{
		run(new TextPane(),475,425);
	}
}
