package gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import static net.mindview.util.SwingConsole.*;

@SuppressWarnings("serial")
class UpperCaseDocument extends PlainDocument
{
	private boolean uppercase=true;
	public void setUpperCase(boolean flag)
	{
		uppercase=flag;
	}
	public void insertString(int offset, String str, AttributeSet attset)throws BadLocationException
	{
		if(uppercase)str=str.toUpperCase();
		super.insertString(offset, str, attset);
	}
}

@SuppressWarnings("serial")
public class TextFields extends JFrame{
	private JButton
	b1=new JButton("Get Text"),
	b2=new JButton("Set Text");
	private JTextField 
	t1=new JTextField(30),
	t2=new JTextField(30),
	t3=new JTextField(30);
	private String string="";
	private UpperCaseDocument ucd=new UpperCaseDocument();
	public TextFields()
	{
		t1.setDocument(ucd);
		ucd.addDocumentListener(new T1());
		b1.addActionListener(new B1());
		b2.addActionListener(new B2());
		t1.addActionListener(new T1A());
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(t1);
		add(t2);
		add(t3);
	}
	class T1 implements DocumentListener
	{
		public void changedUpdate(DocumentEvent e) {}
		public void insertUpdate(DocumentEvent e)
		{
			t2.setText(t1.getText());
			t3.setText("Text: "+t1.getText());
		}
		public void removeUpdate(DocumentEvent e)
		{
			t2.setText(t1.getText());
		}
	}
	class T1A implements ActionListener
	{
		private int count=0;
		public void actionPerformed(ActionEvent e)
		{
			t3.setText("t1 Action Event "+count++);
		}
	}
	class B1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(t1.getSelectedText()==null)
				string=t1.getText();
			else
				string=t1.getSelectedText();
			t1.setEditable(true);
		}
	}
	class B2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ucd.setUpperCase(false);
			t1.setText("Inserted by Button2: "+string);
			ucd.setUpperCase(true);
			t1.setEnabled(false);
		}
	}
	public static void main(String[] args)
	{
		run(new TextFields(), 375, 200);
	}
}
