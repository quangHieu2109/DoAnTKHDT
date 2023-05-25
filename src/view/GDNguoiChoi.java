package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Animation;
import models.Bai;
import models.NguoiChoi;
import models.ObseverDiem;
import models.ObseverHand;
import models.ObseverMoney;


public class GDNguoiChoi extends JPanel implements ObseverMoney, ObseverHand, ObseverDiem ,Observer{
	NguoiChoi nguoiChoi;
	int diem;
	int width = 250;
	int height = 130;
	int SPACE = 5;
	int angle = 0;
	int widthBoundIn4 = 100;
	int heightBoundIn4 = 50;
	int widthBoundBai = width;
	int heightBoundBai = 67;
	JLabel lbName;
	JLabel lbMoney;
	JPanel boundBai;
	JPanel boundIn4Player;
	String name;
	int money;
	int x;
	int y;

	public GDNguoiChoi(NguoiChoi nguoiChoi) {
		this.nguoiChoi = nguoiChoi;
		name = nguoiChoi.getTen();
		money = nguoiChoi.getTien();
		lbName = new JLabel(name);
		lbMoney = new JLabel(money + "");
		x = width / 2;
		y = height / 2;
		boundIn4Player = new JPanel();
		boundBai = new JPanel();
		this.init();
	}

	public void init() {

		this.setOpaque(false);
		this.setLayout(null);

		boundIn4Player.setBounds(width / 2 - widthBoundIn4 / 2, height - heightBoundIn4, widthBoundIn4, heightBoundIn4);
		boundIn4Player.setBackground(Color.black);
		boundBai.setBounds(0, boundIn4Player.getY() - heightBoundBai, widthBoundBai, heightBoundBai);
		lbName.setBounds(widthBoundIn4 / 2 - name.length() * 6 - SPACE, heightBoundIn4 / 2 - 5, 10, 10);
		lbMoney.setBounds(widthBoundIn4 / 2 + SPACE, heightBoundIn4 / 2 - 5, 10, 10);
		lbName.setForeground(Color.white);
		lbMoney.setForeground(Color.white);

		boundIn4Player.add(lbName);
		boundIn4Player.add(lbMoney);

		boundBai.setLayout(new FlowLayout());
		this.add(boundIn4Player);
		this.add(boundBai);

	}

	public NguoiChoi getNguoiChoi() {
		return this.nguoiChoi;
	}

	public void updateMoney(int money) {
		lbMoney.setText(money+"");
		
		repaint();
	}

	public JPanel getBoundBai() {
		return boundBai;
	}

	public void setBoundBai(JPanel boundBai) {
		this.boundBai = boundBai;
	}

	public void themBaiVaoTay(Bai bai, int type) {

		boundBai.add(bai);
		switch (type) {
		case 0: {

			bai.setHinhLaBai(bai.getImgMatTruoc());
			break;
		}
		}
		this.repaint();

	}
	public void showBai() {
		Component[] comps = boundBai.getComponents();
		for(Component comp : comps) {
			if(comp instanceof Bai) {
			    Bai bai = (Bai) comp;
			    bai.setHinhLaBai(bai.getImgMatTruoc());
			}
		}
		repaint();
		View.getInstance().setVisible(true);
	}

	public void roatePanel(int angle) {
		if (angle == 270 || angle == 90) {
			int temp = height;
			height = width;
			width = temp;

		}
		this.angle = angle;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		View.getInstance().setVisible(true);
		Graphics2D g2 = (Graphics2D) g;
		if (angle == 270) {
			g2.rotate(Math.toRadians(angle), height / 2, height / 2);
		}
		if (angle == 90) {
			g2.rotate(Math.toRadians(angle), width / 2, width / 2);
		}
		if (angle == 180) {
			g2.rotate(Math.toRadians(angle), width / 2, height / 2);
		}
	
		

	}

	@Override
	public void updateHand(Bai bai,int delay) {
		Animation animation = new Animation(this);
		animation.registerObs(this);
		animation.moveToX_Y(this.getX()+width/2, this.getY()+height/2, bai);
		animation.start(delay);
	}

	@Override
	public void updateDiem(int diem) {
		this.diem=diem;
		repaint();
		
	}

	@Override
	public void updateHand() {
		boundBai.removeAll();
		for(Bai bai : nguoiChoi.getDSBaiTrenTay()) {
			boundBai.add(bai);
		}
		repaint();
		View.getInstance().setVisible(true);
		
		
	}

	@Override
	public void update(Observable o, Object arg) {
		Animation a = (Animation) o;
		themBaiVaoTay((Bai)a.getObj(), nguoiChoi.getType());
	
		repaint();
		View.getInstance().setVisible(true);
		
	}

}
