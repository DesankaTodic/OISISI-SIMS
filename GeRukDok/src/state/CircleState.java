package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import view.GraphicSlotView;

import commands.AddDeviceCommand;



public class CircleState extends State{
	
	private GraphicSlotView med;
	//AutoScrollThread thread;
	
	public CircleState(GraphicSlotView med) {
	    this.med = med;
	}
	
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		//med. transformToUserSpace(position);
				
		if (e.getButton()==MouseEvent.BUTTON1){
			// if (med.getGraphicSlot().getModel().getElementAtPosition(position)==-1){
				 med.getCommandManager().addCommand(new AddDeviceCommand(med.getGraphicSlot().getModel(),med.getGraphicSlot().getSelectionModel(),position,GraphicSlotView.CIRCLE,(Object)med));
				// med.getCommandManager().addCommand(new AddDeviceCommand(med.getGraphicSlot().getModel(),med.getGraphicSlot().getSelectionModel(),position,GraphicSlotView.CIRCLE,objekat));
			// }
		}
	}
}

