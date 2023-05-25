package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControllerDangKy;
import controller.ControllerDangNhap;

public class GDDangNhap extends APanel {
	private ControllerDangNhap ctrDangNhap;
	private JButton btnDangNhap;
	private JButton btnDangKy;

	private JLabel lbUserName;
	private JLabel lbPass;

	private JTextField txtUsername;
	private JPasswordField txtPass;

	public GDDangNhap(ControllerDangNhap ctrDangNhap) {
		this.ctrDangNhap = ctrDangNhap;
		this.init();
		this.addAction();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		btnDangKy = new JButton("Đăng ký");
		btnDangNhap = new JButton("Đăng nhập");
		lbUserName = new JLabel("Tên đăng nhập:");
		Font font = new Font("Arial", Font.BOLD, 15);
		lbUserName.setFont(font);

		lbPass = new JLabel("Mật khẩu:");
		lbPass.setFont(font);
		txtUsername = new JTextField(8);
		txtPass = new JPasswordField(8);

		btnDangKy.setActionCommand("DangKy");
		btnDangNhap.setActionCommand("DangNhap");

		lbUserName.setBounds((CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE) - 25,
				CHIEUCAOFRAME / 2 - LABEL_SIZE_HEIGHT / 2, LABEL_SIZE_WIDTH + 100, LABEL_SIZE_HEIGHT);
		txtUsername.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 - TXT_SIZE_HEIGHT / 2, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		lbPass.setBounds((CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE) - 25,
				CHIEUCAOFRAME / 2 + LABEL_SIZE_HEIGHT * 2 - SPACE, LABEL_SIZE_WIDTH + 200, LABEL_SIZE_HEIGHT);
		txtPass.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 + TXT_SIZE_HEIGHT * 2 - SPACE, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		btnDangKy.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH - SPACE, CHIEUCAOFRAME / 2 + LABEL_SIZE_WIDTH + SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);
		btnDangNhap.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 + LABEL_SIZE_WIDTH + SPACE, BTN_SIZE_WIDTH,
				BTN_SIZE_HEIGHT);

		this.add(btnDangKy);
		this.add(btnDangNhap);
		this.add(lbPass);
		this.add(lbUserName);
		this.add(txtUsername);
		this.add(txtPass);

		btnOut.setVisible(false);
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public JTextField getTxtPass() {
		return txtPass;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == btnDangNhap.getActionCommand()) {
			clickBtnDangNhap();
		}
		if (e.getActionCommand() == btnDangKy.getActionCommand()) {
			clickBtnDangky();
		}

	}

	private void clickBtnDangky() {
		if (!View.getInstance().hasPanel("Dangky")) {
			new ControllerDangKy();
		}
		View.getInstance().setContentPane(View.getInstance().getPanel("DangKy"));
		View.getInstance().setVisible(true);

	}

	private void clickBtnDangNhap() {
		if (txtUsername.getText().isEmpty()) {
			txtUsername.setText("");
		}
		if (txtPass.getText().isEmpty()) {
			txtPass.setText("");
		}
		ctrDangNhap.dangNhap(txtUsername.getText(), txtPass.getText());

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

}
