package view;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.ControllerSanhGame;
import models.GameBaiCao;
import models.GameXiDach;

public class GDSanhGame extends APanel{
	ControllerSanhGame ctrSanhGame;
	int chonSoNguoiChoi;
	ImageIcon imgXiDach;
	ImageIcon imgBaiCao;
	JButton btnModeXiDach;
	JButton btnModeBaiCao;
	JComboBox<Integer> cbNumOPlayer;
	JLabel lbChonSoNguoiChoi;
	public GDSanhGame(ControllerSanhGame ctrSanhGame) {
		this.ctrSanhGame=ctrSanhGame;
		this.init();
		this.addAction();
	}
	@Override
	public void init() {
		super.init();
		Integer[] soNguoiChoi = { 2, 3, 4 };
		imgBaiCao = new ImageIcon("./img/main/baiCao.png");
		imgXiDach = new ImageIcon("./img/main/xiDach.png");
		btnModeXiDach = new JButton(imgXiDach);
		btnModeBaiCao = new JButton(imgBaiCao);
		lbChonSoNguoiChoi = new JLabel("Chọn số người chơi");
		
		btnModeBaiCao.setActionCommand("BaiCao");
		btnModeXiDach.setActionCommand("XiDach");

		cbNumOPlayer = new JComboBox<>(soNguoiChoi);
		cbNumOPlayer.setActionCommand("selectNumberPlayer");
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
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(btnOut.getActionCommand())) {
			clickBtnOut();
		}
		if (e.getActionCommand().equals(btnModeXiDach.getActionCommand())) {
			btnClickGameXiDach();
		}
		if(e.getActionCommand().equals(btnModeBaiCao.getActionCommand())) {
			btnClickGameBaiCao();
		}
		
	}
	private void btnClickGameBaiCao() {
		ctrSanhGame.setSoNguoiChoi((int)cbNumOPlayer.getSelectedItem());
		ctrSanhGame.playGame(new GameBaiCao());
	}

	private void btnClickGameXiDach() {
		ctrSanhGame.setSoNguoiChoi((int)cbNumOPlayer.getSelectedItem());
		ctrSanhGame.playGame(new GameXiDach());
		
		
		
	}
	private void clickBtnOut() {
		int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không", "Đăng Xuất",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {// nếu đồng ý sẽ xóa panel sảnh game và set view thành panel đăng nhập
			View.getInstance().setContentPane(View.getInstance().getPanel("DangNhap"));
			View.getInstance().removePanel("SanhGame");
			View.getInstance().setVisible(true);
		}
		
		
	}
	@Override
	public void addAction() {
		Component[] comps = this.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(this);
			}
		}
		
	}

}
