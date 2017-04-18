package model.workspace;

import java.io.Serializable;
import java.util.Observable;

import javax.swing.tree.TreeNode;

import event.ModelUpdateEvent;

public abstract class Slot extends Observable implements TreeNode,Serializable{
	private String name;
	private Page page;
	
	public Slot(String slotName, Page page) {
		name=slotName;
		this.page = page;		
	}
	public String toString(){
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
}
