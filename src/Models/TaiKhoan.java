package Models;

import javax.swing.ImageIcon;

public class TaiKhoan {
	String username;
	String password;
	int money = 0;
	ImageIcon img = null;

	public TaiKhoan(String username, String password, int money, ImageIcon img) {
		this.username = username;
		this.password = password;
		this.money = money;
		this.img = img;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

}
