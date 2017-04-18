package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import model.workspace.Project;
import model.workspace.Workspace;
import view.ProjectView;
import view.WorkspaceTreeCellEditor;
import view.WorkspaceTreeCellRendered;
import controller.WorkspaceTreeController;

public class WorkspaceTree extends JTree{
	private Workspace w = null;

	public WorkspaceTree(Workspace w) {
		super(w);
        this.w = w;
		addTreeSelectionListener(new WorkspaceTreeController());
	    setCellEditor(new WorkspaceTreeCellEditor(this,new DefaultTreeCellRenderer()));
	    setCellRenderer(new WorkspaceTreeCellRendered());
	    setEditable(true);
	   
	   ///////////////////////////listener na stablo da bismo ponovo "otvorili" projekat, dokument itd.
	    //tj. cvorove koji se nalazi u stablu
//////////////////////////////////
	    MouseListener ml = new MouseAdapter() {// anonimana unutrasnja klasa
			public void mousePressed(MouseEvent e) {//
				TreePath selPath = getPathForLocation(e.getX(), e.getY());
				if (e.getClickCount() == 2) {// ako 2x kliknemo na
					// cvor

					for (int i = 0; i < selPath.getPathCount(); i++) {// prodjemo
						// kroz
						// njegovu
						// putanju
						Object o = selPath.getPathComponent(i);
						if (o instanceof Project) {// kad naidjemo na
							// projekat
							Project p = (Project) o;
							// selektovan je projekat u stablu

							JInternalFrame[] frames = MyFrame.getInstance()
									.getDesktop().getAllFrames();
							for (JInternalFrame frame : frames) {
								if (frame instanceof ProjectView) {
									ProjectView view = (ProjectView) frame;
									if (p == view.getProject())// ako
																// pronadjemo
																// view koji
																// je kao i
																// projekat
																// koji
									{ // je selektovan u stablu, i stavi ga
										// u fokus
										view.moveToFront();
										try {
											view.setSelected(true);
										} catch (PropertyVetoException e1) {
											// TODO Auto-generated catch
											// block
											e1.printStackTrace();
										}
										view.setVisible(true);
									}
								}
							}
						}
					}
				}
			}
		};

		addMouseListener(ml);
	
		//setComponentPopupMenu(new MyPopupMenu(selectedNode));
	}
	public Workspace getRoot(){
		return this.w;
	}

}
