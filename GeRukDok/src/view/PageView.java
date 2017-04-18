package view;

import event.ModelUpdateEvent;
import gui.listeners.PageMouseListener;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import model.workspace.GraphicSlot;
import model.workspace.Page;
import model.workspace.TextSlot;

public class PageView extends JPanel implements Observer{
	private Page page = null;
	private ArrayList<Object> slots = new ArrayList<Object>();
	
	public PageView( Page p){
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(700,700));
		setName(p.getName());
		setBackground(Color.WHITE);
		setToolTipText(p.getName());
		page = p;
		///////////////////////
		page.addObserver(this);
		//////////////////////////

		BoxLayout box=new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(box);
		addMouseListener(new PageMouseListener());
		putClientProperty("page", p);

		setBorder(new TitledBorder(new EtchedBorder(), p.getName()));
	}
	@Override
	public void update(Observable o, Object obj) {
		// TODO Auto-generated method stub
		ModelUpdateEvent event = (ModelUpdateEvent)obj;
		if(event.getObject() instanceof GraphicSlot)
		{
			GraphicSlot gSlot = (GraphicSlot)event.getObject();
			if(event.getAdd() == true)
			{
				GraphicSlotView slotView = new GraphicSlotView(gSlot);
				add(slotView);// na stranicu dodajemo slot
				slots.add((Object) slotView);
				repaint();
				validate();
				////////////////////////selekcija slota u stablu
				//WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
				//tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] 
				///{tree.getRoot(), gSlot.getPage().getDocument().getProject(), gSlot.getPage().getDocument(), gSlot.getPage(), gSlot}));
				
				/////////////////////////
				event.setAdd(false);
			}else
			{
				for(int i = 0;i < slots.size();i++)
				{
					Object slot = slots.get(i);
					if(slot instanceof GraphicSlotView)
					{
						GraphicSlotView gs = (GraphicSlotView)slot;

						if(gs.getName() == gSlot.getName())
						{
							remove(gs);
							slots.remove(slot);
							revalidate();
							repaint();
							break;
						}
					}
				}
				event.setRemove(false);
			}
		}else
		{
			TextSlot tSlot = (TextSlot)event.getObject();
			if(event.getAdd() == true)
			{
				TextSlotView slotView = new TextSlotView(tSlot);
				add(slotView);// na stranicu dodajemo slot
				slots.add((Object) slotView);
				repaint();
				validate();
				////////////////////////selekcija slota u stablu
				//WorkspaceTree tree = MyFrame.getInstance().getWorkspaceTree();
				//tree.getSelectionModel().setSelectionPath(new TreePath(new Object[] 
				//		{tree.getRoot(), tSlot.getPage().getDocument().getProject(),tSlot.getPage().getDocument(), tSlot.getPage(), tSlot}));
		
		/////////////////////////
				event.setAdd(false);
			}else
			{
				for(int i = 0;i < slots.size();i++)
				{
					Object slot = slots.get(i);
					if(slot instanceof TextSlotView)
					{
						TextSlotView ts = (TextSlotView)slot;

						if(ts.getName() == tSlot.getName())
						{
							remove(ts);
							slots.remove(slot);
							revalidate();
							repaint();
							break;
						}
					}
				}
				event.setRemove(false);
			}
		}
	}
		
		
		
	public Page getPage(){
		return page;
	}
	public void setPage(Page p){
		page = p;
	}
	public int getSlotSize(){
		return slots.size();
	}
	//brisanje iz lista
	public void removeSlot(Object slot){
		slots.remove(slot);	
	}	

	//vraca element liste
	public Object getSlot(int index) {
		return slots.get(index);
	}
	//dodaje u listu
	public void addSlot(Object slot){
		slots.add(slot);	
	}
	

}
