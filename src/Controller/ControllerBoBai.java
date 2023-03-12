package Controller;

import java.util.ArrayList;
import java.util.Random;

import Models.Bai;
import Models.BoBai;

public class ControllerBoBai {
	BoBai boBai;
	ArrayList lstIndexBai = new ArrayList<Integer>();
public ControllerBoBai(BoBai boBai) {
	this.boBai=boBai;
}
public Bai getBaiRandom() {//Rút 1 lá bài ngẫu nhiên
	return boBai.getBoBai().get(getRandomIndexBai());
}
public int getRandomIndexBai() {//lấy ngãu viên vị trí lá bài
	Random rd = new Random(51);
	int temp= rd.nextInt();
	if(!lstIndexBai.contains(temp)) {
		lstIndexBai.add(temp);
		return temp;
	}
	else {
		return getRandomIndexBai();
	}
	
}
}
