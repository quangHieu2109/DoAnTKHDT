package View;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;

import Controller.ControllerDangNhap;

public class DangNhap extends PanelIn4 {
	JButton btnDangKy;
	JButton btnDangnhap;
	public JTextField txtUser;
	public JPasswordField txtPassword;
	JLabel lbTenDangNhap;
	JLabel lbPassword;
	JLabel lbDangNhap;
	JLabel lbSymbolGame;
	ActionListener ac;

	public DangNhap(View view) {
		super(view);
		this.init();
		this.addAction();
	}

	public void init() {
		lbDangNhap = new JLabel("Đăng Nhập");

		lbDangNhap.setFont(new Font("Serif", Font.BOLD, 20));

		btnDangKy = new JButton("Đăng Ký");
		btnDangnhap = new JButton("Đăng Nhập");
		btnDangKy.setActionCommand("DangKy");
		btnDangnhap.setActionCommand("DangNhap");
		txtUser = new JTextField(8);
		txtPassword = new JPasswordField(8);
		lbTenDangNhap = new JLabel("Tên đăng nhập:");
		lbPassword = new JLabel("Mật khẩu:");

		lbDangNhap.setBounds(CHIEURONGPANEL / 2 - LABEL_SIZE_WIDTH / 2,
				CHIEUCAOPANEL / 2 - LABEL_SIZE_HEIGHT * 2 - SPACE, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		lbTenDangNhap.setBounds(CHIEURONGPANEL / 2 - LABEL_SIZE_WIDTH - SPACE,
				CHIEUCAOPANEL / 2 - LABEL_SIZE_HEIGHT / 2, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtUser.setBounds(CHIEURONGPANEL / 2 + SPACE, CHIEUCAOPANEL / 2 - TXT_SIZE_HEIGHT / 2, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		lbPassword.setBounds(CHIEURONGPANEL / 2 - LABEL_SIZE_WIDTH - SPACE,
				CHIEUCAOPANEL / 2 + LABEL_SIZE_HEIGHT * 2 - SPACE, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtPassword.setBounds(CHIEURONGPANEL / 2 + SPACE, CHIEUCAOPANEL / 2 + TXT_SIZE_HEIGHT * 2 - SPACE,
				TXT_SIZE_WIDTH, TXT_SIZE_HEIGHT);

		btnDangKy.setBounds(CHIEURONGPANEL / 2 - BTN_SIZE_WIDTH - SPACE, CHIEUCAOPANEL / 2 + LABEL_SIZE_WIDTH - SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);
		btnDangnhap.setBounds(CHIEURONGPANEL / 2 + SPACE, CHIEUCAOPANEL / 2 + LABEL_SIZE_WIDTH - SPACE, BTN_SIZE_WIDTH,
				BTN_SIZE_HEIGHT);
		lbSymbolGame = new JLabel(imgSymBolGame);
		lbSymbolGame.setBounds(CHIEURONGPANEL / 2 - imgSymBolGame.getIconWidth() / 2,
				lbDangNhap.getY() / 2 - imgSymBolGame.getIconHeight() / 2, imgSymBolGame.getIconWidth(),
				imgSymBolGame.getIconHeight());
		
		btnDangKy.setVisible(true);
		lbOut.setVisible(false);
		
		this.add(lbDangNhap);
		this.add(lbTenDangNhap);
		this.add(txtUser);
		this.add(lbPassword);
		this.add(txtPassword);
		this.add(btnDangKy);
		this.add(btnDangnhap);
		this.add(lbSymbolGame);
	}

	public JTextField getTxtUser() {
		return txtUser;
	}

	public JPasswordField getTxtPassword() {
		return txtPassword;
	}

	@Override
	public void addAction() {
		ac = new ControllerDangNhap(view);
		Component[] comps = this.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JButton) {
				JButton button = (JButton) comp;
				button.addActionListener(ac);
			}

		}

	}

}
