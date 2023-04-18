package controller;

import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import models.Bai;
import view.APanel;
import view.GDBoxPlayer;
import view.GDGameXiDach;
import view.View;

public class ControllerXiDach extends Controller implements Observer {
	GDGameXiDach panel;
	View view;
	boolean state;
	int start=0;

	public ControllerXiDach(APanel panel) {
		this.panel = (GDGameXiDach) panel;
		this.view = panel.getView();

	}

	public boolean getStateAnimation() {
		return state;
	}

	public void rutBai(GDBoxPlayer player) {// rút bài cho player được truyền vào

		Animation animation = new Animation(player);

		animation.registerObs(this);
		Bai bai = models.getBoBai().rutBaiTrenCung();// lấy ra lá bài được rút
		player.getPlayer().themBai(bai);// thêm lá bài đó vào tay người chơi
		animation.moveToX_Y(player.getX()+player.getWidth()/2-bai.getWidthImg()/2, player.getY()+player.getHeight()/2-bai.getHeightImg()/2, bai);// animation di duyển lá bài tới người chơi
		animation.start(panel.getProcess() * 100);// bắt đầu hoạt ảnh

	}

	private void setHienThiLaBai(GDBoxPlayer player, Bai bai) {
		player.themBaiVaoTay(bai,player.getPlayer().getId());// thêm bài vào tay để hiển thị trên màn hình
		panel.getView().setVisible(true);
	}

	public void xaoBai() {// gọi phương thức xào bài
		models.getBoBai().xaoBai();
	}

	public void botPlay(GDBoxPlayer player) {// method cho bot tự chơi
		while (player.getPlayer().getDiemBaiTrenTay() < 15) {
			rutBai(player);
		}

	}

	@Override
	public void update(Observable o, Object arg) {// sau khi hết animation
		Animation animation = (Animation) o;
		setHienThiLaBai((GDBoxPlayer) arg, (Bai) animation.getObj());// gọi phương thức thêm lá bài sau animation

	}
}
