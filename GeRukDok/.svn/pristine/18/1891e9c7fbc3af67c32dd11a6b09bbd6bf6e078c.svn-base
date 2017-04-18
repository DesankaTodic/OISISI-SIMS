package view;

import gui.MyFrame;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import model.elements.SlotElement;
import model.workspace.GraphicSlot;


public class DialogGraphicSlot extends JDialog{
	//dijalog koji isakace kad 2x kliknes na graficki slot
	private GraphicSlot graphicSlot = null;
	private GraphicSlotView gsv = null;
	
	public DialogGraphicSlot(GraphicSlot graphicSlot,GraphicSlotView gsv){
		super(MyFrame.getInstance(),
				graphicSlot.getName(), true);
		this.graphicSlot = graphicSlot;
		/*JDialog dialog = new JDialog(MyFrame.getInstance(),
				graphicSlot.getName(), true);*/
		setSize(400, 400);
		setLocationRelativeTo(MyFrame.getInstance());
		ImageIcon imgSlot = new ImageIcon("Component.png");
		setIconImage(imgSlot.getImage());
		setLayout(new BorderLayout());
		//Framework framework = new Framework(this);
		//add(framework, BorderLayout.CENTER);

		//GraphicSlotController c = new GraphicSlotController();
		//framework.addMouseListener(c);

		
		JToolBar toolbar = new JToolBar();
		JToggleButton rectangle = new JToggleButton();
		ImageIcon img = new ImageIcon("slike/rectangle32x32.png");
		rectangle.setIcon(img);
		rectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gsv.startRectangleState();
			}
		});
		JToggleButton select = new JToggleButton();
		ImageIcon img1 = new ImageIcon("slike/cursor.png");
		select.setIcon(img1);
		select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gsv.startSelectState();
			}
		});
		JToggleButton circle = new JToggleButton();
		ImageIcon img2 = new ImageIcon("slike/circle32x32.png");
		circle.setIcon(img2);
		circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				gsv.startCircleState();
			}
		});
		ButtonGroup grupa = new ButtonGroup();
		grupa.add(circle);
		grupa.add(rectangle);
		grupa.add(select);
		toolbar.add(select);
		toolbar.add(rectangle);
		toolbar.add(circle);
		toolbar.add(MyFrame.getInstance().getActionManager().getUndoAction());
		toolbar.add(MyFrame.getInstance().getActionManager().getRedoAction());
		toolbar.add(MyFrame.getInstance().getActionManager().getEditCopyAction());
		toolbar.add(MyFrame.getInstance().getActionManager().getEditCutAction());
		toolbar.add(MyFrame.getInstance().getActionManager().getEditPasteAction());
		toolbar.add(MyFrame.getInstance().getActionManager().getDeleteElementAction());
		toolbar.setFloatable(false);
		add(toolbar, BorderLayout.NORTH);
		
		//setVisible(true);
	}
}
