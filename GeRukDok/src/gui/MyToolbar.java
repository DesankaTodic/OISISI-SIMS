package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import actions.AboutDialogAction;

public class MyToolbar extends JToolBar{
	public MyToolbar(){
		super(SwingConstants.HORIZONTAL);
		
		//JButton save=new JButton();
		//save.setToolTipText("Save");
		//save.setIcon(new ImageIcon("slike/save.png"));
		//save.addActionListener(new SaveProjectAction());
		add(MyFrame.getInstance().getActionManager().getSaveProjectAction());
		
		addSeparator();
		
		//JButton open=new JButton();
		//open.setToolTipText("Open");
		//open.setIcon(new ImageIcon("slike/folder-open.png"));
		//open.addActionListener(new OpenProjectAction());
		add(MyFrame.getInstance().getActionManager().getOpenProjectAction());
		
		addSeparator();
		
		//JButton newProject=new JButton();
		//newProject.setToolTipText("New project");
		//newProject.setIcon(new ImageIcon("slike/Folder.png"));
		//newProject.addActionListener(MyFrame.getInstance().getActionManager().getNewProjectAction());
		add(MyFrame.getInstance().getActionManager().getNewProjectAction());
		
		addSeparator();
		
		//JButton newDocument=new JButton();
		//newDocument.setToolTipText("New document");
		//newDocument.setIcon(new ImageIcon("slike/New document.png"));
		//newDocument.addActionListener(new NewDocumentAction());
		add(MyFrame.getInstance().getActionManager().getNewDocumentAction());
		
		addSeparator();
		
		//JButton newPage=new JButton();
		//newPage.setToolTipText("New page");
		//newPage.setIcon(new ImageIcon("slike/List.png"));
		//newPage.addActionListener(new NewPageAction());
		add(MyFrame.getInstance().getActionManager().getNewPageAction());
		
		addSeparator();
		
		//JButton newGSlot=new JButton();
		//newGSlot.setToolTipText("New graphic slot");
		//newGSlot.setIcon(new ImageIcon("slike/Component.png"));
		//newGSlot.addActionListener(new NewGraphicSlotAction());
		add(MyFrame.getInstance().getActionManager().getNewGraphicSlotAction());
		
		addSeparator();
		
		//JButton newTSlot=new JButton();
		//newTSlot.setToolTipText("New text slot");
		//newTSlot.setIcon(new ImageIcon("slike/text_slot.png"));
		//newTSlot.addActionListener(new NewTextSlotAction());
		add(MyFrame.getInstance().getActionManager().getNewTextSlotAction());
		
		addSeparator();
		
		//JButton delete=new JButton();
		//delete.setToolTipText("Delete");
		//delete.setIcon(new ImageIcon("slike/Delete.png"));
		//delete.addActionListener(new DeleteAction());
		add(MyFrame.getInstance().getActionManager().getDeleteAction());
	

		addSeparator();

		
		//JButton cascadeHor=new JButton();
		//cascadeHor.setToolTipText("Cascade horizontally");
		//cascadeHor.setIcon(new ImageIcon("slike/cascadeHor.png"));
		//cascadeHor.addActionListener(new CascadeAction());
		add(MyFrame.getInstance().getActionManager().getCascadeAction());
		
		addSeparator();
		
		//JButton tileHor=new JButton();
		//tileHor.setToolTipText("Tile Horizontally");
		//tileHor.setIcon(new ImageIcon("slike/tile_vertical.png"));
		//tileHor.addActionListener(new TileHorizontallyAction());
		add(MyFrame.getInstance().getActionManager().getTileHorizontallyAction());
		
		addSeparator();
		
		//JButton tileVer=new JButton();
		//tileVer.setToolTipText("Tile Vertically");
		//tileVer.setIcon(new ImageIcon("slike/tileHor.png"));
		//tileVer.addActionListener(new TileVerticallyAction());
		add(MyFrame.getInstance().getActionManager().getTileVerticallyAction());
		
		addSeparator();
		
		//JButton matric=new JButton();
		//matric.setToolTipText("Matric project view");
		//matric.setIcon(new ImageIcon("slike/matric.gif"));
		//matric.addActionListener(new MatrixProjectViewAction());
		add(MyFrame.getInstance().getActionManager().getMatrixProjectViewAction());
		
	
		addSeparator();	

		JButton info=new JButton();
		info.setToolTipText("About GeRuDok");
		info.setIcon(new ImageIcon("slike/Info.png"));
		//info.addActionListener(new AboutGeRuDoc());
		info.addActionListener(new AboutDialogAction());
		add(info);
		
		//pokretljivost toolbara
		setFloatable(false);
	}
}
