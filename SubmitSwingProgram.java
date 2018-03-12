package gui;

import javax.swing.*;
import java.util.concurrent.*;

@SuppressWarnings("serial")
public class SubmitSwingProgram extends JFrame
{
	JLabel label;
	public SubmitSwingProgram()
	{
		super("Hello Swing");
		label=new JLabel("A Label");
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,400);
		setVisible(true);
	}
	static SubmitSwingProgram submitSwingProgram;
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				submitSwingProgram=new SubmitSwingProgram();
			}
		});
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				submitSwingProgram.label.setText("Hey! This is Different");
			}
		});
	}
}
