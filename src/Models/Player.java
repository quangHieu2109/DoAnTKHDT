package models;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String name;
	int money;
	List<Bai> baiTrenTay;

	public Player(String name, int money) {
		this.name = name;
		this.money = money;
		baiTrenTay = new ArrayList<>();
	}

	public void themBai(Bai bai) {//thêm bài vào tay
		baiTrenTay.add(bai);
	}

	public int getDiemBaiTrenTay() {//tính điểm bài trên tay người chơi
		int value = 0;
		for (Bai bai : baiTrenTay) {
			if (bai.getSo() > 10) {
				value += 10;
			} else {
				value += bai.getSo();
			}
		}
		return value;
	}

	public List<Bai> getBaiTrenTay() {
		return baiTrenTay;

	}

	public String getName() {
		return name;
	}

	public int getMoney() {
		return money;
	}
}
