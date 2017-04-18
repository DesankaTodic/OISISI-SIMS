package model.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Enumeration;
import java.util.Observable;

import javax.swing.tree.TreeNode;



public class CircleElement extends SlotElement {

	public CircleElement(Point2D position, Dimension size, Stroke stroke, Paint paint,Color strokeColor) {
		super(position, size, stroke, paint,strokeColor);

		shape = new Ellipse2D.Double(position.getX(),position.getY(),size.getHeight(),size.getWidth());
		

	}

	public CircleElement(CircleElement circle){
		super(circle);
		setName("K "+circle.getName());
		shape = new Ellipse2D.Double(circle.getPosition().getX(),circle.getPosition().getY(),circle.getSize().getHeight(),circle.getSize().getWidth());
	}
	
	public static SlotElement createDefault(Point2D pos, int elemNo){
		Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
	    CircleElement or=new CircleElement(position, 
	    		                   new Dimension(50,50),
	    		                   new BasicStroke((float)(5), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),
	    		                   fill,
	    		                   Color.BLUE);
        or.setName("Circle " + elemNo);
        
        
        
		return or;
	}

	@Override
	public SlotElement clone() {
		// TODO Auto-generated method stub
		return new CircleElement(this);
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

