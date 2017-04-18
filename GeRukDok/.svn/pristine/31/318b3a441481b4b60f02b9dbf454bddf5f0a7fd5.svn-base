package view;


import gui.MyFrame;
import gui.listeners.GraphicSlotMouseListener;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import model.SlotElementsSelection;
import model.elements.CircleElement;
import model.elements.RectangleElement;
import model.elements.SlotElement;
import model.workspace.GraphicSlot;
import state.StateManager;
import commands.CommandManager;


public class GraphicSlotView extends JPanel implements Observer {
	private GraphicSlot graphicSlot = null;
	private StateManager stateManager = new StateManager(this);
	private CommandManager commandManager = new CommandManager();

	private Framework framework;

	// private AffineTransform transformation = new AffineTransform();

	public static final int CIRCLE = 4;
	public static final int RECTANGLE = 5;

	private Point2D lastPosition = null;
	private Rectangle2D selectionRectangle = new Rectangle2D.Double();

	// podrska za rad sa StateManagerom
	// ----------------------------------------------

	public void startCircleState() {
		graphicSlot.getSelectionModel().removeAllFromSelectionList();
		stateManager.setCircleState();
	}

	public void startSelectState() {
		stateManager.setSelectState();
	}

	public void startRectangleState() {
		graphicSlot.getSelectionModel().removeAllFromSelectionList();
		stateManager.setRectangleState();
	}
	public void startLassoState() {

    	stateManager.setLassoState();
		}

	public StateManager getStateManager() {
		return stateManager;
	}
	public Framework getFramework() {
		return framework;
	}

	// -----------------------------------------------
	/**
	 * Handlovi za selekciju su identifikovani stranama sveta.
	 * 
	 *
	 */
	public enum Handle {
		North, South, East, West, SouthEast, SouthWest, NorthEast, NorthWest
	}

	public enum Direction {
		Up, Down, Left, Right
	}

	static final int handleSize = 7;

