package controller;

import view.APanel;
import view.GDBoxPlayer;
import view.GDGameXiDach;
import view.View;

public class ControllerXiDach extends Controller{
	GDGameXiDach panel;
	View view;

	public ControllerXiDach(APanel panel) {
		this.panel = (GDGameXiDach) panel;
		this.view = panel.getView();
		
	}
	public void rutBai(GDBoxPlayer player) {// rút bài cho player được truyền vào
		timer.start();
		player.themBaiVaoTay(models.getBoBai().rutBaiTrenCung());
	}
	public void xaoBai() {//gọi phương thức xào bài
		models.getBoBai().xaoBai();
	}
	public void botPlay(GDBoxPlayer player) {//method cho bot tự chơi
		while(player.getPlayer().getDiemBaiTrenTay()<15) {
			rutBai(player);
			
		}
		
	}
}
