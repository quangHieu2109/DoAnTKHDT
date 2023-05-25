package view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GDKetQua extends JPanel {
	private int width = 300;
	private int height = 200;
	private String title;
	private JButton btnChoiLai;
	private JButton btnThoat;
	private JTextArea txtArea;

	public GDKetQua() {
		this.setLayout(null);
		title = "a\na";
		btnChoiLai = new JButton("Chơi lại");
		btnThoat = new JButton("Thoát");
		btnChoiLai.setActionCommand("ChoiLai");
		this.setSize(width, height);
		btnChoiLai.setBounds(60, 150, 80, 30);
		btnThoat.setBounds(160, 150, 80, 30);
		btnThoat.setActionCommand("Thoat");
		this.add(btnChoiLai);
		this.setOpaque(true);
		this.add(btnThoat);
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Arial", Font.BOLD, 20));
		txtArea.setBounds(100, 50, width - 200, 50);
		this.add(txtArea);
	}

	public void addAction(ActionListener ac) {
		btnChoiLai.addActionListener(ac);
		btnThoat.addActionListener(ac);
	}

	public JButton getBtnChoiLai() {
		return btnChoiLai;
	}

	public void setBtnChoiLai(JButton btnChoiLai) {
		this.btnChoiLai = btnChoiLai;
	}

	public JButton getBtnThoat() {
		return btnThoat;
	}

	public void setBtnThoat(JButton btnThoat) {
		this.btnThoat = btnThoat;
	}

	public void updateTitle(String title) {
		txtArea.setText(title);
		View.getInstance().setVisible(true);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
