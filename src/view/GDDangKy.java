package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.lang.ModuleLayer.Controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControllerDangKy;

public class GDDangKy extends APanel {
	private JButton btnDangKy;

	private JLabel lbUserName;
	private JLabel lbPass;
	private ControllerDangKy ctrDangKy;
	private JTextField txtUsername;
	private JPasswordField txtPass;

	public GDDangKy(ControllerDangKy ctrDangKy) {
		this.init();

		this.addAction();
		this.ctrDangKy = ctrDangKy;
	}

	public void init() {
		super.init();

		btnDangKy = new JButton("Đăng ký");
		lbUserName = new JLabel("Tên đăng nhập:");
		lbPass = new JLabel("Mật khẩu:");
		Font font = new Font("Arial", Font.BOLD, 15);
		lbUserName.setFont(font);
		lbPass.setFont(font);
		txtUsername = new JTextField(8);
		txtPass = new JPasswordField(8);

		btnDangKy.setActionCommand("DangKy");

		lbUserName.setBounds((CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE) - 25,
				CHIEUCAOFRAME / 2 - LABEL_SIZE_HEIGHT / 2, LABEL_SIZE_WIDTH + 100, LABEL_SIZE_HEIGHT);
		txtUsername.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 - TXT_SIZE_HEIGHT / 2, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		lbPass.setBounds((CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE) - 25,
				CHIEUCAOFRAME / 2 + LABEL_SIZE_HEIGHT * 2 - SPACE, LABEL_SIZE_WIDTH + 200, LABEL_SIZE_HEIGHT);
		txtPass.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 + TXT_SIZE_HEIGHT * 2 - SPACE, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		btnDangKy.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH / 2, CHIEUCAOFRAME / 2 + LABEL_SIZE_WIDTH - SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);

		btnDangKy.setActionCommand("DangKy");

		this.add(btnDangKy);
		this.add(lbPass);
		this.add(lbUserName);
		this.add(txtUsername);
		this.add(txtPass);
		this.add(btnOut);

	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public JTextField getTxtPass() {
		return txtPass;
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
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == btnOut.getActionCommand()) {
			clickBtnOut();
		}
		if (e.getActionCommand() == btnDangKy.getActionCommand()) {
			clickBtnDangKy();
		}

	}

	public void clickBtnDangKy() {
		if (this.getTxtUsername().getText().isEmpty() || this.getTxtPass().getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
		} else if (ctrDangKy.checkDangKy(txtUsername.getText(), txtPass.getText())) {
			JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu đã được sử dụng");
		} else {
			ctrDangKy.dangKyTK(txtUsername.getText(), txtPass.getText());
			JOptionPane.showMessageDialog(this, "Bạn đã đăng ký thành công!");
		}
	}

	public void clickBtnOut() {
		view.setContentPane(view.getPanel("DangNhap"));
		view.setVisible(true);
	}
}