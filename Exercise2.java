 package gui;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.concurrent.*;

@SuppressWarnings("serial")
class DynamicHelloLabel extends JFrame
{
	private static Random rand=new Random(47);
	JLabel[] labels;
	DynamicHelloLabel()
	{
		super("Hello Label");
		setLayout(new FlowLayout());
		int numOfLabels=rand.nextInt(10)+1;
		labels=new JLabel[numOfLabels];
		for(int i=0;i<numOfLabels;i++)
		{
			add(labels[i]=new JLabel("label: "+i));
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,400);
		setVisible(true);
	}
}

public class Exercise2 
{
	static DynamicHelloLabel dhl;
	public static void main(String[] args) throws Exception
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				dhl=new DynamicHelloLabel();
			}
		});
		TimeUnit.SECONDS.sleep(2);
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				for(int i=0;i<dhl.labels.length;i++)
				{
					dhl.labels[i].setText("LABEL: "+i);
				}
			}
		});
	}
}
