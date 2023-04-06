package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;

import controller.ControllerDangNhap;
import controller.ControllerSanhGame;

public class GDSanhGame extends APanel {
	ImageIcon imgXiDach;
	ImageIcon imgBaiCao;
	JButton btnModeXiDach;
	JButton btnModeBaiCao;
	JComboBox<Integer> cbNumOPlayer;
	JLabel lbChonSoNguoiChoi ;
	public GDSanhGame(View view) {
		super(view);

	}

	@Override
	public void init() {
		super.init();
		Integer[] chonSoNguoiChoi = { 1, 2, 3 };
		imgBaiCao = new ImageIcon("./img/main/baiCao.png");
		imgXiDach = new ImageIcon("./img/main/xiDach.png");
		btnModeXiDach = new JButton(imgXiDach);
		btnModeBaiCao = new JButton(imgBaiCao);
		lbChonSoNguoiChoi = new JLabel("Chọn số người chơi");

		cbNumOPlayer = new JComboBox<>(chonSoNguoiChoi);
		cbNumOPlayer.setSelectedIndex(0);

		btnModeXiDach.setBounds(CHIEURONGFRAME / 2 - SPACE - imgXiDach.getIconWidth(),
				CHIEUCAOFRAME / 2 - imgXiDach.getIconHeight() / 2, imgXiDach.getIconWidth(), imgXiDach.getIconHeight());
		btnModeBaiCao.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 - imgXiDach.getIconHeight() / 2,
				imgBaiCao.getIconWidth(), imgBaiCao.getIconHeight());
		cbNumOPlayer.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH / 2, btnModeBaiCao.getY() - SPACE - BTN_SIZE_HEIGHT,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);
		lbChonSoNguoiChoi.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH / 2,
				cbNumOPlayer.getY() - SPACE - BTN_SIZE_HEIGHT, BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);

		btnModeXiDach.setOpaque(false);
		btnModeBaiCao.setOpaque(false);
		btnModeXiDach.setBorderPainted(false);
		btnModeBaiCao.setBorderPainted(false);

		this.add(btnModeXiDach);
		this.add(btnModeBaiCao);
		this.add(lbChonSoNguoiChoi);
		this.add(cbNumOPlayer);

	}

	@Override
	public void addAction() {
		controller = new ControllerSanhGame(models, this);
		Component[] comps = this.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(controller);
			}
		}

	}

}
