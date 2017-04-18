package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class PageLayoutAction implements ActionListener{
	private int count;
	private JPanel panel;
	
	public PageLayoutAction(int count, JPanel panel) {
		this.count = count;
		this.panel = panel;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
}