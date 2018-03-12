package gui;

import javax.swing.*;
import static gui.SwingConsole.run;
import java.awt.*;

@SuppressWarnings("serial")
public class Exercise8 extends JFrame
{
	private JTextField txt=new JTextField(10);
	private JButton b=new JButton("Button");
	Cursor hand=Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	public Exercise8()
	{
		setLayout(new FlowLayout());
		add(txt);
		add(b);
		txt.setCursor(hand);
		setCursor(hand);
	}
	public static void main(String[] args)
	{
		run(new Exercise8(), 800, 400);
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				
			}
		});*/
	}
}
