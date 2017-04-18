package model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;


public class RectangleElement extends SlotElement {
	
	public RectangleElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(position, size, stroke, paint,strokeColor);
		shape = new Rectangle2D.Double(position.getX(),position.getY(),size.getWidth(),size.getHeight());
	}

	
	public RectangleElement(RectangleElement rectangle){
		super(rectangle);
		setName("rectangle");
	}
	
	
	public static SlotElement createDefault(Point2D pos, int elemNo){
		Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
        RectangleElement rectangleElement=new RectangleElement(position, 
	    		                       new Dimension(80,40),
	    		                      new BasicStroke((float)(5), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),
             	                      fill,
	    		                      Color.BLACK);
        rectangleElement.setName("Rectangle" + elemNo);
		return rectangleElement;
	}
	
	@Override
	public SlotElement clone() {
		// TODO Auto-generated method stub
		return new RectangleElement(this);
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
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
		return true;
	}


	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}


	
}
