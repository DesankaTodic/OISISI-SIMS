package actions;




import gui.MyFrame;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.Iterator;

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
import commands.DeleteDeviceCommand;

public class DeleteElementAction extends AbstractAction{
	
	public DeleteElementAction(){
		putValue(NAME, "Delete element");
	    putValue(SHORT_DESCRIPTION, "Delete element");
	    putValue(SMALL_ICON,new ImageIcon("slike/deleteG.png"));
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("btnBrisanjeElementa"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("btnBrisanjeElementa"));
	}
	public void actionPerformed(ActionEvent e) {
		Object o = MyFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		TreePath path = MyFrame.getInstance().getWorkspaceTree().getSelectionPath();
		if(o instanceof SlotElement){
			System.out.println("*****delete");
			SlotElement element = (SlotElement)o;
			
			GraphicSlot slot = (GraphicSlot) path.getPathComponent(path.getPathCount()-2);
			Page pg = (Page)path.getPathComponent(path.getPathCount()-3);
			Document d = (Document)path.getPathComponent(path.getPathCount()-4);
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
											Point position = (Point)element.getPosition();
											slotView.getCommandManager().addCommand(new DeleteDeviceCommand(slotView.getGraphicSlot().getModel(),slotView.getGraphicSlot().getSelectionModel(),position,GraphicSlotView.CIRCLE,(Object)slotView));
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
