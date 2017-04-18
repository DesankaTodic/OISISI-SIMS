package view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.elements.CircleElement;
import model.elements.RectangleElement;
import model.workspace.Document;
import model.workspace.GraphicSlot;
import model.workspace.Page;
import model.workspace.Project;
import model.workspace.TextSlot;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer{
	public WorkspaceTreeCellRendered(){
		
	}
	public Component getTreeCellRendererComponent(
			JTree tree,
			Object value,
			boolean sel,
			boolean expanded,
			boolean leaf,
			int row,
			boolean hasFocus){
				super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);
			
			if(value instanceof GraphicSlot){
					setIcon(new ImageIcon("slike/Component.png"));
			}else if(value instanceof TextSlot){
					setIcon(new ImageIcon("slike/text_slot.png"));
			}else if(value instanceof RectangleElement){
				setIcon(new ImageIcon("slike/rectangle16x16.png"));
			}else if(value instanceof CircleElement){
				setIcon(new ImageIcon("slike/circle16x16.png"));
			}else if(value instanceof Page){
				setIcon(new ImageIcon("slike/List.png"));
			}else if(value instanceof Document){
				setIcon(new ImageIcon("slike/New document.png"));
			}else if(value instanceof Project){
				this.setIcon(new ImageIcon("slike/Folder.png"));
	
			}
		
			return this;
		}
		
}
