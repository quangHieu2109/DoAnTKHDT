package View;

import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Models.Models;

public class View extends JFrame {
	Models models;
	final int chieuRongFrame = 800;// chiều rộng game
	final int chieuCaoFrame = 600;// chiều cao game
	PanelIn4 firstPanel;
	TreeMap<String, PanelIn4> lstPanel = new TreeMap<>();

	public View(Models models) {
		this.setSize(chieuRongFrame, chieuCaoFrame);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.models = models;
		this.init();
	}

	public void init() {
			try {
			      
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
		   // handle exception
		}
		catch (ClassNotFoundException e) {
		   // handle exception
		}
		catch (InstantiationException e) {
		   // handle exception
		}
		catch (IllegalAccessException e) {
		   // handle exception
		}
		firstPanel = new DangNhap(this);
		lstPanel.put("DangNhap", firstPanel);
		this.setContentPane(lstPanel.get("DangNhap"));
	}
	public Models getModels() {
		return models;
	}

	public TreeMap<String, PanelIn4> getLstPanel() {
		return lstPanel;
	}

	public void setLstPanel(TreeMap<String, PanelIn4> lstPanel) {
		this.lstPanel = lstPanel;
	}
	public JPanel getPanel(String key) {
		
		return lstPanel.get(key);
	}
	public JPanel addPanel(String key, PanelIn4 o) {
		return lstPanel.put(key, o);
	}
	
}
