package actions;

import gui.MyFrame;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.tree.TreePath;

import model.elements.SlotElement;
import model.workspace.Document;
import model.workspace.GraphicSlot;
import model.workspace.Page;
import view.DocView;
import view.GraphicSlotView;
import view.PageView;
import view.ProjectView;

public class UndoAction extends AbstractAction {
	
	public UndoAction(){
		putValue(NAME, "Undo");
	    putValue(SHORT_DESCRIPTION, "Undo");
	    putValue(SMALL_ICON,new ImageIcon("slike/Undo.png"));
		
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("btnUndo"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("btnUndo"));
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = MyFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		TreePath path = MyFrame.getInstance().getWorkspaceTree().getSelectionPath();
		//Object parent = path.getPathComponent(path.getPathCount()-2);
		if(o instanceof GraphicSlot){
			System.out.println("*****unndooooo");
			//SlotElement element = (SlotElement)o;
			GraphicSlot slot = (GraphicSlot) o;
			Page pg = slot.getPage();
			Document d = pg.getDocument();
			JInternalFrame frame = MyFrame.getInstance().getDesktop().getSelectedFrame();
			ProjectView view = (ProjectView)frame;
			for(DocView dv : view.getDocuments())
				{
					if(dv.getName() == d.getName())
					{
						for (PageView pv : dv.getPages()) 
						{
							if (pv.getName() == pg.getName()) 
							{
								for(int i = 0;i < pv.getSlotSize();i++)
								{
									Object oslot = pv.getSlot(i);
									if(oslot instanceof GraphicSlotView)
									{
										GraphicSlotView slotView = (GraphicSlotView)oslot;
										if (slot.getName() == slotView.getName())
										{
											slotView.getCommandManager().undoCommand();
										}
									}
								}
							}
						}
					}
				}
			
		}

	}
}
