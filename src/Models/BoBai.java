package Models;

import java.util.ArrayList;

public class BoBai {
ArrayList<Bai> boBai = new ArrayList<>();
public BoBai() {
	taoBoBai();
}
public ArrayList<Bai> getBoBai() {
	return boBai;
}
public void taoBoBai() {//tạo bộ bài
	for (int i = 1; i < 14; i++) {
		for (int j = 0; j < 4; j++) {
			if(i>10) {
				boBai.add(new Bai(10, i, j));
			}
			else {
				boBai.add(new Bai(i, i, j));
			}
			
		}
	}
}
}
