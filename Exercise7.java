package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
class AllAction extends JFrame
{
	JMenuItem mi=new JMenuItem("Menu Item");
	JTextField txt=new JTextField(30);
	JButton b1=new JButton("Button 1");
	JComboBox<String> jcb=new JComboBox<>(new String[] {
			"Elements","To","Place","In","Combobox"
	});
	JFileChooser jfc=new JFileChooser(".");
	public AllAction()
	{
		setLayout(new FlowLayout());
		add(mi);
		add(txt);
		add(b1);
		add(jcb);
		add(jfc);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				txt.setText("Button pressed");
			}
		});
		txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "JTextField ActionListener fired", "information",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		jcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				txt.setText("FileChooser ActionListener fired: "+jfc.getSelectedFile());
			}
		});
		mi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				txt.setText("JMenuItem selected");
			}
		});
		new Timer(5000,new ActionListener() {
			int i=0;
			public void actionPerformed(ActionEvent e)
			{
				txt.setText("Time Ticked "+i++);
			}
		}).start();
	}
}

public class Exercise7 
{
	public static void main(String[] args)
	{
		run(new AllAction(), 800, 400);
	}
}
