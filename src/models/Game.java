package models;

public class Game {
DSNguoiChoi dsNguoiChoi;
BoBai boBai;
int soNguoiChoi;
int tienCuoc=0;
TypeGame kieuGame;
public Game() {
	dsNguoiChoi = new DSNguoiChoi();
	boBai = new BoBai();
}
public void refresh() {
	boBai.refresh();
	dsNguoiChoi.refresh();
}
public void registerObs(ObseverGame obsGame) {
	kieuGame.registerObs(obsGame);
}
public void run() {
	kieuGame.run(this);
}
public void setKieuGame(TypeGame kieuGame) {
	this.kieuGame = kieuGame;
}
public void setNguoiChoi(int soNguoiChoi) {
	this.soNguoiChoi=soNguoiChoi;
}
public DSNguoiChoi getDsNguoiChoi() {
	return dsNguoiChoi;
}
public BoBai getBoBai() {
	return boBai;
}
public int getSoNguoiChoi() {
	return soNguoiChoi;
}
public int getTienCuoc() {
	return tienCuoc;
}
public void setTienCuoc(int tien) {
	this.tienCuoc=tien;
}
public TypeGame getKieuGame() {
	return kieuGame;
}

}
