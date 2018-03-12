package gui;

import javax.swing.*;
import java.util.concurrent.*;
import static gui.SwingConsole.*;

@SuppressWarnings("serial")
class SubmitSwingProgram2 extends JFrame
{
	JLabel label;
	public SubmitSwingProgram2()
	{
		label=new JLabel("A Label");
		add(label);
	}
}

public class Exercise3
{
	static SubmitSwingProgram2 submitSwingProgram2;
	public static void main(String[] args)throws Exception
	{
		run(submitSwingProgram2=new SubmitSwingProgram2(),800,400);
		TimeUnit.SECONDS.sleep(1);
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				submitSwingProgram2.label.setText("Hey! This is Different");
			}
		});
	}
}
