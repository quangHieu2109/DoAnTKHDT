package models;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.swing.Timer;

public class NguoiChoi {
	String ten;
	int tien;
	int type=1;
	List<Bai> dsBaiTrenTay;
	List<ObseverMoney> dsObsMoney;
	List<ObseverHand> dsObsHand;
	List<ObseverDiem> dsObsDiem;

	public NguoiChoi(String ten, int tien) {
		dsBaiTrenTay = new ArrayList<>();
		dsObsDiem = new ArrayList<>();
		dsObsHand = new ArrayList<>();
		dsObsMoney = new ArrayList<>();
		this.ten = ten;
		this.tien = tien;
	}
	public int getType() {
		return type;
	}

	public void addBaiVaoTay(Bai bai, int delay) {
		dsBaiTrenTay.add(bai);
		notifyObsDiem();
		notifyObsHand(bai, delay);

	}

	public void registerObsMoney(ObseverMoney o) {
		dsObsMoney.add(o);
	}

	public void registerObsHand(ObseverHand o) {
		dsObsHand.add(o);
	}

	public void notifyObsMoney() {
		for (ObseverMoney o : dsObsMoney) {
			o.updateMoney(tien);
		}
	}

	public void notifyObsHand(Bai bai, int delay) {
		for (ObseverHand o : dsObsHand)
			o.updateHand(bai, delay);
	}
	public void notifyObsHand() {
		for (ObseverHand o : dsObsHand)
			o.updateHand();
	}


	public void registerObsDiem(ObseverDiem o) {
		dsObsDiem.add(o);
	}

	public void notifyObsDiem() {
		for (ObseverDiem o : dsObsDiem) {
			o.updateDiem(getDiemTrenTay());
		}
	}

	public int getDiemTrenTay() {
		int res = 0;
		boolean at =false;
		for (int i = 0; i < dsBaiTrenTay.size(); i++) {
			res += dsBaiTrenTay.get(i).getDiem();
		}
		for(Bai b:dsBaiTrenTay) {
			if(b.at()) {
				at = true;
			}
		}
		if(at && (res+10)<=21) {
			res = res+10;
		}else if(at && (res+9)<=21) {
			res = res+9;
		}
		return res;
	}

	public List<Bai> getDSBaiTrenTay() {
		return dsBaiTrenTay;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTien() {
		return tien;
	}

	public void setTien(int tien) {
		this.tien = tien;
		notifyObsMoney();
	}

	public boolean xiDach() { // kiem tra xem co phai xi dach khong
		boolean result = false;
		if (dsBaiTrenTay.size() == 2) {
			if ((dsBaiTrenTay.get(0).getSo() == 1 && dsBaiTrenTay.get(1).getSo() >= 10)
					|| (dsBaiTrenTay.get(1).getSo() == 1 && dsBaiTrenTay.get(0).getSo() >= 10)) {
				result = true;
			}
		}
		return result;

	}
	public boolean nguLinh() {
		boolean result = false;
		if(dsBaiTrenTay.size() ==5 && getDiemTrenTay() <=21) {
			result = true;
		}
		return result;
	}
	public void setType(int type) {
		this.type=type;
	}

	public boolean quat() { // so diem > 21
		boolean result = false;
		if (getDiemTrenTay() > 21) {
			result = true;
		}
		return result;

	}
	
	@Override
	public String toString() {
		return "NguoiChoi [ten=" + ten + ", tien=" + tien + "]";
	}
	public void refresh() {
		dsBaiTrenTay.removeAll(dsBaiTrenTay);
		
	}

}
