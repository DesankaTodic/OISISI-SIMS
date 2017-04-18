package model.workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;

import event.ModelUpdateEvent;
import model.SlotModel;
import model.SlotSelectionModel;
import model.elements.SlotElement;

public class GraphicSlot extends Slot{

	private ArrayList<SlotElement> elements=new ArrayList<SlotElement> ();

	private int elementCounter = 0;

	
	private SlotModel model=new SlotModel();
	//referenca na stateManager
	private SlotSelectionModel selectionModel;
		
	public GraphicSlot(String slotName,Page page) {
		super(slotName,page);
		setName(slotName);
		
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return (TreeNode) elements.get(childIndex);
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return elements.size();
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return elements.isEmpty();
	}

	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return (Enumeration) elements;
	}

	public SlotModel getModel() {
		return model;
	}

	public void setModel(SlotModel model) {
		this.model = model;
	}

	public void addElements(SlotElement element,String name){
		elements.add(element);
		element.setName(name);
		///////////////////observer metode
		ModelUpdateEvent event = new ModelUpdateEvent((Object)element,true,false);
		setChanged();
		notifyObservers(event);
		///////////////////////////////////
	}
	public void removeElement(SlotElement element){
		elements.remove(element);
		///////////////////observer metode
		ModelUpdateEvent event = new ModelUpdateEvent((Object)element,false,true);
		setChanged();
		notifyObservers(event);
		///////////////////////////////////
	}

	public Object getElement(int index){
		return elements.get(index);
	}
	public int getElementIndex(Object element){
		return elements.indexOf(element);
	}
	public int getElementCount(){
		return elements.size();
	}
	
	public SlotSelectionModel getSelectionModel() {
		if(selectionModel == null)
			selectionModel = new SlotSelectionModel();
		return selectionModel;
	}

}