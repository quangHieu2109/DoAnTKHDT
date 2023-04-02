package view;

import java.util.TreeMap;

import javax.swing.JFrame;

import models.Models;

public class View extends JFrame{
	Models models;
	final int chieuRongFrame = 800;// chiều rộng game
	final int chieuCaoFrame = 600;// chiều cao game
	APanel firstPanel;
	TreeMap<String, APanel> lstPanel = new TreeMap<>();
public View(Models models) {
	this.setSize(chieuRongFrame, chieuCaoFrame);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.models = models;
	this.init();
}
public void init() {
	firstPanel = PanelFactory.createPanel("DangNhap");
	firstPanel.setModels(models);
	this.setContentPane(firstPanel);
	lstPanel.put("DangNhap", firstPanel);
}
public Models getModels() {
	return models;
}
}
