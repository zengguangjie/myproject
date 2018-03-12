package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class Menus extends JFrame{
	private String[] flavours= {
			"Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"
	};
	private JTextField textField=new JTextField("No flavor", 30);
	private JMenuBar menuBar1=new JMenuBar();
	private JMenu
	file=new JMenu("File"),
	flavors=new JMenu("Flavors"),
	safety=new JMenu("Safety");
	private JRadioButtonMenuItem[] safetys= {new JRadioButtonMenuItem("Guard"), new JRadioButtonMenuItem("Hide")};
	private JMenuItem[] files= {new JMenuItem("Open")};
	private JMenuBar menuBar2=new JMenuBar();
	private JMenu fooBar=new JMenu("fooBar");
	private JMenuItem[] other= {
			new JMenuItem("Foo", KeyEvent.VK_F),
			new JMenuItem("Bar", KeyEvent.VK_A),
			new JMenuItem("Baz")
	};
	private JButton button=new JButton("Swap Menus");
	class BL implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			JMenuBar m=getJMenuBar();
			setJMenuBar(m==menuBar1?menuBar2:menuBar1);
			validate();
		}
	}
	class ML implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JMenuItem target=(JMenuItem)e.getSource();
			String actionCommand=target.getActionCommand();
			if(actionCommand.equals("Open"))
			{
				String string=textField.getText();
				boolean chosen=false;
				for(String flavor:flavours)
					if(string.equals(flavor))
						chosen=true;
				if(!chosen)
					textField.setText("Choose a flavor first!");
				else
					textField.setText("Opening "+string+". Mmm, mm!");
			}
		}
	}
	class FL implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JMenuItem target=(JMenuItem)e.getSource();
			textField.setText(target.getText());
		}
	}
	class FooL implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			textField.setText("Foo selected");
		}
	}
	class BarL implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			textField.setText("Bar selected");
		}
	}
	class BazL implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			textField.setText("Baz selected");
		}
	}
	class CMIL implements ItemListener{
		public void itemStateChanged(ItemEvent e)
		{
			JRadioButtonMenuItem target=(JRadioButtonMenuItem)e.getSource();
			String actionCommand=target.getActionCommand();
			if(actionCommand.equals("Guard"))
				textField.setText("Guard the Ice Cream! "+"Guarding is "+target.isSelected());
			else if(actionCommand.equals("Hide"))
				textField.setText("Hide the Ice Cream! "+"Is it hidden? "+target.isSelected());
		}
	}
	public Menus()
	{
		ML ml=new ML();
		CMIL cmil=new CMIL();
		safetys[0].setActionCommand("Guard");
		safetys[0].setMnemonic(KeyEvent.VK_G);
		safetys[0].addItemListener(cmil);
		safetys[1].setActionCommand("Hide");
		safetys[1].setMnemonic(KeyEvent.VK_H);
		safetys[1].addItemListener(cmil);
		other[0].addActionListener(new FooL());
		other[1].addActionListener(new BarL());
		other[2].addActionListener(new BazL());
		FL fl=new FL();
		int n=0;
		for(String flavor:flavours)
		{
			JMenuItem mi=new JMenuItem(flavor);
			mi.addActionListener(fl);
			flavors.add(mi);
			if((n++ +1%3)==0)
				flavors.addSeparator();
		}
		for(JRadioButtonMenuItem sfty:safetys)
			safety.add(sfty);
		safety.setMnemonic(KeyEvent.VK_A);
		file.add(safety);
		file.setMnemonic(KeyEvent.VK_F);
		for(int i=0;i<files.length;i++)
		{
			files[i].addActionListener(ml);
			file.add(files[i]);
		}
		menuBar1.add(file);
		menuBar2.add(flavors);
		setJMenuBar(menuBar1);
		textField.setEditable(false);
		add(textField,BorderLayout.CENTER);
		button.addActionListener(new BL());
		button.setMnemonic(KeyEvent.VK_S);
		add(button, BorderLayout.NORTH);
		for(JMenuItem oth:other)
			fooBar.add(oth);
		fooBar.setMnemonic(KeyEvent.VK_B);
		menuBar2.add(fooBar);
	}
	public static void main(String[] args)
	{
		run(new Menus(),300,200);
	}
}
