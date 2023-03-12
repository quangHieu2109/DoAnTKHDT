package Models;

public class Bai {
int diem;//điểm
int chat;//chất
int so;//số
public Bai(int diem, int so, int chat) {
	super();
	this.diem = diem;
	this.chat = chat;
	this.so = so;
}
public int getDiem() {
	return diem;
}
public void setDiem(int diem) {
	this.diem = diem;
}
public int getChat() {
	return chat;
}
public void setChat(int chat) {
	this.chat = chat;
}
public int getSo() {
	return so;
}
public void setSo(int so) {
	this.so = so;
}

}
