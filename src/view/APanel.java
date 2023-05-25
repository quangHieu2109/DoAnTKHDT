package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class APanel extends JPanel implements ActionListener {

	protected View view;
	protected final int SPACE = 15;
	protected final int BTN_SIZE_WIDTH = 100;
	protected final int BTN_SIZE_HEIGHT = 30;
	protected final int LABEL_SIZE_WIDTH = 90;
	protected final int LABEL_SIZE_HEIGHT = 25;
	protected final int TXT_SIZE_WIDTH = 90;
	protected final int TXT_SIZE_HEIGHT = 25;
	protected final ImageIcon imgBtnOut = new ImageIcon("./img/main/out.png");
	protected final int CHIEURONGFRAME = View.getInstance().CHIEURONGFRAME;
	protected final int CHIEUCAOFRAME = View.getInstance().CHIEUCAOFRAME;
	protected JButton btnOut;

	public APanel() {
		view = View.getInstance();
	}

	public void init() {
		this.setBackground(new Color(91, 189, 43));
		this.setVisible(true);
		this.setLayout(null);

		btnOut = new JButton(imgBtnOut);
		btnOut.setActionCommand("Out");

		btnOut.setBounds(0, 0, imgBtnOut.getIconWidth(), imgBtnOut.getIconWidth());

		btnOut.setOpaque(false);
		btnOut.setBorderPainted(false);

		btnOut.setVisible(true);
		this.add(btnOut);
	}

	@Override
	public abstract void actionPerformed(ActionEvent e);

	public abstract void addAction();

	public View getView() {
		return view;
	}

}
