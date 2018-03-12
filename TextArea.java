package gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static gui.SwingConsole.run;
import java.util.*;
import net.mindview.util.*;

@SuppressWarnings("serial")
public class TextArea extends JFrame
{
	private JButton 
	b=new JButton("Add Data"),
	c=new JButton("Clear Data");
	private JTextArea t=new JTextArea(20,40);
	private Map<String, String> m=new HashMap<>();
	public TextArea()
	{
		m.putAll(Countries.capitals());
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				for(Map.Entry<String,String> me:m.entrySet())
				{
					t.append(me.getKey()+": "+me.getValue()+"\n");
				}
			}
		});
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				t.setText("");
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(t));
		add(b);
		add(c);
	}
	public static void main(String[] args) 
	{
		run(new TextArea(), 800, 400);
	}

}
