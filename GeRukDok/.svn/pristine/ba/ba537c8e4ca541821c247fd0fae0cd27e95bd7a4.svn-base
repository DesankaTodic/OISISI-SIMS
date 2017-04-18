package view;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.tree.TreePath;

import model.workspace.Document;
import model.workspace.Project;
import event.ModelUpdateEvent;
import gui.MyFrame;
import gui.WorkspaceTree;

public class ProjectView extends JInternalFrame implements Observer {
//public class ProjectView extends JInternalFrame {
	static int openFrameCount = 0;
	private JTabbedPane tabbdoc = null;
	// sluze nam za odredjivanje pozicije unutrasnjeg prozora
	static final int xOffset = 30, yOffset = 30;
	private ArrayList<DocView> documents = new ArrayList<DocView>();
	private Project project;
	//framework nam predstavlja radnu povrsinu za projekat
	//ne moze direktno iscrtavanje 
	private JPanel framework;
	boolean flag = false;//flag za update
	
	
	
	public ProjectView(Project p) {
		
		super("" ,
		          true, //resizable
		          true, //closable
		          true, //maximizable
		          true);//iconifiable
		++openFrameCount;
		setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
		setIconifiable(true);
		setClosable(true);
		setTitle(p.getName());
		JTabbedPane tabbDoc = new JTabbedPane();
		this.add(tabbDoc);
		project = p;
		///////////////////////////ovaj view je observer za model project i dodaje ga u listu observera
		project.addObserver(this);
		////////////////////////////////////////////////////////////////////
		setSize(550,550);
 	    setVisible(true);	
 	    setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
 	    
		
	}

	///////////////////////////////////mora da implementira ovu metodu jer je observer
	public void update(Observable obs, Object obj) {
			ModelUpdateEvent event = (ModelUpdateEvent)obj;
			Document document = (Document)event.getObject();
			if(event.getAdd() == true)
			{
				DocView dv = new DocView(this,document);
				documents.add(dv);
				//da ga odmah selektuje u stablu
				//WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
				//tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] 
				//{tree.getRoot(), document.getProject(), document}));
				//napravis novu selekcionu putanju
				event.setAdd(false);
				//event.setRemove(false);
			}else
			{
				for(DocView dv : getDocuments())
				{
					if(dv.getName() == document.getName())
					{
						documents.remove(document);
					}
				}
				JTabbedPane tabbDoc = (JTabbedPane)this.getContentPane().getComponent(0);
				for (int j = 0; j < tabbDoc.getTabCount(); j++)//krene od prvog do ukupnog broja tabova 
				{	
					if (tabbDoc.getTitleAt(j) == document.name)	//i poredi nazive(titlove) tabova sa nazivom dokumenta
					{
						tabbDoc.removeTabAt(j);
					}	
				}
				this.revalidate();
				this.repaint();
				event.setRemove(false);
				
			}
	} 
	////////////////////////////////////////////////////////////////////////
	
	public void setProject(Project project){
		this.project = project; 
		this.setName(project.getName());
		
		setTitle(project.getName());
	}

	public Project getProject() {
		return project;
	
	
	}	
	//metoda za brisanje docView-a
	public void removeDocument(DocView document){
		documents.remove(document);	
	}	
	public DocView getDocument(int index) {
		return documents.get(index);
	}
	//metoda koja vraca listu dokumenta koji pripadaju datom projektu
		public ArrayList<DocView> getDocuments() {
			return documents;
		}
}
