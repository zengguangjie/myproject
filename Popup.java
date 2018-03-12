package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class Popup extends JFrame{
	private JPopupMenu popup=new JPopupMenu();
	private JTextField textField=new JTextField(10);
	public Popup()
	{
		setLayout(new FlowLayout());
		add(textField);
		ActionListener al=new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				textField.setText(((JMenuItem)e.getSource()).getText());
			}
		};
		JMenuItem menuItem=new JMenuItem("Hither");
		menuItem.addActionListener(al);
		popup.add(menuItem);
		menuItem=new JMenuItem("Yon");
		menuItem.addActionListener(al);
		popup.add(menuItem);
		menuItem=new JMenuItem("Afar");
		menuItem.addActionListener(al);
		popup.add(menuItem);
		popup.addSeparator();
		menuItem=new JMenuItem("Stay here");
		menuItem.addActionListener(al);
		popup.add(menuItem);
		PopupListener pl=new PopupListener();
		addMouseListener(pl);
		textField.addMouseListener(pl);
	}
	class PopupListener extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			maybeShowPopup(e);
		}
		@Override
		public void mouseReleased(MouseEvent e)
		{
			maybeShowPopup(e);
		}
		private void maybeShowPopup(MouseEvent e)
		{
			if(e.isPopupTrigger())
				popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	public static void main(String[] args)
	{
		run(new Popup());
	}
}
