package Controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import View.Sanh;
import View.View;
import View.XiDach;

public class ControllerSanh extends Controller {

	public ControllerSanh(View view) {
		super(view);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Sanh panel = (Sanh) view.getPanel("Sanh");
		if (e.getActionCommand().equals("Out")) {// nếu ấn nút thoát
			int result = JOptionPane.showConfirmDialog(panel, "Bạn có muốn đăng xuất không", "Đăng Xuất",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				view.setContentPane(view.getPanel("DangNhap"));// sẽ về panel đăng nhập
			}

		}
		if (e.getActionCommand().equals("XiDach")) {

			XiDach xiDach = new XiDach(view);
			view.setContentPane(xiDach);//set panel xì dách vào frame

		}
	}

}
