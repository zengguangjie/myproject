package gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.lang.reflect.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class ButtonGroups extends JFrame{
	public static String[] idStrings= {"June","Ward","Beaver","wally","eddie","lumpy"};
	static JPanel makeBPanel(Class<? extends AbstractButton>kind,String[] idStrings)
	{
		ButtonGroup bg=new ButtonGroup();
		JPanel jp=new JPanel();
		String title=kind.getName();
		title=title.substring(title.lastIndexOf('.')+1);
		jp.setBorder(new TitledBorder(title));
		for(String id:idStrings)
		{
			AbstractButton ab=new JButton("failed");
			try {
				Constructor<? extends AbstractButton> ctor=kind.getConstructor(String.class);
				ab=(AbstractButton)ctor.newInstance(id);
			}catch(Exception ex){
				System.err.println("Can't create "+kind);
			}
			bg.add(ab);
			jp.add(ab);
		}
		return jp;
	}
	public ButtonGroups()
	{
		setLayout(new FlowLayout());
		add(makeBPanel(JButton.class, idStrings));
		add(makeBPanel(JToggleButton.class, idStrings));
		add(makeBPanel(JCheckBox.class, idStrings));
		add(makeBPanel(JRadioButton.class, idStrings));
	}
	public static void main(String[] args)
	{
		run(new ButtonGroups(),500,300);
	}
}
