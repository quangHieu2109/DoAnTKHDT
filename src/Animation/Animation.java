package Animation;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Animation implements ActionListener {
	Container view;
	Component obj;
	Timer timer;

	public final int MOVE_TO_Y = 1;
	public final int MOVE_TO_X = 2;
	public final int MOVE_TO_X_Y = 3;
	int viTrix;
	int viTriy;
	int selection;

	public Animation(Container view) {
		this.view = view;
		timer = new Timer(0, this);
	}

	public void moveToY(int y, Component obj) {
		timer.start();
		selection = MOVE_TO_Y;
		this.obj = obj;
		viTriy = y;
		if (obj.getY() < y) {
			obj.setBounds(obj.getX(), obj.getY() + 1, obj.getWidth(), obj.getHeight());
		} else if (obj.getY() > y) {
			obj.setBounds(obj.getX(), obj.getY() - 1, obj.getWidth(), obj.getHeight());
		} else {
			timer.stop();
		}

	}

	public void moveToX(int x, Component obj) {
		timer.start();
		selection = MOVE_TO_X;
		this.obj = obj;
		viTrix = x;
		if (obj.getX() < x) {
			obj.setBounds(obj.getX() + 1, obj.getY(), obj.getWidth(), obj.getHeight());
		} else if (obj.getX() > x) {
			obj.setBounds(obj.getX() - 1, obj.getY(), obj.getWidth(), obj.getHeight());
		} else {
			timer.stop();
		}

	}

	public void moveTo_X_Y(int x, int y, Component obj) {
		timer.start();
		selection = MOVE_TO_X_Y;
		viTrix = x;
		viTriy = y;
		this.obj = obj;
		if (obj.getX() < x) {
			obj.setBounds(obj.getX() + 1, obj.getY(), obj.getWidth(), obj.getHeight());
		}
		if (obj.getX() > x) {
			obj.setBounds(obj.getX() - 1, obj.getY(), obj.getWidth(), obj.getHeight());
		}
		if (obj.getY() < y) {
			obj.setBounds(obj.getX(), obj.getY() + 1, obj.getWidth(), obj.getHeight());
		}
		if (obj.getY() > y) {
			obj.setBounds(obj.getX(), obj.getY() - 1, obj.getWidth(), obj.getHeight());
		}
		if (obj.getY() == y && obj.getX() == x) {
			timer.stop();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (selection == MOVE_TO_Y) {
			moveToY(viTriy, obj);
		}
		if (selection == MOVE_TO_X) {
			moveToX(viTrix, obj);
		}
		if (selection == MOVE_TO_X_Y) {
			moveTo_X_Y(viTrix, viTriy, obj);
		}

	}

}
