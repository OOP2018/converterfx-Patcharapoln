package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * UI controller for event and initializing components. 
 * @author Patcharapol Nirunpornputta
 *
 */
public class ConverterController {
	@FXML
	private TextField textfield1;
	@FXML
	private TextField textfield2;
	@FXML
	private Button convert;
	@FXML
	private Button clear;
	@FXML
	private ComboBox<Length> unit1;
	@FXML
	private ComboBox<Length> unit2;

	/**
	 * Convert distance form one to another.
	 * @param event is a command from user.
	 */
	public void handleConvert(ActionEvent event) {
		double val1 = unit1.getValue().getValue();
		double val2 = unit2.getValue().getValue();
		double value;
		String text1 = textfield1.getText().trim();
		String text2 = textfield2.getText().trim();
		if (!text1.equals("")) {
			try {
				value = Double.parseDouble(text1);
				value = (value*val1)/val2;
				textfield2.setText(String.format("%.4g", value));
			} catch (NumberFormatException e) {
				textfield1.setStyle("-fx-text-fill: red");
			}
		} else if (!text2.equals("")) {
			try {
				value = Double.parseDouble(text2);
				value = (value *val2) / val1;
				textfield1.setText(String.format("%.4g", value));
			} catch (NumberFormatException e) {
				textfield2.setStyle("-fx-text-fill: red");
			}
		}
	}

	/**
	 * Clear all text field.
	 * @param event is a command from user.
	 */
	public void handleClear(ActionEvent event) {
		textfield1.clear();
		textfield2.clear();
	}

	/**
	 * Add all length unit to combo boxes.
	 */
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
