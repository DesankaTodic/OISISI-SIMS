package view;

import gui.MyFrame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;




import model.workspace.TextSlot;

public class DialogTextSlot extends JDialog{
	
	private TextSlot textSlot = null;
	private TextSlotView gsv = null;
	private JTextArea txt=null;
	
	public DialogTextSlot(TextSlot textSlot,TextSlotView tsv){
		super(MyFrame.getInstance(),
				textSlot.getName(), true);
		this.textSlot = textSlot;
		/*JDialog dialog = new JDialog(MyFrame.getInstance(),
				graphicSlot.getName(), true);*/
		setSize(400, 400);
		setLocationRelativeTo(MyFrame.getInstance());
		ImageIcon imgSlot = new ImageIcon("Component.png");
		setIconImage(imgSlot.getImage());
		setLayout(new BorderLayout());
		//Framework framework = new Framework(this);
		//add(framework, BorderLayout.CENTER);

		//GraphicSlotController c = new GraphicSlotController();
		//framework.addMouseListener(c);

		
		JToolBar toolbar = new JToolBar();
		JToggleButton bold = new JToggleButton();
		ImageIcon img = new ImageIcon("slike/bold.jpg");
		bold.setIcon(img);
		bold.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		add(toolbar, BorderLayout.NORTH);
		Font font = new Font("Verdana", Font.BOLD, 20);
		txt.setFont(font);
		add(txt);
	}
	
}
