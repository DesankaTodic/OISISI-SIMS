package actions;

import gui.MyFrame;
import gui.WorkspaceTree;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import model.workspace.Project;

public class NewProjectAction extends AbstractAction {
	
public NewProjectAction(){
	//Icon icon = new ImageIcon("slike/Folder.png");
	putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
	putValue(SMALL_ICON, new ImageIcon("slike/Folder.png"));
	putValue(NAME, "New project");
	putValue(SHORT_DESCRIPTION, "New project");
}
public void changeName(){
	putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuNoviProjekat"));
	putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuNoviProjekat"));
}

public void actionPerformed(ActionEvent arg0) {
		
		Project p=new Project(" ");
		WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
		tree.getRoot().addProject(p);
		SwingUtilities.updateComponentTreeUI(MyFrame.getInstance()
				.getWorkspaceTree());
	}
}