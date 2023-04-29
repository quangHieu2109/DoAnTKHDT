package models;

import java.util.ArrayList;
import java.util.List;

public class Player {
	int id;
	String name;
	int money;
	List<Bai> baiTrenTay;

	public Player(String name, int money,int id) {
		this.name = name;
		this.money = money;
		this.id=id;
		baiTrenTay = new ArrayList<>();
	}
public int getId() {
	return id;
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
	public boolean xiDach() { //kiem tra xem co phai xi dach khong
		boolean result = false;
		if(baiTrenTay.size() ==2) {
			if((baiTrenTay.get(0).getSo() ==10 && baiTrenTay.get(1).getSo() >=10) ||
			   (baiTrenTay.get(1).getSo() ==10 && baiTrenTay.get(0).getSo() >=10)	) {
				result = true;
			}
		}
		return result;
		
	}
	public boolean quat() { //so diem > 21
		boolean result = true;
		if(getDiemBaiTrenTay()>21) {
			result = false;
		}
		return result;
		
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
	public void setMoney(int money) {
		this.money = money;
	}
	
}
