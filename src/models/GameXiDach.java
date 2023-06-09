package models;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import view.View;

public class GameXiDach implements TypeGame {
	private List<ObseverGame> obsGame;
	private Game game;

	public GameXiDach() {
		obsGame = new ArrayList<>();

	}

	public void run(Game game) {// chạy game trong này
		this.game = game;
		game.getBoBai().xaoBai();
		chiaBai();// chia bài

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {// kiểm tra có thắng ở đầu game không

			@Override
			public void run() {
				for (int i = 0; i < checkThangDauGame().size(); i++) {
					if (checkThangDauGame().get(i) != 0) {// nếu thắng thì kết thúc game
						endGame1();
						notifyObsGame();

					}
				}

			}

		};
		timer.schedule(task, (2 * game.getSoNguoiChoi()) * 500);

	}

	public void chiaBai() {// chia mỗi người 2 lá

		int process = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < game.getSoNguoiChoi(); j++) {

				rutBai(game.getDsNguoiChoi().getNguoiChoi(j), 400 * process + 200);

				process++;

			}
		}
	}

	public void danBai() {// dành cho người chơi
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			int process = 1;

			@Override
			public void run() {
				boolean continute = false;
				for (int i = 1; i < game.getSoNguoiChoi(); i++) {
//					 continute = false;
					if (game.getDsNguoiChoi().getNguoiChoi(i).getDiemTrenTay() < 14) {
						rutBai(game.getDsNguoiChoi().getNguoiChoi(i), process * 200 + 200);
						continute = true;
						process++;
					}
				}
				if (continute == false) {
					timer.cancel();
					Timer timer1 = new Timer();
					TimerTask task1 = new TimerTask() {

						@Override
						public void run() {
							endGame2();
							notifyObsGame();
						}
					};
					timer1.schedule(task1, process * 400 + 500);
//					timer1.s

				}

			}
		};
		timer.schedule(task, 500, 100);

	}

	public void rutBai() {// dành cho người chơi
		if (game.getDsNguoiChoi().getNguoiChoi(0).getDSBaiTrenTay().size() < 5) {
			rutBai(game.getDsNguoiChoi().getNguoiChoi(0), 0);
		} else {

		}

	}

	public void rutBai(NguoiChoi nguoiChoi, int delay) {
		nguoiChoi.addBaiVaoTay(game.getBoBai().rutBaiTrenCung(), delay);
	}

	private void endGame2() {

		List<Integer> res = checkWin();

		NguoiChoi cs = game.getDsNguoiChoi().getNguoiChoi(1);
		for (int i = 0; i < res.size(); i++) {
			NguoiChoi pl = game.getDsNguoiChoi().getNguoiChoi(i);

			pl.setTien(pl.getTien() + game.getTienCuoc() * res.get(i));
		}
		DSTaiKhoan.getInstance().getNguoiChoi().setMoney(game.getDsNguoiChoi().getNguoiChoi(0).getTien());
		DSTaiKhoan.getInstance().updateDSTaiKhoan();
		game.getDsNguoiChoi().updateDSNguoiChoi();
	}

	private void endGame1() {
		List<Integer> res = checkThangDauGame();
		NguoiChoi cs = game.getDsNguoiChoi().getNguoiChoi(1);
		for (int i = 0; i < res.size(); i++) {
			NguoiChoi pl = game.getDsNguoiChoi().getNguoiChoi(i);
			if (i != 1) {
//				pl.setTien(pl.getTien() + game.getTienCuoc() * res.get(i));
				if (res.get(i) <= 1) {
					pl.setTien(pl.getTien() + game.getTienCuoc() * res.get(i));
				}
			}
		}
		DSTaiKhoan.getInstance().getNguoiChoi().setMoney(game.getDsNguoiChoi().getNguoiChoi(0).getTien());
		game.getDsNguoiChoi().updateDSNguoiChoi();
		DSTaiKhoan.getInstance().updateDSTaiKhoan();

	}

	private List<Integer> checkThangDauGame() {// code xem nó có thằng đầu game hay không
		List<Integer> result = new ArrayList<>();
		int res = 0;
//		boolean pl = game.getDsNguoiChoi().getNguoiChoi(0).xiDach();
		boolean cs = game.getDsNguoiChoi().getNguoiChoi(1).xiDach();
		boolean win = false;
		for (int i = 0; i < game.getSoNguoiChoi(); i++) {
			if (game.getDsNguoiChoi().getNguoiChoi(i).xiDach()) {
				win = true;
			}
		}
		if (win) {
			for (int i = 0; i < game.getSoNguoiChoi(); i++) {
				boolean pl = game.getDsNguoiChoi().getNguoiChoi(i).xiDach();
				if (pl != true && cs == true) {
					res = -1; // tru tien nguoi choi
				} else if (pl == true && cs != true) {
					res = 1; // cong tien nguoi choi
				} else if ((pl == true && cs == true) || pl != true && cs != true) {
					res = 9; // hoa
				}
				result.add(res);
			}
		} else {
			for (int i = 0; i < game.getSoNguoiChoi(); i++) {
				
				result.add(0);
			}
		}

		return result;
	}

	public void registerObs(ObseverGame obs) {
		obsGame.add(obs);
	}

	@Override
	public void notifyObsGame() {
		for (ObseverGame obseverGame : obsGame) {
			obseverGame.update(this);
		}

	}

	@Override
	public void choiLai() {
		game.getBoBai().refresh();
		System.out.println(game.getBoBai().getSize());
		for (int i = 0; i < game.getSoNguoiChoi(); i++) {
			game.getDsNguoiChoi().getNguoiChoi(i).getDSBaiTrenTay()
					.removeAll(game.getDsNguoiChoi().getNguoiChoi(i).getDSBaiTrenTay());
			game.getDsNguoiChoi().getNguoiChoi(i).notifyObsHand();
		}

	}

	public List<Integer> checkWin() {// kiểm tra trường hợp win cuối game
		List<Integer> res = new ArrayList<>();
		int result = 0;

		int cs = game.getDsNguoiChoi().getNguoiChoi(1).getDiemTrenTay();
		boolean csQuat = game.getDsNguoiChoi().getNguoiChoi(1).quat();
		boolean csNguLinh = game.getDsNguoiChoi().getNguoiChoi(1).nguLinh();
		for (int i = 0; i < game.getSoNguoiChoi(); i++) {
			int pl = game.getDsNguoiChoi().getNguoiChoi(i).getDiemTrenTay();
			boolean plQuat = game.getDsNguoiChoi().getNguoiChoi(i).quat();
			boolean plNguLinh = game.getDsNguoiChoi().getNguoiChoi(i).nguLinh();
			if (checkThangDauGame().get(i) != 0) {
				result = checkThangDauGame().get(i);
			} else {
				if (plNguLinh == true && csNguLinh != true) {
					result = 1;
				} else if (plNguLinh != true && csNguLinh == true) {
					result = -1;

				} else if (plNguLinh == true && csNguLinh == true) {
					result = 0;
				} else {
					if (plQuat == true && csQuat != true) {
						result = -1;
					} else if (plQuat != true && csQuat == true) {
						result = 1;

					} else if (plQuat == true && csQuat == true) {
						result = 0;
					} else if (plQuat != true && csQuat != true) {
						if (pl < cs) {
							result = -1;
						} else if (pl > cs) {
							result = 1;
						}

					}
				}
			}
			res.add(result);
		}

		return res;
	}

	public String gameOver() {// viết ở đây
		String result = "";
		int check = 0;
		if (checkThangDauGame().get(0) != 0) {
			check = checkThangDauGame().get(0);
		} else {
			check = checkWin().get(0);
		}
		if (check < 0) {
			result = "  You lose \n" + "  " + check * game.getTienCuoc();
		} else if (check == 1) {
			result = "  You win \n" + "  +" + check * game.getTienCuoc();
		} else {
			result = "  You win \n" + "  +" + 0;
		}
		return result;
	}

}
