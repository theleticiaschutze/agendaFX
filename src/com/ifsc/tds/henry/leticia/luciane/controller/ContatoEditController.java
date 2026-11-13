package com.ifsc.tds.henry.leticia.luciane.controller;

import com.ifsc.tds.henry.leticia.luciane.entity.Contato;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ContatoEditController {

	@FXML
	private Button btnCancela;

	@FXML
	private Button btnOK;

	@FXML
	private Label lblEmail;

	@FXML
	private Label lblNome;

	@FXML
	private Label lblTelefone;

	@FXML
	private HBox pnlBotoes;

	@FXML
	private GridPane pnlDados;

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtTelefone;

	private Stage janelaContatoEdit;

	private Contato contato;

	private boolean okClick = false;

	@FXML
	void onClickBtnCancela(ActionEvent event) {
		this.getJanelaContatoEdit().close();
	}

	@FXML
	void onClickBtnOK(ActionEvent event) {
		if (validarCampos()) {
			this.contato.setNome(this.txtNome.getText());
			this.contato.setEmail(this.txtEmail.getText());
			this.contato.setTelefone(this.txtTelefone.getText());

			this.okClick = true;
			this.getJanelaContatoEdit().close();
		}
	}

	public void setJanelaContatoEdit(Stage janelaContatoEdit) {
		this.janelaContatoEdit = janelaContatoEdit;
	}

	public Stage getJanelaContatoEdit() {
		return janelaContatoEdit;
	}

	public void populaTela(Contato contato) {
		this.contato = contato;

		this.txtNome.setText(contato.getNome());
		this.txtEmail.setText(contato.getEmail());
		this.txtTelefone.setText(contato.getTelefone());
	}

	public boolean isOkClick() {
		return okClick;
	}
	
	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.txtNome.getText() == null || this.txtNome.getText().trim().length() == 0 || this.txtEmail.getText() == null || this.txtEmail.getText().trim().length() == 0 || this.txtTelefone.getText() == null || this.txtTelefone.getText().trim().length() == 0) {
			mensagemErros += "Preencha todas as informações!\n";
		}

		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaContatoEdit);
			alerta.setTitle("Dados inválidos!");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();

			return false;
		}
	}
	
}
