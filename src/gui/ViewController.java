package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable {

	@FXML
	private TextField txtNum1;

	@FXML
	private TextField txtNum2;

	@FXML
	private Label lblResultado;

	@FXML
	private Button btnSoma;

	@FXML
	public void onBtnSomaAction() {	
		try {
			
			Locale.setDefault(Locale.US);
			double numero1 = Double.parseDouble(txtNum1.getText());
			double numero2 = Double.parseDouble(txtNum2.getText());
			double soma = numero1 + numero2;
			lblResultado.setText(String.format("%.2f", soma));	
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Erro", null, e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(txtNum1);
		Constraints.setTextFieldDouble(txtNum2);
		Constraints.setTextFieldMaxLength(txtNum1, 12); // limitando a quantidade de números
		Constraints.setTextFieldMaxLength(txtNum2, 12); // limitando a quantidade de números
		
	}

}
