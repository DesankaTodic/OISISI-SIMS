package actions;

import gui.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class SaveProjectAction extends AbstractAction{

	public SaveProjectAction() {
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
		        KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, new ImageIcon("slike/save.png"));
		putValue(NAME, "Save project");
		putValue(SHORT_DESCRIPTION, "Save project");
	}
	public void changeName(){
		putValue(NAME, MyFrame.getInstance().getResourceBundle().getString("mnuCuvanjeProjekta"));
		putValue(SHORT_DESCRIPTION, MyFrame.getInstance().getResourceBundle().getString("mnuCuvanjeProjekta"));
	}

	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new DocumentFileFilter());
		
		/*if (MyFrame.getInstance().getWorkspaceTree().getCurrentProject()==null){
			
			JOptionPane.showMessageDialog(null, "Morate selektovati projekat koji želite da saèuvate.");
			return;
		}
		Project project=MyFrame.getInstance().getWorkspaceTree().getCurrentProject();
		File projectFile=project.getProjectFile();
		*/
		
		/*if (project.getProjectFile()==null){
		         if(jfc.showSaveDialog(MyFrame.getInstance())==JFileChooser.APPROVE_OPTION){
		                   projectFile=jfc.getSelectedFile();           	 
		        	 
		         }else{
		        	return; 
		         }
		         
		}     
	      
		         
	    ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(project);
			project.setProjectFile(projectFile);
			project.setChanged(false);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
			
	
		*/
	
		
	}

}
