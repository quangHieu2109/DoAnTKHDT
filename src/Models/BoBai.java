package models;

import java.util.ArrayList;
import java.util.Collections;

public class BoBai {
	private ArrayList<Bai> boBai;
	public BoBai() {
		boBai = new ArrayList<>();
		for(int i =0; i < 4;i++) {
			for(int j =1;j<14;j++) {
				boBai.add(new Bai(j, i));
			}
		}
	}
	public void xaoBai() {
		Collections.shuffle(boBai);
	}
	public Bai rutBaiTrenCung() {
		return boBai.remove(0);
	}
}
