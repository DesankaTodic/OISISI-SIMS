package actions;

import gui.MyFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;

public class TileHorizontallyAction extends AbstractAction {

	public TileHorizontallyAction() {
		
	    putValue(NAME, "Tile Horizontally");
	    putValue(SHORT_DESCRIPTION, "Tile Horizontally");
	    putValue(ACCELERATOR_KEY,  KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));		
	    putValue(SMALL_ICON, new ImageIcon("slike/tile_vertical.png"));
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuHorizontalno"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuHorizontalno"));
	}



	public void actionPerformed(ActionEvent e)
	{
		int height=MyFrame.getInstance().getDesktop().getSize().height;
		int width=MyFrame.getInstance().getDesktop().getSize().width;
		
	// MainFrame.getInstance().getDesktopPane().setLayout(new FlowLayout(FlowLayout.LEFT));
	  //MainFrame.getInstance().getDesktopPane().validate(); 
	  JInternalFrame[] frames =  MyFrame.getInstance().getDesktop().getAllFrames();
	  
	  int diagramHeight= height/frames.length; 
	  int diagramWidth= width;
	  
	  for (int i = 0; i < frames.length; i++)
	  {
		  
	    JInternalFrame frame = frames[i];
	    frame.setSize(width, diagramHeight);
	    frame.setPreferredSize(new Dimension(diagramHeight,diagramWidth));
	    frame.setLocation(0 ,diagramHeight*i);
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
	