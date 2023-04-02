package view;

import javax.swing.JPanel;

import models.Models;

public abstract class APanel extends JPanel{
	Models models;
	public APanel() {
		addAction();
	}
public abstract void addAction();
public void setModels(Models models) {
	this.models= models;
}
}
