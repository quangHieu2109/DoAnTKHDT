package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.ControllerBanGame;

public class GDBanGame extends APanel {
	static int soNguoiChoi;
	ControllerBanGame ctrBanGame;
	List<GDBoxPlayer> lstBoxPlayer;// dách sách panel hiển thị đại diện người chơi

	public GDBanGame(View view) {
		super(view);
		

	}
	@Override
	public void init() {
		super.init();
		ctrBanGame = new ControllerBanGame();
		lstBoxPlayer = new ArrayList<>();
		lstBoxPlayer.add(new GDBoxPlayer(ctrBanGame.getPlayer()));
		themPVaoBox();
		setBoxPVaoBanGame();
		
		
	}

	public void themPVaoBox() {// thêm bot vào các lstBox
		for (int i = 0; i < soNguoiChoi; i++) {
			lstBoxPlayer.add(new GDBoxPlayer(ctrBanGame.getBot(i)));
		}
	}

	public void setBoxPVaoBanGame() {// set các vị trí cho mỗi người chơi
		switch (soNguoiChoi) {
		case 1: {
			lstBoxPlayer.get(1).setBounds(CHIEURONGFRAME / 2 - lstBoxPlayer.get(1).WIDTH / 2, 0,
					lstBoxPlayer.get(1).WIDTH, lstBoxPlayer.get(1).HEIGHT);
			break;
		}
		case 2: {

			lstBoxPlayer.get(1).setBounds(0, CHIEUCAOFRAME / 2 - lstBoxPlayer.get(1).HEIGHT / 2,
					lstBoxPlayer.get(1).WIDTH, lstBoxPlayer.get(1).HEIGHT);

			lstBoxPlayer.get(2).setBounds(CHIEURONGFRAME - lstBoxPlayer.get(2).WIDTH,
					CHIEUCAOFRAME / 2 - lstBoxPlayer.get(2).HEIGHT / 2, lstBoxPlayer.get(2).WIDTH,
					lstBoxPlayer.get(2).HEIGHT);

			break;
		}
		case 3: {

			lstBoxPlayer.get(3).setBounds(CHIEURONGFRAME / 2 - lstBoxPlayer.get(3).WIDTH / 2, 0,
					lstBoxPlayer.get(3).WIDTH, lstBoxPlayer.get(3).HEIGHT);
			lstBoxPlayer.get(1).setBounds(0, CHIEUCAOFRAME / 2 - lstBoxPlayer.get(1).HEIGHT / 2,
					lstBoxPlayer.get(1).WIDTH, lstBoxPlayer.get(1).HEIGHT);

			lstBoxPlayer.get(2).setBounds(CHIEURONGFRAME - lstBoxPlayer.get(2).WIDTH,

					CHIEUCAOFRAME / 2 - lstBoxPlayer.get(2).HEIGHT / 2, lstBoxPlayer.get(2).WIDTH,
					lstBoxPlayer.get(2).HEIGHT);
			break;
		}
		}
		for (int i = 0; i < lstBoxPlayer.size(); i++) {
			this.add(lstBoxPlayer.get(i));
		}
		lstBoxPlayer.get(0).setBounds(CHIEURONGFRAME / 2 - lstBoxPlayer.get(0).WIDTH / 2,
				CHIEUCAOFRAME - lstBoxPlayer.get(0).HEIGHT - 2 * SPACE, lstBoxPlayer.get(0).WIDTH,
				lstBoxPlayer.get(0).HEIGHT);
		this.add(lstBoxPlayer.get(0));
	}

	public static void setSoNguoiChoi(int num) {
		soNguoiChoi = num;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAction() {
		// TODO Auto-generated method stub

	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon("./img/bobai/matsau.png").getImage() , CHIEURONGFRAME/2-45/2, CHIEUCAOFRAME/2-67/2, this);
	}
}
