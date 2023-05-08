package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import models.Game;
import view.GDGame;
import view.View;


public class ControllerGame {
	Game game;
	GDGame gdGame;
	public ControllerGame(Game game) {
		this.game=game;
		
		View.getInstance().addPanel("Game", new GDGame(this, game));
		View.getInstance().setContentPane(View.getInstance().getPanel("Game"));
		View.getInstance().setVisible(true);
	}
	public void choiLai() {
		game.choiLai();
	}
	public void runGame() {
		game.run();
	}
	public void rutBai() {
		game.getKieuGame().rutBai();
	}
	public void dan() {
		game.getKieuGame().danBai();
		
	}
}
