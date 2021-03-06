package gui;

import gui.listeners.MyWindowListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import model.workspace.Workspace;
import view.WorkspaceView;
import actions.ActionManager;

public class MyFrame extends JFrame implements ClipboardOwner{


	private static MyFrame instance=null;
	private MyToolbar toolbar;
	private Menu menu;
	private StatusBar statusBar;
	private ResourceBundle resourceBundle;
	private WorkspaceView desktop;
	private ActionManager actionManager = new ActionManager();
	private Clipboard clipboard=new Clipboard("GeRuDok clipboard");

    public ActionManager getActionManager() {
		return actionManager;
	}

	private WorkspaceTree workspaceTree;

	
	private MyFrame(){
		addWindowListener(new MyWindowListener());
		//Locale.setDefault(new Locale("sr","RS"));
		Locale.setDefault(new Locale("en","US"));
		System.out.println("Novi Default lokal:"+Locale.getDefault());
		
		resourceBundle =ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault());
	}
	public void changeLanguage(){
		
		resourceBundle =
            ResourceBundle.getBundle( "gui.MessageResources.MessageResources", Locale.getDefault() );
	    setTitle(resourceBundle.getString("naslovAplikacije"));
		menu.initComponents();
		statusBar.initComponents();
		MyFrame.getInstance().getActionManager().getNewProjectAction().changeName();
		MyFrame.getInstance().getActionManager().getNewDocumentAction().changeName();
		MyFrame.getInstance().getActionManager().getNewPageAction().changeName();
		MyFrame.getInstance().getActionManager().getNewTextSlotAction().changeName();
		MyFrame.getInstance().getActionManager().getNewGraphicSlotAction().changeName();
		MyFrame.getInstance().getActionManager().getOpenProjectAction().changeName();
		MyFrame.getInstance().getActionManager().getSaveProjectAction().changeName();
		MyFrame.getInstance().getActionManager().getDeleteAction().changeName();
		MyFrame.getInstance().getActionManager().getCascadeAction().changeName();
		MyFrame.getInstance().getActionManager().getTileHorizontallyAction().changeName();
		MyFrame.getInstance().getActionManager().getTileVerticallyAction().changeName();
		MyFrame.getInstance().getActionManager().getMatrixProjectViewAction().changeName();
		MyFrame.getInstance().getActionManager().getAboutDialogAction().changeName();
		MyFrame.getInstance().getActionManager().getDeleteElementAction().changeName();
		MyFrame.getInstance().getActionManager().getUndoAction().changeName();
		MyFrame.getInstance().getActionManager().getRedoAction().changeName();
		MyFrame.getInstance().getActionManager().getMyWindowListener().changeName();
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	

	private void initialise(){
		initialiseWorkspaceTree();
		initialiseGUI();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initialiseGUI(){
		
		menu=new Menu();
        setJMenuBar(menu);

        toolbar=new MyToolbar();
        getContentPane().add(toolbar,BorderLayout.NORTH);

        
        statusBar=new StatusBar();
        getContentPane().add(statusBar,BorderLayout.SOUTH);

        desktop.setBackground(Color.WHITE);
        

        JScrollPane scroll=new JScrollPane(workspaceTree);
		scroll.setMinimumSize(new Dimension(200,150));
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
		
		add(split,BorderLayout.CENTER);
		split.setDividerLocation(250);
		
        setSize(900,700);
        setTitle(resourceBundle.getString("naslovAplikacije"));
        setLocationRelativeTo(null);
        
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img=kit.getImage("slike/g.jpg");
        setIconImage(img);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   

	}


	private void initialiseWorkspaceTree(){

		
		Workspace root = new Workspace();
		workspaceTree=new WorkspaceTree(root);
		desktop = new WorkspaceView(root);
		workspaceTree.setRootVisible(true);
		
		ToolTipManager.sharedInstance().registerComponent(workspaceTree);
		//add(workspaceTree, BorderLayout.WEST);
	}
	
	
	public static MyFrame getInstance(){
		  if (instance==null){
			  instance=new MyFrame();
			  instance.initialise();
		  }
		  return instance;
		  
	}
	public WorkspaceView getDesktop(){
		return desktop;
	}
	
	public WorkspaceTree getWorkspaceTree() {
		return workspaceTree;
	}
	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		System.out.println("lostOwnership");
	}
	public Clipboard getClipboard() {
		return clipboard;
	}


	
}
