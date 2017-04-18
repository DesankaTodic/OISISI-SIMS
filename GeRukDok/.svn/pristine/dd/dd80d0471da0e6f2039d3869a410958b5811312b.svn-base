package actions;

import gui.MyFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import model.workspace.Page;
import model.workspace.TextSlot;

public class NewTextSlotAction extends AbstractAction{
	public NewTextSlotAction(){
		//putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));
		putValue(SMALL_ICON, new ImageIcon("slike/text_slot.png"));
		putValue(NAME, "New text slot");
		putValue(SHORT_DESCRIPTION, "New text slot");
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuNoviTekstualniSlot"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuNoviTekstualniSlot"));
	}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object p=MyFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		if (p instanceof Page) {
			TextSlot s = new TextSlot("", (Page)p);
			((Page)p).addSlot(s);
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());
		}
	}
}
