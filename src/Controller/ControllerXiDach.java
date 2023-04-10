package controller;

import view.APanel;
import view.GDGameXiDach;
import view.View;

public class ControllerXiDach extends Controller {
	GDGameXiDach panel;
	View view;

	public ControllerXiDach(APanel panel) {

		this.panel = (GDGameXiDach) panel;
		this.view = panel.getView();
	}
}
