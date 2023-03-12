package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.View;

public abstract class Controller implements ActionListener {
	View view;

	public Controller(View view) {
		this.view = view;
	}

	@Override
	public abstract void actionPerformed(ActionEvent e);
}
