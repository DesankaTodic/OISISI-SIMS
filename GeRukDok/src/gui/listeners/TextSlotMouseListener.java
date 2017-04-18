package gui.listeners;

import gui.MyFrame;
import gui.WorkspaceTree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.tree.TreePath;

import view.DialogTextSlot;
import model.workspace.TextSlot;

public class TextSlotMouseListener implements MouseListener{
	private DialogTextSlot dtx;
	@Override
	public void mouseClicked(MouseEvent arg0) {

		if (arg0.getClickCount()==2){	
			System.out.println("proba");
			JPanel panel = (JPanel)arg0.getSource();
			TextSlot slot = (TextSlot)(panel).getClientProperty("textSlot");
			WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
			tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] {tree.getRoot(), slot.getPage().getDocument().getProject(), slot.getPage().getDocument(), slot.getPage(), slot}));
			
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