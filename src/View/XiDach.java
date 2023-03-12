package View;

import java.awt.Graphics;

public class XiDach extends BanGame {

	public XiDach(View view) {
		super(view);
		addAction();

	}

	@Override
	public void addAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(imgMatSauBai.getImage(), CHIEURONGPANEL / 2 - imgMatSauBai.getIconWidth(),
				CHIEUCAOPANEL / 2 - imgMatSauBai.getIconHeight(), null);// vẽ xấp bài ở giữa

	}

}
