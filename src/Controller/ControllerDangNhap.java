package Controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Models.TaiKhoan;
import View.DangKy;
import View.DangNhap;
import View.Sanh;
import View.View;


public class ControllerDangNhap extends Controller {

	public ControllerDangNhap(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DangNhap panel = (DangNhap) view.getLstPanel().get("DangNhap");
		if (e.getActionCommand().equals("DangNhap")) {// nếu án vào nút đăng nhập
			if (view.getModels().checkTKVaSetTKGame(panel.getTxtUser().getText(), panel.getTxtPassword().getText())) {
				if(!view.getLstPanel().containsKey("Sanh")) {
					Sanh sanh = new Sanh(view);
					view.addPanel("Sanh", sanh);
					
				}
				view.setContentPane(view.getPanel("Sanh"));
			}
			// nếu tk có trong danh sách sẽ set panel Sảnh vào frame
			else {
				JOptionPane.showMessageDialog(panel, "Bạn đã nhập sai tài khoản hoặc mật khẩu");
		    // nếu không có thì sẽ hiện thông báo
			}
		}
		if(e.getActionCommand().equals("DangKy")) {
			if(!view.getLstPanel().containsKey("DangKy")) {
				DangKy dangKy = new DangKy(view);
				view.addPanel("DangKy", dangKy);
			}
			view.setContentPane(view.getPanel("DangKy"));
		}
	}

}
