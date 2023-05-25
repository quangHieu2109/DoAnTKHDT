package view;

import java.awt.Component;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControllerGame;
import controller.ControllerSanhGame;
import models.Bai;
import models.Game;
import models.GameBaiCao;
import models.GameXiDach;
import models.ObseverGame;
import models.TypeGame;

public class GDGame extends APanel implements ObseverGame {
	private Game game;
	private ControllerGame ctrGame;
	private List<GDNguoiChoi> dsGDNguoiChoi;
	private JLabel lbDatCuoc;
	private GDKetQua gdKetQua;
	private JTextField txtDatCuoc;
	private JButton btnBatDau;
	private JButton btnRutBai;
	private JButton btnDan;
	private boolean rutBai = true;
	int soNguoiChoi;

	public GDGame(ControllerGame ctrGame, Game game) {
		this.game = game;
		this.ctrGame = ctrGame;
		game.getKieuGame().registerObs(this);
		init();
		addAction();
		stateCuoc();

	}

	@Override
	public void init() {
		super.init();

		soNguoiChoi = game.getSoNguoiChoi();
		dsGDNguoiChoi = new ArrayList<>();

		gdKetQua = new GDKetQua();
		gdKetQua.setBounds(CHIEURONGFRAME / 2 - gdKetQua.getWidth() / 2, CHIEUCAOFRAME / 2 - gdKetQua.getHeight() / 2,
				gdKetQua.getWidth(), gdKetQua.getHeight());
		gdKetQua.addAction(this);
		this.add(gdKetQua);
		themNguoiChoiVaoGame();

		lbDatCuoc = new JLabel("Đặt cược: ");
		txtDatCuoc = new JTextField(7);

		btnRutBai = new JButton("Rút Bài");
		btnDan = new JButton("Dằn");

		btnRutBai.setActionCommand("RutBai");
		btnRutBai.setBounds(CHIEURONGFRAME / 2 + SPACE * 3, dsGDNguoiChoi.get(0).getY() - BTN_SIZE_HEIGHT - SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);// thiết lập cho nút rút bài
		btnBatDau = new JButton("Bắt đầu");
		btnBatDau.setActionCommand("Bat Dau");
		btnBatDau.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH / 2, CHIEUCAOFRAME / 2 + lbDatCuoc.getHeight() + SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);
		btnDan.setActionCommand("DanBai");
		btnDan.setBounds(CHIEURONGFRAME / 2 - SPACE * 3 - BTN_SIZE_WIDTH,
				dsGDNguoiChoi.get(0).getY() - SPACE - BTN_SIZE_HEIGHT, BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);// thiết lập nút
																										// gập bài
		txtDatCuoc.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 - TXT_SIZE_HEIGHT, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);
		txtDatCuoc.setText(20000 + "");
		lbDatCuoc.setBounds(CHIEURONGFRAME / 2 - SPACE - LABEL_SIZE_WIDTH, CHIEUCAOFRAME / 2 - LABEL_SIZE_HEIGHT,
				LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		// thêm bài vào game
		for (int i = 0; i < game.getBoBai().getSize(); i++) {
			game.getBoBai().getBaiTai(i).setBounds(CHIEURONGFRAME / 2 - game.getBoBai().getBaiTai(i).getWidthImg() / 2,
					CHIEUCAOFRAME / 2 - game.getBoBai().getBaiTai(i).getHeightImg(),
					game.getBoBai().getBaiTai(i).getWidthImg(), game.getBoBai().getBaiTai(i).getHeightImg());
			this.add(game.getBoBai().getBaiTai(i));
		}
		this.add(btnBatDau);
		this.add(btnRutBai);
		this.add(txtDatCuoc);
		this.add(lbDatCuoc);
		this.add(btnDan);
	}

	public void statePlayGame() {
		for (int i = 0; i < game.getBoBai().getSize(); i++) {
			game.getBoBai().getBaiTai(i).setVisible(true);
		}
		gdKetQua.setVisible(false);
		btnDan.setVisible(true);
		btnRutBai.setVisible(true);
		btnBatDau.setVisible(false);
		txtDatCuoc.setVisible(false);
		lbDatCuoc.setVisible(false);
		if (game.getKieuGame() instanceof GameBaiCao) {
			btnDan.setVisible(false);
			btnRutBai.setVisible(false);
		}
	}

	public void stateCuoc() {
		for (int i = 0; i < game.getBoBai().getSize(); i++) {
			game.getBoBai().getBaiTai(i).setVisible(false);
		}
		gdKetQua.setVisible(false);
		btnDan.setVisible(false);
		btnRutBai.setVisible(false);
		btnBatDau.setVisible(true);
		txtDatCuoc.setVisible(true);
		lbDatCuoc.setVisible(true);
		if (game.getKieuGame() instanceof GameBaiCao) {
			btnDan.setVisible(false);
			btnRutBai.setVisible(false);
		}
	}

	public void themNguoiChoiVaoGame() {
		for (int i = 0; i < soNguoiChoi; i++) {
			dsGDNguoiChoi.add(new GDNguoiChoi(game.getDsNguoiChoi().getNguoiChoi(i)));
			game.getDsNguoiChoi().getNguoiChoi(i).registerObsMoney(dsGDNguoiChoi.get(i));
			game.getDsNguoiChoi().getNguoiChoi(i).registerObsHand(dsGDNguoiChoi.get(i));
			game.getDsNguoiChoi().getNguoiChoi(i).registerObsDiem(dsGDNguoiChoi.get(i));
		}
		setBoxPVaoBanGame();
	}

	public void refresh() {
		for (int i = 0; i < game.getBoBai().getSize(); i++) {
			game.getBoBai().getBaiTai(i).setBounds(CHIEURONGFRAME / 2 - game.getBoBai().getBaiTai(i).getWidthImg() / 2,
					CHIEUCAOFRAME / 2 - game.getBoBai().getBaiTai(i).getHeightImg(),
					game.getBoBai().getBaiTai(i).getWidthImg(), game.getBoBai().getBaiTai(i).getHeightImg());
			this.add(game.getBoBai().getBaiTai(i));
		}
		for (GDNguoiChoi gd : dsGDNguoiChoi) {
			gd.updateHand();
		}
	}

	public void stateKetQua() {
		for (int i = 0; i < game.getBoBai().getSize(); i++) {
			game.getBoBai().getBaiTai(i).setVisible(false);
		}
		gdKetQua.setVisible(false);
		btnDan.setVisible(false);
		btnRutBai.setVisible(false);
		btnBatDau.setVisible(false);
		txtDatCuoc.setVisible(false);
		lbDatCuoc.setVisible(false);
		gdKetQua.setVisible(true);
		if (game.getKieuGame() instanceof GameBaiCao) {
			btnDan.setVisible(false);
			btnRutBai.setVisible(false);
		}
	}

	public void setBoxPVaoBanGame() {// set các vị trí cho mỗi người chơi
		switch (soNguoiChoi) {// set vị trí cho bot
		case 2: {// set vị trí cho bot 1
			dsGDNguoiChoi.get(1).roatePanel(180);
			dsGDNguoiChoi.get(1).setBounds(CHIEURONGFRAME / 2 - dsGDNguoiChoi.get(1).width / 2, 0,
					dsGDNguoiChoi.get(1).width, dsGDNguoiChoi.get(1).height);
			break;
		}
		case 3: {// set vị trí cho bot 1,2
			dsGDNguoiChoi.get(1).roatePanel(90);
			dsGDNguoiChoi.get(2).roatePanel(270);

			dsGDNguoiChoi.get(1).setBounds(0, CHIEUCAOFRAME / 2 - dsGDNguoiChoi.get(1).height / 2,
					dsGDNguoiChoi.get(1).width, dsGDNguoiChoi.get(1).height);

			dsGDNguoiChoi.get(2).setBounds(CHIEURONGFRAME - dsGDNguoiChoi.get(2).width,
					CHIEUCAOFRAME / 2 - dsGDNguoiChoi.get(2).height / 2, dsGDNguoiChoi.get(2).width,
					dsGDNguoiChoi.get(2).height);

			break;
		}
		case 4: {// set vị trí cho bot 1,2,3
			dsGDNguoiChoi.get(1).roatePanel(90);
			dsGDNguoiChoi.get(2).roatePanel(270);
			dsGDNguoiChoi.get(3).roatePanel(180);

			dsGDNguoiChoi.get(3).setBounds(CHIEURONGFRAME / 2 - dsGDNguoiChoi.get(3).width / 2, 0,
					dsGDNguoiChoi.get(3).width, dsGDNguoiChoi.get(3).height);
			dsGDNguoiChoi.get(1).setBounds(0, CHIEUCAOFRAME / 2 - dsGDNguoiChoi.get(1).height / 2,
					dsGDNguoiChoi.get(1).width, dsGDNguoiChoi.get(1).height);

			dsGDNguoiChoi.get(2).setBounds(CHIEURONGFRAME - dsGDNguoiChoi.get(2).width,

					CHIEUCAOFRAME / 2 - dsGDNguoiChoi.get(2).height / 2, dsGDNguoiChoi.get(2).width,
					dsGDNguoiChoi.get(2).height);
			break;
		}
		}
		for (int i = 0; i < dsGDNguoiChoi.size(); i++) {
			this.add(dsGDNguoiChoi.get(i));
		}
		// set Vị trí cho người chơi
		dsGDNguoiChoi.get(0).setBounds(CHIEURONGFRAME / 2 - dsGDNguoiChoi.get(0).width / 2,
				CHIEUCAOFRAME - dsGDNguoiChoi.get(0).height - 2 * SPACE, dsGDNguoiChoi.get(0).width,
				dsGDNguoiChoi.get(0).height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == btnBatDau.getActionCommand()) {
			int tienCuoc = 0;
			if (!txtDatCuoc.getText().isEmpty()) {
				tienCuoc = Integer.parseInt(txtDatCuoc.getText());
			}
			if (tienCuoc > game.getDsNguoiChoi().getNguoiChoi(0).getTien()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập tiền cược không vượt quá số dư hiện có!");
			} else {
				game.setTienCuoc(tienCuoc);
				statePlayGame();
				ctrGame.runGame();
			}

		}
		if (e.getActionCommand() == btnOut.getActionCommand()
				|| e.getActionCommand() == gdKetQua.getBtnThoat().getActionCommand()) {
			if (View.getInstance().hasPanel("SanhGame")) {
				View.getInstance().removePanel("SanhGame");
			}
			new ControllerSanhGame();
			View.getInstance().setVisible(true);
		}
		if (e.getActionCommand().equals(gdKetQua.getBtnChoiLai().getActionCommand())) {
			game.refresh();
			refresh();
			stateCuoc();
			rutBai = true;
		}
		if (e.getActionCommand().equals(btnDan.getActionCommand())) {
			ctrGame.dan();
			rutBai = false;
		}
		if (e.getActionCommand() == btnRutBai.getActionCommand()) {
			if (game.getKieuGame() instanceof GameXiDach) {
				if (game.getDsNguoiChoi().getNguoiChoi(0).getDSBaiTrenTay().size() < 5) {
					if (rutBai) {
						ctrGame.rutBai();
					}
				}
				if (game.getDsNguoiChoi().getNguoiChoi(0).getDSBaiTrenTay().size() == 5
						|| game.getDsNguoiChoi().getNguoiChoi(0).getDiemTrenTay() > 21) {
					btnRutBai.setVisible(false);
				}
			}

		}

	}

	@Override
	public void addAction() {
		Component[] comps = this.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(this);
			}
		}

	}

	@Override
	public void update(TypeGame game) {
		gdKetQua.updateTitle(game.gameOver());
		for (GDNguoiChoi gd : dsGDNguoiChoi) {
			gd.showBai();
		}
		stateKetQua();
		View.getInstance().setVisible(true);

	}

}
