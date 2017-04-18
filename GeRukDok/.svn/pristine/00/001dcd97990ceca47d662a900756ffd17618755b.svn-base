package actions;


import gui.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import model.workspace.Document;
import model.workspace.GraphicSlot;
import model.workspace.Page;
import view.DocView;
import view.GraphicSlotView;
import view.PageView;
import view.ProjectView;

public class EditPasteAction extends AbstractEditorAction {
	EditPasteAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
		putValue(SMALL_ICON, new ImageIcon("slike/paste.png"));
		putValue(NAME, "Paste");
		putValue(SHORT_DESCRIPTION, "Paste");
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = MyFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		TreePath path = MyFrame.getInstance().getWorkspaceTree().getSelectionPath();
		if(o instanceof GraphicSlot){
			GraphicSlot slot = (GraphicSlot) o;
			Page pg = slot.getPage();
			Document d = pg.getDocument();
			JInternalFrame frame = MyFrame.getInstance().getDesktop().getSelectedFrame();
			ProjectView view = (ProjectView)frame;
			for(DocView dv : view.getDocuments())
				{
					if(dv.getName() == d.getName())
					{
						for (PageView pv : dv.getPages()) 
						{
							if (pv.getName() == pg.getName()) 
							{
								for(int i = 0;i < pv.getSlotSize();i++)
								{
									Object oslot = pv.getSlot(i);
									if(oslot instanceof GraphicSlotView)
									{
										GraphicSlotView slotView = (GraphicSlotView)oslot;
										if (slot.getName() == slotView.getName())
										{
											slotView.getFramework().paste();
										}
									}
								}
							}
						}
					}
				}
		}
	}

}
