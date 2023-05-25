package view;

import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.ControllerDangNhap;

public class View extends JFrame {
	private static final View instance = new View();
	final int CHIEURONGFRAME = 800;// chiều rộng game
	final int CHIEUCAOFRAME = 600;// chiều cao game
	TreeMap<String, APanel> lstPanel = new TreeMap<>();

	private View() {
		this.setSize(CHIEURONGFRAME, CHIEUCAOFRAME);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.init();
	}

	public void run() {
		ControllerDangNhap ctrDangNhap = new ControllerDangNhap();

	}

	public static View getInstance() {
		return instance;
	}

	public void setFirstPanel(APanel panel) {
		this.init();
	}

	public void init() {

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

	}

	public boolean hasPanel(String namePanel) {
		return lstPanel.containsKey(namePanel);
	}

	public APanel getPanel(String key) {
		return lstPanel.get(key);
	}

	public void addPanel(String key, APanel o) {
		lstPanel.put(key, o);
	}

	public void removePanel(String namePanel) {
		lstPanel.remove(namePanel);
	}

}
