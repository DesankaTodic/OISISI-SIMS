package view;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.tree.TreePath;

import model.workspace.Project;
import model.workspace.Workspace;
import event.ModelUpdateEvent;
import gui.MyFrame;
import gui.WorkspaceTree;
import gui.listeners.ProjectMouseListener;

public class WorkspaceView extends JDesktopPane implements Observer{
	private Workspace workspace;
	private ArrayList<ProjectView> projects = new ArrayList<ProjectView>();
	public WorkspaceView(Workspace w){
		workspace = w;
		workspace.addObserver(this);
	}

	@Override
	public void update(Observable o, Object obj) {
     
        ModelUpdateEvent event = (ModelUpdateEvent)obj;
        Project p = (Project) event.getObject();
        if(event.getAdd() ==  true){
			ProjectView view=new ProjectView(p);
			projects.add(view);
			view.setName(p.getName());
			//view.setProject(p);
			//dodajem JTabbedPane koji ce u sebi sadrzati tabove koji predstavljaju dokumenta

			((BasicInternalFrameUI)view.getUI()).getNorthPane().addMouseListener(new ProjectMouseListener());
			
			//MyFrame.getInstance().getDesktop().add(view);
			add(view);
			///////////////////////////selekcija u stablu
			//WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
			//tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] 
			//{tree.getRoot(), p}));
			/////////////////////////////////
			try {
				view.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else
        {
			for (ProjectView view : projects){
				if (view.getName() == p.getName()){
					projects.remove(view);	
					view.setVisible(false);
					//MyFrame.getInstance().getDesktop().remove(view);
					remove(view);
					break;
				}			
			}
        }
	}
	
}
