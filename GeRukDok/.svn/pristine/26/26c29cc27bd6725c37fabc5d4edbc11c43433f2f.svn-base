package gui.listeners;

import gui.MyFrame;
import gui.WorkspaceTree;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.tree.TreePath;

import model.workspace.Project;
import view.ProjectView;

public class ProjectMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if (arg0.getClickCount()==1){
			//JOptionPane.showMessageDialog(null, "project Dupli klik i to sa : "+(arg0.getButton()==1?"Levi taster":arg0.getButton()==2?"Točkić":"Desni taster"));
			ProjectView view = (ProjectView)((Component)arg0.getSource()).getParent();
			WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
			Project project = view.getProject();
			tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] {tree.getRoot(), project}));
			//tree.setSelectionPath(project.getParent());
		}	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
