package gui;
	

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
	
	
public class AboutDialog extends JDialog  {
	
	


	public AboutDialog() {
	
		setSize(600, 600);

		setLocationRelativeTo(null);

		JPanel jp = new JPanel();

		JLabel lab1 = new JLabel();

		lab1.setIcon(new ImageIcon("slike/Info.png"));

		lab1.setText("Nikola Majstorovic RA 197/2012");

		jp.add(lab1);

		JLabel lab2 = new JLabel();

		lab2.setIcon(new ImageIcon("images/Project-icon.png"));

		lab2.setText("Desanka Todic RA 113/2012");

		jp.add(lab2);

		JLabel label4 = new JLabel(new ImageIcon("slike/nikola.jpg"));

		label4.setText("Center-Bottom");

		label4.setHorizontalTextPosition(JLabel.CENTER);

		label4.setVerticalTextPosition(JLabel.BOTTOM);

		jp.add(label4);

		add(jp);
	}
}