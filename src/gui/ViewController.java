package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entidade.Pessoa;

public class ViewController implements Initializable {
	
	@FXML
	private ComboBox<Pessoa> comboBoxPessoa;
	
	@FXML
	private Button btnTudo;
	
	private ObservableList<Pessoa> obsList;
	
	
	// Mostra todos os cadastros das listas
	@FXML
	public void onBtnTudoAction() {
		for (Pessoa pessoa : comboBoxPessoa.getItems()) {
			System.out.println(pessoa);
		}
	}
	
	// Mostrar o cadastro completo
	@FXML
	public void onComboBoxPessoaAction() {
		Pessoa pessoa = comboBoxPessoa.getSelectionModel().getSelectedItem();
		System.out.println(pessoa);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Pessoa> lista = new ArrayList<>();
		lista.add(new Pessoa(1, "Sandro", "sandro@gmail.com"));
		lista.add(new Pessoa(2, "Regina", "regina@gmail.com"));
		lista.add(new Pessoa(3, "Uilson", "uilson@hotmail.com"));
		lista.add(new Pessoa(4, "Maria", "maria@gmail.com"));
		
		obsList = FXCollections.observableArrayList(lista);
		comboBoxPessoa.setItems(obsList);
		
		// Pegar somente o nome da lista não o toString completo
		Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {
			@Override
			protected void updateItem(Pessoa item, boolean vazio) {
				super.updateItem(item, vazio);
				setText(vazio ? "" : item.getNome());
			}
		};
		
		comboBoxPessoa.setCellFactory(factory);
		comboBoxPessoa.setButtonCell(factory.call(null));
	}

}
