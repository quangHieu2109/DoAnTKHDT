package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import models.Player;

public class GDBoxPlayer extends JPanel {
	final int WIDTH = 200;
	final int HEIGHT = 130;
	final int SPACE = 5;
	int widthBoundIn4 = 100;
	int heightBoundIn4 = 50;
	JPanel boundBai;
	JPanel boundIn4Player;
	String name;
	int money;

	public GDBoxPlayer(Player player) {

		name = player.getName();
		money = player.getMoney();
		this.init();
	}

	public void init() {

		this.setBackground(new Color(91, 189, 43));
		this.setLayout(null);
		boundIn4Player = new JPanel();
		boundBai = new JPanel();
		
		
		

		boundIn4Player.setBounds(WIDTH / 2 - widthBoundIn4 / 2, HEIGHT - heightBoundIn4, widthBoundIn4, heightBoundIn4);
		boundIn4Player.setBackground(Color.black);
		boundBai.setBounds(0, 0, WIDTH, HEIGHT - heightBoundIn4);
		this.add(boundIn4Player);
		this.add(boundBai);

	}

	public void updateMoney(int money) {
		this.money = money;
		repaint();
	}

	
	
	public JPanel getBoundBai() {
		return boundBai;
	}

	public void setBoundBai(JPanel boundBai) {
		this.boundBai = boundBai;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		g.drawString(name + "", boundIn4Player.getX()+ widthBoundIn4 / 2 - name.length() * 6 - SPACE,  boundIn4Player.getY()+heightBoundIn4 / 2 - 5);
		g.drawString(money + "",  boundIn4Player.getX()+widthBoundIn4 / 2 + SPACE,  boundIn4Player.getY()+heightBoundIn4 / 2 - 5);
	}

}
