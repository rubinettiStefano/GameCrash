package com.generation.gamecrash.controller;

import com.generation.gamecrash.helpers.ControllerHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ApplicationController
{
	@FXML
	public Text output;
	@FXML
	public TextField title,genre,platforms,price,id;
	private ControllerHelper ch = ControllerHelper.getInstance();

	public void leggiTutto()
	{
		output.setText(ch.produciLista());
	}

	public void inserisci()
	{
		output.setText(ch.inserisciVideogioco(title.getText(), genre.getText(), platforms.getText(), Double.parseDouble(price.getText())));
	}

	public void acquista()
	{
		output.setText(ch.acquistaVideogioco(Integer.parseInt(id.getText())));
	}
}

