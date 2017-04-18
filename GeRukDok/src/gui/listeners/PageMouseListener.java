package gui.listeners;

import gui.MyFrame;
import gui.WorkspaceTree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.tree.TreePath;

import model.workspace.Page;

public class PageMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if (arg0.getClickCount()==1){
			//JOptionPane.showMessageDialog(null, " page Dupli klik i to sa : "+(arg0.getButton()==1?"Levi taster":arg0.getButton()==2?"Točkić":"Desni taster"));
			//JLabel panel = (JLabel)arg0.getSource();
			JPanel panel = (JPanel)arg0.getSource();
			Page page = (Page)(panel).getClientProperty("page");
			WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
			tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] {tree.getRoot(), page.getDocument().getProject(), page.getDocument(), page}));
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

