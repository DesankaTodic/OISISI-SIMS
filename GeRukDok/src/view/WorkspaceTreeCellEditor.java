package view;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.elements.CircleElement;
import model.elements.RectangleElement;
import model.workspace.Document;
import model.workspace.GraphicSlot;
import model.workspace.Page;
import model.workspace.Project;
import model.workspace.TextSlot;

public class WorkspaceTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {
	private Object stavka=null;
    private JTextField edit=null;
    
	public WorkspaceTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
		super(arg0, arg1);
	}

	public Component getTreeCellEditorComponent(JTree arg0, Object value, boolean selected, boolean expanded, boolean leaf, int row) {

		super.getTreeCellEditorComponent(arg0,value,selected,expanded,leaf,row);
		stavka=value;
		
		edit=new JTextField(value.toString());
		
		edit.addActionListener(this);
		return edit;
	}

	public boolean isCellEditable(EventObject arg0) {
		if (arg0 instanceof MouseEvent)
		{
			if (((MouseEvent)arg0).getClickCount()==3){//kad preimenuje u stablu da se primenuje u view?
				return true;
			}
		}
		
		return false;
	}

	public void actionPerformed(ActionEvent e){
		if (stavka instanceof Project){
			((Project)stavka).setName(e.getActionCommand());	
		}else if(stavka instanceof Document){
			((Document)stavka).setName(e.getActionCommand());
		}else if(stavka instanceof Page){
			((Page)stavka).setName(e.getActionCommand());
		}else if(stavka instanceof GraphicSlot){
			((GraphicSlot)stavka).setName(e.getActionCommand());
		}else if(stavka instanceof TextSlot){
			((TextSlot)stavka).setName(e.getActionCommand());
		}else if(stavka instanceof RectangleElement){
			((RectangleElement)stavka).setName(e.getActionCommand());
		}else{
			((CircleElement)stavka).setName(e.getActionCommand());
		}
		
	}
}

