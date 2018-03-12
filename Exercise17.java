package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static gui.SwingConsole.run;

@SuppressWarnings("serial")
public class Exercise17 extends JFrame{
	private JPasswordField password=new JPasswordField(10);
	public Exercise17()
	{
		setLayout(new FlowLayout());
		add(new JLabel("Type in your password: "));
		add(password);
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String message="Incorrect Password";
				JPasswordField pass=(JPasswordField)e.getSource();
				if("Blarth".equals(new String(pass.getPassword())))
					message="Correct Password";
				JOptionPane.showMessageDialog(null, message, "information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
	public static void main(String[] args)
	{
		run(new Exercise17());
	}
}
