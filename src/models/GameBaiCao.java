package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GameBaiCao implements TypeGame{
	List<ObseverGame> obsGame;
	private Game game;
public GameBaiCao() {
	obsGame = new ArrayList<>();
}
	public void run(Game game) {// chạy game trong này
		this.game = game;
		game.boBai.xaoBai();
		chiaBai();// chia bài

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {// kiểm tra có thắng ở đầu game không

			@Override
			public void run() {
				for (int i = 0; i < game.getSoNguoiChoi(); i++) {
					
						endGame();
						notifyObsGame();

				}

			}

		};
		timer.schedule(task, (3 *game.getSoNguoiChoi())* 500);

	}

	public void chiaBai() {// chia mỗi người 3 lá

		int process = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < game.getSoNguoiChoi(); j++) {
				rutBai(game.getDsNguoiChoi().getNguoiChoi(j), 400 * process + 200);
				process++;

			}
		}
	}
	public List<Integer> checkWin() {
		List<Integer> result = new ArrayList<>();
		int res = 0;
		int cs = game.getDsNguoiChoi().getNguoiChoi(1).getDiemTrenTay();
		for(int i=0; i<game.getSoNguoiChoi();i++) {
			int pl = game.getDsNguoiChoi().getNguoiChoi(i).getDiemTrenTay();
			if ((cs%10)>(pl%10)) {
				res = -1; // tru tien nguoi choi
			} else if ((cs%10)<(pl%10)) {
				res = 1; // cong tien nguoi choi
			} else {
				res=0;
			}
			result.add(res);
		}
	return result;
	}
	private void endGame() {

		List<Integer> res = checkWin();

		NguoiChoi cs = game.dsNguoiChoi.getNguoiChoi(1);
		for (int i = 0; i < res.size(); i++) {
			NguoiChoi pl = game.dsNguoiChoi.getNguoiChoi(i);

			pl.setTien(pl.getTien() + game.getTienCuoc() * res.get(i));
		}
		DSTaiKhoan.getInstance().getNguoiChoi().setMoney(game.getDsNguoiChoi().getNguoiChoi(0).getTien());
		DSTaiKhoan.getInstance().updateDSTaiKhoan();
		game.dsNguoiChoi.updateDSNguoiChoi();
	}
	public String gameOver() {// viết ở đây
		String result = "";
		int check = checkWin().get(0);
		if (check < 0) {
			result = "  You lose \n" + "  " + check * game.getTienCuoc();
		} else {
			result = "  You win \n" + "  +" + check * game.getTienCuoc();
		}
		return result;
	}
	public void choiLai() {
		game.getBoBai().refresh();
		System.out.println(game.getBoBai().getSize());
		for (int i = 0; i < game.soNguoiChoi; i++) {
			game.getDsNguoiChoi().getNguoiChoi(i).dsBaiTrenTay
					.removeAll(game.getDsNguoiChoi().getNguoiChoi(i).dsBaiTrenTay);
			game.getDsNguoiChoi().getNguoiChoi(i).notifyObsHand();
		}

	}

	@Override
	public void danBai() {// không làm gì
		
		
	}

	@Override
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
	public void rutBai() {// không làm gì
		
		
	}
	public void rutBai(NguoiChoi nguoiChoi, int delay) {
		nguoiChoi.addBaiVaoTay(game.boBai.rutBaiTrenCung(), delay);
		
	}
	
}
