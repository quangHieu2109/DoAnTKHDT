package models;

public class TaiKhoan {
	private String userName;
	private String password;
	private int money;

	public TaiKhoan(String userName, String password, int money) {
		this.userName = userName;
		this.password = password;
		this.money = money;
	}

	public static TaiKhoan createTaiKhoan(String userName, String pass, int money) {
		TaiKhoan tk = new TaiKhoan(userName, pass, money);
//	tk.setMoney(50000);
		return tk;
	}

	public boolean checkTaiKhoan(String name, String pass) {
		return this.userName.equals(name) && this.password.equals(pass);
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public int getMoney() {
		return money;
	}

	@Override
	public String toString() {
		return "TaiKhoan [userName=" + userName + ", password=" + password + ", money=" + money + "]";
	}

}
