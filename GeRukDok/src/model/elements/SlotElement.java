package model.elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

import javax.swing.tree.TreeNode;

import serialization.d.SerializableStrokeAdapter;

/**
 * Apstraktna klasa koja opisuje bilo koji element  mre�e.
 * Opisuje  elemente dijagrama
 *
 */
public abstract class SlotElement implements TreeNode,Serializable{
	
	protected Paint paint;
	protected SerializableStrokeAdapter stroke;
	protected Color  strokeColor;
	protected Dimension size;
	protected Point2D position;
	protected Shape shape;
	protected String name;
	protected String description;
	
	
	
	//metoda za kloniranje elemenata
	abstract public SlotElement clone();

	
	public SlotElement(Point2D position, Dimension size, Stroke stroke, Paint paint,Color  strokeColor){
		//super(stroke, paint,strokeColor);
		this.size = size;
		//ovo omogucava translaciju tacaka tako da se element kreira u centru
		position.setLocation(position.getX()-size.getWidth()/2,position.getY()-size.getHeight()/2);
		setStroke(stroke);
		this.paint = paint;
		this.strokeColor=strokeColor;
		this.position = position;
		
	}

	 
	public Dimension getSize() {
		return size;
	}

	/*	public SlotDevice(SlotDevice device){
		super(device);
		this.size=device.size;
		this.position=device.position;

	}
	*/

	public boolean isElementAt( Point pos){
		//DiagramDevice device = (DiagramDevice) element;
		Rectangle2D rect=new Rectangle2D.Double();
		rect.setRect(this.getPosition().getX(), this.getPosition().getY(),
				this.getSize().getWidth(), this.getSize().getHeight());
		return rect.contains(pos);
	}
	
	
	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
 
	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public Dimension getInitSize(){
		return size;
	}


	public void setSize(Dimension size) {
		this.size = size;
	}

/**/

	/**Copy konstruktor klase

	 * 
	 */
	public SlotElement(SlotElement element){
		this.stroke=element.stroke;
		this.position=element.position;
		this.size=element.size;
		this.strokeColor=element.strokeColor;
		this.name=element.name;
		this.description=element.description;
		this.paint = element.paint;
		this.shape =element.shape;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = new SerializableStrokeAdapter(stroke);
	}

	public String toString(){
		return name;
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}


}
