package view;

import gui.listeners.TextSlotMouseListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import model.workspace.TextSlot;
		

public class TextSlotView extends JPanel{
	private TextSlot slot = null;
	
	public TextSlotView(TextSlot s){
		//super();
		slot=s;
		setBorder(new TitledBorder(new EtchedBorder(), s.getName()));
	    setLayout(new BorderLayout());

		setName(s.getName());
		
//		Font font = new Font("Verdana", Font.BOLD, 20);
//		setFont(font);
		//txt.setMinimumSize(new Dimension(100,100));
		setPreferredSize(new Dimension(500,200));
		setBackground(Color.white);
		addMouseListener(new TextSlotMouseListener());
		
		repaint();
		validate();
		
		
	}
}
