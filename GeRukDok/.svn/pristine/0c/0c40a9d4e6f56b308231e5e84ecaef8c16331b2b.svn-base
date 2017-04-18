package model;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;

import model.elements.SlotElement;

public class SlotElementsSelection implements Transferable,ClipboardOwner {
	
	
	static public DataFlavor elementFlavor;//Ovaj atribut predstavlja vrstu podataka koja
											//je podrzana u operacijama sa clipboard-om
	private DataFlavor [] supportedFlavors = {elementFlavor};//Ovo je niz koji sadrzi vrste podataka koji su
															//podrzani u operacijama sa clipboard-om.
	public ArrayList<SlotElement> slotElements=new ArrayList<SlotElement>();//Lista elemenata koji se nalaze u clipboardu.
	
	
	public SlotElementsSelection (ArrayList<SlotElement> elements) {
		slotElements = elements;
		 	try {
		 		elementFlavor = new DataFlavor (Class.forName ("java.util.ArrayList"), "Elements");
		 	}catch (ClassNotFoundException e) {
		 		e.printStackTrace ();
		 	}
	}
	//Ova metoda vraca objekat koji je
	//predmet CCP operacija
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		
		if (flavor.equals (elementFlavor))
		    return (slotElements);
		else
		   throw new UnsupportedFlavorException (elementFlavor);
	}
	//Vraca niz DataFlavor objekata koji
	//koji predstavlja skup klasa koji mogu
	//biti sadrzani u CCP operacijama
	public DataFlavor[] getTransferDataFlavors() {
		return (supportedFlavors);
	}
	//Metoda koja proverava da li
	//prosledjeni objekat tipa DataFlawor
	//može ucestvavati u CCP operacijama
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals (elementFlavor));
	}
	/*Ova metoda se poziva u trenutku kada neki
	drugi objekat unutar aplikacije preuzme
	vlasništvo nad instancom klase Clipboard
	koji je do tog trenutka bio u vlasnistvu
	klase koja implementira interfejs
	ClipboardOwner.
	clipboard - objekat nad kojim je izgubljeno
	vlasništvo
	contents - sadržaj koji je klasa koja
	implementira interfejs ClipboardOwner
	stavila u clipboard.*/
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		
	}

}