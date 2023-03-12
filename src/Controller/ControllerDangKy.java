package Controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Models.TaiKhoan;
import View.DangKy;
import View.View;

public class ControllerDangKy extends Controller {

	public ControllerDangKy(View view) {
		super(view);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DangKy panel = (DangKy) view.getPanel("DangKy");
		if (e.getActionCommand().equals("DangKy")) {// nếu ấn vào nút đăng ký
			if (panel.getTxtUser().getText().isEmpty() || panel.getTxtPassword().getText().isEmpty()) {
				// kiểm tra xem đã nhập đủ thông tin?
				JOptionPane.showMessageDialog(panel, "Vui lòng nhập đầy đủ thông tin");
			} else if (!view.getModels().checkTK(panel.getTxtUser().getText(), panel.getTxtPassword().getText())) {
				
				// kiểm tra xem tài khoản đã có chưa
				TaiKhoan temp = new TaiKhoan(panel.getTxtUser().getText(), panel.getTxtPassword().getText(), 5000,
						null);// tạo tài khoản mới
				view.getModels().getDsTaiKhoan().add(temp);// thêm tài khoản vào danh sách
				
				JOptionPane.showMessageDialog(panel, "Bạn đã đăng ký thành công!");// hiển thị thông báo đăng ký thành
																					// công
			} else {
				JOptionPane.showMessageDialog(panel, "Tên tài khoản hoặc mật khẩu đã được dùng");
			}
		}
		if (e.getActionCommand().equals("Out")) {// nếu ấn nút trở về
			
			view.setContentPane(view.getPanel("DangNhap"));// sẽ về panel đăng nhập
		}

	}

}