	public GraphicSlotView(GraphicSlot s) {
		// super();
		graphicSlot = s;
		setBorder(new TitledBorder(new EtchedBorder(), s.getName()));
		setBackground(Color.WHITE);
		setName(s.getName());
		// ////////////////////////
		graphicSlot.addObserver(this);

		this.setPreferredSize(new Dimension(500, 200));
		this.setBackground(Color.white);
		addMouseListener(new GraphicSlotMouseListener());

		putClientProperty("graphicSlot", s);
		repaint();
		validate();
		//GraphicSlotController c = new GraphicSlotController();
		//addMouseListener(c);
		//addMouseMotionListener(c);
		//addMouseWheelListener(c);
		addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) { 
					//ovo je dialog na koji se dodaje panel tj. Framework 
					//i na njemu ce se iscrtavati elementi
					DialogGraphicSlot dialog = new DialogGraphicSlot(graphicSlot,getGraphicSlotView());
					framework = new Framework(dialog,graphicSlot,getGraphicSlotView());
					dialog.add(framework, BorderLayout.CENTER);

					GraphicSlotController c = new GraphicSlotController();
					framework.addMouseListener(c);
					framework.addMouseMotionListener(c);
					framework.addMouseWheelListener(c);
					dialog.setVisible(true);
				}
			}
		});
		setVisible(true);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void setGraphicSlot(GraphicSlot m) {
		graphicSlot = m;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0.8f));
		Iterator<SlotElement> it = graphicSlot.getModel().getElementsIterator();
		SlotElement device = null;
		while (it.hasNext()) {
			device = it.next();
			// ElementPainter painter = element.getPainter();

			// /painter.paint(g2, element);

			if (device instanceof SlotElement) {
				g2.setPaint(Color.BLACK);
				g.drawString(device.getName(), (int) device.getPosition()
						.getX() + 10, (int) device.getPosition().getY()
						+ (int) device.getSize().getHeight() / 2);
			}

			// ovaj deo iscrtava element
			g2.setPaint(device.getStrokeColor());
			g2.setStroke(device.getStroke());
			g2.draw(device.getShape());

			g2.setPaint(device.getPaint());
			g2.fill(device.getShape());
			

		}
		
	}

	public GraphicSlot getGraphicSlot() {
		return graphicSlot;
	}

	private class GraphicSlotController extends MouseAdapter {

		public void mousePressed(MouseEvent e) {
			lastPosition = e.getPoint();
			// transformToUserSpace(lastPosition);

			getStateManager().getCurrentState().mousePressed(e);
		}

		public void mouseReleased(MouseEvent e) {

			getStateManager().getCurrentState().mouseReleased(e);
		}

		public void mouseDragged(MouseEvent e) {

			getStateManager().getCurrentState().mouseDragged(e);
		}

		public void mouseMoved(MouseEvent e) {

			getStateManager().getCurrentState().mouseMoved(e);
		}
	}

	/**
	 * Iscrtavanje selekcionih hendlova oko selektovanog elementa Velicina
	 * hendlova ne sme da zavisi od tekuceg skaliranja
	 */
	public void paintSelectionHandles(Graphics2D g2) {

		Iterator<SlotElement> it = graphicSlot.getSelectionModel()
				.getSelectionListIterator();
		while (it.hasNext()) {
			SlotElement element = it.next();
			if (element instanceof SlotElement) {
				SlotElement device = (SlotElement) element;
				// Iscrtavanje pravougaonika sa isprekidanom linijom
				g2.setStroke(new BasicStroke((float) 1, BasicStroke.CAP_SQUARE,
						BasicStroke.JOIN_BEVEL, 1f, new float[] { 3f, 6f }, 0));
				g2.setPaint(Color.BLACK);

				g2.drawRect((int) device.getPosition().getX(), (int) device
						.getPosition().getY(), (int) device.getSize()
						.getWidth(), (int) device.getSize().getHeight());

				// Iscrtavanje hendlova
				
				  for(Handle e: Handle.values()){ paintSelectionHandle(g2,
				  getHandlePoint(device.getPosition(), device.getSize(), e)); }
				
			}
		}
	}

	private void paintSelectionHandle(Graphics2D g2, Point2D position) {
		double size = handleSize;
		g2.fill(new Rectangle2D.Double(position.getX() - size / 2, position
				.getY() - size / 2, size, size));
	}

	private Point2D getHandlePoint(Point2D topLeft, Dimension2D size,
			Handle handlePosition) {
		double x = 0, y = 0;

		// Doredjivanje y koordinate

		// Ako su gornji hendlovi
		if (handlePosition == Handle.NorthWest
				|| handlePosition == Handle.North
				|| handlePosition == Handle.NorthEast) {
			y = topLeft.getY();
		}
		// Ako su centralni po y osi
		if (handlePosition == Handle.East || handlePosition == Handle.West) {
			y = topLeft.getY() + size.getHeight() / 2;
		}
		// Ako su donji
		if (handlePosition == Handle.SouthWest
				|| handlePosition == Handle.South
				|| handlePosition == Handle.SouthEast) {
			y = topLeft.getY() + size.getHeight();
		}

		// Odredjivanje x koordinate

		// Ako su levi
		if (handlePosition == Handle.NorthWest || handlePosition == Handle.West
				|| handlePosition == Handle.SouthWest) {
			x = topLeft.getX();
		}
		// ako su centralni po x osi
		if (handlePosition == Handle.North || handlePosition == Handle.South) {
			x = topLeft.getX() + size.getWidth() / 2;
		}
		// ako su desni
		if (handlePosition == Handle.NorthEast || handlePosition == Handle.East
				|| handlePosition == Handle.SouthEast) {
			x = topLeft.getX() + size.getWidth();
		}

		return new Point2D.Double(x, y);

	}
	/**
	 * Na osnovu hendla iznad koga se nalazi postavlja kursor
	 */
	public void setMouseCursor(Point2D point){
		
		Handle handle = getDeviceAndHandleForPoint(point);

		if(handle != null){
			Cursor cursor = null;
			
			switch(handle){
			case North: cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);break;
			case South: cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);break;
			case East: cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);break;
			case West: cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);break;
			case SouthEast: cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);break;
			case NorthWest: cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);break;
			case SouthWest: cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);break;
			case NorthEast: cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);break;
			}
			framework.setCursor(cursor);
		}
		else
			framework.setCursor(Cursor.getDefaultCursor());
	}

	public Point2D getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Point2D lastPosition) {
		this.lastPosition = lastPosition;
	}

	public Rectangle2D getSelectionRectangle() {
		return selectionRectangle;
	}

	public void setSelectionRectangle(Rectangle2D selectionRectangle) {
		this.selectionRectangle = selectionRectangle;
	}

	public CommandManager getCommandManager() {
		return commandManager;
	}

	public void setCommandManager(CommandManager commandManager) {
		this.commandManager = commandManager;
	}

	/**
	 * Odredjuje handl i uredjaj koji se nalazi na zadatoj lokaciji
	 * 
	 * @param point
	 *            Ulazni parametar koji odredjuje lokaciju
	 * @return Hendl za zadatu poziciju. Ukoliko je null tada je device
	 *         nedefinisan.
	 */
	public Handle getDeviceAndHandleForPoint(Point2D point) {
		SlotElement element;

		Iterator<SlotElement> it = graphicSlot.getSelectionModel()
				.getSelectionListIterator();
		while (it.hasNext()) {
			element = it.next();
			return getHandleForPoint(element, point);
		}
		return null;
	}

	/**
	 * Za zadatu tacku i uredjaj vraca hendl.
	 * 
	 * @param device
	 * @param point
	 * @return Hendl ukoliko je "pogodjen", u suprotnom vraca null
	 */
	private Handle getHandleForPoint(SlotElement element, Point2D point) {
		for (Handle h : Handle.values()) {
			if (isPointInHandle(element, point, h)) {
				return h;
			}
		}
		return null;
	}

	/**
	 * Za zadati uredjaj, tacku i hendl odrdjuje da li je tacka unutar hendla
	 * 
	 * @param device
	 * @param point
	 * @param handle
	 * @return
	 */
	private boolean isPointInHandle(SlotElement element, Point2D point,
			Handle handle) {
		if (element instanceof SlotElement) {
			SlotElement device = (SlotElement) element;
			Point2D handleCenter = getHandlePoint(device.getPosition(),
					device.getSize(), handle);
			return ((Math.abs(point.getX() - handleCenter.getX()) <= (double) handleSize / 2) && (Math
					.abs(point.getY() - handleCenter.getY()) <= (double) handleSize / 2));
		} else
			return false;
	}

	public GraphicSlotView getGraphicSlotView() {
		return this;
	}
