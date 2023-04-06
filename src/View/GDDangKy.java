package view;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ControllerDangKy;

public class GDDangKy extends APanel{
	JButton btnDangKy;
	
	JLabel lbUserName;
	JLabel lbPass;
	
	JTextField txtUsername;
	JTextField txtPass;
	public GDDangKy(View view) {
		super(view);
	
	}
	public void init() {
		super.init();
		
		btnDangKy = new JButton("Đăng ký");
		lbUserName = new JLabel("Tên đăng nhập:");
		lbPass = new JLabel("Mật khẩu:");
		txtUsername = new JTextField(8);
		txtPass = new JTextField(8);
		
		btnDangKy.setActionCommand("DangKy");
		
		
		lbUserName.setBounds(CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE,
				CHIEUCAOFRAME / 2 - LABEL_SIZE_HEIGHT / 2, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtUsername.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 - TXT_SIZE_HEIGHT / 2, TXT_SIZE_WIDTH,
				TXT_SIZE_HEIGHT);

		lbPass.setBounds(CHIEURONGFRAME / 2 - LABEL_SIZE_WIDTH - SPACE,
				CHIEUCAOFRAME / 2 + LABEL_SIZE_HEIGHT * 2 - SPACE, LABEL_SIZE_WIDTH, LABEL_SIZE_HEIGHT);
		txtPass.setBounds(CHIEURONGFRAME / 2 + SPACE, CHIEUCAOFRAME / 2 + TXT_SIZE_HEIGHT * 2 - SPACE,
				TXT_SIZE_WIDTH, TXT_SIZE_HEIGHT);

		btnDangKy.setBounds(CHIEURONGFRAME / 2 - BTN_SIZE_WIDTH/2 , CHIEUCAOFRAME / 2 + LABEL_SIZE_WIDTH - SPACE,
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
		controller = new ControllerDangKy(models,this);
		Component[] comps =  this.getComponents();
		for(Component comp : comps) {
			if(comp instanceof JButton) {
				JButton btn = (JButton) comp;
				btn.addActionListener(controller);
			}
		}
		
	}

	

}
