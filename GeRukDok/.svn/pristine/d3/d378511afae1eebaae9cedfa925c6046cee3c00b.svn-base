package gui;

import javax.swing.JPopupMenu;
import javax.swing.tree.TreeNode;

import model.elements.SlotElement;
import model.workspace.Document;
import model.workspace.GraphicSlot;
import model.workspace.Page;
import model.workspace.Project;
import model.workspace.TextSlot;
import model.workspace.Workspace;

public class MyPopupMenu extends JPopupMenu{
	public MyPopupMenu(TreeNode node){
		//JMenuItem neww = new JMenuItem();
		super();
		if(node instanceof Workspace){
			add(MyFrame.getInstance().getActionManager().getNewProjectAction());
			add(MyFrame.getInstance().getActionManager().getCascadeAction());
			add(MyFrame.getInstance().getActionManager().getTileHorizontallyAction());
			add(MyFrame.getInstance().getActionManager().getTileVerticallyAction());
			add(MyFrame.getInstance().getActionManager().getMatrixProjectViewAction());
		}
		else if(node instanceof Project){
			add(MyFrame.getInstance().getActionManager().getNewDocumentAction());
			add(MyFrame.getInstance().getActionManager().getDeleteAction());
		}else if(node instanceof Document){
			add(MyFrame.getInstance().getActionManager().getNewPageAction());
			add(MyFrame.getInstance().getActionManager().getDeleteAction());
		}else if(node instanceof Page){
			add(MyFrame.getInstance().getActionManager().getNewGraphicSlotAction());
			add(MyFrame.getInstance().getActionManager().getNewTextSlotAction());
			add(MyFrame.getInstance().getActionManager().getDeleteAction());
		}else if(node instanceof GraphicSlot){
			add(MyFrame.getInstance().getActionManager().getDeleteAction());
		}else if(node instanceof TextSlot){
			add(MyFrame.getInstance().getActionManager().getDeleteAction());
		}else if(node instanceof SlotElement){
			add(MyFrame.getInstance().getActionManager().getDeleteElementAction());
		}
		
			

	}
}
