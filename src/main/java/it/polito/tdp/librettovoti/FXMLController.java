package it.polito.tdp.librettovoti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Libretto model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<Integer> cmbPunti;

	@FXML
	private TextField txtNome;

	@FXML
	private Label txtStatus;

	@FXML
	private TextArea txtVoti;

	@FXML
	void handleNuovoVoto(ActionEvent event) {

		// 1. acquisizione e controllo dati
		String nome = txtNome.getText();
		Integer punti = cmbPunti.getValue();

		// controlli di validità
		if (nome.equals("") || punti == null) {
			// errore, non posso eseguire l'operazione
			txtStatus.setText("ERRORE: occorre inserire nome e voto\n");
			return;
		}

		// 2. esecuzione dell'operazione (== chiedere al Model di farla)
		boolean ok = model.add(new Voto(nome, punti));

		// 3. visualizzazione/aggiornamento del risultato
		if (ok) {
			List<Voto> voti = model.getVoti();
			txtVoti.clear();
			txtVoti.appendText("Hai superato " + voti.size() + " esami\n");
			for (Voto v : voti) {
				txtVoti.appendText(v.toString() + "\n");
			}

			txtNome.clear();
			cmbPunti.setValue(null);
			txtStatus.setText("");
		} else {
			txtStatus.setText("ERRORE: esame già presente") ;
		}

	}

	public void setModel(Libretto model) {
		this.model = model;
	}

	@FXML
	void initialize() {
		assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";

		cmbPunti.getItems().clear();
		for (int p = 18; p <= 30; p++) {
			cmbPunti.getItems().add(p);
		}

	}

}
