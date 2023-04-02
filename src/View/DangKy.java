package View;

import java.awt.Component;

import javax.swing.JButton;

import Controller.ControllerDangKy;
import Controller.ControllerDangNhap;
import Models.Models;

public class DangKy extends DangNhap {
	

	public DangKy(View view) {
		super(view);

	}

	@Override
	public void init() {
		super.init();
	
		lbOut.setVisible(true);
		btnDangnhap.setVisible(false);
		lbDangNhap.setText("Đăng Ký");
		lbDangNhap.setBounds(CHIEURONGPANEL / 2 - LABEL_SIZE_WIDTH / 2 + 15,
				CHIEUCAOPANEL / 2 - LABEL_SIZE_HEIGHT * 2 - SPACE, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);

		btnDangKy.setBounds(CHIEURONGPANEL / 2 - BTN_SIZE_WIDTH / 2, CHIEUCAOPANEL / 2 + LABEL_SIZE_WIDTH - SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);

	}

	@Override
	public void addAction() {
		ac = new ControllerDangKy(view);
		Component[] comps = this.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton button = (JButton) comp;
				button.addActionListener(ac);
			}

		}

	}
}
