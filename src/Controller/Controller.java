package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

import models.Bai;
import models.BoBai;
import models.Models;
import models.Player;
import models.TaiKhoan;
import view.APanel;

public  class Controller implements ActionListener{
	static Models models;
	APanel panel;
	Timer timer;
public Controller() {
	timer = new Timer(100, this);

}
public BoBai getBoBai() {
	return models.getBoBai();
}
public void setPlayer() {
	models.setPlayer();
}
public Player getPlayer() {
	return models.getPlayer();
}
public boolean checkTaiKhoan(String userName,String pass) {
	return models.checkTaiKhoan(userName, pass);
}
public void themTkVaoDs(String userName,String pass) {
	models.getDsTK().add(new TaiKhoan(userName, pass));
}

public static void setModels(Models other) {
	models = other;
}
@Override
public  void actionPerformed(ActionEvent e) {
	
}
}
