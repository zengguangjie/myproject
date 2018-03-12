package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class ComboBoxs extends JFrame{
	private String[] description= {"Ebullient","Obtuse","Recalcitrant","Brilliant","Somnescent","Timorous","Florid","Putrescent"};
	private JTextField textField=new JTextField(15);
	private JComboBox<String> comboBox=new JComboBox<String>();
	private JButton jButton=new JButton("Add items");
	private int count=0;
	public ComboBoxs()
	{
		for(int i=0;i<4;i++)
			comboBox.addItem(description[count++]);
		textField.setEditable(false);
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(count<description.length)
					comboBox.addItem(description[count++]);
			}
		});
		comboBox.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("index: "+comboBox.getSelectedIndex()+" "+((JComboBox<String>)e.getSource()).getSelectedItem());
			}
		});
		comboBox.setEditable(true);
		setLayout(new FlowLayout());
		add(textField);
		add(comboBox);
		add(jButton);
	}
	public static void main(String[] args)
	{
		run(new ComboBoxs());
	}
}
