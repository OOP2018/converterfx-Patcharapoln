package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConverterController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	Button convert;
	@FXML
	Button clear;
	@FXML
	ComboBox<Length> unit1;
	@FXML
	ComboBox<Length> unit2;

	public void handleConvert(ActionEvent event) {
		try {
			textfield1.setStyle("-fx-text-fill: black");
			textfield2.setStyle("-fx-text-fill: black");
			double value;
			String text1 = textfield1.getText().trim();
			String text2 = textfield2.getText().trim();
			double val1 = unit1.getValue().getValue();
			double val2 = unit2.getValue().getValue();
			if (!text1.equals("")) {
				value = Double.parseDouble(text1);
				value = value * (val1 / val2);
				textfield2.setText(String.format("%.4g", value));
			} else if (!text2.equals("")) {
				value = Double.parseDouble(text2);
				value = value * (val1 / val2);
				textfield1.setText(String.format("%.4g", value));
			}
		} catch (NumberFormatException e) {
			textfield1.setStyle("-fx-text-fill: red");
			textfield2.setStyle("-fx-text-fill: red");
		}
	}

	public void handleClear(ActionEvent event) {
		textfield1.clear();
		textfield2.clear();
	}

	@FXML
	public void initialize() {
		if (unit1 != null) {
			unit1.getItems().addAll(Length.values());
			unit1.getSelectionModel().select(0);
		}
		if (unit2 != null) {
			unit2.getItems().addAll(Length.values());
			unit2.getSelectionModel().select(1);
		}

	}
}
