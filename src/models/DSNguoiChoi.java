package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.security.DrbgParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DSNguoiChoi {
	private List<NguoiChoi> dsNguoiChoi;

	public void refresh() {
		for (NguoiChoi nguoiChoi : dsNguoiChoi) {
			nguoiChoi.refresh();
		}
	}

	public DSNguoiChoi() {//
		dsNguoiChoi = new ArrayList<>();
		taoNguoiChoi();
	}

	public void taoNguoiChoi() {
		TaiKhoan pl = DSTaiKhoan.getInstance().getNguoiChoi();
		NguoiChoi nguoiChoi = new NguoiChoi(pl.getUserName(), pl.getMoney());
		nguoiChoi.setType(0);
		dsNguoiChoi.add(nguoiChoi);
		String ten = "";
		int money = 0;
		try {
			File file = new File("NguoiChoi.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] s = line.split(" ");
				ten = s[0];

				money = Integer.valueOf(s[1]);
				dsNguoiChoi.add(new NguoiChoi(ten, money));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void updateDSNguoiChoi() {
		xoaFile();
		try {

			PrintWriter pw = new PrintWriter("NguoiChoi.txt");
			String ten = "";
			int money = 0;
			for (int i = 1; i < dsNguoiChoi.size(); i++) {
				ten = dsNguoiChoi.get(i).getTen();
				money = dsNguoiChoi.get(i).getTien();
				pw.println(ten + " " + money);

			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}

	}

	public void xoaFile() {
		File file = new File("NguoiChoi.txt");
		file.delete();

	}

	public NguoiChoi getNguoiChoi(int index) {

		return dsNguoiChoi.get(index);
	}

	public List<NguoiChoi> getDsNguoiChoi() {
		return dsNguoiChoi;
	}

	public void setDsNguoiChoi(List<NguoiChoi> dsNguoiChoi) {
		this.dsNguoiChoi = dsNguoiChoi;
	}
}
