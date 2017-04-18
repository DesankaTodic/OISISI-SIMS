package actions;

import gui.MyFrame;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.workspace.Document;
import model.workspace.Page;
import view.ProjectView;

public class NewPageAction extends AbstractAction{
	
	public NewPageAction(){
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));
		putValue(SMALL_ICON, new ImageIcon("slike/List.png"));
		putValue(NAME, "New page");
		putValue(SHORT_DESCRIPTION, "New page");
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuNovaStranica"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuNovaStranica"));
	}

	public void actionPerformed(ActionEvent arg0) {
		Object d=MyFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (d instanceof Document) {
			Page p = new Page("New page",(Document)d);
			((Document)d).addPage(p);
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());
			//preuzmi sve frejmove
			JInternalFrame[] frames = MyFrame.getInstance().getDesktop().getAllFrames();
			for (JInternalFrame frame : frames)	//prodji kroz sve frejmove
			{
				if (frame instanceof ProjectView)//ako je frejm instanca ProjectView
				{
					ProjectView view = (ProjectView)frame;
					if (((Document)d).getProject() == view.getProject())				//preuzmi njegov projekat
					{
						view.moveToFront();			//postavljenje projekta u fokus
						try {
							view.setSelected(true);	//selekcija fokusiranog projekta
						} catch (PropertyVetoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
					}
				}
			}
		}	
	}

}
