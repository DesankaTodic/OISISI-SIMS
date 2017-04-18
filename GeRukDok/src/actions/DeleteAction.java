package actions;

import gui.MyFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import model.workspace.Document;
import model.workspace.GraphicSlot;
import model.workspace.Page;
import model.workspace.Project;
import model.workspace.Slot;

public class DeleteAction extends AbstractAction{
	public DeleteAction(){
		//putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S,Event.CTRL_MASK));
		putValue(SMALL_ICON, new ImageIcon("slike/Delete.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete");
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuBrisanje"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuBrisanje"));
	}

	public void actionPerformed(ActionEvent arg0) {
		Object o = MyFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		
		TreePath path = MyFrame.getInstance().getWorkspaceTree().getSelectionPath();
		Object parent = path.getPathComponent(path.getPathCount()-2);//indeks roditelje je za 2 umanjen duzina putanje
																	//dati cvor se nalazi na duzina putanje-1
		if (o instanceof Project){
			MyFrame.getInstance().getWorkspaceTree().getRoot().removeProject((Project)o);
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());
			
		}else if (o instanceof Document){
			Project p = (Project) parent;
			Document d = (Document)o;
			p.removeDocument(d);
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());

		} else if (o instanceof Page){	
			Document d = (Document)parent;
			Page pg = (Page)o;
			d.removePage(pg);
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());
			

		}else if (o instanceof Slot){
			Object grandpa = path.getPathComponent(path.getPathCount()-3);
			Document d = (Document)grandpa;
			Page pg = (Page)parent;
			pg.removeSlot((Slot)o);
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());

			

		}
	}
}