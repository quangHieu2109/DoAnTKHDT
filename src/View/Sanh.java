package View;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controller.ControllerDangKy;
import Controller.ControllerSanh;

public class Sanh extends PanelIn4 {
	final int PANEL_SIZE_WIDTH_MODE = imgModeBaiCao.getIconWidth();
	final int PANEL_SIZE_HEIGHT_MODE = imgModeBaiCao.getIconHeight();
	JLabel avatar;
	JButton shop;
	JButton xiDach;
	JButton baiCao;
	

	public Sanh(View view) {
		super(view);
		
		init();
		addAction();
	}

	public void init() {
		
		shop = new JButton(imgShop);
		xiDach = new JButton(new ImageIcon("./img/main/baiCao.png"));
		baiCao = new JButton(imgModeBaiCao);

		baiCao.setActionCommand("BaiCao");
		xiDach.setActionCommand("XiDach");
		shop.setActionCommand("shop");
        this.setLayout(null);
		baiCao.setBounds(CHIEURONGPANEL / 2 - PANEL_SIZE_WIDTH_MODE - SPACE,
				CHIEUCAOPANEL / 2 - PANEL_SIZE_HEIGHT_MODE / 2, PANEL_SIZE_WIDTH_MODE, PANEL_SIZE_HEIGHT_MODE);
		xiDach.setBounds(CHIEURONGPANEL / 2 + SPACE, CHIEUCAOPANEL / 2 - PANEL_SIZE_HEIGHT_MODE / 2,
				PANEL_SIZE_WIDTH_MODE, PANEL_SIZE_HEIGHT_MODE);

		xiDach.setBorderPainted(false);
		xiDach.setOpaque(false);
		baiCao.setBorderPainted(false);
		baiCao.setOpaque(false);

		add(baiCao);
		add(xiDach);
	}

	public void addAction() {
		ac = new ControllerSanh(view);
		Component[] comps = this.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton button = (JButton) comp;
				button.addActionListener(ac);
			}

		}

	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int sizeFont = 20;
		g.setFont(new Font("Serif", Font.BOLD, sizeFont));
		g.drawString("Xì Dách", xiDach.getX()+xiDach.getWidth()/2-sizeFont*2, xiDach.getY()+xiDach.getHeight()+SPACE+sizeFont/4);
		g.drawString("Bài Cào", baiCao.getX()+baiCao.getWidth()/2-sizeFont*2, baiCao.getY()+baiCao.getHeight()+SPACE+sizeFont/4);
	}

}
