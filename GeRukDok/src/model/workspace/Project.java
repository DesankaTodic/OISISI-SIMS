package model.workspace;




import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import event.ModelUpdateEvent;
import gui.MyFrame;

public class Project extends Observable implements TreeNode,Serializable{
//public class Project implements TreeNode,Serializable{
	private ArrayList<Document> documents = new ArrayList<Document>();
	private String name;
	private int documentCounter = 0;
	private transient boolean changed; 
	private File projectFile;
	//private boolean flag = false;//flag za update

	
	public Project(String projectName) {
		this.name=projectName;

	}
	
	public void addDocument(Document document){
		documents.add(document);
		document.setName( "Document: "+String.valueOf(++documentCounter));
		///////////////////observer metode
		ModelUpdateEvent event = new ModelUpdateEvent((Object)document,true,false);
		setChanged();
		notifyObservers(event);
		///////////////////////////////////
		
	}	
	//metoda za brisanje dokumenta
	public void removeDocument(Document document){
		documents.remove(document);	
		///////////////////observer metode
		ModelUpdateEvent event = new ModelUpdateEvent((Object)document,false,true);
		setChanged();
		notifyObservers(event);
		///////////////////////////////////
	}	
	
	public String toString(){
		return name;
	}	
	
	public Document getDocument(int index) {
		return documents.get(index);
	}
	
	public int getDocumentIndex(Document document) {
		return documents.indexOf(document);
	}
	
	public int getDocumentCount() {
		return documents.size();
	}	
	/////////////za uklanjanje plusa kad nema dokumenata
	public boolean isLeaf() {
		return documents.size()==0;
	}	
	///////////////////////////izbaci?
	public void setName(String name){
		this.name=name;
	}


	public TreeNode getChildAt(int arg0) {
		return getDocument(arg0);
	}
	//metoda koja vraca listu dokumenta koji pripadaju datom projektu
	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public int getChildCount() {
		return getDocumentCount();
	}


	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}


	public int getIndex(TreeNode arg0) {
		return getDocumentIndex((Document)arg0);
	}


	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	public Enumeration children() {
		// TODO Auto-generated method stub
		return (Enumeration) documents;
	}
	//metoda za preuzimanje imena projekta
	public String getName(){
		return name;
	}
	public File getProjectFile() {
		return projectFile;
	}
	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}
	public void setChanged(boolean changed) {
		if (this.changed!=changed){
		     this.changed=changed;
		     SwingUtilities.updateComponentTreeUI(MyFrame.getInstance().getWorkspaceTree());
		}
	}
}
