package model.workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;

import event.ModelUpdateEvent;

public class Page extends Observable implements TreeNode,Serializable{
	private ArrayList<Slot> slots=new ArrayList<Slot>();
	private String name;
	private Document document;
	private int gSlotCounter = 0;
	private int tSlotCounter = 0;

	
	public Page(String pageName,Document document){
		this.name=pageName;
		this.document=document;//prosirujem konstruktor da bih u svakom trenutku imali kome pripada data stranica
	}
	/////////////////////////////////napravi apstraktnu klasu slot koju ce naslijediti text i graphic slot
	public void addSlot(Slot slot){
		
		if(slot instanceof GraphicSlot)
			slot.setName("GraphicSlot: "+(++gSlotCounter));
		else
			slot.setName("TextSlot: "+(++tSlotCounter));
		
		slots.add(slot);
		///////////////////observer metode
		ModelUpdateEvent event = new ModelUpdateEvent((Object)slot,true,false);
		setChanged();
		notifyObservers(event);
		///////////////////////////////////
	}
	public void removeSlot(Slot slot){
		slots.remove(slot);
		///////////////////observer metode
		ModelUpdateEvent event = new ModelUpdateEvent((Object)slot,false,true);
		setChanged();
		notifyObservers(event);
		///////////////////////////////////
	}
	
	public String toString(){
		return name;
	}
	public String getName(){
		return name;
	}

	public Object getSlot(int index){
		return slots.get(index);
	}
	public int getSlotIndex(Object slot){
		return slots.indexOf(slot);
	}
	public int getSlotCount(){
		return slots.size();
	}
	public boolean isLeaf() {
		return slots.isEmpty();
	}	
	
	public void setName(String name){
		this.name=name;
	}

	public TreeNode getChildAt(int arg0) {
		return (TreeNode) slots.get(arg0);
	}


	public int getChildCount() {
		return slots.size();
	}
	
	public Document getDocument(){
		return document;
	}


	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getIndex(TreeNode arg0) {
		return getSlotIndex((Object)arg0);
	}


	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}


	public Enumeration children() {
		// TODO Auto-generated method stub
		return (Enumeration) slots;
	}
}
