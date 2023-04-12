package models;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;

public class Models {
Controller controller;
BoBai boBai;
TaiKhoan taiKhoan;
List<TaiKhoan> dsTaiKhoan;
Player player;
List<Player> lstBot;

public Models() {
	Controller.setModels(this);
	boBai = new BoBai();
	dsTaiKhoan= new ArrayList<>();
	dsTaiKhoan.add(new TaiKhoan("root", "root"));
	lstBot = new ArrayList<>();
	createBots();
}
public List<TaiKhoan> getDsTK(){
	return dsTaiKhoan;
}
public void createBots() {
	lstBot.removeAll(lstBot);
	for(int i = 1; i <= 4;i++) {
		lstBot.add(new Player("bot "+i, 9000000));
	}
}
public void setPlayer() {
        player = new Player(taiKhoan.getName(), taiKhoan.getMoney());
}
public boolean checkTaiKhoan(String name,String mk) {
	boolean res=false;
	for (TaiKhoan taiKhoan : dsTaiKhoan) {
		if(taiKhoan.dangNhap(name, mk)) {
			res=true;
			this.taiKhoan = taiKhoan;
			break;
		}
	}
	return res;
}
public List<Player> getLstBot(){
	return lstBot;
}
public BoBai getBoBai() {
	return boBai;
}

public TaiKhoan getTaiKhoan() {
	return taiKhoan;
}
public Player getPlayer() {
	return player;
}

}
