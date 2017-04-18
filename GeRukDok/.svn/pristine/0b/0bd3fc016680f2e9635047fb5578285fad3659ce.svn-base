package state;


import gui.MyFrame;
import gui.WorkspaceTree;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.tree.TreePath;

import model.elements.SlotElement;
import model.workspace.GraphicSlot;
import view.GraphicSlotView;
import view.GraphicSlotView.Handle;


public class SelectState extends State{
	private GraphicSlotView med; 
	
	//indeks elementa koji je selektovan
	private int elementInMotion = -1;
	private Handle handleInMotion = null;

	
	public SelectState(GraphicSlotView md) {
	med = md;
	}
	
	
	public void mousePressed(MouseEvent e) {
		if(!e.isControlDown()){
			med.getGraphicSlot().getSelectionModel().removeAllFromSelectionList();
			}
		
		Point position = e.getPoint();
		//med.transformToUserSpace(position);
		if (e.getButton()==MouseEvent.BUTTON1){
			handleInMotion = med.getDeviceAndHandleForPoint(position);
			if(handleInMotion == null){
				if(!e.isControlDown()){
					med.getGraphicSlot().getSelectionModel().removeAllFromSelectionList();
					}				
				elementInMotion = med.getGraphicSlot().getModel().getElementAtPosition(position);
				
				if(elementInMotion != -1){
					///////////////////desa////////////////////////
					//pogodjen je element, ukoliko je selektovan treba ga ukloniti iz liste,
					//ako nije treba ga dodati u listu
					SlotElement element=med.getGraphicSlot().getModel().getElementAt(elementInMotion);
					////////////////////desa/////////////da selektuje element i u stablu
					GraphicSlot slot = med.getGraphicSlot();
					WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
					tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] {
							tree.getRoot(), slot.getPage().getDocument().getProject(), slot.getPage().getDocument(),
							slot.getPage(), slot, element}));
					
					
					if (med.getGraphicSlot().getSelectionModel().isElementSelected(element)){
						med.getGraphicSlot().getSelectionModel().removeFromSelectionList(element);
					}else{
						med.getGraphicSlot().getSelectionModel().addToSelectionList(element);
					}	
					
				}else{
					//nije pogodjen nijedan element
					
				}
			}
		}
		
	}
	
	public void mouseMoved(MouseEvent e) {
		// Promena pokazivaca misa u zavisnosti od toga iznad cega se nalazi
		Point2D point = e.getPoint();
		med.setMouseCursor(point);
		//MyFrame.getInstance().getStatusBar().setPosition(e.getPoint().toString());
		
	}	

	public void mouseDragged(MouseEvent e) {

			med.startLassoState();

		
	}
		
	}
