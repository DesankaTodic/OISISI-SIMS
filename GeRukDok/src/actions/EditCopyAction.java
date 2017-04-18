package actions;


import gui.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import model.SlotElementsSelection;
import model.workspace.GraphicSlot;
import view.ProjectView;

public class EditCopyAction extends AbstractEditorAction {
	
	EditCopyAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
		putValue(SMALL_ICON, new ImageIcon("slike/copy.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy");
	}
	
	public void actionPerformed(ActionEvent e) {
		Object o = MyFrame.getInstance().getWorkspaceTree().getLastSelectedPathComponent();
		TreePath path = MyFrame.getInstance().getWorkspaceTree().getSelectionPath();
		if(o instanceof GraphicSlot){
			GraphicSlot slot = (GraphicSlot) o;
			if(!(slot.getSelectionModel().getSelectionListSize()==0)){
				SlotElementsSelection contents = new SlotElementsSelection (slot.getSelectionModel().getSelected());
				
				MyFrame.getInstance().getClipboard().setContents (contents, MyFrame.getInstance());
				/*setContents-Metoda kojom se postavlja sadrzaj
				clipboard-a koji je raspoloziv u CCP
				operacijama i registruje se vlasnik
				clipboard objekta i sadrzaja clipboard
				objekta.*/
			}
			
		}
		
	}
}
