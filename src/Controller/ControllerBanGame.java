package controller;

import models.Player;

public class ControllerBanGame extends Controller{
public Player getBot(int index) {
	return models.getLstBot().get(index);
}
}
