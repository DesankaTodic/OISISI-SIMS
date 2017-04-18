package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StatusBar extends JPanel {
	//pogledaj pdf sa termin4 9.strana sta se sve moze dodati u statusbar
	//da ne bude praznog prostora
	private JLabel lblJezik;
	private JLabel lblNikola;
	private JLabel lblDesa;
	
	public StatusBar() {		
	super();
	
	setLayout(new GridLayout(1, 3));
	
	JPanel panBottom=new JPanel(new FlowLayout(FlowLayout.CENTER));
	panBottom.setBackground(Color.LIGHT_GRAY);
	//postavljenje aktivnog jezika
	lblJezik = new JLabel(MyFrame.getInstance().getResourceBundle().getString("lblJezik")+
			Locale.getDefault().getDisplayLanguage());
	///////////////////////////////
	panBottom.add(lblJezik);
	
	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	panBottom.setBorder(loweredbevel);
	add(panBottom);
	
	JPanel panBottom2=new JPanel(new FlowLayout(FlowLayout.CENTER));
	panBottom2.setBackground(Color.LIGHT_GRAY);
	lblNikola = new JLabel(MyFrame.getInstance().getResourceBundle().getString("lblDesa"));
	panBottom2.add(lblNikola);
	panBottom2.setBorder(loweredbevel);
	add(panBottom2);
	
	JPanel panBottom3=new JPanel(new FlowLayout(FlowLayout.CENTER));
	panBottom3.setBackground(Color.LIGHT_GRAY);
	lblDesa = new JLabel(MyFrame.getInstance().getResourceBundle().getString("lblNikola"));
	panBottom3.add(lblDesa);
	panBottom3.setBorder(loweredbevel);
	add(panBottom3);

	}
	public void initComponents(){
		
		lblJezik.setText(MyFrame.getInstance().getResourceBundle().getString("lblJezik")+
				MyFrame.getInstance().getResourceBundle().getString("Serbian"));
		System.out.println("Novi Default lokal:"+Locale.getDefault());
		lblDesa.setText(MyFrame.getInstance().getResourceBundle().getString("lblDesa"));
		lblNikola.setText(MyFrame.getInstance().getResourceBundle().getString("lblNikola"));

	}

}