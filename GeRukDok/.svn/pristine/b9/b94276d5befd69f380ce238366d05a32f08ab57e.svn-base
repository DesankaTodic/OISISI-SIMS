package actions;

import gui.MyFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class AboutDialogAction extends AbstractAction {
	
	public AboutDialogAction() {
		super();
		putValue(SMALL_ICON, new ImageIcon("slike/Info.png"));
		putValue(NAME, "About GeRuDok");
		putValue(SHORT_DESCRIPTION, "About GeRuDok");
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuAbout"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuAbout"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AboutDialog ad=new AboutDialog();
		ad.setVisible(true);	
	}

}
