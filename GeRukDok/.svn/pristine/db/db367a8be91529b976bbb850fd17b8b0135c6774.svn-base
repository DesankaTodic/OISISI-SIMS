package actions;

import gui.MyFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class MatrixProjectViewAction extends AbstractAction {

	public MatrixProjectViewAction()
	  {
		    putValue(NAME, "Matrix Project View");
		    putValue(SHORT_DESCRIPTION, "Matrix Project View");
		    putValue(ACCELERATOR_KEY, 
		      KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		    putValue(SMALL_ICON,new ImageIcon("slike/matric.gif"));
		  }
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuMatricno"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuMatricno"));
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MyFrame.getInstance().getDesktop().setLayout(new GridLayout(3,3));
		MyFrame.getInstance().getDesktop().validate(); 		//da bi moglo da se prebacuje u istom trenutku
	
	}
}
