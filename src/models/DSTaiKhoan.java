package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DSTaiKhoan {
	private static List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
	private static DSTaiKhoan instance = new DSTaiKhoan();
	private String username = "";

	public static DSTaiKhoan getDSTaiKhoan() {
		taoTaiKhoan();
		return instance;
	}

	public static DSTaiKhoan getInstance() {
		return instance;
	}

	public static void updateDSTaiKhoan() {// đọc file text dsTaiKhoan ở đây
		xoaFile();
		try {
			PrintWriter pw = new PrintWriter("TaiKhoan.txt");
			for (TaiKhoan t : dsTaiKhoan) {
				String tk = t.getUserName();
				String mk = t.getPassword();
				int money = t.getMoney();
				pw.println(tk + " " + mk + " " + money);

			}
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void taoTaiKhoan() {
		dsTaiKhoan.removeAll(dsTaiKhoan);
		File file = new File("TaiKhoan.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String tk = "";
			String mk = "";
			int money = 0;
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] s = line.split(" ");
				tk = s[0];
				mk = s[1];
				money = Integer.valueOf(s[2]);

				dsTaiKhoan.add(TaiKhoan.createTaiKhoan(tk, mk, money));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void themTaiKhoan(String tk, String mk) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("TaiKhoan.txt", true));
			pw.println(tk + " " + mk + " " + 200000);
//		pw.flush();
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void xoaFile() {
		try {
			File file = new File("TaiKhoan.txt");
			file.delete();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static boolean ktTaiKhoan(String tk) {
		boolean result = true;
		List<String> listTK = new ArrayList<>();
		for (TaiKhoan t : dsTaiKhoan) {
			listTK.add(t.getUserName());
		}
		if (listTK.contains(tk)) {
			result = false;
		}
		return result;
	}

	public int getSize() {
		return dsTaiKhoan.size();
	}

	public boolean checkTaiKhoan(String userName, String passWord) {
		boolean res = false;

		for (TaiKhoan taiKhoan : dsTaiKhoan) {
			if (taiKhoan.checkTaiKhoan(userName, passWord)) {
				res = true;
				break;
			}
		}
		return res;
	}

	public TaiKhoan getTaiKhoan(int index) {
		return dsTaiKhoan.get(index);
	}

	public static void setDsTaiKhoan(List<TaiKhoan> dsTaiKhoan) {
		DSTaiKhoan.dsTaiKhoan = dsTaiKhoan;
	}

	public TaiKhoan getNguoiChoi() {
		TaiKhoan result = null;
		System.out.println();
		for (TaiKhoan t : dsTaiKhoan) {
			if (t.getUserName().equals(username)) {
				result = t;
			}
		}
		return result;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void remove() {
		dsTaiKhoan.removeAll(dsTaiKhoan);
	}

}
