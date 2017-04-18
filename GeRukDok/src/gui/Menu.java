package gui;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import actions.AboutDialogAction;

public class Menu extends JMenuBar {
		private Object object;
		JMenu mnuJezik;
		JCheckBoxMenuItem mniSrpski;
		JCheckBoxMenuItem mniEngleski;
		JCheckBoxMenuItem mniSrpskiC;
		JMenu mnuProjekat;
		JMenu mnuProzori;
		JMenu mnuPomoc;
		
		Menu() 
		{	
			/////////////////////////////ovako se mijenjaju obicne stavke
			mnuProjekat=new JMenu( MyFrame.getInstance().getResourceBundle().getString("mnuProjekat"));
			////////////////////////////////////////////////////////////////
			mnuProjekat.setMnemonic(KeyEvent.VK_P);
			add(mnuProjekat);
	

			//object = MyFrame.getInstance().getResourceBundle().getString("mnuCuvanjeProjekta");
			//saveProjectAction.putValue("NAME", object);
			mnuProjekat.add(MyFrame.getInstance().getActionManager().getSaveProjectAction());
			
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuOtvaranjeProjekta");
			//OpenProjectAction.putValue("NAME", object);
			mnuProjekat.add(MyFrame.getInstance().getActionManager().getOpenProjectAction());
	
			//////////////ovako se pristupa stavki koja je apstraktna akcija
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuNoviProjekat");
			//newProjectAction.putValue("NAME", object);
			
			//MyFrame.getInstance().getActionManager().getNewProjectAction().changeName();
			mnuProjekat.add(MyFrame.getInstance().getActionManager().getNewProjectAction());
			
			///////////////////////////////////////////////////////////////
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuNoviDokument");
			//newDocumentAction.putValue("NAME", object);
			mnuProjekat.add(MyFrame.getInstance().getActionManager().getNewDocumentAction());
			
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuNovaStranica");
			//newPageAction.putValue("NAME", object);
			mnuProjekat.add(MyFrame.getInstance().getActionManager().getNewPageAction());
			
			mnuProjekat.addSeparator();	
			
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuNoviGrafickiSlot");
			//newGraphicSlotAction.putValue("NAME", object);
			mnuProjekat.add(MyFrame.getInstance().getActionManager().getNewGraphicSlotAction());
			
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuNoviTekstualniSlot");
			//newTextSlotAction.putValue("NAME", object);
			mnuProjekat.add(MyFrame.getInstance().getActionManager().getNewTextSlotAction());

			
			mnuProjekat.addSeparator();	
			
	
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuBrisanje");
			//DeleteAction.putValue("NAME", object);
			mnuProjekat.add(MyFrame.getInstance().getActionManager().getDeleteAction());
	//-----------------------------------------------------------------	
			mnuProzori=new JMenu( MyFrame.getInstance().getResourceBundle().getString("mnuProzori"));
			////////////////////////////////////////////////////////////////
			mnuProzori.setMnemonic(KeyEvent.VK_W);
			add(mnuProzori);			
	
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuKaskadno");
			//cascadeAction.putValue("NAME", object);
			mnuProzori.add(MyFrame.getInstance().getActionManager().getCascadeAction());
	
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuHorizontalno");
			//tileHorizontallyAction.putValue("NAME", object);
			mnuProzori.add(MyFrame.getInstance().getActionManager().getTileHorizontallyAction());
			
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuVertikalno");
			//tileVerticallyAction.putValue("NAME", object);
			mnuProzori.add(MyFrame.getInstance().getActionManager().getTileVerticallyAction());
			
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuMatricno");
			//matrixProjectViewAction.putValue("NAME", object);
			mnuProzori.add(MyFrame.getInstance().getActionManager().getMatrixProjectViewAction());

			
			
			mnuJezik=new JMenu( MyFrame.getInstance().getResourceBundle().getString("mnuJezik"));
			////////////////////////////////////////////////////////////////
			mnuJezik.setMnemonic(KeyEvent.VK_W);
			add(mnuJezik);		
			
			mniSrpskiC= new JCheckBoxMenuItem(MyFrame.getInstance().getResourceBundle().getString("mniSrpskiC"));
			mniSrpskiC.setSelected(false);
			mniSrpskiC.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("sr","RS"));
					MyFrame.getInstance().changeLanguage();
					
					
				}
			});
			mnuJezik.add(mniSrpskiC);
			
			mniSrpski=new JCheckBoxMenuItem(MyFrame.getInstance().getResourceBundle().getString("mniSrpski"));
			mniSrpski.setSelected(false);
			mniSrpski.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("sr","BA"));
					MyFrame.getInstance().changeLanguage();
					
					
				}
			});
			mnuJezik.add(mniSrpski);
			
			//////////////default jezik je engleski
			mniEngleski=new JCheckBoxMenuItem(MyFrame.getInstance().getResourceBundle().getString("mniEngleski"));
			mniEngleski.setSelected(true);
			mniEngleski.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("en","US"));
					MyFrame.getInstance().changeLanguage();
				}
			});
			mnuJezik.add(mniEngleski);
			
			
			ButtonGroup bg=new ButtonGroup();
			bg.add(mniSrpskiC);
			bg.add(mniSrpski);
			bg.add(mniEngleski);
			//////////////////////////////////////////////////////////////////////////
		
			mnuPomoc=new JMenu( MyFrame.getInstance().getResourceBundle().getString("mnuPomoc"));
			add(mnuPomoc);
		
			//object = MyFrame.getInstance().getResourceBundle().getString("mnuAbout");
			//aboutDialogAction.putValue("NAME", object);
			mnuPomoc.add(MyFrame.getInstance().getActionManager().getAboutDialogAction());
		}
		
		public void initComponents(){
			/////////////komponente koje su stalno vidljive potrebno je dodatno osvjeziti
			///////////////za obicne stavke 
			mnuProjekat.setText(MyFrame.getInstance().getResourceBundle().getString("mnuProjekat"));
			///////////////////////////////
			
			mnuProzori.setText(MyFrame.getInstance().getResourceBundle().getString("mnuProzori"));
			
			
			mnuPomoc.setText(MyFrame.getInstance().getResourceBundle().getString("mnuPomoc"));
			
			//String sp = MyFrame.getInstance().getResourceBundle().getString("mnuAbout");
			//mnuPomoc.getItem(0).setText(sp);
			
			mnuJezik.setText(MyFrame.getInstance().getResourceBundle().getString("mnuJezik"));
			
			mniEngleski.setText(MyFrame.getInstance().getResourceBundle().getString("mniEngleski"));
			
			mniSrpski.setText(MyFrame.getInstance().getResourceBundle().getString("mniSrpski"));
			
			mniSrpskiC.setText(MyFrame.getInstance().getResourceBundle().getString("mniSrpskiC"));
			
			
			
		}
}
