package controller;

import javax.swing.JOptionPane;

import models.DSTaiKhoan;
import view.GDDangNhap;
import view.GDSanhGame;
import view.View;

public class ControllerDangNhap {
	public ControllerDangNhap() {
		GDDangNhap gdDangNhap = new GDDangNhap(this);
		if (View.getInstance().hasPanel("DangNhap")) {
			View.getInstance().removePanel("DangNhap");
		}
		View.getInstance().addPanel("DangNhap", gdDangNhap);
		View.getInstance().setContentPane(View.getInstance().getPanel("DangNhap"));
		View.getInstance().setVisible(true);
	}

	public void dangNhap(String userName, String pass) {
		if (DSTaiKhoan.getDSTaiKhoan().checkTaiKhoan(userName, pass)) {
			if (View.getInstance().hasPanel("SanhGame")) {// nếu đã có panel sảnh game thì xóa đi
				View.getInstance().removePanel("SanhGame");
			}
			DSTaiKhoan.getDSTaiKhoan().setUsername(userName);
			ControllerSanhGame ctrSanhGame = new ControllerSanhGame();

			View.getInstance().setVisible(true);

		} else {
			JOptionPane.showMessageDialog(View.getInstance(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");
		}
	}

}
