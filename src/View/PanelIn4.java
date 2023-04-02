package View;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class PanelIn4 extends JPanel {
	int CHIEURONGPANEL;
	int CHIEUCAOPANEL;
	final int SPACE = 15;
	final int BTN_SIZE_WIDTH = 100;
	final int BTN_SIZE_HEIGHT = 30;
	final int LABEL_SIZE_WIDTH = 100;
	final int LABEL_SIZE_HEIGHT = 25;
	final int TXT_SIZE_WIDTH = 90;
	final int TXT_SIZE_HEIGHT = 25;
    ImageIcon imgMatSauBai = new ImageIcon("./img/boBai/matsau.png");
    ImageIcon imgShop = new ImageIcon("./img/main/shop.png");
    ImageIcon imgModeBaiCao = new ImageIcon("./img/main/baiCao.png");
    ImageIcon imgModeXiDach = new ImageIcon("./img/main/xidach.png");
    ImageIcon imgOut = new ImageIcon("./img/main/out.png");
    ImageIcon imgSymBolGame = new ImageIcon("./img/main/symbolGame.png");
	
    JButton lbOut;
    ActionListener ac;
	View view;

	public PanelIn4(View view) {
		this.setLayout(null);
		
		CHIEUCAOPANEL = view.chieuCaoFrame;
		CHIEURONGPANEL = view.chieuRongFrame;
		
		lbOut = new JButton(imgOut);
		lbOut.setActionCommand("Out");
		lbOut.setBounds(0, 0, imgOut.getIconWidth(), imgOut.getIconHeight());
		lbOut.setOpaque(false);
		lbOut.setBorderPainted(false);
		lbOut.setVisible(true);
		this.add(lbOut);
		
		this.view = view;
		this.setBackground(new Color(91, 189, 43));
		this.setSize(view.chieuRongFrame, view.chieuCaoFrame);
		this.setLayout(null);
	}

	public abstract void addAction();
}
