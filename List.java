package gui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class List extends JFrame{
	private String[] flavours= {"Chocolate", "Strawberry", "Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge", "Rum Raisin", "Praline Cream", "Mud Pie"};
	//private DefaultListModel<String> lItems=new DefaultListModel<String>();
	private JList<String> list=new JList<>(flavours);
	private JTextArea textArea=new JTextArea(flavours.length, 20);
	private JButton button=new JButton("Add Item");
	//private int count=0;
	private ActionListener bListener=new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			/*if(count<flavours.length)
				lItems.add(0, flavours[count++]);
			else
				button.setEnabled(false);*/
		}
	};
	private ListSelectionListener lListener=new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e)
		{
			if(e.getValueIsAdjusting()) return;
			textArea.setText("");
			for(Object item:list.getSelectedValuesList())
				textArea.append(item+"\n");
		}
	};
	public List()
	{
		textArea.setEditable(false);
		setLayout(new FlowLayout());
		Border border=new MatteBorder(1,1,2,2,Color.BLACK);
		list.setBorder(border);
		textArea.setBorder(border);
		/*for(int i=0;i<4;i++)
			lItems.addElement(flavours[count++]);*/
		add(textArea);
		add(list);
		add(button);
		list.addListSelectionListener(lListener);
		button.addActionListener(bListener);
	}
	public static void main(String[] args)
	{
		run(new List());
	}
}
