package controller;

import models.DSTaiKhoan;
import view.GDDangKy;
import view.View;

public class ControllerDangKy {
	public ControllerDangKy() {
		GDDangKy gdDK = new GDDangKy(this);
		View.getInstance().addPanel("DangKy", gdDK);
	}

	public void dangKyTK(String userName, String password) {
		DSTaiKhoan.getDSTaiKhoan().themTaiKhoan(userName, password);
	}

	public boolean checkDangKy(String userName, String password) {
		return DSTaiKhoan.getDSTaiKhoan().checkTaiKhoan(userName, password);
	}
}
