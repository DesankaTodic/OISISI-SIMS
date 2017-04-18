package actions;

import gui.MyFrame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

public class TileVerticallyAction extends AbstractAction {

	public TileVerticallyAction() {
		
	    putValue(NAME, "Tile Vertically");
	    putValue(SHORT_DESCRIPTION, "Tile Vertically");
	    putValue(ACCELERATOR_KEY,  KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));		
	    putValue(SMALL_ICON, new ImageIcon("slike/tileHor.png"));
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuVertikalno"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuVertikalno"));
	}



	public void actionPerformed(ActionEvent e)
	{
		int height=MyFrame.getInstance().getDesktop().getSize().height;
		int width=MyFrame.getInstance().getDesktop().getSize().width;
		
	// MainFrame.getInstance().getDesktopPane().setLayout(new FlowLayout(FlowLayout.LEFT));
	  //MainFrame.getInstance().getDesktopPane().validate(); 
	  JInternalFrame[] frames =  MyFrame.getInstance().getDesktop().getAllFrames();
	  
	  int diagramHeight= height; 
	  int diagramWidth= width/frames.length;
	  
	  for (int i = 0; i < frames.length; i++)
	  {
		  
	    JInternalFrame frame = frames[i];
	    frame.setSize(width, diagramHeight);
	    frame.setPreferredSize(new Dimension(diagramHeight,diagramWidth));
	    frame.setLocation(diagramWidth*i ,0);
	    try
	    {
	      frame.setSelected(true);
	    }
	    catch (PropertyVetoException e1)
	    {
	      e1.printStackTrace();
	    }
	  } 
	}
	}
