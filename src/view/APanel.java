package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class APanel extends JPanel implements ActionListener{
	
	View view;
	final int SPACE = 15;
	final int BTN_SIZE_WIDTH = 100;
	final int BTN_SIZE_HEIGHT = 30;
	final int LABEL_SIZE_WIDTH = 90;
	final int LABEL_SIZE_HEIGHT = 25;
	final int TXT_SIZE_WIDTH = 90;
	final int TXT_SIZE_HEIGHT = 25;
	final ImageIcon imgBtnOut = new ImageIcon("./img/main/out.png");
	final ImageIcon imgBtnGuide = new ImageIcon("./img/main/guide.png");
    final int CHIEURONGFRAME = View.getInstance().CHIEURONGFRAME;
    final int CHIEUCAOFRAME = View.getInstance().CHIEUCAOFRAME;
    JButton btnOut;
    public APanel() {
    	view= View.getInstance();
    }
	


	public void init() {
		this.setBackground(new Color(91, 189, 43));
		this.setVisible(true);
		this.setLayout(null);

		btnOut = new JButton(imgBtnOut);
		btnOut.setActionCommand("Out");
		
		btnOut.setBounds(0, 0, imgBtnOut.getIconWidth(), imgBtnOut.getIconWidth());
		
		btnOut.setOpaque(false);
		btnOut.setBorderPainted(false);
		
		btnOut.setVisible(true);
		this.add(btnOut);
	}
	
@Override
public abstract void actionPerformed(ActionEvent e);
	public abstract void addAction();
public View getView() {
	return view;
}
	
}