/*public void paste (){
		
		Transferable clipboardContent = MyFrame.getInstance().getClipboard().getContents (MyFrame.getInstance()); 
		if ((clipboardContent != null) &&
		 	(clipboardContent.isDataFlavorSupported (SlotElementsSelection.elementFlavor))) {
			try {
				SlotElement element = null;
				ArrayList<SlotElement> tempElements = (ArrayList<SlotElement>) clipboardContent.getTransferData (SlotElementsSelection.elementFlavor);					
		 		for(int i=0;i<tempElements.size();i++){

		 			if(tempElements.get(i) instanceof SlotElement){
		 				element=(SlotElement) tempElements.get(i).clone();
			 			Point2D newLocation=(Point2D) element.getPosition().clone();
			 			//transliranje pozicije elementa na slotu
			 			System.out.println("1 "+element.getPosition().getX());
			 			
			 			newLocation.setLocation(element.getPosition().getX()+40,element.getPosition().getY()+40);
			 			element.setPosition(newLocation);
			 			System.out.println(element.getPosition().getX());
			 			
			 			graphicSlot.addElements(element, element.getName());
			 			graphicSlot.getModel().addSlotElement(element);
		 			}
		 		}
			}catch (Exception ex) {
		 		ex.printStackTrace ();
		 	}
		}
	}*/
}