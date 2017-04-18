package model;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultSingleSelectionModel;
import javax.swing.event.EventListenerList;
import model.elements.SlotElement;

public class SlotSelectionModel extends DefaultSingleSelectionModel {

	/**
	 * Lista sa elementima koji su selektovani.
	 */
	private ArrayList<SlotElement> selectionList = new ArrayList<SlotElement>();

	/**
	 * Metoda dodaje element u listu selekcije.
	 * 
	 */
	public void addToSelectionList(SlotElement element) {
		selectionList.add(element);
	}

	/**
	 * Metoda dodaje listu elemenata u selekcionu listu.
	 */
	public void addToSelectionList(ArrayList<SlotElement> list) {
		selectionList.addAll(list);
	}

	/**
	 * Vraca broj elemenata u selekcionoj listi.
	 */
	public int getSelectionListSize() {
		return selectionList.size();
	}

	/**
	 * Vraca element iz selekcione liste koji se nalazi na indeksu koji se
	 * navodi kao argument.
	 */
	public SlotElement getElementFromSelectionListAt(int index) {
		return (SlotElement) selectionList.get(index);
	}

	/**
	 * Vraca indeks zadatog elementa u selekcionoj listi.
	 * 
	 * @param element
	 *            - element za koji se trazi indeks u listi
	 * @return - indeks elementa u listi ili -1
	 */
	public int getIndexByObject(SlotElement element) {
		return selectionList.indexOf(element);
	}

	/**
	 * Uklanja element iz selekcione liste na datom indeksu.
	 * 
	 * @param index
	 *            - indeks elementa koji se uklanja iz selekcione liste.
	 */
	public void removeFromSelectionList(SlotElement element) {
		selectionList.remove(element);
	}

	/**
	 * Uklanja sve elemente iz selekcione liste.
	 */
	public void removeAllFromSelectionList() {
		selectionList.clear();
	}

	/**
	 * Vraca objekat selekcione liste.
	 * 
	 * @return - objekat selekcione liste
	 */
	public ArrayList<SlotElement> getSelectionList() {
		return selectionList;
	}

	public Iterator<SlotElement> getSelectionListIterator() {
		return selectionList.iterator();
	}

	public boolean isElementSelected(SlotElement element) {
		return selectionList.contains(element);

	}

	/**
	 * Metoda selektuje sve elemente koji se seku ili su obuhvaceni
	 * pravougaonikom
	 * 
	 * @param rec
	 *            - selekcioni pravougaonik
	 * @param elements
	 *            - niz elemenata iz modela
	 * 
	 */
	public void selectElements(Rectangle2D rec, ArrayList<SlotElement> elements) {
		Iterator<SlotElement> it = elements.iterator();
		while (it.hasNext()) {
			SlotElement element = it.next();
			if (element instanceof SlotElement) {
				SlotElement device = (SlotElement) element;
				if (rec.intersects(device.getPosition().getX(), device
						.getPosition().getY(), device.getSize().getWidth(),
						device.getSize().getHeight())) {
					if (!isElementSelected(device))
						selectionList.add(device);
				}
			}
		}

	}

	public ArrayList<SlotElement> getSelected() {
		ArrayList<SlotElement> selected = new ArrayList<SlotElement>();
		selected.addAll(selectionList);

		return selected;
	}

}
