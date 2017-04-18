package model;


import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import model.elements.SlotElement;

public class SlotModel {

	private String name;
	
	protected ArrayList<SlotElement> slotElements =new ArrayList <SlotElement>();	
	 int counter = 0;

	/**
	 * Pronalazi indeks elementa koji se nalazi na zadatim logickim koordinatama
	 * @param point
	 * @return
	 */
	public int getElementAtPosition(Point point) {
		System.out.println("Uzmi pozicijuuuuu");
		for(int i=getElementsCount()-1;i>=0;i--){
			SlotElement element = getElementAt(i);
			if(element.isElementAt(point)){
				return i;
			}
		}
		return -1;
	}
	 
	public Iterator<SlotElement> getElementsIterator(){
		return slotElements.iterator();
		
	}
	public void removeElement(SlotElement element){
		
		slotElements.remove(element);
	}		
	public int getElementsCount(){
		return slotElements.size();
	}
	//za davanje jedinstvenih imena elementima
	public int getCounter(){
		return counter++;
	}
	
	public SlotElement getElementAt(int i){
		return slotElements.get(i);
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}	
	
	public void addSlotElement(SlotElement element){
		slotElements.add(element);
	}	
	
	public ArrayList<SlotElement >  getSlotElements() {
			return slotElements;
	}

	
}