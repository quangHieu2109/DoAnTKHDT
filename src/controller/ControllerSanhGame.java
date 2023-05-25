package controller;

import models.Game;
import models.GameXiDach;
import models.TypeGame;
import view.GDGame;
import view.GDSanhGame;
import view.View;

public class ControllerSanhGame {
	private Game game;

	public ControllerSanhGame() {
		game = new Game();
		game.setNguoiChoi(2);
		View.getInstance().addPanel("SanhGame", new GDSanhGame(this));// thêm panel vào ds các panel
		View.getInstance().setContentPane(View.getInstance().getPanel("SanhGame"));// set panel vào view

	}

	public void setSoNguoiChoi(int soNguoiChoi) {
		game.setNguoiChoi(soNguoiChoi);
	}

	public void playGame(TypeGame typeGame) {
		if (View.getInstance().hasPanel("Game")) {// nếu đã có panel sảnh game thì xóa đi
			View.getInstance().removePanel("Game");
		}
		game.refresh();
		game.setKieuGame(typeGame);
		ControllerGame ctrGame = new ControllerGame(game);

	}

}
