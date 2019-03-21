package domain.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// TODO where do these handlers go, package-wise?
public class DecodeHandler extends CipherHandler implements EventHandler<ActionEvent> {

    DecodeHandler(TextField sentenceTextField, ComboBox<String> algorithmBox, Label resultLabel) {
        setSentenceTextField(sentenceTextField);
        setAlgorithmBox(algorithmBox);
        setResultLabel(resultLabel);
    }

    @Override
    public void handle(ActionEvent event) {
        setStrategy();
        getCipherContext().decode();
        getResultLabel().setText(getCipherContext().getText());
    }
}