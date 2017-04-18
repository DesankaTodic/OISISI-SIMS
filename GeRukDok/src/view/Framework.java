package view;


import gui.MyFrame;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.datatransfer.Transferable;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.SlotElementsSelection;
import model.elements.CircleElement;
import model.elements.RectangleElement;
import model.elements.SlotElement;
import model.workspace.GraphicSlot;

public class Framework extends JPanel implements Observer{
	//klasa koja predstavlja panel na koji se iscrtavaju graficki elementi
	DialogGraphicSlot dialog = null;
	GraphicSlot graphicSlot = null;
	GraphicSlotView view = null;
	public Framework(DialogGraphicSlot dialog,GraphicSlot graphicSlot,GraphicSlotView view) {
		this.view = view;
		this.graphicSlot = graphicSlot;
		this.dialog = dialog;
		setBackground(Color.WHITE);
		graphicSlot.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0.8f));
		Iterator<SlotElement> it = graphicSlot.getModel()
				.getElementsIterator();
		SlotElement device = null;
		while (it.hasNext()) {
			device = it.next();
			// ElementPainter painter = element.getPainter();

			// /painter.paint(g2, element);

			if (device instanceof SlotElement) {
				g2.setPaint(Color.BLACK);
				g.drawString(device.getName(), (int) device.getPosition()
						.getX() + 10, (int) device.getPosition().getY()
						+ (int) device.getSize().getHeight() / 2);
			}

			// ovaj deo iscrtava element
			g2.setPaint(device.getStrokeColor());
			g2.setStroke(device.getStroke());
			g2.draw(device.getShape());

			g2.setPaint(device.getPaint());
			g2.fill(device.getShape());
			repaint();

			}
		view.paintSelectionHandles(g2); 
		
		//iscrtavanje pravougaonika za lasso
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
				BasicStroke.JOIN_BEVEL, 1f, new float[]{(float)3, (float)6}, 0 ));
		g2.draw(view.getSelectionRectangle());	
		}
	public void paste (){
		
		Transferable clipboardContent = MyFrame.getInstance().getClipboard().getContents (MyFrame.getInstance()); 
		if ((clipboardContent != null) &&
		 	(clipboardContent.isDataFlavorSupported (SlotElementsSelection.elementFlavor))) {
			try {
				SlotElement element = null;
				ArrayList<SlotElement> tempElements = (ArrayList<SlotElement>) clipboardContent.getTransferData (SlotElementsSelection.elementFlavor);					
		 		for(int i=0;i<tempElements.size();i++){

		 			if(tempElements.get(i) instanceof SlotElement){
		 				element=(SlotElement) tempElements.get(i);
		 				Point2D newLocation=(Point2D) element.getPosition().clone();
		 				//transliranje pozicije elementa na slotu
		 				newLocation.setLocation(element.getPosition().getX()+80,element.getPosition().getY()+80);
			 			element.setPosition(newLocation);
			 			
			 			String name = null;
			 			if(element instanceof CircleElement){
			 				name = element.getName();
			 				element = new CircleElement(element.getPosition(),element.getSize(),element.getStroke(),element.getPaint(),element.getStrokeColor());
			 			}else if(element instanceof RectangleElement){
			 				name = element.getName();
			 				element = new RectangleElement(element.getPosition(),element.getSize(),element.getStroke(),element.getPaint(),element.getStrokeColor());
			 			}
			 			element.setName("K "+name);
	
			 			graphicSlot.addElements(element, element.getName());
			 			graphicSlot.getModel().addSlotElement(element);
		
		 			}
		 		}
			}catch (Exception ex) {
		 		ex.printStackTrace ();
		 	}
		}
	}
}
