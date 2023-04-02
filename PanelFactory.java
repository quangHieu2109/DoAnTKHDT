package view;

public class PanelFactory {
public static APanel createPanel(String type) {
	APanel panel = null;
	switch (type) {
	case "DangNhap": {
		panel= new GDDangNhap();
		
	}
	
	}
	return panel;
}
}
