package commands;

import gui.MyFrame;
import gui.WorkspaceTree;

import java.awt.geom.Point2D;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import model.SlotModel;
import model.SlotSelectionModel;
import model.elements.CircleElement;
import model.elements.RectangleElement;
import model.elements.SlotElement;
import model.workspace.GraphicSlot;
import view.GraphicSlotView;


public class AddDeviceCommand  extends AbstractCommand{

	SlotModel model;
	Point2D lastPosition;
	SlotElement element = null;
	SlotSelectionModel selectionModel;
	int elementType;
	Object obj;
	
	public AddDeviceCommand(SlotModel model,SlotSelectionModel selectionModel, Point2D lastPosition,int elementType,Object m) {
		this.model = model;
		this.lastPosition = lastPosition;
		this.selectionModel = selectionModel;
		this.elementType=elementType;	
		obj=m;

	}

	@Override
	public void doCommand() {
		if (elementType==GraphicSlotView.CIRCLE){
			element=CircleElement.createDefault(lastPosition,model.getElementsCount());
			GraphicSlot gs = ((GraphicSlotView) obj).getGraphicSlot();
			gs.addElements(element, element.getName());
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());
				
				
		}else if (elementType==GraphicSlotView.RECTANGLE){
			element=RectangleElement.createDefault(lastPosition,model.getElementsCount());
			GraphicSlot gs = ((GraphicSlotView) obj).getGraphicSlot();
			gs.addElements(element, element.getName());
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());
		}

		selectionModel.removeAllFromSelectionList();
		
		model.addSlotElement(element);	
		
		selectionModel.addToSelectionList(element);
	
	}

	@Override
	public void undoCommand() {
		
		if(element!=null){
			selectionModel.removeAllFromSelectionList();
			model.removeElement(element);
			GraphicSlot gs = ((GraphicSlotView) obj).getGraphicSlot();
			gs.removeElement(element);
			SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());
				
			//selectionModel.removeFromSelectionList(element);
			
		}
	}
}