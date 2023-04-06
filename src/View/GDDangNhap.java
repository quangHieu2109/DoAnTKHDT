package view;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerDangNhap;

public class GDDangNhap extends APanel{
	public GDDangNhap(View view) {
		super(view);
	}

	JButton btnDangNhap;
	JButton btnDangKy;
	
	JLabel lbUserName;
	JLabel lbPass;
	
	JTextField txtUsername;
	JTextField txtPass;
	
	@Override
	public void init() {
		super.init();
		btnDangKy = new JButton("Đăng ký");
		btnDangNhap = new JButton("Đăng nhập");
		lbUserName = new JLabel("Tên đăng nhập:");
		lbPass = new JLabel("Mật khẩu:");
		txtUsername = new JTextField(8);
		txtPass = new JTextField(8);
		
		btnDangKy.setActionCommand("DangKy");
		btnDangNhap.setActionCommand("DangNhap");
		
		lbUserName.setBounds(CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE,
				CHIEUCAOFRAME / 2 - LABEL_SIZE_HEIGHT / 2, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtUsername.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 - TXT_SIZE_HEIGHT / 2, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		lbPass.setBounds(CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE,
				CHIEUCAOFRAME / 2 + LABEL_SIZE_HEIGHT * 2 - SPACE, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtPass.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 + TXT_SIZE_HEIGHT * 2 - SPACE,
				TXT_SIZE_WIDTH, TXT_SIZE_HEIGHT);

		btnDangKy.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH - SPACE, CHIEUCAOFRAME / 2 + LABEL_SIZE_WIDTH - SPACE,
				BTN_SIZE_WIDTH, BTN_SIZE_HEIGHT);
		btnDangNhap.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 + LABEL_SIZE_WIDTH - SPACE, BTN_SIZE_WIDTH,
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
	public void addAction() {//thêm các sụ kiện cho panel này
		controller = new ControllerDangNhap(models,this);
		Component[] comps =  this.getComponents();
		for(Component comp : comps) {
			if(comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(controller);
			}
		}
	}

	

}
