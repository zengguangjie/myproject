package gui;

import javax.swing.*;
import java.util.concurrent.*;

public class HelloSwing 
{
	public static void main(String[] args)throws Exception
	{
		JFrame frame=new JFrame("Hello swing");
		JLabel label=new JLabel("A label");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setVisible(true);
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				label.setText("Hey! This is Different");
			}
		});
	}
}
