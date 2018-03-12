package gui;

import static gui.SwingConsole.run;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Exercise10 extends JFrame{
	private JButton b1=new JButton("Button 1");
	private TextField t1=new TextField(10);
	public Exercise10()
	{
		setLayout(new FlowLayout());
		add(b1);
		add(t1);
		b1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				t1.setText(t1.getText()+e.getKeyChar());
			}
		});
	}
	public static void main(String[] args)
	{
		run(new Exercise10());
	}
}
