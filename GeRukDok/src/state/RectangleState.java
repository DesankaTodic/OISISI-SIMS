package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import view.GraphicSlotView;

import commands.AddDeviceCommand;


public class RectangleState extends State{
	
	private GraphicSlotView med; 
	//AutoScrollThread thread;
	
	
	public RectangleState(GraphicSlotView med) {
      	this.med = med;
      	//thread=new AutoScrollThread(med);
	}

	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		//med. transformToUserSpace(position);
		if (e.getButton()==MouseEvent.BUTTON1){
			 //if (med.getGraphicSlot().getModel().getElementAtPosition(position)==-1){
				 med.getCommandManager().addCommand(new AddDeviceCommand(med.getGraphicSlot().getModel(),med.getGraphicSlot().getSelectionModel(),position,GraphicSlotView.RECTANGLE,(Object)med));
				 //med.getCommandManager().addCommand(new AddDeviceCommand(med.getGraphicSlot().getModel(),med.getGraphicSlot().getSelectionModel(),position,GraphicSlotView.RECTANGLE,objekat));
			 //}
		}
	}
}
