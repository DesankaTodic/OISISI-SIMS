package view;

import event.ModelUpdateEvent;
import gui.MyFrame;
import gui.WorkspaceTree;
import gui.listeners.DocumentMouseListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.tree.TreePath;

import model.workspace.Document;
import model.workspace.Page;
import net.miginfocom.swing.MigLayout;
import actions.PageLayoutAction;

public class DocView extends JPanel implements Observer{
	
	public Document doc = null;
	public ProjectView pv = null;
	public JPanel contentPanel = null;
	private ArrayList<PageView> pages = new ArrayList<PageView>();
	
	public DocView(ProjectView pv,Document d){
		doc = d;
		////////////////////
		doc.addObserver(this);
		//////////////////
		this.pv = pv;
		JTabbedPane tabbDoc = (JTabbedPane)pv.getContentPane().getComponent(0);
		tabbDoc.addMouseListener(new DocumentMouseListener());
		setName(d.getName());
		JPanel docPanel=new JPanel();
		docPanel.putClientProperty("document", d);
		
		//BoxLayout box=new BoxLayout(docPanel, BoxLayout.Y_AXIS);
		//docPanel.setLayout(box);
		
		docPanel.setLayout(new BorderLayout());
		
		ImageIcon icon = new ImageIcon("New document.png");
		tabbDoc.addTab(d.name, icon, docPanel, d.name);		
		tabbDoc.setSelectedIndex(tabbDoc.getTabCount() - 1);//cim doda novi tab selektuje ga

		JToolBar toolbar=new JToolBar();
		docPanel.add(toolbar,BorderLayout.NORTH);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new MigLayout());
		contentPanel.setBackground(Color.gray);
		
		JScrollPane scrolly=new JScrollPane(contentPanel);
		scrolly.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrolly.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		docPanel.add(scrolly,BorderLayout.CENTER);
		
		for (int j = 1; j <= 16; j++)
		{	
			JButton button=new JButton(""+j);
			//button.setToolTipText("New project");
			button.addActionListener(new PageLayoutAction(j, contentPanel));
			toolbar.add(button);
		}
	}
	///////////////////////////////////mora da implementira ovu metodu jer je observer
	public void update(Observable obs, Object obj) {
		ModelUpdateEvent event = (ModelUpdateEvent)obj;
		Page page = (Page)event.getObject();
		if(event.getAdd() == true)
		{
			PageView pgv = new PageView(page);
			pages.add(pgv);//u listu stranica dodajem novu stranicu
			contentPanel.add(pgv,"wrap");
			contentPanel.repaint();
			contentPanel.validate();
			//////////////////////////////selekcija u stablu
			//WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
			//tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] 
			//{tree.getRoot(), page.getDocument().getProject(), page.getDocument(), page}));
			//////////////////////////
			event.setAdd(false);
		}else
		{
			for (PageView pgv : pages)
			{

				if (pgv.getName() == page.getName()) 
				{
					contentPanel.remove(pgv);
					pages.remove(pgv);
					contentPanel.revalidate();
					contentPanel.repaint();
					break;
				}
				
			}
			event.setRemove(false);
		}
	} 
	////////////////////////////////////////////////////////////////////////
	public JPanel getContentPanel(){
		return contentPanel;
	}
	public ArrayList<PageView> getPages() {
		return pages;
	}

	public PageView getPage(int index) {
		return pages.get(index);
	}
	
	/*public static JPanel GetDocumentContentPanel(JPanel docPanel)
	{
		JScrollPane scrolly = (JScrollPane)docPanel.getComponent(1);
		JViewport viewport = scrolly.getViewport(); //na ovaj nacin izvlacimo komponentu-panel iz skrola
		JPanel contentPanel = (JPanel)viewport.getView();//u taj panel kasnije smjestamo stranice
		this.contentPanel = contentPanel;
		return contentPanel;
	}*/
}
