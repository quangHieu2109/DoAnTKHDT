package view;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import controller.ControllerXiDach;

public class GDGameXiDach extends GDBanGame {
	ControllerXiDach ctrXiDach;
	JButton btnRutBai;
	JButton btnGapBai;
	int soBaiDuocChia = 2;
	int luotPlayer = 0;

	public GDGameXiDach(View view) {
		super(view);
		this.start();

	}

	@Override
	public void init() {
		super.init();
		btnRutBai = new JButton("Rút bài");
		btnRutBai.setActionCommand("RutBai");
		btnRutBai.setBounds(CHIEURONGFRAME / 2 + SPACE * 3, CHIEUCAOFRAME / 2 - BTN_SIZE_HEIGHT, BTN_SIZE_WIDTH,
				BTN_SIZE_HEIGHT);

		this.add(btnRutBai);
		
	}

	public void start() {
		boBai.xaoBai();
		for (GDBoxPlayer gdBoxPlayer : lstBoxPlayer) {
			gdBoxPlayer.themBaiVaoTay(boBai.rutBaiTrenCung());
			gdBoxPlayer.themBaiVaoTay(boBai.rutBaiTrenCung());
		}
	}

	public void clickBtnRutBai() {
		lstBoxPlayer.get(luotPlayer).themBaiVaoTay(boBai.rutBaiTrenCung());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == btnRutBai.getActionCommand()) {
			clickBtnRutBai();
		}

		view.setVisible(true);
	}

	@Override
	public void addAction() {
		ctrXiDach = new ControllerXiDach(this);
		Component[] comps = this.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(this);
			}
		}

	}

}
