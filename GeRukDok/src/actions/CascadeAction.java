package actions;

import gui.MyFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;


public class CascadeAction extends AbstractAction {
	

	public CascadeAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, new ImageIcon("slike/cascadeHor.png"));
		putValue(NAME, "Cascade");
		putValue(SHORT_DESCRIPTION, "Cascade");
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuKaskadno"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuKaskadno"));
	}
	

	public void actionPerformed(ActionEvent e) {
		MyFrame.getInstance().getDesktop().setLayout(null);
		JInternalFrame[] frames = MyFrame.getInstance().getDesktop()
				.getAllFrames();
		for (int i = 0; i < frames.length; i++) {
			JInternalFrame frame = frames[i];
			frame.setSize(new Dimension(400, 400));
			frame.setLocation(i * 40, i * 40);
			try {
				frame.setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
}
