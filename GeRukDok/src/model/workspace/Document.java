package model.workspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import event.ModelUpdateEvent;
import gui.MyFrame;
import state.StateManager;

public class Document extends Observable implements TreeNode,Serializable{
	private ArrayList<Page> pages=new ArrayList<Page>();
	//promjenila iz private u public da bih mogla preuzeti prilikom kreiranja nov dokument
	public String name;
	private Project project;
	private int pageCounter = 0;
	//private DocumentModel model;
	private StateManager stateManager=new StateManager();

	
	public Document(String documentName, Project project){
		this.name=documentName;
		this.project = project;
	}
	public void addPage(Page page){
		pages.add(page);
		page.setName("Page: "+String.valueOf(++pageCounter));	
		///////////////////observer metode
		ModelUpdateEvent event = new ModelUpdateEvent((Object)page,true,false);
		setChanged();
		notifyObservers(event);
		///////////////////////////////////
		
	}
	//metoda za brisanje dokumenta
	public void removePage(Page page){
		pages.remove(page);
		///////////////////observer metode
		ModelUpdateEvent event = new ModelUpdateEvent((Object)page,false,true);
		setChanged();
		notifyObservers(event);
		///////////////////////////////////
	}
	
	public String toString(){
		return name;
	}
	public Page getPage(int index){
		return pages.get(index);
	}
	public int getPageIndex(Page page){
		return pages.indexOf(page);
	}
	public int getPageCount(){
		return pages.size();
	}
	public boolean isLeaf() {
		return pages.isEmpty();
	}	
	
	public void setName(String name){
		this.name=name;
	}


	public TreeNode getChildAt(int arg0) {
		return getPage(arg0);
	}


	public int getChildCount() {
		return getPageCount();
	}


	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getIndex(TreeNode arg0) {
		return getPageIndex((Page)arg0);
	}


	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}
//metoda za preuzimanje projekta kojem pripada dokument
    public Project getProject()
    {
    	return project;
    }
    
	public Enumeration children() {
		// TODO Auto-generated method stub
		return (Enumeration) pages;
	}
/*	public DocumentModel getModel() {
		return model;
	}*/
	public String getName() {
		return name;
	}
	public StateManager getStateManager() {
		return stateManager;
	}
}
