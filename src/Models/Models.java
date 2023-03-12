package Models;

import java.util.ArrayList;
import java.util.TreeMap;

public class Models {
	BoBai boBai;
	TaiKhoan taiKhoan;
	ArrayList<TaiKhoan> dsTaiKhoan;

	public Models() {
		boBai = new BoBai();
		dsTaiKhoan = new ArrayList<>();
		dsTaiKhoan.add(new TaiKhoan("root", "root", 0, null));
	}

	public boolean checkTKVaSetTKGame(String username, String password) {
		boolean result = false;
		for (TaiKhoan taiKhoan : dsTaiKhoan) {
			if (taiKhoan.getUsername().equals(username) && taiKhoan.getPassword().equals(password)) {
				this.taiKhoan = taiKhoan;
				result = true;
			}
		}
		return result;
	}
	public boolean checkTK(String username, String password) {
		boolean result = false;
		for (TaiKhoan taiKhoan : dsTaiKhoan) {
			if (taiKhoan.getUsername().equals(username) && taiKhoan.getPassword().equals(password)) {
				result = true;
			}
		}
		return result;
	}

	public BoBai getBoBai() {
		return boBai;
	}

	public void setBoBai(BoBai boBai) {
		this.boBai = boBai;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public ArrayList<TaiKhoan> getDsTaiKhoan() {
		return dsTaiKhoan;
	}

	public void setDsTaiKhoan(ArrayList<TaiKhoan> dsTaiKhoan) {
		this.dsTaiKhoan = dsTaiKhoan;
	}

}
