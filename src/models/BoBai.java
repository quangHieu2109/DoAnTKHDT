package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoBai {
	private List<Bai> boBai;

	public BoBai() {
		boBai = new ArrayList<>();
		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				boBai.add(new Bai(i, j));
			}
		}
	}

	public void refresh() {
		boBai.removeAll(boBai);
		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				boBai.add(new Bai(i, j));
			}
		}

	}

	public Bai getBaiTai(int i) {
		return boBai.get(i);
	}

	public int getSize() {
		return boBai.size();
	}

	public void xaoBai() {// xào bài
		Collections.shuffle(boBai);
	}

	public Bai rutBaiTrenCung() {// rút bài

		return boBai.remove(0);
	}

}
