package gui.listeners;

import gui.MyFrame;
import gui.WorkspaceTree;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.tree.TreePath;

import model.workspace.GraphicSlot;
import state.CircleState;
import state.RectangleState;
import state.SelectState;
import state.State;
import view.GraphicSlotView;

public class GraphicSlotMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if (arg0.getClickCount()==1){	
			JPanel panel = (JPanel)arg0.getSource();
			GraphicSlot slot = (GraphicSlot)(panel).getClientProperty("graphicSlot");
			WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
			tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] {tree.getRoot(), slot.getPage().getDocument().getProject(), slot.getPage().getDocument(), slot.getPage(), slot}));
		
			/* GraphicSlotView gsv = (GraphicSlotView)arg0.getSource();
			 State currentState = gsv.getStateManager().getCurrentState();
			 if(currentState instanceof SelectState){
				 MyFrame.getInstance().getPalette().setSelectButton(true);
				// System.out.println("selectt");
			 }else if(currentState instanceof CircleState){
				 MyFrame.getInstance().getPalette().setCircleButton(true);
				 //System.out.println("circle");
			 }else if(currentState instanceof RectangleState){
				 MyFrame.getInstance().getPalette().setRectangleButton(true);
				 //System.out.println("rectangle");
			 }*/
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